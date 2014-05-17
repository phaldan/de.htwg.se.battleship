/**
 * 
 */
package de.htwg.se.battleship.aview.tui;

import java.io.IOException;

/**
 * @author Philipp Daniels<philipp.daniels@gmail.com>
 *
 */
public interface Input {

    /**
     * Retrieve input from interface
     * 
     * @return String
     */
    public String get() throws IOException;


    /**
     * Close all resources of interface
     */
    public void close();
}
