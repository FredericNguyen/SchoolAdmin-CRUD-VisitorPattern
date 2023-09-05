
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class FenetreNotesExamens{

	private JPanel contentPane;
	private JTextField textField;
    GestionEtablissement etablissement;
    private JFrame frame; 
    private JComboBox<String> comboBoxEtudiant;
    private ExamMatiere examMatiere ;

	/**
	 * Launch the application.
	 */
	public FenetreNotesExamens(GestionEtablissement etablissement) {
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
	 * Creation de la fenetre.
	 */
	public void creerFenetre() {
        frame = new JFrame("Insertion de Notes");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		frame.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBackground(new Color(255,128,64));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Insertion Notes");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(lblNewLabel);
		panel.setBackground(new Color(255,128,64));
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new GridLayout(3, 1));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Code Matière:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_2.add(lblNewLabel_1);
        String[] codeMatieres = etablissement.getLesMatieres().accept(VisitorAccessImpl.getInstance(),1) ;
		JComboBox<String> comboBox = new JComboBox<String>(codeMatieres);
        comboBox.setPreferredSize(new Dimension(100,30));
        comboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e){
				VisitorAccessInterf visiteur = VisitorAccessImpl.getInstance();
                if (e.getSource() == comboBox && e.getStateChange() == ItemEvent.SELECTED){
                    String codeMatiere = (String)comboBox.getSelectedItem();
                    Matiere matiere = etablissement.getLesMatieres().accept(visiteur,codeMatiere);  
                    String[] codeEtds = etablissement.getLesPersonnels().accept(visiteur,matiere);
					for(int i= 0; i< codeEtds.length ; i++)
						comboBoxEtudiant.addItem(codeEtds[i]);
                }
            }    
        });
		panel_2.add(comboBox);
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Code Etudiant:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_3.add(lblNewLabel_2);
		
		comboBoxEtudiant = new JComboBox<String>();
		panel_3.add(comboBoxEtudiant);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		
		JLabel lblNewLabel_3 = new JLabel("Note:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_4.add(lblNewLabel_3);
		
		textField = new JTextField();
		panel_4.add(textField);
		textField.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		contentPane.add(panel_5, BorderLayout.CENTER);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\ablak\\OneDrive\\Bureau\\photoLibrairie\\imagePret.jpg"));
		panel_5.add(lblNewLabel_4);
		
		JPanel panel_6 = new JPanel();
		contentPane.add(panel_6, BorderLayout.SOUTH);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnAjouter.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String etdCode = (String)comboBoxEtudiant.getSelectedItem();
                int note = Integer.parseInt(textField.getText());
				System.out.println(etdCode + "," + note);
                Etudiant etd = (Etudiant)etablissement.getLesPersonnels().accept(VisitorAccessImpl.getInstance(), etdCode);
                examMatiere.accept(VisitorInsertionImpl.getInstance(),etd,note);
            }
        });
		panel_6.add(btnAjouter);
		
		JButton btnFin = new JButton("Fin Insertion");
		btnFin.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_6.add(btnFin);
        btnFin.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.dispose();
            }
        });

	}

}
