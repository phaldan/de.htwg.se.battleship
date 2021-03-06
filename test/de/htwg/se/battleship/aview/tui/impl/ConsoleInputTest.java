package de.htwg.se.battleship.aview.tui.impl;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConsoleInputTest {

    private final static String text = "test";
    private ConsoleInput input;
    private InputStream backup;

    @Before
    public void setUp() {
        backup = System.in;
    }

    @After
    public void tearDown() {
        System.setIn(backup);
    }

    private class TestThread implements Runnable {

        @Override
        public void run() {
            try {

                byte[] bytes = "".getBytes("UTF-8");
                System.setIn(new ByteArrayInputStream(bytes));
                input = new ConsoleInput();
                input.get();
            } catch (Exception e) {
                fail(e.getMessage());
            }
        }
    }

    @Test
    public void testWithOneLine() throws Exception {

        String lineSeperator = System.getProperty("line.separator");
        String string = ConsoleInputTest.text + lineSeperator;
        byte[] bytes = string.getBytes("UTF-8");
        System.setIn(new ByteArrayInputStream(bytes));

        input = new ConsoleInput();
        assertEquals(ConsoleInputTest.text, input.get());
    }

    @Test
    public void testWithTwoLines() throws Exception {
        String lineSeperator = System.getProperty("line.separator");
        String string = ConsoleInputTest.text + lineSeperator;

        byte[] bytes = (string + string).getBytes("UTF-8");
        System.setIn(new ByteArrayInputStream(bytes));

        input = new ConsoleInput();
        assertEquals(ConsoleInputTest.text, input.get());
    }

    @Test
    public void testWithEmptyInput() throws InterruptedException {
        Runnable r = new TestThread();
        Thread t = new Thread(r);
        t.start();

        Thread.sleep(50);
        input.close();
    }
}
