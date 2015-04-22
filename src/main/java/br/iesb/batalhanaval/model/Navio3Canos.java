package br.iesb.batalhanaval.model;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Braian Nunes on 4/21/2015.
 */
public class Navio3Canos implements Embarcacao {
    private static int LIFE = 6;

    @Override
    public String getName() {
        return "Navio de 3 canos";
    }

    @Override
    public int getLife() {
        return LIFE;
    }

    @Override
    public List<Location> getLocations() {
        List<Location> locations = new ArrayList<Location>();

        Location l1 = new Location(4, 2);
        locations.add(l1);

        Location l2 = new Location(4, 3);
        locations.add(l2);

        Location l3 = new Location(4, 4);
        locations.add(l3);

        Location l4 = new Location(4, 6);
        locations.add(l4);

        Location l5 = new Location(4, 7);
        locations.add(l5);

        Location l6 = new Location(4, 8);
        locations.add(l6);

        return locations;
    }

    @Override
    public void decrementLife() {
        LIFE -= 1;
    }
}