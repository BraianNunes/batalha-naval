package br.iesb.batalhanaval.model;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Braian Nunes on 4/21/2015.
 */
public class Navio1Cano implements Embarcacao {
    private static int LIFE = 4;

    @Override
    public String getName() {
        return "Navio 1 cano";
    }

    @Override
    public int getLife() {
        return LIFE;
    }

    @Override
    public List<Location> getLocations() {
        List<Location> locations = new ArrayList<Location>();

        Location l1 = new Location(8, 2);
        locations.add(l1);

        Location l2 = new Location(8, 4);
        locations.add(l2);

        Location l3 = new Location(8, 6);
        locations.add(l3);

        Location l4 = new Location(8, 8);
        locations.add(l4);

        return locations;
    }

    @Override
    public void decrementLife() {
        LIFE -= 1;
    }
}