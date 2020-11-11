package VIEW;
import java.sql.Connection;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.AbstractDAOFactory;
import DAO.*;
import POJO.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class InscriptionJFrame extends JFrame {

 static final long serialVersionUID = 2538226678514688194L;
 
	//Attributs
	private JPanel contentPane;
	private JTextField Nom;
	private JTextField Prenom;
	private JTextField Email;
	private JTextField Mdp;
	private JTextField Adresse;
	

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InscriptionJFrame frame = new InscriptionJFrame();
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
	public InscriptionJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//NOM
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(10, 24, 45, 13);
		contentPane.add(lblNom);
		
		Nom = new JTextField();
		Nom.setBounds(75, 21, 111, 19);
		contentPane.add(Nom);
		Nom.setColumns(10);
		
		//PRENOM
		JLabel lblPrenom = new JLabel("Pr\u00E9nom : ");
		lblPrenom.setBounds(217, 24, 73, 13);
		contentPane.add(lblPrenom);
		
		Prenom = new JTextField();
		Prenom.setBounds(300, 21, 111, 19);
		contentPane.add(Prenom);
		Prenom.setColumns(10);
		
		//EMAIL
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(10, 67, 45, 13);
		contentPane.add(lblEmail);
		
		Email = new JTextField();
		Email.setBounds(75, 64, 111, 19);
		contentPane.add(Email);
		Email.setColumns(10);
		
		//MOT DE PASSE
		JLabel lblMdp = new JLabel("Mot de passe :");
		lblMdp.setBounds(202, 67, 96, 13);
		contentPane.add(lblMdp);
		
		Mdp = new JTextField();
		Mdp.setBounds(300, 64, 111, 19);
		contentPane.add(Mdp);
		Mdp.setColumns(10);
		
		//ADRESSE
		JLabel lblAdresse = new JLabel("Adresse : ");
		lblAdresse.setBounds(10, 101, 66, 13);
		contentPane.add(lblAdresse);
		
		Adresse = new JTextField();
		Adresse.setBounds(75, 98, 336, 19);
		contentPane.add(Adresse);
		Adresse.setColumns(10);
		
		//CHOIX
		JLabel lblChoix = new JLabel("Vous \u00EAtes :");
		lblChoix.setBounds(10, 139, 66, 13);
		contentPane.add(lblChoix);
		
			//CLIENT
			JRadioButton rdbtnClient = new JRadioButton("Client");
			rdbtnClient.setSelected(true);
			rdbtnClient.setBounds(89, 135, 103, 21);
			contentPane.add(rdbtnClient);
			
			//ORGANISATEUR
			JRadioButton rdbtnOrganisateur = new JRadioButton("Organisateur");
			rdbtnOrganisateur.setBounds(89, 158, 103, 21);
			contentPane.add(rdbtnOrganisateur);
			
			
		ButtonGroup bgroup = new ButtonGroup();
		bgroup.add(rdbtnClient);
		bgroup.add(rdbtnOrganisateur);

			
		//BOUTTON INSCRIPTION
		JButton btnInscription = new JButton("S'inscrire");
		btnInscription.setBounds(144, 200, 164, 31);
		contentPane.add(btnInscription);
		btnInscription.addActionListener(new ActionListener() 
		{
			//@SuppressWarnings("null")
			public void actionPerformed(ActionEvent e)
			{				
				if(rdbtnClient.isSelected())
				{
					Client c = new Client(Nom.getText(),Prenom.getText(),Adresse.getText(),Email.getText(),Mdp.getText());
					if(c.verifierChamps(Nom.getText(), Prenom.getText(),Adresse.getText(),Email.getText(),Mdp.getText())) 
					{	
						c.ajoutClient();
						JOptionPane.showMessageDialog(null, "Client creer");
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "Erreur. Le Client n'a pas été créer ! ");
					}
				}
				
				if(rdbtnOrganisateur.isSelected())
				{
					Organisateur o = new Organisateur(Nom.getText(),Prenom.getText(),Adresse.getText(),Email.getText(),Mdp.getText());
					if(o.verifierChamps(Nom.getText(), Prenom.getText(),Adresse.getText(),Email.getText(),Mdp.getText())) 
					{	
						o.ajoutOrganisateur();
						JOptionPane.showMessageDialog(null, "Organisateur creer");
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "Erreur. L'organisateur n'a pas été créer ! ");
					}
				}
			}
		});	
	}
}
