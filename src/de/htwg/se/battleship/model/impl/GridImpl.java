/**
 *
 */
package de.htwg.se.battleship.model.impl;

import java.util.HashMap;
import java.util.Map;

import de.htwg.se.battleship.model.Cell;
import de.htwg.se.battleship.model.Grid;
import de.htwg.se.battleship.model.Player;

/**
 * This class contains all data for the Grid
 * 
 * @author Philipp Daniels<philipp.daniels@gmail.com>
 * 
 */
public class GridImpl implements Grid {

    public static final int DEFAULT_SIZE = 10;

    private final int size;
    private final Map<String, Cell> cells;
    private final Player player;

    /**
     * Create new instance of a Grid with his size.
     * 
     * @param size Number of cell for width/height
     */
    public GridImpl(final int size, final Player player) {
        this.size = size;
        this.cells = new HashMap<String, Cell>();
        this.player = player;
        player.setGrid(this);

        initCells();
    }

    private void initCells() {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                addCell(new CellImpl(i, j, this));
            }
        }
    }

    @Override
    public int getWidth() {
        return size;
    }

    private void addCell(final CellImpl cell) {
        cells.put(cell.getKey(), cell);
    }

    @Override
    public Cell getCell(final int x, final int y) {
        String key = CellImpl.createKey(x, y);
        Cell cell = null;

        if (cells.containsKey(key)) {
            cell = cells.get(key);
        }

        return cell;
    }

    @Override
    public Player getPlayer() {
        return player;
    }
}