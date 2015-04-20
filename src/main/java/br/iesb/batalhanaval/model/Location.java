package br.iesb.batalhanaval.model;

/**
 * Created by abraao.queiroz on 10/04/2015.
 */
public class Location {
    private int axisRow;
    private int axisColumn;
    private Icon icon;
    private boolean newlySelected = true;

    public Location() {
    }

    public Location(final int finalAxisRow, final int finalAxisColumn) {
        axisRow = finalAxisRow;
        axisColumn = finalAxisColumn;
    }

    public Location(Icon icon) {
        this.icon = icon;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public int getAxisRow() {
        return axisRow;
    }

    public void setAxisRow(final int finalAxisRow) {
        axisRow = finalAxisRow;
    }

    public int getAxisColumn() {
        return axisColumn;
    }

    public void setAxisColumn(final int finalAxisColumn) {
        axisColumn = finalAxisColumn;
    }

    @Override
    public String toString() {
        return "L";
    }

    public boolean is(int row, int column) {
        return axisRow == row && axisColumn == column;
    }

    public boolean isNewlySelected() {
        return newlySelected;
    }

    public void setNewlySelected(boolean newlySelected) {
        this.newlySelected = newlySelected;
    }
}
