import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class Boo_Record_Management extends JFrame {
    public Connection  con=null;
    public PreparedStatement ps;
    private JFrame frame;

    private JLabel l1;
    private JLabel l2;
    private JLabel l3;
    private JLabel l4;
    private JLabel l5;
    private JLabel l6;


    // FOR MODIFY LABLES
    private JLabel ml1;
    private JLabel ml2;
    private JLabel ml3;
    private JLabel ml4;

    // FOR DELETE LABLES
    private JLabel dl1;
    private JTextField mt1;
    private JTextField mt2;
    private JTextField mt3;
    private JTextField mt4;
    private JTextField t1;
    private JTextField t2;
    private JTextField t3;
    private JTextField t4;
    private JTextField t5;
    private JTextField t6;

    // FOR DELETE
    private JTextField dt1;
    private JTabbedPane tabbedPane;
    private JButton insertbutton;
    private JButton modifybutton;
    private JButton deletebutton;
    private JPanel insertpanel;
    private JPanel modiftpanel;
    private JPanel deletepanel;
    public void InitComponent(){

        // FOR LABLES
        l1=new JLabel("ID:");
        l2=new JLabel("PRICE:");
        l3=new JLabel("NAME:");
        l4=new JLabel("AUTHOR:");
        l5=new JLabel("PUBLISHER:");
        l6=new JLabel("ENTER MODIY BOOKID ");
        // FOR MODIFY LABLE
        ml1=new JLabel("NAME:");
        ml2=new JLabel("PRICE");
        ml3=new JLabel("Author");
        ml4=new JLabel("Publisher");

        // FOR DETETING LABEL
        dl1=new JLabel("ENTER ID FOR DELETE");
        dt1=new JTextField();
        dl1.setBounds(20,50,200,20);
        dt1.setBounds(150,50,100,20);
        // FOR TEXTFIELD
        t1=new JTextField();
        t2=new JTextField();
        t3=new JTextField();
        t4=new JTextField();
        t5=new JTextField();
        t6=new JTextField();

        // for modify textfield

        mt1=new JTextField();
        mt2=new JTextField();
        mt3=new JTextField();
        mt4=new JTextField();


        t1.setBounds(150,50,100,20);
        t2.setBounds(150,100,100,20);
        t3.setBounds(150,150,100,20);
        t4.setBounds(150,200,100,20);
        t5.setBounds(150,250,100,20);
        t6.setBounds(200,50,100,20);


        // FOR MODIFY TEXTFIELd

        mt1.setBounds(150,100,100,20);
        mt2.setBounds(150,150,100,20);
        mt3.setBounds(150,200,100,20);
        mt4.setBounds(150,250,100,20);
        // FOR TABLES BOUND
        l1.setBounds(50,50,100,20);
        l2.setBounds(50,100,100,20);
        l3.setBounds(50,150,100,20);
        l4.setBounds(50,200,100,20);
        l5.setBounds(50,250,100,20);
        l6.setBounds(50,50,200,20);

        // FOR MODIFY LABEL
        ml1.setBounds(50,100,100,20);
        ml2.setBounds(50,150,100,20);
        ml3.setBounds(50,200,100,20);
        ml4.setBounds(50,250,100,20);


        // FOR BUTTTON
        insertbutton=new JButton("INSERT");
        modifybutton=new JButton("MODIFY");
        deletebutton=new JButton("DELETE");
        insertbutton.setBounds(50,300,100,20);
        modifybutton.setBounds(50,300,100,20);
        deletebutton.setBounds(50,100,100,20);

        // FOR BUTTION ACTION LISTNER
        insertbutton.addActionListener(new InsertInto() );
        modifybutton.addActionListener(new ModifyInto());
        deletebutton.addActionListener(new Delete());
        // FOR PANEL
        insertpanel=new JPanel();
        modiftpanel=new JPanel();
        deletepanel=new JPanel();
        insertpanel.setLayout(null);
        modiftpanel.setLayout(null);
        deletepanel.setLayout(null);
       // modiftpanel.setLayout(null);
        insertpanel.add(insertbutton);
        insertpanel.add(l1);
        insertpanel.add(l2);
        insertpanel.add(l3);
        insertpanel.add(l4);
        insertpanel.add(l5);
        insertpanel.add(t1);
        insertpanel.add(t2);
        insertpanel.add(t3);
        insertpanel.add(t4);
        insertpanel.add(t5);
        modiftpanel.add(modifybutton);
        modiftpanel.add(deletebutton);
        modiftpanel.add(l6);
        modiftpanel.add(ml1);
        modiftpanel.add(ml2);
        modiftpanel.add(ml3);
        modiftpanel.add(ml4);
        modiftpanel.add(mt1);
        modiftpanel.add(mt2);
        modiftpanel.add(mt3);
        modiftpanel.add(mt4);
        modiftpanel.add(t6);

        deletepanel.add(dl1);
        deletepanel.add(dt1);
        deletepanel.add(deletebutton);
        // FOR TAPPED PANE
        tabbedPane=new JTabbedPane();
        tabbedPane=new JTabbedPane();
        tabbedPane.add(insertpanel);
        tabbedPane.add(modiftpanel);
        tabbedPane.add(deletepanel);
        // for f2 function
        // FOR ADDING FRAME
        frame=new JFrame("BOOK RECORD MANAGEMENT SYSTEM");
        frame.setSize(400,400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.add(tabbedPane);
        //frame.add(modifypane);
    }
    class InsertInto implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            int i=Integer.parseInt(t1.getText());
            double pric=Double.parseDouble(t2.getText());
            String nam=t3.getText().toString();
            String autho=t4.getText().toString();
            String publishe=t5.getText().toString();
            System.out.println("HEELO ");
            try{
                String url="insert into book(id,price,name,author,publisher)values(?,?,?,?,?);";
                PreparedStatement ps= con.prepareStatement(url);
                ps.setInt(1,i);
                ps.setDouble(2,pric);
                ps.setString(3,nam);
                ps.setString(4,autho);
                ps.setString(5,publishe);
                System.out.println("2 ND ONE");
                ps.execute();
           //     System.out.println("INSERTED");
            }
            catch (SQLException E){
                E.getMessage();
            }
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
        }
    }
    class ModifyInto implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            //f2();
            try{
                System.out.println("I AM MODIFY START");
                int id=Integer.parseInt(t6.getText());
                System.out.println(id);
               // System.out.println(id);
                double price=Double.parseDouble(mt2.getText());
               // ps=con.prepareStatement("ahj");
                System.out.println(price);
                String auth=mt3.getText().toString();
                System.out.println(auth);
                String pub=mt4.getText().toString();
                System.out.println(pub);
               String nam=mt1.getText().toString();
                System.out.println("HALF");
                String url="update book set name=?,price=?,author=?,publisher=? where id=?;";
                //System.out.println("SECOND");
                ps=con.prepareStatement(url);
                ps.setString(1,nam);
                ps.setDouble(2,price);
                ps.setString(3,auth);
                ps.setString(4,pub);
                ps.setInt(5,id);
                //System.out.println("THIRD");
                ps.executeUpdate();
                //System.out.println("fourth");
            }
            catch (SQLException E){
                E.getMessage();
            }
            t6.setText("");
            mt1.setText("");
            mt2.setText("");
            mt3.setText("");
            mt4.setText("");
        }
    }
    class Delete implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            int id=Integer.parseInt(dt1.getText());
            try{
               // System.out.println("one");
                String url="delete from book where id=?;";
               // System.out.println("two");
                ps=con.prepareStatement(url);
               // System.out.println("three");
                ps.setInt(1,id);
                ps.execute();
               // System.out.println("four");
            }
            catch (SQLException E){
                E.getMessage();
            }
            dt1.setText("");
        }
    }
   public void getConncection(){
        String url="jdbc:mysql://localhost:3306/merabook";
        try {
            con = DriverManager.getConnection(url, "root", "ayush2312");
        }
        catch (SQLException E){
            E.getMessage();
        }
   }
    Boo_Record_Management(){
        getConncection();
        InitComponent();
    }
}
