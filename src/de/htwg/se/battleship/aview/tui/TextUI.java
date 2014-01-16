package de.htwg.se.battleship.aview.tui;

import java.util.Map;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import de.htwg.se.battleship.controller.IController;
import de.htwg.se.battleship.controller.IInitGameController;
import de.htwg.se.battleship.controller.event.CloseProgamm;
import de.htwg.se.battleship.controller.event.InitGame;
import de.htwg.se.battleship.controller.impl.ControllerFactory;

/**
 * Text User Interface is an Observer
 * 
 * @author aullik
 */
@Singleton
public class TextUI extends UserInterface  {

    public static final String MSG_INPUT_NOTE   = "Please choice a menu: ";
    public static final String MSG_DEFAULT_MENU = "Sorry bro, but '%s' has no menu entry!%n";
    public static final String MSG_EXIT         = "This is the end my friend!";


    private final Map<String, IMenuEntry> menu;

    private boolean process = true;

    /**
     * @param controller controller to observe
     */
    @Inject
    public TextUI(IController controller, IScannerFactory sf, IMenu menu) {
        super(sf.getScanner());
        controller.addObserver(this);

        this.menu = menu.get();

        getLogger().info(header());
        processInput();
    }

    private void processInput() {
        while (process) {
            getLogger().info(menu());
            getLogger().info(MSG_INPUT_NOTE);
            String input = getScanner().nextLine();

            executeInput(input);
        }
    }

    private void executeInput(String input) {
        IMenuEntry e = menu.get(input);

        if (e == null) {
            getLogger().info(header());
            getLogger().info(String.format(MSG_DEFAULT_MENU, input));
        } else {
            e.action();
        }

    }

    /**
     * Shutdown TUI process input
     * @param e CloseProgamm
     */
    public void update(CloseProgamm e) {
        getLogger().info(header());
        process = false;
        getLogger().info(MSG_EXIT);
    }

    /**
     * Start TUI for game initialization
     * @param e InitGame
     */
    public void update(InitGame e) {
        IInitGameController c = ControllerFactory.createIInitGameController();
        new InitGameUI(c, getScanner());
        c.init();
    }


    private String menu() {
        StringBuilder sb = new StringBuilder();
        sb.append("Main Menu:").append("\n");

        for (IMenuEntry entry : menu.values()) {
            sb.append(String.format("%-20s - ", entry.command()));
            sb.append(entry.description()).append("\n");
        }
        return sb.toString();
    }
}
