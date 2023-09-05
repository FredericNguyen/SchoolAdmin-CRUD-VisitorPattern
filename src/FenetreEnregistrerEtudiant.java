import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class FenetreEnregistrerEtudiant{

	private JPanel contentPane;
	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private JTextField txtJjmmaaaa;
	private JTextField textFieldTel;
	private JTextField textFieldSpec;
    private JFrame frame;
    private GestionEtablissement etablissement;

	/**
	 * Le constructeur.
	 */
	public FenetreEnregistrerEtudiant(GestionEtablissement etablissement){
        this.etablissement = etablissement;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					creerFenetre();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Creation de la fenetre.
	 */
	public void creerFenetre(){
        frame = new JFrame("Enregistrment Nouveau Etudiant");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255,128,64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		frame.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		//panel.setBackground(new Color(240, 240, 240));
		panel.setBackground(new Color(255,128,64));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Enregistrer Un Etudiant");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("Nom: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		textFieldNom = new JTextField();
		textFieldNom.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Prénom:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		textFieldPrenom = new JTextField();
		textFieldPrenom.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Date Naissance:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtJjmmaaaa = new JTextField();
		txtJjmmaaaa.setText("jj/mm/aaaa");
		txtJjmmaaaa.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Spécialité:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		textFieldSpec = new JTextField();
		textFieldSpec.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Téléphone:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		textFieldTel = new JTextField();
		textFieldTel.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_4)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(textFieldNom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldSpec, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(34)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_5))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(textFieldTel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldPrenom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(44))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_3)
							.addGap(18)
							.addComponent(txtJjmmaaaa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2)
						.addComponent(textFieldPrenom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldNom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_4)
							.addComponent(textFieldTel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_5)
							.addComponent(textFieldSpec, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(34)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(txtJjmmaaaa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(91, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnEnregistrer = new JButton("Enregistrer");
        btnEnregistrer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
				try{
					String nom = textFieldNom.getText();
					String prenom = textFieldPrenom.getText();
					StringTokenizer st = new  StringTokenizer(txtJjmmaaaa.getText(),"/");
					int jour = Integer.parseInt(st.nextToken());
					int mois = Integer.parseInt(st.nextToken());
					int an = Integer.parseInt(st.nextToken());
					Date d = new Date(jour, mois, an);
					String specialite = textFieldSpec.getText();
					String tel = textFieldTel.getText();
					Etudiant etd = new Etudiant(nom,prenom,d,tel,specialite);
					System.out.println(etd);
					//on invite le visiteur d'insertion a venir inserer l'etudiant dans la structure 
					etablissement.getLesPersonnels().accept(VisitorInsertionImpl.getInstance(), etd);
            	}catch(Exception ex){}
			}    
        });
		btnEnregistrer.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_2.add(btnEnregistrer);
		
		JButton btnAnnuler = new JButton("Corriger");
        btnAnnuler.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                textFieldNom.setText("");
                textFieldPrenom.setText("");
                textFieldTel.setText("");
                textFieldSpec.setText("");
                txtJjmmaaaa.setText("jj/mm/aaaa");
            }
        });
		btnAnnuler.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_2.add(btnAnnuler);
		
		JButton btnRetour = new JButton("Retour");
        btnRetour.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.dispose();
            }
        });
		btnRetour.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_2.add(btnRetour);
        frame.setVisible(true);
	}
}

