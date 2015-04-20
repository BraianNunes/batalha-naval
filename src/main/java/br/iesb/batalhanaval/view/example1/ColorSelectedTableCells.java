package br.iesb.batalhanaval.view.example1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Braian Nunes on 4/19/2015.
 */
public class ColorSelectedTableCells extends JPanel {
    public static final Object[][] DATA = new Object[3][3];
    public static final String[] COLS = {"A", "B", "C"};
    private static final int PREF_WIDTH = 400;
    private static final int PREF_HEIGHT = 300;
    private static CellSelectionSet2 cellSelectionSet = new CellSelectionSet2();

    private JButton btn = new JButton("color cells");
    private MyCellRenderer myCellRenderer = new MyCellRenderer(cellSelectionSet);

    private JTable table = new JTable(DATA, COLS) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }

        @Override
        public boolean isCellSelected(int row, int column) {
            if (cellSelectionSet.containsOneOrLess()) {
                return super.isCellSelected(row, column);
            }
            return cellSelectionSet.contains(row, column);
        }

        @Override
        public void changeSelection(int rowIndex, int columnIndex, boolean toggle, boolean extend) {
            super.changeSelection(rowIndex, columnIndex, toggle, extend);
            if (toggle) {
                cellSelectionSet.add(rowIndex, columnIndex);
            } else {
                if (extend) {
                    cellSelectionSet.add(rowIndex, columnIndex);
                } else {
                    cellSelectionSet.add(rowIndex, columnIndex);
                }
            }
        }
    };

    public ColorSelectedTableCells() {
        table.setDefaultRenderer(Object.class, myCellRenderer);
        table.setCellSelectionEnabled(true);
        table.setColumnSelectionAllowed(false);
        table.setRowSelectionAllowed(false);

        JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JPanel btnPanel = new JPanel();
        btnPanel.add(btn);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // myCellRenderer.setShowSelected(true);
                for (int i = 0; i < cellSelectionSet.getSize(); i++) {
                    cellSelectionSet.getElementAt(i).setNewlySelected(false);
                }
                table.repaint();
            }
        });
    }

    private static void createAndShowUI() {
        JFrame frame = new JFrame();
        frame.getContentPane().add(new ColorSelectedTableCells());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                createAndShowUI();
            }
        });
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(PREF_WIDTH, PREF_HEIGHT);
    }
}