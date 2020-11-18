package VIEW;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.ArtisteDAO;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;

import POJO.*;
import javax.swing.ListModel;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
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
	private JTextField Bronze2;
	private JTextField Argent2;
	private JTextField Or2;
	private JTextField Diamant2;
	private JTextField textField;
	private JTextField Libre2;
	private JList<Artiste> listeToutLesArtistes;
	LoginJFrame frame1 = new LoginJFrame();


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
	public CreationSpectacleJFrame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 735, 452);
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
		NomSpectacle.setBounds(10, 28, 151, 19);
		contentPane.add(NomSpectacle);
		
		//ARTISTES DISPONIBLES
		JLabel lblArtistesPresent = new JLabel("Liste d'artistes :");
		lblArtistesPresent.setForeground(Color.WHITE);
		lblArtistesPresent.setBounds(226, 10, 121, 13);
		contentPane.add(lblArtistesPresent);
		
		Artiste a = new Artiste();
		DefaultListModel<Artiste> model = new DefaultListModel<>();
		model.addAll(a.listeArtistes());
		listeToutLesArtistes = new JList<>(model);
		listeToutLesArtistes.setBounds(226, 28, 103, 127);
		contentPane.add(listeToutLesArtistes);
		
		//ARTISTES CHOISIT
		JLabel lblChoixArtistes = new JLabel("Artistes choisi :");
		lblChoixArtistes.setHorizontalAlignment(SwingConstants.CENTER);
		lblChoixArtistes.setForeground(Color.WHITE);
		lblChoixArtistes.setBounds(454, 10, 116, 13);
		contentPane.add(lblChoixArtistes);
		
		DefaultListModel<Artiste> ArtistesSelectionner = new DefaultListModel<>();
		JList<Artiste> listeChoisit = new JList<>(ArtistesSelectionner);
		listeChoisit.setBounds(464, 30, 103, 123);
		contentPane.add(listeChoisit);
				
		
		
		//CHOSIR -->
		JButton btnChoisir = new JButton("Choisir >>");
		btnChoisir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if (!ArtistesSelectionner.contains(listeToutLesArtistes.getSelectedValue()))
					ArtistesSelectionner.addElement(listeToutLesArtistes.getSelectedValue());
			}
		});
		btnChoisir.setBounds(339, 58, 115, 21);
		contentPane.add(btnChoisir);	
		
		
		//RETIRER <--
		JButton btnRetirer = new JButton("<< Retirer");
		btnRetirer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArtistesSelectionner.removeElement(listeChoisit.getSelectedValue());
			}
		});
		btnRetirer.setBounds(339, 94, 115, 21);
		contentPane.add(btnRetirer);
		
		

		
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
			lblOr.setBounds(36, 262, 35, 13);
			contentPane.add(lblOr);
			Or = new JTextField();
			Or.setBounds(65, 259, 35, 19);
			contentPane.add(Or);
			Or.setColumns(10);
		
			
			JLabel lblDiamant = new JLabel("Diamant : ");
			lblDiamant.setForeground(Color.WHITE);
			lblDiamant.setBounds(10, 285, 68, 17);
			contentPane.add(lblDiamant);
			Diamant = new JTextField();
			Diamant.setBounds(65, 284, 35, 19);
			contentPane.add(Diamant);
			Diamant.setColumns(10);
		
			JLabel lblLibre = new JLabel("Libre :");
			lblLibre.setForeground(Color.WHITE);
			lblLibre.setBounds(10, 206, 45, 13);
			contentPane.add(lblLibre);
			Libre = new JTextField();
			Libre.setBounds(65, 203, 35, 19);
			contentPane.add(Libre);
			Libre.setColumns(10);
			
	//RADIO GROUP	
	ButtonGroup bgroup = new ButtonGroup();
	bgroup.add(RadioDebout);
	bgroup.add(RadioConcert);
	bgroup.add(RadioCirque);
	
	
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
	lblEuro3.setBounds(110, 262, 16, 13);
	contentPane.add(lblEuro3);
	
	JLabel lblEuro4 = new JLabel("\u20AC");
	lblEuro4.setVisible(false);
	lblEuro4.setForeground(Color.WHITE);
	lblEuro4.setBounds(110, 287, 16, 13);
	contentPane.add(lblEuro4);
	

	//NOMBRE DE PLACES
	JLabel lblNbrPlace = new JLabel("Nombre de places :");
	lblNbrPlace.setForeground(Color.WHITE);
	lblNbrPlace.setBounds(208, 175, 121, 13);
	contentPane.add(lblNbrPlace);
	
	
	JLabel lblBronze_1 = new JLabel("Bronze : ");
	lblBronze_1.setForeground(Color.WHITE);
	lblBronze_1.setBounds(224, 206, 60, 13);
	contentPane.add(lblBronze_1);
	Bronze2 = new JTextField();
	Bronze2.setColumns(10);
	Bronze2.setBounds(294, 203, 35, 19);
	contentPane.add(Bronze2);
	
	JLabel lblArgent_1 = new JLabel("Argent  : ");
	lblArgent_1.setForeground(Color.WHITE);
	lblArgent_1.setBounds(224, 235, 60, 13);
	contentPane.add(lblArgent_1);
	Argent2 = new JTextField();
	Argent2.setColumns(10);
	Argent2.setBounds(294, 232, 35, 19);
	contentPane.add(Argent2);
	
	JLabel lblOr_1 = new JLabel("Or : ");
	lblOr_1.setForeground(Color.WHITE);
	lblOr_1.setBounds(249, 262, 35, 13);
	contentPane.add(lblOr_1);
	Or2 = new JTextField();
	Or2.setColumns(10);
	Or2.setBounds(294, 259, 35, 19);
	contentPane.add(Or2);
	
	JLabel lblDiamant_1 = new JLabel("Diamant : ");
	lblDiamant_1.setForeground(Color.WHITE);
	lblDiamant_1.setBounds(216, 285, 68, 17);
	contentPane.add(lblDiamant_1);
	Diamant2 = new JTextField();
	Diamant2.setColumns(10);
	Diamant2.setBounds(294, 284, 35, 19);
	contentPane.add(Diamant2);
	
	JLabel lblLibre_1 = new JLabel("Libre :");
	lblLibre_1.setForeground(Color.WHITE);
	lblLibre_1.setBounds(226, 206, 45, 13);
	contentPane.add(lblLibre_1);
	Libre2 = new JTextField();
	Libre2.setColumns(10);
	Libre2.setBounds(294, 203, 35, 19);
	contentPane.add(Libre2);
	
	textField = new JTextField();
	textField.setColumns(10);
	textField.setBounds(294, 203, 35, 19);
	contentPane.add(textField);
	
	
	//CONFIGURATION CHOISIE
	RadioDebout.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == RadioDebout) {
				lblBronze.setVisible(false);
				Bronze.setVisible(false);
				lblBronze_1.setVisible(false);
				Bronze2.setVisible(false);
				lblArgent.setVisible(false);
				Argent.setVisible(false);
				lblArgent_1.setVisible(false);
				Argent2.setVisible(false);
				lblOr.setVisible(false);
				Or.setVisible(false);
				lblOr_1.setVisible(false);
				Or2.setVisible(false);
				lblDiamant.setVisible(false);
				Diamant.setVisible(false);
				lblDiamant_1.setVisible(false);
				Diamant2.setVisible(false);
				lblEuro1.setVisible(true);
				lblEuro2.setVisible(false);
				lblEuro3.setVisible(false);
				lblEuro4.setVisible(false);
				lblLibre.setVisible(true);
				Libre.setVisible(true);
				lblLibre_1.setVisible(true);
				Libre2.setVisible(true);
				
			}
		}
	});
	
	RadioConcert.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == RadioConcert) {
				lblEuro4.setVisible(false);
				lblLibre.setVisible(false);
				Libre.setVisible(false);
				lblLibre_1.setVisible(false);
				Libre2.setVisible(false);
				lblDiamant.setVisible(false);
				Diamant.setVisible(false);
				lblDiamant_1.setVisible(false);
				Diamant2.setVisible(false);
				lblBronze.setVisible(true);
				Bronze.setVisible(true);
				lblBronze_1.setVisible(true);
				Bronze2.setVisible(true);
				lblArgent.setVisible(true);
				Argent.setVisible(true);
				lblArgent_1.setVisible(true);
				Argent2.setVisible(true);
				lblOr.setVisible(true);
				Or.setVisible(true);
				lblOr_1.setVisible(true);
				Or2.setVisible(true);
				lblEuro1.setVisible(true);
				lblEuro2.setVisible(true);
				lblEuro3.setVisible(true);
			}
		}
	});
	
	RadioCirque.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == RadioCirque) {
				lblLibre.setVisible(false);
				Libre.setVisible(false);
				lblLibre_1.setVisible(false);
				Libre2.setVisible(false);
				lblBronze.setVisible(true);
				Bronze.setVisible(true);
				lblBronze_1.setVisible(true);
				Bronze2.setVisible(true);
				lblArgent.setVisible(true);
				Argent.setVisible(true);
				lblArgent_1.setVisible(true);
				Argent2.setVisible(true);
				lblOr.setVisible(true);
				Or.setVisible(true);
				lblOr_1.setVisible(true);
				Or2.setVisible(true);
				lblDiamant.setVisible(true);
				Diamant.setVisible(true);
				lblDiamant_1.setVisible(true);
				Diamant2.setVisible(true);
				lblEuro1.setVisible(true);
				lblEuro2.setVisible(true);
				lblEuro3.setVisible(true);
				lblEuro4.setVisible(true);
			}	
		}
	});
	
	//VALIDER
	JButton btnValider = new JButton("VALIDER");
	btnValider.setBounds(502, 331, 127, 51);
	contentPane.add(btnValider);
	btnValider.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showMessageDialog(null, "Spectacle Ajouter 'A MODIFIER' !");
			}
		});
	}
}
