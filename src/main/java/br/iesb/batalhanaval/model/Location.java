package br.iesb.batalhanaval.model;

/**
 * Created by abraao.queiroz on 10/04/2015.
 */
public class Location {
    private int axisX;
    private int axisY;
    private Icon icon = Icon.EMPTY;

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

    public int getAxisX() {
        return axisX;
    }

    public void setAxisX(int axisX) {
        this.axisX = axisX;
    }

    public int getAxisY() {
        return axisY;
    }

    public void setAxisY(int axisY) {
        this.axisY = axisY;
    }
}
