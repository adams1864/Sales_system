import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu_Page_UI extends JFrame implements ActionListener
{
    JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu = new JMenu("Go to");
    JMenuItem Itempage = new JMenuItem("Items");
    JMenuItem StockPage = new JMenuItem("Stocks");
    JMenuItem SalesPage = new JMenuItem("Sales");
    JMenuItem CustomersPage = new JMenuItem("Customers");
    JMenuItem ExitItem = new JMenuItem("Exit");
     Menu_Page_UI() {
         setTitle("Main Menu");
         setSize(600, 600);
         setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
         Itempage.addActionListener(this);
         StockPage.addActionListener(this);
         SalesPage.addActionListener(this);
         CustomersPage.addActionListener(this);
         ExitItem.addActionListener(this);

         fileMenu.add(Itempage);
         fileMenu.add(StockPage);
         fileMenu.add(SalesPage);
         fileMenu.add(CustomersPage);
         fileMenu.addSeparator();
         fileMenu.add(ExitItem);

         menuBar.add(fileMenu);
         setJMenuBar(menuBar);
         setVisible(true);
     }
     public void actionPerformed(ActionEvent e){
         if (e.getSource()==Itempage){
             new ItemUI();
         } else if (e.getSource()==StockPage) {
             new StockUI();

         } else if (e.getSource()==SalesPage) {
             new SalesUI();

         }else if (e.getSource()==CustomersPage){
             new CustomersUI();
         }else if(e.getSource()==ExitItem){
             System.exit(0);
         }


     }

    public static void main(String[] args) {
        new Menu_Page_UI();
    }

}
