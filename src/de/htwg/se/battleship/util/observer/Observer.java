package de.htwg.se.battleship.util.observer;

/**
 * Interface for Observer
 * 
 * @author aullik
 */
public interface Observer {
    /**
     * Updates specified to e whenever it got notified
     * 
     * @param e Event
     */
    void update(Event e);

}
