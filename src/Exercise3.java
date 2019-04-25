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

public class Exercise3 extends JFrame{
    JLabel background;
    JPanel backgroundPanel;

    JButton back;
    JLabel cerinta1;
    JLabel cerinta2;
    // a)
    JLabel aCerinta1;
    JLabel aCerinta2;
    JLabel aCerinta3;

    JButton a1;

    JLabel b1Cerinta;
    JLabel b2Cerinta;
    JLabel b3Cerinta;
    JLabel b1;
    JTextField b2;
    JButton b3;



    JTable table;
    JPanel tablePanel;
    JScrollPane scrollPane;


    public Exercise3 () {

        table = new JTable();
        tablePanel = new JPanel();
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0,0,800,300);

        back = new JButton("Revenire");
        back.addActionListener(new backListener());



        a1 = new JButton("Afiseaza");
        a1.addActionListener(new AListener());

        b1 = new JLabel("Nr bilet");
        b2 = new JTextField(10);
        b3 = new JButton("Cauta clasa, loc");
        b3.addActionListener(new BListener());



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
        cerinta1 = new JLabel("7.03. Să se exprime în SQL următoarele interogări:  ");


        JPanel cerinta11 = new JPanel();
        cerinta11.setLayout(new FlowLayout());
        cerinta11.add(cerinta1);
        cerintaPanel.add(cerinta11, BorderLayout.NORTH);

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
        aCerinta1 = new JLabel("a) Să se găsească detaliile biletelor  ");
        aCerinta2 = new JLabel("pentru care sursa și destinația");
        aCerinta3 = new JLabel(" încep cu aceeași literă în ordinea sursei.");

        a1Panel.add(aCerinta1);
        a1Panel.add(aCerinta2);
        a1Panel.add(aCerinta3);
        a1Panel.setBackground(new Color(49,153,218));

        JPanel a2Panel = new JPanel();
        a2Panel.setLayout(new BoxLayout(a2Panel, BoxLayout.Y_AXIS));
        a2Panel.setBackground(new Color(49,153,218));



        JPanel a22Panel = new JPanel();
        a22Panel.setBackground(new Color(49,153,218));
        a22Panel.add(a1);
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
        b1Panel.setLayout(new BoxLayout(b1Panel, BoxLayout.Y_AXIS));
        b1Cerinta = new JLabel("b) Să se găsească pentru nrbilet 123  ");
        b2Cerinta = new JLabel("ce nrzbor, clasa și loc");
        b3Cerinta = new JLabel(" au fost folosite.");

        b1Panel.add(b1Cerinta);
        b1Panel.add(b2Cerinta);
        b1Panel.add(b3Cerinta);
        b1Panel.setBackground(new Color(49,153,218));

        JPanel b2Panel = new JPanel();

        b2Panel.add(b1);
        b2Panel.add(b2);
        b2Panel.add(b3);
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


            Object[] columns = {"Nr Bilet", "Clasa", "Valoare", "Sursa", "Destinatia", "Id Client"};
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(columns);


            // Create the connection and prepare the statement
            try {
                Connection myConnection = DB.getConnection();
                PreparedStatement myStatement = myConnection.prepareStatement("call exercitiul3a();");

                ResultSet myResult = myStatement.executeQuery();

                while ( myResult.next() ) {
                    //System.out.println("idclient");

                    Object[] row = new Object[6];
                    row[0] = myResult.getString("nrbilet");
                    row[1] = myResult.getString("clasa");
                    row[2] = myResult.getString("valoare");
                    row[3] = myResult.getString("sursa");
                    row[4] = myResult.getString("destinatia");
                    row[5] = myResult.getString("idclient");

                    model.addRow(row);

                }
            } catch (Exception exception) {
                System.out.println("ceva nu e bine ex 3 A");
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


            Object[] columns = {"Nr Zbor", "Clasa", "Loc"};
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(columns);


            // Create the connection and prepare the statement
            try {
                Connection myConnection = DB.getConnection();
                PreparedStatement myStatement = myConnection.prepareStatement("SELECT nrzbor, clasa, loc FROM Cupoane WHERE  nrbilet = ? ;");

                int varNrBilet = 123;
                try {
                    varNrBilet = Integer.parseInt(b2.getText());
                } catch (Exception nu)
                {
                    System.out.println("nu ia bine int ex 3 b");
                }

                myStatement.setInt(1, varNrBilet );

                ResultSet myResult = myStatement.executeQuery();

                while ( myResult.next() ) {

                    Object[] row = new Object[3];
                    row[0] = myResult.getString("nrzbor");
                    row[1] = myResult.getString("clasa");
                    row[2] = myResult.getString("loc");
                    ;

                    model.addRow(row);

                }
            } catch (Exception exception) {
                System.out.println("ceva nu e bine ex 3 B");
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
