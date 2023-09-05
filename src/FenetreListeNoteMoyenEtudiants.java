
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
    
public class FenetreListeNoteMoyenEtudiants {

    private JFrame frame;
    private JTable table;
    GestionEtablissement etablissement;
    String codeEtd;

public FenetreListeNoteMoyenEtudiants(GestionEtablissement etablissement, String codeEtd){
        this.etablissement = etablissement;
        this.codeEtd = codeEtd;
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    initialiser();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void initialiser() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 128, 64));
        frame.getContentPane().add(panel, BorderLayout.NORTH);
        String titre;
        titre = "Liste des Notes des étudiants dans l'etablissement";
        JLabel lblTitre = new JLabel(titre);
        lblTitre.setFont(new Font("Serif", Font.BOLD, 18));
        panel.add(lblTitre);
        //String[] enteteTable = etablissement.getLesMatieres().accept(new VisitorAccessImpl()); //invite visite pour chercher nom matieres
        String[] enteteTable = etablissement.accept(VisitorAccessImpl.getInstance());
        String[][] data;
        if(codeEtd.equalsIgnoreCase("Tous"))
            data = etablissement.accept(VisitorCalculMoyenneImpl.getInstance());//invite visit pur table de notes et 
        // Creation de la table JTable
        else
            data = etablissement.accept(VisitorCalculMoyenneImpl.getInstance(),codeEtd);
        table = new JTable(data, enteteTable);
        JScrollPane scroll = new JScrollPane(table); 
        JPanel sud = new JPanel();
        sud.setLayout(new GridLayout(2,1));
        JPanel panelLabel = new JPanel();
        panelLabel.add(new JLabel("Nombre d't\u00E9udiants: " + data.length));
        sud.add(panelLabel);
        panelLabel.setBackground(new Color(255, 128, 64));
        JPanel panelBtn = new JPanel();
        JButton retour = new JButton("Retour");
        panelBtn.add(retour);
        sud.add(panelBtn);
        panelBtn.setBackground(new Color(255, 128, 64));
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
       
