package br.iesb.batalhanaval.view;

import javax.swing.*;

/**
 * Created by abraao.queiroz on 08/04/2015.
 */
public class SeaBattleBoard extends JFrame {
    private JPanel jp_Main;
    private BoardTable tb_Player1;
    private JScrollPane jsp_Player1;
    private JTable table1;

    public SeaBattleBoard() {
    }

    public static void main(String[] args) {
        SeaBattleBoard sb = new SeaBattleBoard();
        sb.setTitle("SeaBattleBoard");
        sb.setContentPane(new SeaBattleBoard().jp_Main);
        sb.setLocationRelativeTo(null);
        sb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sb.setResizable(false);
        sb.pack();
        sb.setVisible(true);
    }

    private void createUIComponents() {
        jp_Main = new JPanel();
        tb_Player1 = new BoardTable(new DefaultTableModelImpl());
        this.jsp_Player1 = new JScrollPaneImpl(tb_Player1);

//        TableCellRenderer renderer = new TableCellRendererImpl();
//        tb_Player1.setDefaultRenderer(Object.class, renderer);
    }
}