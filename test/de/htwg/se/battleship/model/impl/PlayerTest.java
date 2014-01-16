/**
 * 
 */
package de.htwg.se.battleship.model.impl;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import de.htwg.se.battleship.model.ICell;
import de.htwg.se.battleship.model.impl.Grid;
import de.htwg.se.battleship.model.impl.Player;
import de.htwg.se.battleship.model.impl.Ship;

/**
 * @author Philipp Daniels<philipp.daniels@gmail.com>
 * 
 */
public class PlayerTest {

    private Player p1;
    private Player p2;

    private final static String NAME1 = "philipp";
    private final static String NAME2 = "nicolas";

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        p1 = new Player(NAME1);
        p2 = new Player(NAME2);
    }

    @Test
    public void testGetName() {

        assertEquals(NAME1, p1.getName());
        assertEquals(NAME2, p2.getName());
    }

    @Test
    public void testShip() {

        HashMap<String, ICell> map = new HashMap<String, ICell>();

        Ship s1 = new Ship(p1, map);
        assertTrue(p1.containsShip(s1));

        Ship s2 = new Ship(p1, map);
        assertTrue(p1.containsShip(s2));

        assertTrue(p1.containsShip(s1));
    }

    @Test
    public void testGrid() {
        Grid g1 = new Grid(1, p1);
        assertEquals(p1.getGrid(), g1);

        Grid g2 = new Grid(1, p2);
        assertEquals(p2.getGrid(), g2);
    }
}
