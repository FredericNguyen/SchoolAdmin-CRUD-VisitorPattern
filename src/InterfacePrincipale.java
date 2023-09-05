
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class InterfacePrincipale extends JFrame {
	private GestionEtablissement etablissement;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfacePrincipale frame = new InterfacePrincipale();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public InterfacePrincipale() {
		etablissement = new GestionEtablissement("Ecole Notre Dame");
		// etablissement.accept(new VisitorChargementImpl());//on charge les fichgiers
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Dimension tailleMoniteur = Toolkit.getDefaultToolkit().getScreenSize();
		int longueur = tailleMoniteur.width * 2 / 3;
		int hauteur = tailleMoniteur.height * 2 / 3;
		// régler la taille de JFrame à 2/3 la taille de l'écran
		setBounds(100, 100, longueur, hauteur);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("Menu de choix principal");
		contentPane.setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		// panel.setBackground(Color.ORANGE);
		panel.setBackground(new Color(255, 128, 64));
		contentPane.add(panel, BorderLayout.NORTH);
		JLabel lblNewLabel = new JLabel("Gestion des Examens");
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));

		JButton btnNewButton = new JButton("Ajouter Etudiant");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FenetreEnregistrerEtudiant(etablissement);
			}
		});
		JButton btnNewButton_1 = new JButton("Ajouter Enseignant");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_1.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FenetreEnregistrerEnseignant(etablissement);
			}
		});

		JButton btnNewButton_2 = new JButton("Ajouter un Examen");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_1.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FenetreInsertionExamen(etablissement.getLesExamens(), etablissement.getLesMatieres(),
						etablissement.getLesPersonnels());
			}
		});

		JButton btnNewButton_3 = new JButton("Ajouter Matiere");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_1.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FenetreAjouterMatiere(etablissement.getLesMatieres());
			}
		});

		JButton btnNewButton_4 = new JButton("Lister Moyennes Examens");
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_1.add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FenetreListeMoyenneExams(etablissement.getLesExamens());
			}
		});
		JButton btnNewButton_5 = new JButton("Lister Notes Tous Etudiants");
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_1.add(btnNewButton_5);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FentrePrincipaleListeNotesEtudiants(etablissement);
			}
		});
		JButton btnNewButton_6 = new JButton("Inserer Notes Examen");
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_1.add(btnNewButton_6);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FenetreNotesExamens(etablissement);
			}
		});
		JButton btnNewButton_7 = new JButton("Affecter Mati\u00E8re");
		btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_1.add(btnNewButton_7);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FenetreAffecterMatiere1(etablissement);
			}
		});

		JButton btnNewButton_8 = new JButton("Quitter");
		btnNewButton_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_1.add(btnNewButton_8);
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				etablissement.accept(VisitorSauvegardeImpl.getInstance());
				dispose();
			}
		});

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 128, 64));
		contentPane.add(panel_2, BorderLayout.SOUTH);

		Label label = new Label("Faites vos choix");
		label.setAlignment(Label.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setBackground(new Color(255, 128, 64));
		panel_2.add(label);

		JPanel center = new JPanel();
		JLabel photo = new JLabel();
		photo.setText(null);
		photo.setIcon(new ImageIcon("ProjetFinalAlgo\\src\\donnees\\icon.jpg"));
		center.add(photo);
		center.setBackground(new Color(255, 128, 64));
		getContentPane().add(center, BorderLayout.CENTER);

	}

}
