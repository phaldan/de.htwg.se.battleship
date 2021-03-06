/**
 * 
 */
package de.htwg.se.battleship.aview.tui.menuentry;

import de.htwg.se.battleship.aview.tui.IMenuEntry;
import de.htwg.se.battleship.controller.IController;

/**
 * @author Philipp Daniels<philipp.daniels@gmail.com>
 *
 */
public class Close implements IMenuEntry {

    private final IController controller;
    public static final String CMD  = "-close";
    public static final String DESC = "Terminates program";

    /**
     * Close is the menu entry, that start exit the program
     */
    public Close(IController controller) {
        this.controller = controller;
    }

    @Override
    public void action() {
        controller.close();
    }

    @Override
    public String command() {
        return CMD;
    }

    @Override
    public String description() {
        return DESC;
    }

}
