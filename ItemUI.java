import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ItemUI extends JFrame implements ActionListener {

    JFrame f1 = new JFrame();
    JPanel p1 = new JPanel();
    JLabel l1 = new JLabel("Item Number");
    JLabel l2 = new JLabel("Item Description");
    JTextField t1 = new JTextField(20);
    JTextField t2 = new JTextField(20);
    JButton b1 = new JButton("Save");
    ItemUI(){

        f1.add(p1);
        p1.add(l1);
        p1.add(t1);
        p1.add(l2);
        p1.add(t2);
        p1.add(b1);
        b1.addActionListener(this);
        f1.setVisible(true);
        f1.setTitle("Item Page");
        f1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        p1.setBackground(Color.WHITE);
    }
    public void actionPerformed(ActionEvent e){
    String  Item_no = t1.getText();
    String  Item_Description = t2.getText();
    String path = "jdbc:mysql://localhost:3306/sales_analyst_system";
    String username = "root";
    String pw = "";
    try{
        Connection conn = DriverManager.getConnection(path, username, pw);
        Statement statement = conn.createStatement();
        String query = "Insert INTO item (Item_no, Item_Description) VALUES ('"+ Item_no+"', '"+Item_Description+"')";
        statement.executeUpdate(query);
        JOptionPane.showMessageDialog(null,"Saved");
    }catch (SQLException f){
        f.printStackTrace();
    }
    }

    public static void main(String[] args) {
        new ItemUI();
    }

}
