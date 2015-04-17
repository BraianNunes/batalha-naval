package br.iesb.batalhanaval.model;

/**
 * Created by abraao.queiroz on 10/04/2015.
 */
public class Location {
    private int axisRow;
    private int axisColumn;
    private Icon icon;

    public Location() {
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
}
