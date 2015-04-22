package br.iesb.batalhanaval.view;

import br.iesb.batalhanaval.model.Embarcacao;
import br.iesb.batalhanaval.model.Icon;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

/**
 * Created by abraao.queiroz on 16/04/2015.
 */
public class TableCellRendererImpl extends DefaultTableCellRenderer {

    private LocationSelectionSet locationSelectionSet = null;

    public TableCellRendererImpl(final LocationSelectionSet locationSelectionSet) {
        this.locationSelectionSet = locationSelectionSet;
        setHorizontalAlignment(CENTER);
    }

    @Override
    public Component getTableCellRendererComponent(final JTable table, final Object value, final boolean isSelected, final boolean hasFocus, final int row, final int column) {
        Component renderer = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (localizacaoExata(table, row, column)) {
            setIcon(configureIcon(Icon.HIT, 60, 60));

        } else if (this.locationSelectionSet.contains(row, column, Icon.WATER)) {
            renderer.setBackground(table.getSelectionBackground());
            setIcon(configureIcon(Icon.WATER, 25, 25));

        } else {
            renderer.setBackground(table.getBackground());
            setIcon(null);
            setBackground(Color.decode("#006994"));
        }

        return this;
    }

    private boolean localizacaoExata(final JTable table, final int row, final int column) {
        if (this.locationSelectionSet.contains(row, column, Icon.HIT)) {
            return true;
        }

        if (table.getSelectedRow() == row && table.getSelectedColumn() == column) {
            Embarcacao embarcacao = (Embarcacao) table.getModel().getValueAt(table.getSelectedRow(), table.getSelectedColumn());
            if (embarcacao != null) {
                embarcacao.decrementLife();
                this.locationSelectionSet.add(table.getSelectedRow(), table.getSelectedColumn(), Icon.HIT);
                return true;
            }

            // Adiciona água a lista
            this.locationSelectionSet.add(table.getSelectedRow(), table.getSelectedColumn(), Icon.WATER);
        }

        return false;
    }

    private ImageIcon configureIcon(Icon icon, int witdh, int height) {
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/" + icon.getIcon()));
        Image image = imageIcon.getImage();
        Image newImage = image.getScaledInstance(witdh, height, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newImage);

        return imageIcon;
    }

    @Override
    protected void setValue(final Object value) {
        super.setValue("");
    }
}