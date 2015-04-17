package br.iesb.batalhanaval.view;

import javax.swing.*;

/**
 * Created by abraao.queiroz on 08/04/2015.
 */
public class RowHeaderAll extends JList {
    public RowHeaderAll(String[] headers, JTable table) {
        super(headers);

        setFixedCellWidth(50);
        setFixedCellHeight(table.getRowHeight());
        setCellRenderer(new RowHeaderRenderer(table));
    }
}
