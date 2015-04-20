package br.iesb.batalhanaval.view.example1;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

/**
 * Created by Braian Nunes on 4/19/2015.
 */
class MyCellRenderer extends DefaultTableCellRenderer {
    private boolean showSelected = false;
    private byte colorSwitcher;
    private CellSelectionSet cellSelectionSet;

    public MyCellRenderer(CellSelectionSet cellSelectionSet) {
        this.cellSelectionSet = cellSelectionSet;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table,Object value, boolean isSelected, boolean hasFocus, int row,int column) {
        Component superComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (cellSelectionSet.contains(row, column)
                && !cellSelectionSet.getCellAt(row, column).isNewlySelected()) {

            superComponent.setBackground(Color.GREEN);
            setIcon(configureIcon(br.iesb.batalhanaval.model.Icon.HIT));
        }
        else if (table.isCellSelected(row, column)){
            superComponent.setBackground(table.getSelectionBackground());
            setIcon(null);
        }
        else {
            superComponent.setBackground(table.getBackground());
            setIcon(null);
        }
        return superComponent;
    }

    private ImageIcon configureIcon(br.iesb.batalhanaval.model.Icon icon) {
        String uiIcon = "OptionPane.informationIcon";
        if (icon == br.iesb.batalhanaval.model.Icon.HIT) {
            uiIcon = "OptionPane.errorIcon";
        } else if (icon == br.iesb.batalhanaval.model.Icon.WATER) {
            uiIcon = "OptionPane.questionIcon";
        }

        ImageIcon informationIcon = (ImageIcon) UIManager.getIcon(uiIcon);
        Image image = informationIcon.getImage();
        Image newImage = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        informationIcon = new ImageIcon(newImage);

        return informationIcon;
    }
}
