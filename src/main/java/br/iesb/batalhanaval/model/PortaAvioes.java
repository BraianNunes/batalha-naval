package br.iesb.batalhanaval.model;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Braian Nunes on 4/21/2015.
 */
public class PortaAvioes implements Embarcacao {
    private static final int LIFE = 5;

    @Override
    public String getName() {
        return "Porta avi�es!";
    }

    @Override
    public int getLife() {
        return LIFE;
    }

    @Override
    public List<Location> getLocations() {
        List<Location> locations = new ArrayList<Location>();

        Location l1 = new Location(0, 0);
        locations.add(l1);

        Location l2 = new Location(0, 1);
        locations.add(l2);

        Location l3 = new Location(0, 2);
        locations.add(l3);

        Location l4 = new Location(1, 1);
        locations.add(l4);

        Location l5 = new Location(2, 1);
        locations.add(l5);

        if (locations.size() != LIFE) {
            throw new IllegalArgumentException("Quantidade de localiza��es incorretas para o " + this.getName());
        }

        return locations;
    }
}
