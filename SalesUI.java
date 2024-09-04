import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SalesUI extends JFrame implements ActionListener
{
    JFrame f1 = new JFrame();
    JPanel p1 = new JPanel();
    JLabel l1 = new JLabel("Sales ID");
    JLabel l2 = new JLabel("Item ID");
    JLabel l3 = new JLabel("Customer ID");
    JLabel l4 = new JLabel("Sold Quantity");
    JLabel l5 = new JLabel("Sales Date");
    JTextField t1 = new JTextField(20);
    JTextField t2 = new JTextField(20);
    JTextField t3 = new JTextField(20);
    JTextField t4 = new JTextField(20);
    JTextField t5 = new JTextField(20);
    JButton b1 = new JButton("Save");
    JButton b2 = new JButton("Show Total Sale");

    SalesUI(){

        f1.add(p1);
        p1.add(l1);
        p1.add(t1);
        p1.add(l2);
        p1.add(t2);
        p1.add(l3);
        p1.add(t3);
        p1.add(l4);
        p1.add(t4);
        p1.add(l5);
        p1.add(t5);
        p1.add(b1);
        b1.addActionListener(this);
        p1.add(b2);
        b2.addActionListener(this);
        f1.setVisible(true);
        f1.setTitle("Sales Page");
        f1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        p1.setBackground(Color.WHITE);

    }
public void actionPerformed(ActionEvent e){
        String Sale_no = t1.getText();
        String Item_no = t2.getText();
        String Customer_no = t3.getText();
        String Sale_qty = t4.getText();
        String Time = t5.getText();

        String path = "jdbc:mysql://localhost:3306/sales_analyst_system";
        String username = "root";
        String pw = "";
        try{
            Connection conn = DriverManager.getConnection(path,username,pw);
            Statement statement = conn.createStatement();

            String query = "Insert into  sales(Sale_no, Item_no,Customer_no, Sale_qty,Time) values(' "+Sale_no+"', '"+Item_no +"', '"+Customer_no+"', '"+Sale_qty+"', '"+Time+"')";
            statement.executeUpdate(query);
            JOptionPane.showConfirmDialog(null,"Saved!");
        }catch (SQLException f){
            f.printStackTrace();
        }


}
    public static void main(String[] args) {
        new SalesUI();
    }
    }

