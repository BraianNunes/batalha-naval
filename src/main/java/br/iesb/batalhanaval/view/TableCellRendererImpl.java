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

//        System.out.println("..........");

        if (locationSelectionSet.contains(row, column) && !locationSelectionSet.getLocationAt(row, column).isNewlySelected()) {

            renderer.setBackground(Color.GREEN);
            System.out.println("contains");
            Location location = ((Location) table.getValueAt(row, column));
            if (location.getIcon() == Icon.HIT) {
                setIcon(configureIcon(location.getIcon(), 60, 60));
//                setIcon(null);
//                setBackground(Color.red);
            } else {
                setIcon(configureIcon(location.getIcon(), 25, 25));
                setBackground(Color.decode("#499DF5"));//"#006994"));
            }

        } else if (table.isCellSelected(row, column)) {
            renderer.setBackground(table.getSelectionBackground());
//            setIcon(configureIcon(location.getIcon()));

        } else {
//            System.out.println("not contains 2");
            renderer.setBackground(table.getBackground());
            setIcon(null);
//            setBackground(Color.decode("#006994"));
        }

        return this;
    }

    private ImageIcon configureIcon(Icon icon, int witdh, int height) {
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/" + icon.getIcon()));
        Image image = imageIcon.getImage();
        Image newImage = image.getScaledInstance(witdh, height, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newImage);

        return imageIcon;
    }

//    @Override
//    protected void setValue(final Object value) {
//        if (value == null) {
//            return;
//        }
//
//        Object result = value;
//        if (value instanceof Location) {
//            Location location = (Location) value;
//            result = location.getIcon().getIcon();
////            result = configureIcon(Icon.HIT);
//        }
//
//        super.setValue("");
//    }
}
