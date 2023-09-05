import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;

public class FenetreEnregistrerEnseignant{

	private JPanel contentPane;
	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private JTextField textFieldTel;
    private GestionEtablissement etablissement;
    private JFrame frame;

	/**
	 * lancement de la fenetre.
	 */
	public FenetreEnregistrerEnseignant(GestionEtablissement etablissement) {
        this.etablissement = etablissement;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
                    creerFenetre();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Creation de la la fenetre.
	 */
	public void creerFenetre() {
        frame = new JFrame("Enregistrement Nouveau Enseignant");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 602, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(255,128,64));
		frame.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255,128,64));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Enregistrement Un Enseignant");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 240, 240));
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_1.add(btnEnregistrer);
		JButton btnAnnuler = new JButton("Corriger");
		btnAnnuler.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_1.add(btnAnnuler);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_1.add(btnRetour);
        btnRetour.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.dispose();
            }
        });
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("Nom:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		textFieldNom = new JTextField();
		textFieldNom.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Pénom:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		textFieldPrenom = new JTextField();
		textFieldPrenom.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Date Naissance:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblNewLabel_4 = new JLabel("Tel:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		textFieldTel = new JTextField();
		textFieldTel.setColumns(10);
		String[] jours = {"Jour","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20",
								"21","22","23","24","25","26","27","28","29","30","31"};
		String[] mois = {"Mois","1","2","3","4","5","6","7","8","9","10","11","12"};
		String[] annees = new String[46];
		annees[0] = "Annee";
		for(int i=1 ; i < annees.length ; i++)
			annees[i] = (1960 + i) + "";
		JComboBox<String> comboBoxJours = new JComboBox<String>(jours);
		comboBoxJours.setMaximumRowCount(7);
		
		JComboBox<String> comboBoxMois = new JComboBox<String>(mois);
		JComboBox<String> comboBoxAnnee = new JComboBox<String>(annees);
		
		JLabel lblNewLabel_5 = new JLabel("Diplôme:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		String[] titres = {"Titre Diplôme","Baccalaureat","Maitrise","Doctorat"};
		JComboBox<String> comboBoxTitre = new JComboBox<String>(titres);
		String[] specialites = {"Specialité","Informatique","Mathématiques","Physique","Chimie"};
		JComboBox<String> comboBoxSpec = new JComboBox<String>(specialites);
		String[] anneesO = new String[64];
		anneesO[0] = "Annee Obtention";
		for(int i=1 ; i < annees.length ; i++)
			anneesO[i] = (1960 + i) + "";
		JComboBox<String> comboBoxAnObt = new JComboBox<String>(anneesO);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldNom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(42)
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textFieldPrenom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(32)
							.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(textFieldTel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(48, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel_5))
							.addPreferredGap(ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBoxJours, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBoxTitre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(35)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBoxMois, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBoxSpec, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(37)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBoxAnObt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBoxAnnee, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
							.addGap(160))))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(textFieldNom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(textFieldPrenom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4)
						.addComponent(textFieldTel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(comboBoxAnnee, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxJours, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxMois, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(comboBoxTitre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxSpec, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxAnObt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(63, Short.MAX_VALUE))
		);
        btnEnregistrer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    String nom = textFieldNom.getText();
                    String prenom = textFieldNom.getText();
                    String tel = textFieldTel.getText();
                    boolean create = false;
                    int jour, mois, annee;
                    Date d = null;
                    if(comboBoxJours.getSelectedIndex() >= 1 && comboBoxMois.getSelectedIndex() >= 1 && comboBoxAnnee.getSelectedIndex() >= 1){
                        jour = Integer.parseInt((String)comboBoxJours.getSelectedItem());
                        mois = Integer.parseInt((String)comboBoxMois.getSelectedItem());
                        annee= Integer.parseInt((String)comboBoxAnnee.getSelectedItem());
                        d = new Date(jour,mois, annee);
                        create = true;
                    }
                    if(create && comboBoxSpec.getSelectedIndex() >= 1 && comboBoxTitre.getSelectedIndex() >= 1 && comboBoxAnObt.getSelectedIndex() >= 1){
                        String titre = (String) comboBoxTitre.getSelectedItem();
                        int anObt = Integer.parseInt((String)comboBoxAnObt.getSelectedItem());
                        String specialite = (String)comboBoxSpec.getSelectedItem();
                        Diplome diplome = new Diplome(titre, specialite, tel, anObt);
                        Enseignant prof = new Enseignant(nom, prenom, tel, d, diplome);
                        etablissement.getLesPersonnels().accept(VisitorInsertionImpl.getInstance(), prof);
                        frame.dispose();
                    }                  
                } catch(Exception ex){}
            }
        });
        btnAnnuler.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                textFieldNom.setText("");
                textFieldNom.setText("");
                textFieldTel.setText("");
                comboBoxJours.setSelectedIndex(0);
                comboBoxMois.setSelectedIndex(0);
                comboBoxAnnee.setSelectedIndex(0);
                comboBoxTitre.setSelectedIndex(0);
                comboBoxAnObt.setSelectedIndex(0);
                comboBoxSpec.setSelectedIndex(0);   
            } 
        });
        panel_2.setLayout(gl_panel_2);
        frame.setVisible(true);
    }
}