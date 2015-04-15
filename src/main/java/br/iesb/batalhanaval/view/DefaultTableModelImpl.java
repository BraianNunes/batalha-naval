package br.iesb.batalhanaval.view;

import br.iesb.batalhanaval.model.Icon;
import br.iesb.batalhanaval.model.Location;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by abraao.queiroz on 09/04/2015.
 */
public class DefaultTableModelImpl extends AbstractTableModel {
    protected static final String[] COLUMN_HEADER = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    protected static final String[] ROW_HEADER = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

    private List<Location> listLocation;

    public DefaultTableModelImpl() {
        createLocations();
    }

    private void createLocations() {
        listLocation = new ArrayList<Location>();
        for (int i = 0; i < ROW_HEADER.length * COLUMN_HEADER.length; i++) {
            // FIXME remover condição
            if (i % 2 == 0) {
                listLocation.add(new Location(Icon.HIT));
            } else {
                listLocation.add(new Location(Icon.WATER));
            }
        }
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }

    public int getColumnCount() {
        return COLUMN_HEADER.length;
    }

    public int getRowCount() {
        return ROW_HEADER.length;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
}