/**
 * 
 */
package de.htwg.se.battleship.controller;

import de.htwg.se.battleship.controller.event.CloseProgamm;
import de.htwg.se.battleship.controller.event.InitGame;
import de.htwg.se.battleship.util.observer.Observable;

/**
 * @author Philipp Daniels<philipp.daniels@gmail.com>
 *
 */
public class Controller extends Observable implements IController {

    @Override
    public void newGame() {
        notifyObservers(new InitGame(new InitGameController()));
    }

    @Override
    public void close() {
        notifyObservers(new CloseProgamm());
    }

}
