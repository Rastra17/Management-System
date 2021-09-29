package src.ms;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFrame;

public class Crud
{
    public static void main(String args[])
    {
        JTable table=new JTable();
        Object[] columns={"User ID","Name","Username","Email","Password","Address","Contact"};
        DefaultTableModel model=new DefaultTableModel();

        JFrame frame=new JFrame("WINDOW");
        frame.getContentPane().setBackground(new Color(0,0,0));
        frame.getContentPane().setForeground(Color.WHITE);
        frame.setBounds(100,100,100,100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);

        model.setColumnIdentifiers(columns);
        table.setModel(model);
        table.setBackground(Color.white);
        table.setForeground(Color.black);
        table.setSelectionBackground(Color.red);
        table.setGridColor(Color.red);
        table.setSelectionForeground(Color.white);
        table.setFont(new Font("Tanhoma",Font.PLAIN,17));

        frame.setVisible(true);

    }
}