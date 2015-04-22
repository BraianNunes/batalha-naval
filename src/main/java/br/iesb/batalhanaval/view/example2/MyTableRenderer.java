package br.iesb.batalhanaval.view.example2;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MyTableRenderer {

    private final class DefaultTableModelExtension extends DefaultTableModel {
        private static final long serialVersionUID = 1L;

        private String selected;

        private DefaultTableModelExtension(Object[][] data, Object[] columnNames) {
            super(data, columnNames);
        }

        @Override
        public Class getColumnClass(int column) {
            return getValueAt(0, column).getClass();
        }

        public String getSelected() {
            return selected;
        }

        public void setSelected(String selected) {
            if (this.selected == null && selected == null || this.selected != null && this.selected.equalsIgnoreCase(selected)) {
                return;
            }
            class Cell {
                public final int row;
                public final int column;

                public Cell(int row, int column) {
                    super();
                    this.row = row;
                    this.column = column;
                }
            }
            List<Cell> updatedCells = new ArrayList<Cell>();
            if (this.selected != null) {
                for (int i = 0; i < data.length; i++) {
                    Object[] o = data[i];
                    for (int j = 0; j < o.length; j++) {
                        Object object = o[j];
                        if (this.selected.toString().equalsIgnoreCase(object.toString())) {
                            updatedCells.add(new Cell(i, j));
                        }
                    }
                }
            }
            this.selected = selected;
            if (this.selected != null) {
                for (int i = 0; i < data.length; i++) {
                    Object[] o = data[i];
                    for (int j = 0; j < o.length; j++) {
                        Object object = o[j];
                        if (this.selected.toString().equalsIgnoreCase(object.toString())) {
                            updatedCells.add(new Cell(i, j));
                        }
                    }
                }
            }
            for (Cell pair : updatedCells) {
                fireTableCellUpdated(pair.row, pair.column);
            }
        }
    }

    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private String[] items = {"Item 1", "Item 2", "Item 3", "Item 4"};
    private DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel(items);
    private JComboBox combo = new JComboBox(comboBoxModel);
    private JPanel panel1 = new JPanel();
    private String[] columnNames = {"First Name", "Last Name", "Sport", "# of Years", "Vegetarian"};
    private Object[][] data = {{"Kathy", "Smith", "Item 1", new Integer(5), false}, {"John", "Doe", "Item 1", new Integer(3), true},
            {"Sue", "Black", "Item 3", new Integer(2), false}, {"Jane", "White", "Item 3", new Integer(20), true},
            {"Joe", "Brown", "Item 3", new Integer(10), false}};
    private DefaultTableModelExtension model = new DefaultTableModelExtension(data, columnNames);
    private JTable table = new JTable(model);

    public MyTableRenderer() {
        panel.setBorder(new EmptyBorder(10, 0, 2, 0));
        panel.add(combo);
        combo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                updateSelected();
            }

        });
        // Need first synch
        updateSelected();
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row,
                                                           int column) {
                System.out.println("*********");
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                String str = combo.getSelectedItem().toString();
                if (value.toString().equalsIgnoreCase(str)) {
                    c.setBackground(Color.RED);
                } else {
                    c.setBackground(null);
                }
                return this;
            }
        });
        table.getTableHeader().setReorderingAllowed(false);
        table.setAutoCreateRowSorter(true);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        panel1.setLayout(new GridLayout(1, 1, 10, 10));
        panel1.add(new JScrollPane(table));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel, BorderLayout.NORTH);
        frame.add(panel1);
        frame.pack();
        frame.setVisible(true);
    }

    private void updateSelected() {
        model.setSelected((String) combo.getSelectedItem());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MyTableRenderer fs = new MyTableRenderer();
            }
        });
    }
}

