package br.iesb.batalhanaval.model;

/**
 * Created by abraao.queiroz on 10/04/2015.
 */
public enum Icon {
    WATER("W"),
    HIT("H"),
    EMPTY("-");

    private String icon;

    Icon(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }
}
