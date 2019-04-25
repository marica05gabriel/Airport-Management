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

public class Exercise5 extends JFrame{
    JLabel background;
    JPanel backgroundPanel;

    JButton back;
    JLabel cerinta1;
    JLabel cerinta2;
    // a)
    JLabel aCerinta1;
    JLabel aCerinta2;
    JLabel aCerinta3;
    JLabel a1;
    JTextField a2;
    JButton a3;

    JLabel b1Cerinta;
    JLabel b2Cerinta;
    JLabel b3Cerinta;
    JLabel b1;
    JRadioButton b2;
    JRadioButton b3;
    JLabel b4;
    JTextField b5;
    JButton b6;

    JTable table;
    JPanel tablePanel;
    JScrollPane scrollPane;


    public Exercise5 () {

        table = new JTable();
        tablePanel = new JPanel();
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0,0,800,300);

        back = new JButton("Revenire");
        back.addActionListener(new backListener());

        a1 = new JLabel("Clasa [Economic/Business]:");
        a2 = new JTextField(15);


        a3 = new JButton("Cauta detaliile calatoriilor");
        a3.addActionListener(new AListener());

        b1 = new JLabel("Statut:");
        b2 = new JRadioButton("VIP");
        b3 = new JRadioButton("C");
        ButtonGroup radio1 = new ButtonGroup();
        radio1.add(b2);
        radio1.add(b3);

        b4 = new JLabel("Plecare de pe aeroportul:");
        b5 = new JTextField(15);
        b6 = new JButton("Afiseaza");
        b6.addActionListener(new BListener());



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
        cerinta1 = new JLabel("7.05. Să se exprime în SQL fără funcții de agregare următoarele interogări ");
        cerinta2 = new JLabel("folosind cel puțin o interogare imbricată și operatori de genul EXISTS, IN, ALL, ANY:");

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
        aCerinta1 = new JLabel("a) Să se găsească numele clienților ");
        aCerinta2 = new JLabel("al căror bilet are valoarea cea mai mare");
        aCerinta3 = new JLabel(" între biletele din clasa ’Economic’.");

        a1Panel.add(aCerinta1);
        a1Panel.add(aCerinta2);
        a1Panel.add(aCerinta3);
        a1Panel.setBackground(new Color(49,153,218));

        JPanel a2Panel = new JPanel();
        a2Panel.setLayout(new BoxLayout(a2Panel, BoxLayout.Y_AXIS));
        a2Panel.setBackground(new Color(49,153,218));


        JPanel a21Panel = new JPanel();
        a21Panel.setBackground(new Color(49,153,218));
        a21Panel.add(a1);
        a21Panel.add(a2);
        a2Panel.add(a21Panel);

        JPanel a22Panel = new JPanel();
        a22Panel.setBackground(new Color(49,153,218));
        a22Panel.add(a3);
        a2Panel.add(a22Panel);
        a2Panel.setBackground(new Color(49,153,218));


        aPanel.add(a1Panel);
        aPanel.add(a2Panel);
        // gata cu a Panel

        //crem b Panel
        JPanel bPanel = new JPanel();
        bPanel.setLayout(new BoxLayout(bPanel, BoxLayout.Y_AXIS));
        bPanel.setBackground(new Color(49,153,218));


        JLabel b1cerinta = new JLabel("b) Să se găsească destinațiile clienților cu statut VIP ");
        JLabel b2cerinta = new JLabel("cu plecare de pe aeroportul ’Oradea’.");
        JPanel bCerintaPanel = new JPanel();
        bCerintaPanel.setLayout(new BoxLayout(bCerintaPanel, BoxLayout.Y_AXIS ));
        bCerintaPanel.setBackground(albastru);
        bCerintaPanel.add(b1cerinta);
        bCerintaPanel.add(b2cerinta);

        JPanel b1Panel = new JPanel( new FlowLayout());
        b1Panel.setBackground(albastru);
        b1Panel.add(b1);
        b1Panel.add(b2);
        b1Panel.add(b3);
        b2.setBackground(albastru);
        b3.setBackground(albastru);

        JPanel b2Panel = new JPanel( new FlowLayout());
        b2Panel.setBackground(albastru);
        b2Panel.add(b4);
        b2Panel.add(b5);

        JPanel b3Panel = new JPanel(new FlowLayout());
        b3Panel.setBackground(albastru);
        b3Panel.add(b6);

        bPanel.add(bCerintaPanel);
        bPanel.add(b1Panel);
        bPanel.add(b2Panel);
        bPanel.add(b3Panel);




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


            Object[] columns = {"Nume"};
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(columns);


            // Create the connection and prepare the statement
            try {
                Connection myConnection = DB.getConnection();
                PreparedStatement myStatement = myConnection.prepareStatement("call exercitiul5a(?);");

                String varNumeClasa = "Economic";
                // 3 mai apare de 2 ori
                try {
                    varNumeClasa = a2.getText();
                } catch (Exception nu)
                {
                    System.out.println("nu ia bine NumeClasa");
                }

                myStatement.setString(1, varNumeClasa);


                ResultSet myResult = myStatement.executeQuery();

                while ( myResult.next() ) {
                    //System.out.println("idclient");

                    Object[] row = new Object[1];
                    row[0] = myResult.getString("nume");

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

    private class BListener implements  ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {


            Object[] columns = {"Destinatia"};
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(columns);


            // Create the connection and prepare the statement
            try {
                Connection myConnection = DB.getConnection();
                PreparedStatement myStatement = myConnection.prepareStatement("call exercitiul5b(?, ?);");

                String varStatut = "VIP";
                // 3 mai apare de 2 ori
                if ( b2.isSelected() )
                {
                    varStatut = "VIP";
                }
                else {
                    if ( b3.isSelected() ) {
                        varStatut = "C";
                    }
                }

                String varDeLa = "Oradea";
                try {
                    varDeLa = b5.getText();
                } catch (Exception exception) {
                    System.out.println("nu s-a putut prelua De La...ex5b");
                }


                myStatement.setString(1, varStatut);
                myStatement.setString(2, varDeLa);


                ResultSet myResult = myStatement.executeQuery();

                while ( myResult.next() ) {
                    Object[] row = new Object[1];
                    row[0] = myResult.getString("destinatia");

                    ;

                    model.addRow(row);

                }
            } catch (Exception exception) {
                System.out.println("ceva nu e bine ex 5 B");
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
