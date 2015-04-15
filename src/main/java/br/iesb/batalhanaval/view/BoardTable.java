package br.iesb.batalhanaval.view;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by abraao.queiroz on 09/04/2015.
 */
public class BoardTable extends JTable {
    private String headers[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private JScrollPane scroll = new JScrollPane(this);

    public BoardTable(DefaultTableModelImpl defaultTableModel) {
        super(defaultTableModel);
        initializeVariables();
    }

    protected void initializeVariables() {
        this.setRowHeight(30);
        this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.setCellSelectionEnabled(true);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Row: " + getSelectedRow() + " Column: " + getSelectedColumn());
            }
        });


        configureScrollPane();
    }

    private void configureScrollPane() {
        // Configure RowHeader
        RowHeaderAll rowHeader = new RowHeaderAll(headers, this);
        rowHeader.setPreferredSize(new Dimension(10, 100));

        // Column Header
        JTableHeader tableHeader = this.getTableHeader();
        tableHeader.setPreferredSize(new Dimension(100, 30));

        // Configure scroll
        scroll.setRowHeaderView(rowHeader);
        scroll.setColumnHeaderView(tableHeader);

        // Configure corner
        String[] corner = {""};
        scroll.setCorner(JScrollPane.UPPER_LEFT_CORNER, new RowHeaderAll(corner, this));
    }
}
