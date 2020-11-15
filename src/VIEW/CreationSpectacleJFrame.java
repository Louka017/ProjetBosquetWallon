package VIEW;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import POJO.Artiste;
import javax.swing.ListModel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.SwingConstants;

public class CreationSpectacleJFrame extends JFrame {

	private static final long serialVersionUID = -5754931842887157647L;
	private JPanel contentPane;
	private JTextField NomSpectacle;
	private JTextField Bronze;
	private JTextField Argent;
	private JTextField Or;
	private JTextField Diamant;
	private JTextField Libre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//LoginJFrame frame = new LoginJFrame();
					CreationSpectacleJFrame frame = new CreationSpectacleJFrame();
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
	public CreationSpectacleJFrame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		
		//NOM SPECTACLE
		JLabel lblNomSpectacle = new JLabel("Nom du spectacle : ");
		lblNomSpectacle.setForeground(Color.WHITE);
		lblNomSpectacle.setBounds(10, 10, 121, 13);
		contentPane.add(lblNomSpectacle);
		
		NomSpectacle = new JTextField();
		NomSpectacle.setColumns(10);
		NomSpectacle.setBounds(10, 28, 116, 19);
		contentPane.add(NomSpectacle);
		
		//ARTiSTES
		JLabel lblChoixArtistes = new JLabel("Artistes choisi :");
		lblChoixArtistes.setHorizontalAlignment(SwingConstants.CENTER);
		lblChoixArtistes.setForeground(Color.WHITE);
		lblChoixArtistes.setBounds(320, 10, 116, 13);
		contentPane.add(lblChoixArtistes);
		
	
		JButton btnChoisir = new JButton("Choisir");
		btnChoisir.setBounds(235, 40, 85, 21);
		contentPane.add(btnChoisir);	

		
		JButton btnRetirer = new JButton("Retirer");
		btnRetirer.setBounds(235, 73, 85, 21);
		contentPane.add(btnRetirer);
		
		JLabel lblArtistesPresent = new JLabel("Liste d'artistes :");
		lblArtistesPresent.setForeground(Color.WHITE);
		lblArtistesPresent.setBounds(141, 10, 121, 13);
		contentPane.add(lblArtistesPresent);
		
		//CONFIGURATION
		JLabel lblConfiguration = new JLabel("Configuration:");
		lblConfiguration.setForeground(Color.WHITE);
		lblConfiguration.setBounds(10, 73, 116, 13);
		contentPane.add(lblConfiguration);
		
		JRadioButton RadioDebout = new JRadioButton("Debout");
		RadioDebout.setBounds(10, 94, 103, 21);
		contentPane.add(RadioDebout);
		
		JRadioButton RadioConcert = new JRadioButton("Concert");
		RadioConcert.setSelected(true);
		RadioConcert.setBounds(10, 115, 103, 21);
		contentPane.add(RadioConcert);
		
		JRadioButton RadioCirque = new JRadioButton("Cirque");
		RadioCirque.setBounds(10, 132, 103, 21);
		contentPane.add(RadioCirque);
		
			JLabel lblBronze = new JLabel("Bronze : ");
			lblBronze.setForeground(Color.WHITE);
			lblBronze.setBounds(10, 206, 60, 13);
			contentPane.add(lblBronze);
			Bronze = new JTextField();
			Bronze.setBounds(65, 203, 35, 19);
			contentPane.add(Bronze);
			Bronze.setColumns(10);
		
			
			JLabel lblArgent = new JLabel("Argent  : ");
			lblArgent.setForeground(Color.WHITE);
			lblArgent.setBounds(10, 235, 60, 13);
			contentPane.add(lblArgent);
			Argent = new JTextField();
			Argent.setBounds(65, 232, 35, 19);
			contentPane.add(Argent);
			Argent.setColumns(10);
		
			
			JLabel lblOr = new JLabel("Or : ");
			lblOr.setForeground(Color.WHITE);
			lblOr.setBounds(181, 206, 35, 13);
			contentPane.add(lblOr);
			Or = new JTextField();
			Or.setBounds(212, 203, 35, 19);
			contentPane.add(Or);
			Or.setColumns(10);
		
			
			JLabel lblDiamant = new JLabel("Diamant : ");
			lblDiamant.setForeground(Color.WHITE);
			lblDiamant.setBounds(148, 233, 68, 17);
			contentPane.add(lblDiamant);
			Diamant = new JTextField();
			Diamant.setBounds(212, 232, 35, 19);
			contentPane.add(Diamant);
			Diamant.setColumns(10);
		
			JLabel lblLibre = new JLabel("Libre :");
			lblLibre.setForeground(Color.WHITE);
			lblLibre.setBounds(10, 206, 45, 13);
			contentPane.add(lblLibre);
			Libre = new JTextField();
			Libre.setBounds(55, 203, 35, 19);
			contentPane.add(Libre);
			Libre.setColumns(10);
			
	//RADIO GROUP	
	ButtonGroup bgroup = new ButtonGroup();
	bgroup.add(RadioDebout);
	bgroup.add(RadioConcert);
	bgroup.add(RadioCirque);
	
	//VALIDER
	JButton btnValider = new JButton("VALIDER");
	btnValider.setBounds(320, 190, 85, 44);
	contentPane.add(btnValider);
	
	//PRIX DES PLACES
	JLabel lblPrix = new JLabel("Prix des places :");
	lblPrix.setForeground(Color.WHITE);
	lblPrix.setBounds(10, 175, 121, 13);
	contentPane.add(lblPrix);
	
	//SYMBOLES EURO
	JLabel lblEuro1 = new JLabel("\u20AC");
	lblEuro1.setVisible(false);
	lblEuro1.setForeground(Color.WHITE);
	lblEuro1.setBounds(110, 206, 16, 13);
	contentPane.add(lblEuro1);
	
	JLabel lblEuro2 = new JLabel("\u20AC");
	lblEuro2.setVisible(false);
	lblEuro2.setForeground(Color.WHITE);
	lblEuro2.setBounds(110, 235, 16, 13);
	contentPane.add(lblEuro2);
	
	JLabel lblEuro3 = new JLabel("\u20AC");
	lblEuro3.setVisible(false);
	lblEuro3.setForeground(Color.WHITE);
	lblEuro3.setBounds(253, 206, 16, 13);
	contentPane.add(lblEuro3);
	
	JLabel lblEuro4 = new JLabel("\u20AC");
	lblEuro4.setVisible(false);
	lblEuro4.setForeground(Color.WHITE);
	lblEuro4.setBounds(253, 235, 16, 13);
	contentPane.add(lblEuro4);
	
	JList list = new JList();
	list.setBounds(330, 30, 89, 86);
	contentPane.add(list);
	
	JList list_1 = new JList();
	list_1.setBounds(136, 30, 89, 86);
	contentPane.add(list_1);
	
	//CONFIGURATION CHOISIE
	
	RadioDebout.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == RadioDebout) {
				lblBronze.setVisible(false);
				Bronze.setVisible(false);
				lblArgent.setVisible(false);
				Argent.setVisible(false);
				lblOr.setVisible(false);
				Or.setVisible(false);
				lblDiamant.setVisible(false);
				Diamant.setVisible(false);
				lblLibre.setVisible(true);
				Libre.setVisible(true);
				lblEuro1.setVisible(true);
				lblEuro2.setVisible(false);
				lblEuro3.setVisible(false);
				lblEuro4.setVisible(false);
			}
		}
	});
	
	RadioConcert.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == RadioConcert) {
				lblLibre.setVisible(false);
				Libre.setVisible(false);
				lblDiamant.setVisible(false);
				Diamant.setVisible(false);
				lblBronze.setVisible(true);
				Bronze.setVisible(true);
				lblArgent.setVisible(true);
				Argent.setVisible(true);
				lblOr.setVisible(true);
				Or.setVisible(true);
				lblEuro1.setVisible(true);
				lblEuro2.setVisible(true);
				lblEuro3.setVisible(true);
				lblEuro4.setVisible(false);
			}
		}
	});
	
	RadioCirque.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == RadioCirque) {
				lblLibre.setVisible(false);
				Libre.setVisible(false);
				lblBronze.setVisible(true);
				Bronze.setVisible(true);
				lblArgent.setVisible(true);
				Argent.setVisible(true);
				lblOr.setVisible(true);
				Or.setVisible(true);
				lblDiamant.setVisible(true);
				Diamant.setVisible(true);
				lblEuro1.setVisible(true);
				lblEuro2.setVisible(true);
				lblEuro3.setVisible(true);
				lblEuro4.setVisible(true);
			}
		}
	});
	
		
		
	}
}
