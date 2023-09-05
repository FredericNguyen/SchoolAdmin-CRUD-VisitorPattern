
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
    
public class FenetreListeMoyenneExams  {

    private JFrame frame;
    private JTable table;
    LesExamens examens;

public FenetreListeMoyenneExams(LesExamens examens){
        this.examens= examens;
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    initialize();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 128, 64));
        frame.getContentPane().add(panel, BorderLayout.NORTH);
        String titre;
        titre = "Liste des moyennes des examens";
        JLabel lblTitre = new JLabel(titre);
        lblTitre.setFont(new Font("Serif", Font.BOLD, 18));
        panel.add(lblTitre);
        String[] enteteTable = examens.accept(VisitorAccessImpl.getInstance()); //invite visite pour chercher nom matieres
        String[][] data = examens.accept(VisitorCalculMoyenneImpl.getInstance());//invite visit pour table de moyennes des examens et 
        // Creation de la table JTable
        table = new JTable(data, enteteTable);
        JScrollPane scroll = new JScrollPane(table); 
        JPanel sud = new JPanel();
        sud.setLayout(new GridLayout(2,1));
        sud.setBackground(new Color(255, 128, 64));
        JPanel panelLabel = new JPanel();
        panelLabel.add(new JLabel("Nombre d'Examens " + data.length));
        panelLabel.setBackground(new Color(255, 128, 64));
        sud.add(panelLabel);
        JPanel panelBtn = new JPanel();
        JButton retour = new JButton("Retour");
        panelBtn.add(retour);
        panelBtn.setBackground(new Color(255, 128, 64));
        sud.add(panelBtn);
        sud.setBackground(Color.ORANGE);
        retour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        frame.add(scroll);
        frame.getContentPane().add(sud,BorderLayout.SOUTH);
        frame.pack();
        }	
}
