/**
 * 
 */
package de.htwg.se.battleship.controller.event;

import de.htwg.se.battleship.model.Round;

/**
 * @author Philipp Daniels<philipp.daniels@gmail.com>
 *
 */
public class WrongCoordinate extends AbstractEvent {

    private final String message;

    /**
     * Create instance of WrongCoordinate.
     * @param round Round
     */
    public WrongCoordinate(Round round, String message) {
        super(round);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
