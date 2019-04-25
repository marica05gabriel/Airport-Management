import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class MainWindow {

    JFrame mainFrame;

    JButton exercitiul3;
    JButton exercitiul4;
    JButton exercitiul5;
    JButton exercitiul6;


    public static void main(String[] args) {

        MainWindow mainWindow = new MainWindow();
    }

    public MainWindow () {
        mainFrame = new JFrame();
        gui();

        exercitiul3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Exercise3 exercise3 = new Exercise3();

                } catch (Exception ex) {
                    System.out.println("Nu se poate deschide Exercitiul 3");
                }
                mainFrame.dispose();
            }
        });


        exercitiul4.addActionListener(new Exercitiul4());
        exercitiul5.addActionListener(new Exercitiul5());
        exercitiul6.addActionListener(new Exercitiul6());
    }


    public void gui(){
        // initialize the main frame
        mainFrame.setTitle("Subiectul 7 - Marica Gabriel");
        mainFrame.setSize(800,600);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);


        //add the Background
        mainFrame.setLayout(new BorderLayout());
        JLabel background=new JLabel(new ImageIcon("D:\\WorkSpace\\POO\\Proiect_BD_Final\\src\\mainWindowBackground1.gif"));
        mainFrame.add(background);
        background.setLayout(new BorderLayout());


        // SOUTH
        JLabel maricaGabriel = new JLabel("Project made by Marica Gabriel");
        maricaGabriel.setForeground(Color.white);

        JPanel southPanel = new JPanel();
        southPanel.setBackground(Color.black);
        southPanel.add(maricaGabriel);


        //Add Buttons
         exercitiul3 = new JButton("Exercitiul 3");
         exercitiul4 = new JButton("Exercitiul 4");
         exercitiul5 = new JButton("Exercitiul 5");
         exercitiul6 = new JButton("Exercitiul 6");
        exercitiul3.setBackground(Color.white);
        exercitiul4.setBackground(Color.white);
        exercitiul5.setBackground(Color.white);
        exercitiul6.setBackground(Color.white);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(Color.white);


        //buttonsPanel.setLayout( new BoxLayout(buttonsPanel, BoxLayout.X_AXIS ));
        buttonsPanel.setLayout(new FlowLayout());
        buttonsPanel.add(exercitiul3);
        buttonsPanel.add(exercitiul4);
        buttonsPanel.add(exercitiul5);
        buttonsPanel.add(exercitiul6);


        background.add(buttonsPanel, BorderLayout.NORTH);


        background.add(southPanel, BorderLayout.SOUTH);
        mainFrame.pack();
        //mainFrame.setResizable(false);
        //mainFrame.setSize(800, 600);
        mainFrame.setVisible(true);
    }

    private class Exercitiul4 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                Exercise4 exercise4 = new Exercise4();

            } catch (Exception ex) {
                System.out.println("Nu se poate deschide Exercitiul 4");
                ex.printStackTrace();
            }
            mainFrame.dispose();
        }
    }

    private class Exercitiul5 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                Exercise5 exercise5 = new Exercise5();

            } catch (Exception ex) {
                System.out.println("Nu se poate deschide Exercitiul 5");
                ex.printStackTrace();
            }
            mainFrame.dispose();
        }
    }

    private class Exercitiul6 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                Exercise6 exercise6 = new Exercise6();

            } catch (Exception ex) {
                System.out.println("Nu se poate deschide Exercitiul 6");
                ex.printStackTrace();
            }
            mainFrame.dispose();
        }
    }



}
