import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class CustomersUI extends JFrame implements ActionListener {
    JFrame f1 = new JFrame();
    JPanel p1 = new JPanel();
    JLabel l1 = new JLabel("Customer Id");
    JLabel l2 = new JLabel("Customer Name");
    JLabel l3 = new JLabel("Deposit");
    JTextField t1 = new JTextField(20);
    JTextField t2 = new JTextField(20);
    JTextField t3 = new JTextField(20);
    JButton b1 = new JButton("Save");
    JButton b2 = new JButton("List Customers");

    CustomersUI() {
        f1.add(p1);
        p1.add(l1);
        p1.add(t1);
        p1.add(l2);
        p1.add(t2);
        p1.add(l3);
        p1.add(t3);
        p1.add(b1);
        b1.addActionListener(this);
        p1.add(b2);
        b2.addActionListener(this); // Add ActionListener for the "List Customers" button
        f1.setVisible(true);
        f1.setSize(300, 200); // Set the size of the frame
        f1.setTitle("Customers Page");
        f1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        p1.setBackground(Color.WHITE);
    }

    public void actionPerformed(ActionEvent e) {
        String customer_no = t1.getText();
        String customer_name = t2.getText();
        String deposit = t3.getText();
        String path = "jdbc:mysql://localhost:3306/sales_analyst_system";
        String username = "root";
        String pw = "";

        try {
            Connection conn = DriverManager.getConnection(path, username, pw);
            Statement statement = conn.createStatement();

            // Check which button was clicked
            if (e.getSource() == b1) { // "Save" button
                String query = "INSERT INTO Customers (customer_no, customer_name, Deposit) VALUES ('" + customer_no + "', '" + customer_name + "', '" + deposit + "')";
                statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Saved");
            } else if (e.getSource() == b2) { // "List Customers" button
                String query1 = "SELECT * FROM Customers";
                ResultSet resultSet = statement.executeQuery(query1);

                // Use a String to accumulate the fetched data
                String data = "";
                while (resultSet.next()) {
                    int Id = resultSet.getInt("customer_no");
                    String name = resultSet.getString("customer_name");
                    String depo = resultSet.getString("Deposit");

                    // Concatenate each row's data to the String
                    data += "ID: " + Id + ", Name: " + name + ", Deposit: " + depo + "\n";
                }

                // Display the fetched data using JOptionPane
                JOptionPane.showMessageDialog(null, data, "Customer List", JOptionPane.INFORMATION_MESSAGE);
            }

            conn.close(); // Close the connection
        } catch (SQLException f) {
            f.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new CustomersUI();
    }
}
