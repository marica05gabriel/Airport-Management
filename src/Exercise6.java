import org.jdesktop.swingx.prompt.PromptSupport;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static java.lang.Integer.parseInt;

public class Exercise6 extends JFrame{
    JLabel background;
    JPanel backgroundPanel;

    JButton back;
    JLabel cerinta1;
    JLabel cerinta2;
    // a)
    JLabel aCerinta1;
    JLabel aCerinta2;
    JLabel aCerinta3;

    JButton a4;

    JLabel bCerinta1;
    JLabel bCerinta2;
    JLabel bCerinta3;
    JButton b1;



    JTable table;
    JPanel tablePanel;
    JScrollPane scrollPane;


    public Exercise6 () {

        table = new JTable();
        tablePanel = new JPanel();
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0,0,800,300);

        back = new JButton("Revenire");
        back.addActionListener(new backListener());



        a4 = new JButton("Afiseaza");
        a4.addActionListener(new AListener());

        b1 = new JButton("Calculeaza");
        b1.addActionListener(new BListener());



        gui();

    }



    private void gui(){
        Color albastru = new Color(49,153,218);
        //this.setLayout(new BorderLayout());
        background = new JLabel( new ImageIcon("D:\\WorkSpace\\POO\\Proiect_BD_Final\\src\\airplaneTexture.gif"));
        this.add(background);
        background.setLayout( new BorderLayout());


//----------- 1 ----------
        // punem back intr-un JPanel
        JPanel backPanel = new JPanel();
        backPanel.setBackground(new Color(49, 153, 218));
        //back = new JButton("Back");
        backPanel.add(back);

        // punem cerinta intr-un JPanel
        JPanel cerintaPanel = new JPanel();
        cerintaPanel.setLayout(new BorderLayout());
        cerinta1 = new JLabel("7.06. Să se exprime în SQL următoarele interogări folosind  ");
        cerinta2 = new JLabel("funcţii de agregare:");

        JPanel cerinta11 = new JPanel();
        JPanel cerinta12 = new JPanel();
        cerinta11.setLayout(new FlowLayout());
        cerinta12.setLayout(new FlowLayout());
        cerinta11.add(cerinta1);
        cerinta12.add(cerinta2);
        cerintaPanel.add(cerinta11, BorderLayout.NORTH);
        cerintaPanel.add(cerinta12, BorderLayout.CENTER);

        //le adaugam pe astea 2 intr-un panou Box - panel1
        JPanel panel1= new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        panel1.add(backPanel);
        panel1.add(cerintaPanel);
//----------- 1 end ----------
        //aici ne intereseaza panel1


//----------- 2 ----------
        //crem a Panel
        JPanel aPanel = new JPanel();
        aPanel.setLayout(new BoxLayout(aPanel, BoxLayout.Y_AXIS));
        aPanel.setBackground(new Color(49,153,218));

        JPanel a1Panel = new JPanel();
        a1Panel.setLayout(new BoxLayout( a1Panel, BoxLayout.Y_AXIS));
        aCerinta1 = new JLabel("a) Să se găsească pentru zborurile din perioada   ");
        aCerinta2 = new JLabel("’01-JAN-2018’ - ’31-MAR-2018’");
        aCerinta3 = new JLabel(" numărul de bilete pentru fiecare clasă..");

        a1Panel.add(aCerinta1);
        a1Panel.add(aCerinta2);
        a1Panel.add(aCerinta3);
        a1Panel.setBackground(new Color(49,153,218));

        JPanel a2Panel = new JPanel();
        a2Panel.setLayout(new BoxLayout(a2Panel, BoxLayout.Y_AXIS));
        a2Panel.setBackground(new Color(49,153,218));



        JPanel a22Panel = new JPanel();
        a22Panel.setBackground(new Color(49,153,218));
        a22Panel.add(a4);
        a2Panel.add(a22Panel);
        a2Panel.setBackground(new Color(49,153,218));


        aPanel.add(a1Panel);
        aPanel.add(a2Panel);
        // gata cu a Panel

        //crem b Panel
        JPanel bPanel = new JPanel();
        bPanel.setLayout(new BoxLayout(bPanel, BoxLayout.Y_AXIS));
        bPanel.setBackground(new Color(49,153,218));

        JPanel b1Panel = new JPanel();
        b1Panel.setLayout(new BoxLayout( b1Panel, BoxLayout.Y_AXIS));
        bCerinta1 = new JLabel("b) Să se găsească valoarea medie a biletelor  ");
        bCerinta2 = new JLabel("pentru fiecare clasă.");


        b1Panel.add(bCerinta1);
        b1Panel.add(bCerinta2);

        b1Panel.setBackground(new Color(49,153,218));

        JPanel b2Panel = new JPanel();

        JPanel b22Panel = new JPanel();
        b22Panel.setBackground(new Color(49,153,218));
        b22Panel.add(b1);
        b2Panel.add(b22Panel);
        b2Panel.setBackground(new Color(49,153,218));


        bPanel.add(b1Panel);
        bPanel.add(b2Panel);


        // gata cu a Panel

        // AB PANEL
        JPanel abPanel = new JPanel();
        abPanel.setLayout( new GridLayout(1,2));
        abPanel.add(aPanel);
        //abPanel.add( Box.createRigidArea(new Dimension(100, 0)));
        abPanel.add(bPanel);
        abPanel.setBackground(new Color(49,153,218));

//----------- 2  end ----------
        //ne intereseaza abPanel


//----------- 3 ----------
        // Grupam elementele din nord
        JPanel northPanel = new JPanel();
        northPanel.setLayout( new BoxLayout(northPanel, BoxLayout.Y_AXIS));
        northPanel.add(panel1);
        northPanel.add(abPanel);
//----------- 3 end ----------
        //northPanel e gata


//----------- 4 ----------
        scrollPane.setBounds(0,0,800,300);
        tablePanel.setBackground(new Color(49,153,218));


        tablePanel.add(scrollPane);
//----------- 4 end ----------
        //ne intereseaza tablePanel


//----------- 5 ----------
        JPanel southPanel = new JPanel();
        southPanel.setBackground(Color.black);
        JLabel maricaGabriel = new JLabel("Project made by Marica Gabriel");
        maricaGabriel.setForeground(Color.white);
        southPanel.add(maricaGabriel);
//----------- 5 end ----------
        //southPanel e gata

        tablePanel.setVisible(false);
        background.add(northPanel, BorderLayout.NORTH);
        background.add(tablePanel, BorderLayout.CENTER);
        background.add(southPanel, BorderLayout.SOUTH);

        scrollPane.setBounds(0,0,800,300);



        setTitle("Exercitiul 4 # Subiectul 7 - Marica Gabriel");
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
    }



    private class AListener implements  ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {


            Object[] columns = {"Clasa", "Numar de bilete"};
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(columns);


            // Create the connection and prepare the statement
            try {
                Connection myConnection = DB.getConnection();
                PreparedStatement myStatement = myConnection.prepareStatement("call exercitiul6a();");

                ResultSet myResult = myStatement.executeQuery();

                while ( myResult.next() ) {
                    //System.out.println("idclient");

                    Object[] row = new Object[2];
                    row[0] = myResult.getString("Clasa");
                    row[1] = myResult.getString("COUNT(nrbilet)");

                    model.addRow(row);

                }
            } catch (Exception exception) {
                System.out.println("ceva nu e bine ex 6 A");
                exception.printStackTrace();
            }

            tablePanel.setVisible(true);
            table.setRowHeight(30);
            table.setModel(model);
        }
    }

    private class BListener implements  ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {


            Object[] columns = {"Clasa", "Media"};
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(columns);


            // Create the connection and prepare the statement
            try {
                Connection myConnection = DB.getConnection();
                PreparedStatement myStatement = myConnection.prepareStatement("call exercitiul6b();");

                ResultSet myResult = myStatement.executeQuery();

                while ( myResult.next() ) {
                    Object[] row = new Object[2];
                    row[0] = myResult.getString("Clasa");
                    row[1] = myResult.getString("ROUND(AVG(valoare),2)");

                    model.addRow(row);

                }
            } catch (Exception exception) {
                System.out.println("ceva nu e bine ex 6 B");
                exception.printStackTrace();
            }

            tablePanel.setVisible(true);
            table.setRowHeight(30);
            table.setModel(model);
        }
    }

    private class backListener implements  ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            MainWindow mainWindow = new MainWindow();
            dispose();
        }
    }
}
