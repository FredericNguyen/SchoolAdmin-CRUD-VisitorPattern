
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;

import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

public class FenetreAffecterMatiere1{

	private JPanel contentPane;
    private JFrame frame;
    private GestionEtablissement etablissement;
    private VisitorAccessInterf visiteur;
    private JComboBox<String> cbBoxCodeEtudiant;

	/**
	 * Lancement de l'application.
	 */
	public FenetreAffecterMatiere1(GestionEtablissement etablissement) {
        visiteur = VisitorAccessImpl.getInstance(); 
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
	 * Create the frame.
	 */
	public void creerFenetre() {
        frame = new JFrame("Affectation Matière");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 604, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		frame.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelTitre = new JPanel();
		contentPane.add(panelTitre, BorderLayout.NORTH);
		
		JLabel lblTitre = new JLabel("Affectation Matière");
		lblTitre.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelTitre.add(lblTitre);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		
		JLabel lblCodeMatiere = new JLabel("Code Matiere?");
		lblCodeMatiere.setFont(new Font("Tahoma", Font.BOLD, 13));
		String[] codeMatieres = etablissement.getLesMatieres().accept(visiteur,1);
        Arrays.sort(codeMatieres);
		JComboBox<String> cbBoxCodeMatiere = new JComboBox<String>(codeMatieres);
		
		JLabel lblTypePersonne = new JLabel("Etudiant/Enseignant?");
		lblTypePersonne.setFont(new Font("Tahoma", Font.BOLD, 13));
		String[] tab = {"Enseignant", "Etudiant"};
		JComboBox<String> cbBoxTypePersonne = new JComboBox<String>(tab);
        cbBoxTypePersonne.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e){
                if (e.getSource() == cbBoxTypePersonne && e.getStateChange() == ItemEvent.SELECTED){
                    String personne = (String)cbBoxTypePersonne.getSelectedItem(); 
                    String[] codesPersonnes = personne.equalsIgnoreCase("Etudiant") ?  etablissement.getLesPersonnels().accept(visiteur,true) : 
                                etablissement.getLesPersonnels().accept(visiteur,false);
					cbBoxCodeEtudiant.removeAllItems();
                    for(int i = 0; i < codesPersonnes.length; i++)
                        cbBoxCodeEtudiant.addItem(codesPersonnes[i]);
					cbBoxCodeEtudiant.addItem("Tous");
                }
            }    
        });
		JLabel lblCodePersonne = new JLabel("Code Enseignat/Etudiant?");
		lblCodePersonne.setFont(new Font("Tahoma", Font.BOLD, 13));
		String[] codePers = etablissement.getLesPersonnels().accept(visiteur,false);
		cbBoxCodeEtudiant = new JComboBox<String>(codePers);
		
		JButton btnAffecter = new JButton("Affecter");
		btnAffecter.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnAffecter.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String codeMatiere = (String)cbBoxCodeMatiere.getSelectedItem();
                Matiere matiere = etablissement.getLesMatieres().accept(VisitorAccessImpl.getInstance(),codeMatiere); 
				String codePersonne = (String)cbBoxCodeEtudiant.getSelectedItem();
				if(!codePersonne.equals("Tous")){
                	Personne p = etablissement.getLesPersonnels().accept(visiteur, codePersonne);
                	p.accept(VisitorInsertionImpl.getInstance(), matiere);
				}
				else{
					String personne = (String)cbBoxTypePersonne.getSelectedItem(); 
					String[] codesPersonnes = personne.equalsIgnoreCase("Etudiant") ?  etablissement.getLesPersonnels().accept(visiteur,true) : 
                                etablissement.getLesPersonnels().accept(visiteur,false);
					for(int i = 0; i < codesPersonnes.length ; i++){
						Personne p = etablissement.getLesPersonnels().accept(visiteur, codePersonne);
                		p.accept(VisitorInsertionImpl.getInstance(), matiere);
					}
				}
            }
        });
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnRetour.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.dispose();
            }
        });
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(5)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblCodeMatiere)
										.addComponent(lblTypePersonne)))
								.addComponent(lblCodePersonne))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(cbBoxCodeEtudiant, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(cbBoxTypePersonne, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(cbBoxCodeMatiere, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnAffecter)
							.addGap(18)
							.addComponent(btnRetour)))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(9)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodeMatiere)
						.addComponent(cbBoxCodeMatiere, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTypePersonne)
						.addComponent(cbBoxTypePersonne, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodePersonne)
						.addComponent(cbBoxCodeEtudiant, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAffecter)
						.addComponent(btnRetour))
					.addContainerGap(48, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panelImage = new JPanel();
		contentPane.add(panelImage, BorderLayout.CENTER);
		
		JLabel lblImage = new JLabel("");
		lblImage.setIcon(new ImageIcon("C:\\Users\\ablak\\OneDrive\\Bureau\\photoLibrairie\\imagePret.jpg"));
		panelImage.add(lblImage);
	}
}
