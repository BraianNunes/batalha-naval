package br.iesb.batalhanaval.view;

import br.iesb.batalhanaval.model.Location;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by abraao.queiroz on 09/04/2015.
 */
public class BoardTable extends JTable {
    private String headers[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private JScrollPane scroll = new JScrollPane(this);
    private DefaultTableModelImpl myTableModel;

    private ImageIcon errorIcon = (ImageIcon) UIManager.getIcon("OptionPane.errorIcon");
    private ImageIcon infoIcon = (ImageIcon) UIManager.getIcon("OptionPane.informationIcon");
    private ImageIcon warnIcon = (ImageIcon) UIManager.getIcon("OptionPane.warningIcon");

    public BoardTable(DefaultTableModelImpl defaultTableModel) {
        super(defaultTableModel);
        super.setDefaultRenderer(Object.class, new TableCellRendererImpl());
        this.myTableModel = defaultTableModel;
        initializeVariables();
    }

    @Override
    public Component prepareRenderer(final TableCellRenderer renderer, final int row, final int column) {
        Component component = super.prepareRenderer(renderer, row, column);
//        System.out.println("Prepare component!");
//        JLabel jLabel = (JLabel) component;
        if (isRowSelected(row) && isColumnSelected(column)) {
//            Location location = (Location) myTableModel.getValueAt(row, column);
//            location.setIcon(Icon.EMPTY);
//
//            jLabel.setText(location.getIcon().getIcon());
//            System.out.println("Row: " + getSelectedRow() + " Column: " + getSelectedColumn());
//            Rectangle rectangle = new Rectangle();
//            rectangle.add(new Point(row, column));
//            repaint(rectangle);
        }

        return component;
    }

    protected void initializeVariables() {
        this.setRowHeight(30);
        this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.setCellSelectionEnabled(true);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = getSelectedRow();
                int column = getSelectedColumn();

//                System.out.println("Row: " + getSelectedRow() + " Column: " + getSelectedColumn());
                Location location = (Location) myTableModel.getValueAt(row, column);
                System.out.println("Icon: " + location.getIcon().toString());
//                setDefaultRenderer(Object.class, new TableCellRendererImpl(row, column));
//                getColumnModel().getColumn(0).setCellRenderer(new TableCellRendererImpl(0, 1));
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