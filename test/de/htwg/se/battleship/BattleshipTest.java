package de.htwg.se.battleship;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.htwg.se.battleship.aview.tui.menuentry.Close;

public class BattleshipTest {

    private InputStream backup;

    @Before
    public void setUp() throws UnsupportedEncodingException {
        backup = System.in;

        Close close = new Close(null);
        String s = close.command() + System.getProperty("line.separator");
        System.setIn(new ByteArrayInputStream(s.getBytes("UTF-8")));
    }

    @After
    public void tearDown() {
        System.setIn(backup);
    }

    @Test
    public void test() {
        try {
            Battleship.main(null);
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }

    @Test
    public void testGetInstance() {
        Battleship b1 = Battleship.getInstance();
        Battleship b2 = Battleship.getInstance();

        assertEquals(b1, b2);
    }

}
