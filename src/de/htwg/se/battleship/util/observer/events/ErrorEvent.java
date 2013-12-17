package de.htwg.se.battleship.util.observer.events;

import de.htwg.se.battleship.util.observer.Event;

/**
 * Standard ERROR event with an outputMessage
 * 
 * @author aullik
 */
public class ErrorEvent implements Event {

    private final String message;

    /**
     * @param msg sets message
     */
    public ErrorEvent(String msg) {
        this.message = msg;

    }

    @Override
    public String getMessage() {
        return message;
    }

}
