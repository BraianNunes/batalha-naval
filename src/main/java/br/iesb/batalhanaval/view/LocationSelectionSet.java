package br.iesb.batalhanaval.view;

import br.iesb.batalhanaval.model.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Braian Nunes on 4/19/2015.
 */
public class LocationSelectionSet {
    private List<Location> locations = new ArrayList<Location>();

    public void add(int r, int c) {
        if (!contains(r, c)) {
            locations.add(new Location(r, c));
        }
    }

    public boolean containsOneOrLess() {
        return locations.size() <= 1;
    }

    public boolean contains(int row, int column) {
        for (Location location : locations) {
            if (location.is(row, column)) {
                return true;
            }
        }
        return false;
    }

    public Location getElementAt(int i) {
        return locations.get(i);
    }

    public int getSize() {
        return this.locations.size();
    }

    public Location getLocationAt(int row, int column) {
        Location l = null;

        for (Location location : locations) {
            if (location.is(row, column)) {
                l = location;
            }

        }
        return l;
    }
}