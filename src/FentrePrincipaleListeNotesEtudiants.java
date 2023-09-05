
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class FentrePrincipaleListeNotesEtudiants{

	private JPanel contentPane;
    private JFrame frame;
    private GestionEtablissement etablissement;

	/**
	 * Launch the application.
	 */
	public FentrePrincipaleListeNotesEtudiants(GestionEtablissement etablissement) {
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
        frame = new JFrame("Lister Notes Etudiants");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		frame.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelCombo = new JPanel();
		contentPane.add(panelCombo, BorderLayout.NORTH);
		
		JLabel lblTitre = new JLabel("Liste Notes Etudiants");
		lblTitre.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelCombo.add(lblTitre);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new GridLayout(2, 1));
		
		JPanel panel = new JPanel();
		panel_1.add(panel);
		
		JLabel lblCodeEtd = new JLabel("Codes Etudiants");
		panel.add(lblCodeEtd);
        String[] tab = etablissement.getLesPersonnels().accept(VisitorAccessImpl.getInstance(),true);
        String [] liste = new String[tab.length + 1];
        liste[0] = "Tous";
        for(int i=0; i < tab.length ; i++)
            liste[i+1] = tab[i];    
		JComboBox<String> cbBoxCodeEtd = new JComboBox<String>(liste);
		panel.add(cbBoxCodeEtd);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		
		JButton btnLister = new JButton("Lister");
		btnLister.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_2.add(btnLister);
        btnLister.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String codeEtd = (String)cbBoxCodeEtd.getSelectedItem();
                new FenetreListeNoteMoyenEtudiants(etablissement,codeEtd);
            }
        }); 

		JButton btnRetour = new JButton("Retour");
        btnRetour.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.dispose();
            }
        });
		btnRetour.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_2.add(btnRetour);
		
		JPanel panelImage = new JPanel();
		contentPane.add(panelImage, BorderLayout.CENTER);
		
		JLabel lblImage = new JLabel("New label");
		lblImage.setIcon(new ImageIcon("C:\\Users\\ablak\\OneDrive\\Bureau\\photoLibrairie\\imagePret.jpg"));
		panelImage.add(lblImage);
	}

}
