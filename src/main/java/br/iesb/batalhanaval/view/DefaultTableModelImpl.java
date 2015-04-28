package br.iesb.batalhanaval.view;

import br.iesb.batalhanaval.model.*;

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
    private List<Embarcacao> listEmbarcacao = new ArrayList<Embarcacao>();

    public DefaultTableModelImpl() {
//        fillLocations();
        configureLocations();
    }

    private void configureLocations() {
        Embarcacao portaAvioes = new PortaAvioes();
        adicionarEmbarcacao(portaAvioes);

        Embarcacao navio4Canos = new Navio4Canos();
        adicionarEmbarcacao(navio4Canos);

        Embarcacao navio3Canos = new Navio3Canos();
        adicionarEmbarcacao(navio3Canos);

        Embarcacao navio2Canos = new Navio2Canos();
        adicionarEmbarcacao(navio2Canos);

        Embarcacao navio1Cano = new Navio1Cano();
        adicionarEmbarcacao(navio1Cano);
    }

    private void fillLocations() {
        for (int row = 0; row < ROW_HEADER.length; row++) {
            for (int column = 0; column < COLUMN_HEADER.length; column++) {
                Location location = new Location();

//                // FIXME remover condição
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
        this.listEmbarcacao.add(embarcacao);
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        for (final Embarcacao embarcacao : listEmbarcacao) {
            for (final Location location : embarcacao.getLocations()) {
                if (location.getAxisRow() == rowIndex && location.getAxisColumn() == columnIndex) {
                    return embarcacao;
                }
            }
        }

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

    @Override
    public void setValueAt(final Object aValue, final int rowIndex, final int columnIndex) {
        super.setValueAt(aValue, rowIndex, columnIndex);
    }

    public List<Embarcacao> getListEmbarcacao() {
        return listEmbarcacao;
    }

    // FIXME Implementar método!

    /**
     * Seta a localização dos navios
     * Deve instanciar o objeto correspondente ex.: Navio, Porta aviões, etc...
     * Capturar o seu objeto localização (obtendo as coordenadas) (verificar conflitos entre as posições (chamar método no pai)
     * ele vai identificar a localização e definir os pontos estratégicos para cada localização das embarcações.
     */
    private int[][] setLocation() {
        return null;
    }
}