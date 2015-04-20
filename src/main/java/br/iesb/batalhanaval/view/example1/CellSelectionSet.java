package br.iesb.batalhanaval.view.example1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Braian Nunes on 4/19/2015.
 */
public class CellSelectionSet {
    private List<Cell> cells = new ArrayList<Cell>();

    public void add(int r, int c) {
        if (!contains(r, c)) {
            cells.add(new Cell(r, c));
        }
    }

    public boolean containsOneOrLess() {
        return cells.size() <= 1;
    }

    public boolean contains(int r, int c) {
        for (Cell cell : cells) {
            if (cell.is(r, c)) {
                return true;
            }
        }
        return false;
    }

    public Cell getElementAt(int i){
        return cells.get(i);
    }

    public int getSize(){
        return this.cells.size();
    }

    public void clear() {
        cells.clear();
        System.out.println("CellSelectionSet cleared.");
    }

    public Cell getCellAt(int row, int column) {
        Cell c = null;
        for (Cell cell : cells) {
            if (cell.is(row, column)) {
                c = cell;
            }
        }
        return c;
    }

}

