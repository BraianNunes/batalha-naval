package br.iesb.batalhanaval.view;

import br.iesb.batalhanaval.model.Icon;
import br.iesb.batalhanaval.model.Location;

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
//        renderer.setForeground(Color.RED);

        if (localizacaoExata(table, row, column)) {
            Location location = locationSelectionSet.getLocationAt(row, column);
            location.setNewlySelected(false);

            System.out.println("Row: " + row + " Column: " + column);
            System.out.println("Selected row: " + table.getSelectedRow() + " Selected Column: " + table.getSelectedColumn());

//            Location location1 = ((Location) table.getValueAt(row, column));
            setIcon(configureIcon(Icon.HIT, 60, 60));
//            table.repaint();

        } else if (table.isCellSelected(row, column)) {
//            System.out.println("not contains 1");
            renderer.setBackground(table.getSelectionBackground());
            setIcon(configureIcon(Icon.WATER, 25, 25));

        } else {
//            System.out.println("not contains 2");
            renderer.setBackground(table.getBackground());
            setIcon(null);
//            setBackground(Color.decode("#006994"));
        }

        return this;
    }

    private boolean localizacaoExata(final JTable table, final int row, final int column) {
        if (this.locationSelectionSet.contains(row, column)) {
            return true;
        }

        if (table.getSelectedRow() == row && table.getSelectedColumn() == column) {
            Location location = (Location) table.getModel().getValueAt(table.getSelectedRow(), table.getSelectedColumn());
            if (location != null) {
                this.locationSelectionSet.add(table.getSelectedRow(), table.getSelectedColumn());
                return true;
            }
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
}
