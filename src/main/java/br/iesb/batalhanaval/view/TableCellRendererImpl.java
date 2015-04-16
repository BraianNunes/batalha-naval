package br.iesb.batalhanaval.view;

import br.iesb.batalhanaval.model.Location;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

/**
 * Created by abraao.queiroz on 16/04/2015.
 */
public class TableCellRendererImpl extends DefaultTableCellRenderer {
    public TableCellRendererImpl() {
        setHorizontalAlignment(CENTER);
    }

    @Override
    public Component getTableCellRendererComponent(final JTable table, final Object value, final boolean isSelected, final boolean hasFocus, final int row, final int column) {
        Component renderer = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        renderer.setForeground(Color.RED);
        
        return this;
    }

    @Override
    protected void setValue(final Object value) {
        if (value == null) {
            return;
        }

        Object result = value;
        if (value instanceof Location) {
            Location location = (Location) value;
            result = location.getIcon().toString();
        }

        super.setValue(result);
    }
}
