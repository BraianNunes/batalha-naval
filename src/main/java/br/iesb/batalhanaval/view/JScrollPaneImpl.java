package br.iesb.batalhanaval.view;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;

/**
 * Created by abraao.queiroz on 13/04/2015.
 */
public class JScrollPaneImpl extends JScrollPane {

    public JScrollPaneImpl(JTable jtable) {
        super(jtable);

        // Row Header
        RowHeaderAll rowHeaderAll = new RowHeaderAll(DefaultTableModelImpl.ROW_HEADER, jtable);
        setRowHeaderView(rowHeaderAll);

        // Column Header
        JTableHeader tableHeader = jtable.getTableHeader();
        tableHeader.setPreferredSize(new Dimension(100, 30));
//        tableHeader.set

        // Configure scroll
        setColumnHeaderView(tableHeader);

        String[] corner = {"Player 1 "};
        setCorner(JScrollPane.UPPER_LEFT_CORNER, new RowHeaderAll(corner, jtable));
    }
}
