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

    private int column;
    private int row;

    public TableCellRendererImpl(int row, int column) {
        this.row = row;
        this.column = column;
        setHorizontalAlignment(CENTER);
    }

    public TableCellRendererImpl() {
        setHorizontalAlignment(CENTER);
    }

    @Override
    public Component getTableCellRendererComponent(final JTable table, final Object value, final boolean isSelected, final boolean hasFocus, final int row, final int column) {
        Component renderer = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        renderer.setForeground(Color.RED);
//
//        setForeground( (column == this.column && row == this.row) ? Color.red : Color.black );
//
        if (isSelected) {
            Location location = (Location) table.getModel().getValueAt(row, column);
//            location.setIcon(Icon.EMPTY);
            System.out.println("Setando Empty");
//            setIcon(location.getIcon().getIcon());

            if (location.getIcon() == Icon.WATER) {
                setText("AGUA!");
                renderer.setBackground(Color.BLUE);
            }
        } else {
            renderer.setBackground(table.getBackground());
        }
//        setText("");

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

        ImageIcon informationIcon = (ImageIcon) UIManager.getIcon(uiIcon);
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
