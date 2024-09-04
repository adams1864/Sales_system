import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StockUI extends JFrame implements ActionListener
{
    JFrame f1 = new JFrame();
    JPanel p1 = new JPanel();
    JLabel l1 = new JLabel("Stock Quantity");
    JLabel l2 = new JLabel("Price");
    JLabel l3 = new JLabel("Date Accepted");
    JLabel l4  =new JLabel("Item Id");
    JTextField t1 = new JTextField(20);
    JTextField t2 = new JTextField(20);
    JTextField t3 = new JTextField(20);
    JTextField t4 = new JTextField(20);
    JButton b1 = new JButton("Save");
    JButton b2 = new JButton("Stock Status");
    StockUI(){

        f1.add(p1);
        p1.add(l1);
        p1.add(t1);
        p1.add(l2);
        p1.add(t2);
        p1.add(l3);
        p1.add(t3);
        p1.add(l4);
        p1.add(t4);
        p1.add(b1);
        b1.addActionListener(this);
        p1.add(b2);
        f1.setVisible(true);
        f1.setTitle("Stock Page");
        f1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        p1.setBackground(Color.WHITE);
    }
    public  void actionPerformed(ActionEvent e){
        String stock_qty = t1.getText();
        String Price = t2.getText();
        String  Time = t3.getText();
        String Item_no = t4.getText();
        String path = "jdbc:mysql://localhost:3306/sales_analyst_system";
        String username = "root";
        String pw = "";
        try{
            Connection conn = DriverManager.getConnection(path,username,pw);
            Statement statement  =conn.createStatement();
            String query  = "INSERT INTO  stock (stock_qty, Price, Time, Item_no) VALUES ('"+stock_qty +"' ,'"+Price+"' ,'" + Time+"' ,'" + Item_no+"')";
            statement.executeUpdate(query);
        }catch (SQLException f){
            f.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "Saved Successfully!");

    }
    public static void main(String[] args) {
        new StockUI();
    }
}
