import javax.swing.GroupLayout.Alignment;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;


public class FenetreInsertionNotesExam {
    private static final int DISPOSE_ON_CLOSE = 0;
    private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
    private ExamMatiere examen;
    private LesPersonnels personnels;
    private JFrame frame;

	/**
	 * Launch the application.
	 */
	public FenetreInsertionNotesExam(ExamMatiere examen, LesPersonnels personnels) {
        this.examen = examen;
        this.personnels = personnels;
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
	 * Create the frame.
	 */
	public void creerFenetre() {
        frame = new JFrame("Insertion Notes Examen");
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 768, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		frame.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 128, 64));
		contentPane.add(panel, BorderLayout.WEST);
		
		JLabel lblNewLabel = new JLabel("Code Etudiant:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Note Etudiant:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGap(18)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(193, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 128, 64));
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("Insertion Notes Examen");
		lblNewLabel_1.setBackground(new Color(255, 128, 64));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 128, 64));
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnNewButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
				int note = 0;
				Etudiant  etd = null;
				try{
            		note = Integer.parseInt(textField_1.getText());
                	String codeEtd = textField.getText();
                	etd = (Etudiant)personnels.getPersonnels().get(codeEtd);
                	if(etd != null)
                		examen.accept(VisitorInsertionImpl.getInstance(),etd,note);
                	textField.setText("");
                	textField_1.setText("");
            	}catch(Exception ex){
					System.out.println(note + " " + etd);
				}
        }});
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Fin insertion Note");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnNewButton_1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.dispose();
            }
        });
		panel_2.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\ablak\\OneDrive\\Bureau\\photoLibrairie\\imagePret.jpg"));
		contentPane.add(lblNewLabel_2, BorderLayout.CENTER);
        frame.setVisible(true);
	}

}
