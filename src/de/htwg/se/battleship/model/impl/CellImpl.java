/**
 *
 */
package de.htwg.se.battleship.model.impl;

import de.htwg.se.battleship.model.Cell;
import de.htwg.se.battleship.model.Grid;
import de.htwg.se.battleship.model.Ship;

/**
 * This class contains all data of a single Cell
 * 
 * @author Philipp Daniels<philipp.daniels@gmail.com>
 * 
 */
public class CellImpl implements Cell {

    private static final int STATUS_NORMAL = 0;
    private static final int STATUS_SHOT = 1;
    private static final int STATUS_HIT = 2;

    private final int x;
    private final int y;
    private final String key;
    private final Grid grid;
    private Ship ship;
    private int status;

    /**
     * Create a new Cell instance with coordinates and initialize list for Ship
     * and Player.
     * 
     * @param x X-Coordinate
     * @param y Y-Coordinate
     */
    public CellImpl(int x, int y, Grid grid) {
        this.x = x;
        this.y = y;
        this.key = CellImpl.createKey(x, y);
        this.status = STATUS_NORMAL;
        this.grid = grid;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public Grid getGrid() {
        return grid;
    }

    @Override
    public void setShip(final Ship ship) {
        this.ship = ship;
    }

    @Override
    public Ship getShip() {
        return ship;
    }

    @Override
    public boolean isNormal() {
        return (status == STATUS_NORMAL);
    }

    @Override
    public boolean isHit() {
        return (status == STATUS_HIT);
    }

    @Override
    public boolean isShot() {
        return (status == STATUS_SHOT || isHit());
    }

    @Override
    public void setToHit() {
        status = STATUS_HIT;
    }

    @Override
    public void setToShot() {
        status = STATUS_SHOT;
    }

    /**
     * Create with x- and y-coordinate a key for a Map
     * 
     * @param x X-Coordinate
     * @param y Y-Coordinate
     * @return Key of the cell
     */
    public static String createKey(final int x, final int y) {
        return x + "." + y;
    }
}