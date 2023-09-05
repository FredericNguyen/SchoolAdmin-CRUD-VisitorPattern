
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;


import java.awt.Color;
import javax.swing.ImageIcon;

public class FenetreInsertionExamen{

	private JPanel contentPane;
	private JFrame frame;
	private LesExamens examens;
	private LesMatieres matieres;
	private LesPersonnels personnels;
	

	/**
	 * Construction de la fenetre.
	 */
	public FenetreInsertionExamen(LesExamens examens, LesMatieres matieres, LesPersonnels personnels) {
		this.examens = examens;
		this.matieres = matieres;
		this.personnels = personnels;
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
		frame = new JFrame("Insertion nouveau Examen");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 768, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		frame.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 128, 64));
		contentPane.add(panel, BorderLayout.WEST);
		
		JLabel lblNewLabel = new JLabel("Code Matière:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel.add(lblNewLabel);
		String[] codes = matieres.accept(VisitorAccessImpl.getInstance(),0);   
		JComboBox<String> comboBox = new JComboBox<String>(codes);
		panel.add(comboBox);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 128, 64));
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("Ajout Un Examen");
		lblNewLabel_1.setBackground(new Color(255, 128, 64)); //Color.ORANGE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 128, 64));
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_2.add(btnAjouter);
		btnAjouter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String codeMatiere = (String) comboBox.getSelectedItem();
				//Matiere m = matieres.getMatieres().get(codeMatiere);
				Matiere m = matieres.accept(VisitorAccessImpl.getInstance(), codeMatiere);
				int reponse;
				if(!examens.accept(VisitorInsertionImpl.getInstance(),m))
					reponse = JOptionPane.showConfirmDialog(null, "Cette Examen existe deja. Voulez vous inserer des notes dans l'examen de" + m.getDesc()  + "?", "Creation Un Examen", JOptionPane.YES_NO_OPTION);
				else
					reponse = JOptionPane.showConfirmDialog(null, "Examen cree. Voulez vous inserer des notes dans l'examen de" + m.getDesc()  + "?", "Creation Un Examen", JOptionPane.YES_NO_OPTION);
				if (reponse == JOptionPane.YES_OPTION)
						new FenetreInsertionNotesExam(examens.getExamens().get(m.getCode()), personnels);
					// else
					// 	frame.dispose();
					//new FenetreInsertionNotesExam(examens.getExamens().get(codeMatiere), personnels);	 
			}
		});
		// JButton btnAjouterNote = new JButton("Ajouter Notes");
		// // btnAjouterNote.addActionListener(new ActionListener(){
		// // 	public void actionPerformed(ActionEvent e){
		// // 		new FenetreInsertionNotesExam(examen, personnels);
		// // 	}
		// // });
		// btnAjouterNote.setFont(new Font("Tahoma", Font.BOLD, 13));

		// panel_2.add(btnAjouterNote);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRetour.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
			}
		});
		panel_2.add(btnRetour);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\ablak\\OneDrive\\Bureau\\photoLibrairie\\imagePret.jpg"));
		contentPane.add(lblNewLabel_2, BorderLayout.CENTER);
	}

}
