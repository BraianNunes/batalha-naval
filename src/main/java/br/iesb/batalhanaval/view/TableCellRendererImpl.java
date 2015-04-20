package br.iesb.batalhanaval.view;

import br.iesb.batalhanaval.model.Icon;
import br.iesb.batalhanaval.model.Location;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

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
        renderer.setForeground(Color.RED);

        if (locationSelectionSet.contains(row, column) && !locationSelectionSet.getLocationAt(row, column).isNewlySelected()) {
            renderer.setBackground(Color.GREEN);
            setIcon(configureIcon(Icon.HIT));

        } else if (table.isCellSelected(row, column)) {
            renderer.setBackground(table.getSelectionBackground());
            setIcon(null);

        } else {
            renderer.setBackground(table.getBackground());
            setIcon(null);
        }

        return this;
    }

    /*
    private ImageIcon errorIcon = (ImageIcon) UIManager.getIcon("OptionPane.errorIcon");
    private ImageIcon infoIcon = (ImageIcon) UIManager.getIcon("OptionPane.informationIcon");
    private ImageIcon warnIcon = (ImageIcon) UIManager.getIcon("OptionPane.warningIcon");
    private ImageIcon questIcon = (ImageIcon) UIManager.getIcon("OptionPane.questionIcon");
    * */

    private ImageIcon configureIcon(Icon icon) {
        String uiIcon = "OptionPane.informationIcon";
        if (icon == Icon.HIT) {
            uiIcon = "OptionPane.errorIcon";
        } else if (icon == Icon.WATER) {
            uiIcon = "OptionPane.questionIcon";
        }

//        ImageIcon informationIcon = (ImageIcon) UIManager.getIcon(uiIcon);
        try {
            BufferedImage image = ImageIO.read(getClass().getResource("/Resources/Flower0.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ImageIcon informationIcon = new ImageIcon(getClass().getResource("images/gif_bomb.png"));
        System.out.println("informationIcon = " + informationIcon);

        Image image = informationIcon.getImage();
        Image newImage = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        informationIcon = new ImageIcon(newImage);

        return informationIcon;
    }

    @Override
    protected void setValue(final Object value) {
        if (value == null) {
            return;
        }

        Object result = value;
        if (value instanceof Location) {
            Location location = (Location) value;
            result = location.getIcon().getIcon();
//            result = configureIcon(Icon.HIT);
        }

        super.setValue(result);
    }
}
