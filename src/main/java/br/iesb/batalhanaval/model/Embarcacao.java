package br.iesb.batalhanaval.model;
import java.util.List;
/**
 * Created by Braian Nunes on 4/21/2015.
 */
public interface Embarcacao {
    String getName();

    int getLife();

    List<Location> getLocations();

    void decrementLife();
}
