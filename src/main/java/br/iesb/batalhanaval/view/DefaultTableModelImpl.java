package br.iesb.batalhanaval.view;

import br.iesb.batalhanaval.model.Embarcacao;
import br.iesb.batalhanaval.model.Icon;
import br.iesb.batalhanaval.model.Location;
import br.iesb.batalhanaval.model.PortaAvioes;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by abraao.queiroz on 09/04/2015.
 */
public class DefaultTableModelImpl extends AbstractTableModel {
    protected static final String[] COLUMN_HEADER = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    protected static final String[] ROW_HEADER = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
    private List<Location> listLocation = new ArrayList<Location>();

    public DefaultTableModelImpl() {
        fillLocations();
        configureLocations();
    }

    private void configureLocations() {
        Embarcacao portaAvioes = new PortaAvioes();
//        adicionarEmbarcacao(portaAvioes);

    }

    private void fillLocations() {
        for (int row = 0; row < ROW_HEADER.length; row++) {
            for (int column = 0; column < COLUMN_HEADER.length; column++) {
                Location location = new Location();

//                // FIXME remover condi��o
                if (row % 2 == 0) {
                    location.setIcon(Icon.HIT);
                } else {
                    location.setIcon(Icon.WATER);
                }

                location.setAxisRow(row);
                location.setAxisColumn(column);
                listLocation.add(location);
            }
        }
    }

    private void adicionarEmbarcacao(final Embarcacao embarcacao) {
        for (final Location location : embarcacao.getLocations()) {
            this.listLocation.add(location);
        }
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        for (Location item : listLocation) {
            if (item.getAxisRow() == rowIndex && item.getAxisColumn() == columnIndex) {
                return item;
            }
        }
        return new Location(Icon.WATER);
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

    @Override
    public void setValueAt(final Object aValue, final int rowIndex, final int columnIndex) {
        super.setValueAt(aValue, rowIndex, columnIndex);
    }

    // FIXME Implementar m�todo!

    /**
     * Seta a localiza��o dos navios
     * Deve instanciar o objeto correspondente ex.: Navio, Porta avi�es, etc...
     * Capturar o seu objeto localiza��o (obtendo as coordenadas) (verificar conflitos entre as posi��es (chamar m�todo no pai mesmo)
     * ele vai identificar a localiza��o e definir os pontos estrat�gicos para cada localiza��o das embarca��es.
     */
    private int[][] setLocation() {
        return null;
    }
}