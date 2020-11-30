package VIEW;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import POJO.Gestionnaire;
import POJO.Personne;
import POJO.PlanningSalle;
import POJO.Spectacle;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class GestionnaireJFrame extends JFrame {

	private JPanel contentPane;
	private JList<PlanningSalle> listeTousLesSpec;
	private JLabel lblDb;
	private JLabel lblDf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginJFrame frame = new LoginJFrame();
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
	public GestionnaireJFrame(Personne p) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 685, 408);
		//JPANEL
		contentPane = new JPanel() {
			private static final long serialVersionUID = 3827614812064042101L;
			public void paintComponent(Graphics g) {
                Image img = Toolkit.getDefaultToolkit().getImage(LoginJFrame.class.getResource("theatre.jpg"));
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
            }
          };
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		DefaultListModel<PlanningSalle> model = new DefaultListModel<>();
		model.addAll(p.findAllPlanningSalle());
		listeTousLesSpec = new JList<>(model);
		listeTousLesSpec.setBounds(10, 44, 312, 305);
		contentPane.add(listeTousLesSpec);
		
		
		//BOUTON RETOUR
		JButton btnRetour = new JButton("Retour");
		btnRetour.setBounds(493, 193, 85, 21);
		contentPane.add(btnRetour);
		
		JLabel lblId = new JLabel("Id");
		lblId.setHorizontalAlignment(SwingConstants.LEFT);
		lblId.setBounds(10, 22, 45, 13);
		contentPane.add(lblId);
		
		lblDb = new JLabel("Date d\u00E9but : ");
		lblDb.setHorizontalAlignment(SwingConstants.CENTER);
		lblDb.setBounds(93, 21, 85, 13);
		contentPane.add(lblDb);
		
		lblDf = new JLabel("Date fin :");
		lblDf.setHorizontalAlignment(SwingConstants.CENTER);
		lblDf.setBounds(258, 22, 64, 13);
		contentPane.add(lblDf);
		
		
		
	}
}
