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
    private final LocationSelectionSet locationSelectionSet = new LocationSelectionSet();
    private String headers[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

    private JScrollPane scroll = new JScrollPane(this);
    private DefaultTableModelImpl myTableModel;

    private ImageIcon infoIcon = (ImageIcon) UIManager.getIcon("OptionPane.informationIcon");
    private ImageIcon errorIcon = (ImageIcon) UIManager.getIcon("OptionPane.errorIcon");
    private ImageIcon warnIcon = (ImageIcon) UIManager.getIcon("OptionPane.warningIcon");
    private boolean pressed;

    public BoardTable(DefaultTableModelImpl defaultTableModel) {
        super(defaultTableModel);
        super.setDefaultRenderer(Object.class, new TableCellRendererImpl(locationSelectionSet));
        this.myTableModel = defaultTableModel;
        initializeVariables();
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

//    @Override
//    public boolean isCellSelected(final int row, final int column) {
////        if (locationSelectionSet.containsOneOrLess()) {
////            return isCellSelected(row, column);
////        }
//
//        return locationSelectionSet.contains(row, column);
//    }

    @Override
    public void changeSelection(final int rowIndex, final int columnIndex, final boolean toggle, final boolean extend) {
        super.changeSelection(rowIndex, columnIndex, toggle, extend);
//        if (toggle) {
//            locationSelectionSet.add(rowIndex, columnIndex);
//
//        } else {
//            if (extend) {
//                locationSelectionSet.add(rowIndex, columnIndex);
//
//            } else {
//                locationSelectionSet.add(rowIndex, columnIndex);
//            }
//        }
        if (!toggle && !extend) {
            locationSelectionSet.add(rowIndex, columnIndex);
        }
    }

    protected void initializeVariables() {
        this.setRowHeight(30);
        this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.setCellSelectionEnabled(true);
        this.setColumnSelectionAllowed(false);
        this.setRowSelectionAllowed(false);
        this.setDragEnabled(false);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = getSelectedRow();
                int column = getSelectedColumn();

                System.out.println("Mouse clicked!");

                for (int i = 0; i < locationSelectionSet.getSize(); i++) {
                    locationSelectionSet.getElementAt(i).setNewlySelected(false);
                }

                repaint();
            }
        });

        configureScrollPane();
    }
    
    private boolean isUnselected(MouseEvent e) {
        Point pt = e.getPoint();
        int row = rowAtPoint(pt);
        int col = columnAtPoint(pt);
        return row >= 0 && col >= 0 && !super.isCellSelected(row, col);
    }

    @Override
    protected void processMouseEvent(MouseEvent e) {
        pressed = e.getID() == MouseEvent.MOUSE_PRESSED
                && SwingUtilities.isLeftMouseButton(e)
                && !e.isShiftDown() && !e.isControlDown()
                && isUnselected(e);
        try {
            if (pressed)
                clearSelection();
            super.processMouseEvent(e);
        } finally {
            pressed = false;
        }
    }

    @Override
    public boolean isCellSelected(int row, int col) {
//        return pressed && locationSelectionSet.contains(row, col) ? true : super.isCellSelected(row, col);
        // super.isCellSelected(row, col);
        return false;
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