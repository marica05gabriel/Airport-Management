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

public class Exercise4 extends JFrame{
    JLabel background;
    JPanel backgroundPanel;

    JButton back;
    JLabel cerinta;
// a)
    JLabel aCerinta1;
    JLabel aCerinta2;
    JLabel aCerinta3;
    JLabel a1;
    JTextField a2;
    JLabel a3;
    JTextField a4;
    JTextField a5;
    JButton a6;
//b)
    JLabel b1Cerinta;
    JLabel b2Cerinta;
    JLabel b3Cerinta;
    JLabel b1;
    JTextField b2;
    JButton b3;

    JTable table;
    JPanel tablePanel;
    JScrollPane scrollPane;


    public Exercise4 () {

        table = new JTable();
        tablePanel = new JPanel();
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0,0,800,300);

        back = new JButton("Revenire");
        back.addActionListener(new backListener());

        a1 = new JLabel("Nume Client:");
        a2 = new JTextField(15);
        a3 = new JLabel("Perioada");
        a4 = new JTextField(8);
        PromptSupport.setPrompt("YYYY-MM-DD", a4);
        PromptSupport.setForeground( Color.gray, a4);

        a5 = new JTextField(8);
        PromptSupport.setPrompt("YYYY-MM-DD", a5);
        PromptSupport.setForeground( Color.gray, a5);

        a6 = new JButton("Cauta detaliile calatoriilor");
        a6.addActionListener(new AListener());

        b1 = new JLabel("Nr. Zbor");
        b2 = new JTextField(7);
        b3 = new JButton("Cauta");
        b3.addActionListener(new BListener());

        gui();

    }



    private void gui(){
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
        cerinta = new JLabel("7.04. Să se exprime în SQL următoarele interogări folosind operatorul JOIN:");
        cerintaPanel.add(cerinta);

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
        aCerinta1 = new JLabel("a) Să se găsească pentru clientul cu numele ");
        aCerinta2 = new JLabel("’Popescu Paul’ detaliile călătoriilor efectuate");
        aCerinta3 = new JLabel("în perioada ’01-JAN-2018’ - ’31-MAR-2018’.");

        a1Panel.add(aCerinta1);
        a1Panel.add(aCerinta2);
        a1Panel.add(aCerinta3);
        a1Panel.setBackground(new Color(49,153,218));

        JPanel a21Panel = new JPanel();
        a21Panel.add(a1);
        a21Panel.add(a2);
        a21Panel.setBackground(new Color(49,153,218));

        JPanel a22Panel = new JPanel();
        a22Panel.add(a3);
        a22Panel.add(a4);
        a22Panel.add(a5);
        a22Panel.setBackground(new Color(49,153,218));

        JPanel a23Panel = new JPanel();
        a23Panel.add(a6);
        a23Panel.setBackground(new Color(49,153,218));

        JPanel a24Panel = new JPanel();
        a24Panel.setLayout(new BoxLayout( a24Panel, BoxLayout.Y_AXIS));
        a24Panel.add(a21Panel);
        a24Panel.add(a22Panel);
        a24Panel.add(a23Panel);
        a24Panel.setBackground(new Color(49,153,218));



        aPanel.add(a1Panel);
        aPanel.add(a24Panel);
        aPanel.setBackground(new Color(49,153,218));
        // gata cu a Panel

        //crem b Panel
        JPanel bPanel = new JPanel();
        bPanel.setLayout(new BoxLayout(bPanel, BoxLayout.Y_AXIS));
        bPanel.setBackground(new Color(49,153,218));

        JPanel b1Panel = new JPanel();
        b1Panel.setLayout(new BoxLayout(b1Panel, BoxLayout.Y_AXIS));
        b1Cerinta = new JLabel("b) Să se găsească perechi de zboruri  ");
        b2Cerinta = new JLabel("(nrzbor1, nrzbor2) pentru nrbilet 123.");
        b3Cerinta = new JLabel("O pereche este unică în rezultat.");

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

            scrollPane.setBounds(0,0,800,320);

            Object[] columns = {"nume", "de_la", "la", "plecare", "sosire"};
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(columns);
            table.setModel(model);


            try {

                Connection myConnection = null;
                PreparedStatement myStatement = null;
                ResultSet myResult = null;

                myConnection = DB.getConnection();
                myStatement = myConnection.prepareStatement("SELECT nume, de_la, la, plecare, sosire FROM Zboruri INNER JOIN Cupoane USING (nrzbor) INNER JOIN Bilete USING (nrbilet) INNER JOIN Clienti USING (idclient) WHERE Clienti.nume = ? AND Zboruri.plecare >= ? AND Zboruri.sosire <= ? ORDER BY plecare");

                String varNume = "Popescu Paul";
                try {
                    if (a2.getText() != "")
                    varNume = a2.getText();
                } catch (Exception exceprion) {
                    System.out.println("nu s-a preluat numele");
                }

                String data1 = "2018-01-01";
                try {
                    data1 = a4.getText();
                } catch (Exception exceprion) {
                    System.out.println("nu s-a preluat data1");
                }

                String data2 = "2018-03-31";
                try {
                    data2 = a5.getText();
                } catch (Exception exceprion) {
                    System.out.println("nu s-a preluat data2");
                }


                myStatement.setString(1, varNume);
                myStatement.setString(2, data1);
                myStatement.setString(3, data2);


                myResult = myStatement.executeQuery();

                while( myResult.next()) {
                    System.out.println( myResult.getString("nume"));
                    Object[] row = new Object[5];
                    row[0] = myResult.getString("nume");
                    row[1] = myResult.getString("de_la");
                    row[2] = myResult.getString("la");
                    row[3] = myResult.getString("plecare");
                    row[4] = myResult.getString("sosire");

                    model.addRow(row);
                }




            } catch (Exception exception) {
                System.out.println("Buton A ex 4");
                exception.printStackTrace();
            }


            table.setFillsViewportHeight(true);
            table.setDefaultEditor(Object.class, null);
            table.setRowHeight(30);
            tablePanel.setVisible(true);

        }
    }

    private class BListener implements  ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {


            Object[] columns = {"zbor1", "zbor2"};
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(columns);


            // Create the connection and prepare the statement
            try {
                Connection myConnection = DB.getConnection();
                PreparedStatement myStatement = myConnection.prepareStatement("SELECT DISTINCT least(c1.nrzbor, c2.nrzbor) AS   ?  , greatest(c1.nrzbor,c2.nrzbor) AS  ? FROM (Cupoane c1 JOIN Cupoane c2 ON c1.nrbilet = c2.nrbilet) WHERE c1.nrzbor<>c2.nrzbor AND c1.nrbilet= ? ;");

                int varNrzbor = 123;
                // 3 mai apare de 2 ori
                try {
                    varNrzbor = Integer.parseInt(b2.getText());
                } catch (Exception nu)
                {
                    System.out.println("nu ia bine int");
                }

                myStatement.setString(1, "Zbor1" );
                myStatement.setString(2, "Zbor2" );
                myStatement.setInt(3, varNrzbor );

                ResultSet myResult = myStatement.executeQuery();

                while ( myResult.next() ) {
                    //System.out.println("idclient");

                    Object[] row = new Object[2];
                    row[0] = myResult.getString("zbor1");
                    row[1] = myResult.getString("zbor2");
                   ;

                    model.addRow(row);

                }
            } catch (Exception exception) {
                System.out.println("ceva nu e bine ex 4 B");
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
