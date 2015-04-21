package br.iesb.batalhanaval.view.example1;

/**
 * Created by Braian Nunes on 4/19/2015.
 */
public class Cell {
    private int row, column;
    private boolean newlySelected = true;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public boolean is(int r, int c) {
        return row == r && column == c;
    }

    public boolean isNewlySelected() {
        return newlySelected;
    }

    public void setNewlySelected(boolean newlySelected) {
        this.newlySelected = newlySelected;
    }
}

