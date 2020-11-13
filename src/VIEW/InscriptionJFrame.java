package VIEW;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import POJO.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
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
	private JTextField Rue;
	private JTextField Numero;
	private JTextField CodePostal;
	private JTextField Ville;
	

	
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
		Nom.setBounds(54, 21, 111, 19);
		contentPane.add(Nom);
		Nom.setColumns(10);
		
		//PRENOM
		JLabel lblPrenom = new JLabel("Pr\u00E9nom : ");
		lblPrenom.setBounds(248, 24, 73, 13);
		contentPane.add(lblPrenom);
		
		Prenom = new JTextField();
		Prenom.setBounds(315, 21, 111, 19);
		contentPane.add(Prenom);
		Prenom.setColumns(10);
		
		//EMAIL
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(10, 67, 45, 13);
		contentPane.add(lblEmail);
		
		Email = new JTextField();
		Email.setBounds(54, 64, 153, 19);
		contentPane.add(Email);
		Email.setColumns(10);
		
		//MOT DE PASSE
		JLabel lblMdp = new JLabel("Mot de passe :");
		lblMdp.setBounds(217, 67, 96, 13);
		contentPane.add(lblMdp);
		
		Mdp = new JTextField();
		Mdp.setBounds(315, 64, 111, 19);
		contentPane.add(Mdp);
		Mdp.setColumns(10);
		
		//RUE
		JLabel lblRue = new JLabel("Rue : ");
		lblRue.setBounds(10, 101, 66, 13);
		contentPane.add(lblRue);
		
		Rue = new JTextField();
		Rue.setBounds(54, 98, 111, 19);
		contentPane.add(Rue);
		Rue.setColumns(10);
		
		//NUMERO
		JLabel lblNumero = new JLabel("n\u00B0 : ");
		lblNumero.setBounds(281, 140, 40, 13);
		contentPane.add(lblNumero);
		
		Numero = new JTextField();
		Numero.setBounds(313, 137, 45, 19);
		contentPane.add(Numero);
		Numero.setColumns(10);
		
		//CODE POSTAL
		JLabel lblCp = new JLabel("Code Postal : ");
		lblCp.setBounds(224, 101, 89, 13);
		contentPane.add(lblCp);
		
		CodePostal = new JTextField();
		CodePostal.setBounds(315, 98, 111, 19);
		contentPane.add(CodePostal);
		CodePostal.setColumns(10);
		
		//VILLE
		JLabel lblVille = new JLabel("Ville :");
		lblVille.setBounds(10, 140, 45, 13);
		contentPane.add(lblVille);
		
		Ville = new JTextField();
		Ville.setBounds(54, 137, 111, 19);
		contentPane.add(Ville);
		Ville.setColumns(10);
		
		//CHOIX
		JLabel lblChoix = new JLabel("Vous \u00EAtes :");
		lblChoix.setBounds(10, 184, 66, 13);
		contentPane.add(lblChoix);
		
			//CLIENT
			JRadioButton rdbtnClient = new JRadioButton("Client");
			rdbtnClient.setSelected(true);
			rdbtnClient.setBounds(89, 180, 103, 21);
			contentPane.add(rdbtnClient);
			
			//ORGANISATEUR
			JRadioButton rdbtnOrganisateur = new JRadioButton("Organisateur");
			rdbtnOrganisateur.setBounds(89, 203, 103, 21);
			contentPane.add(rdbtnOrganisateur);
			
			//ARTISTE
			JRadioButton rdbtnArtiste = new JRadioButton("Artiste");
			rdbtnArtiste.setBounds(89, 226, 103, 21);
			contentPane.add(rdbtnArtiste);
			
			
		ButtonGroup bgroup = new ButtonGroup();
		bgroup.add(rdbtnClient);
		bgroup.add(rdbtnOrganisateur);
		bgroup.add(rdbtnArtiste);

			
		//BOUTTON INSCRIPTION
		JButton btnInscription = new JButton("S'inscrire");
		btnInscription.setBounds(237, 203, 164, 31);
		contentPane.add(btnInscription);
		

		
		
		
		btnInscription.addActionListener(new ActionListener() 
		{

			public void actionPerformed(ActionEvent e)
			{		
				
				if(rdbtnClient.isSelected())
				{
					Client c = new Client(Nom.getText(),Prenom.getText(),Rue.getText(),Integer.parseInt(Numero.getText()),Ville.getText(),Integer.parseInt(CodePostal.getText()),Email.getText(),Mdp.getText());
					if(c.verifierChamps(Nom.getText(),Prenom.getText(),Rue.getText(),Integer.parseInt(Numero.getText()),Ville.getText(),Integer.parseInt(CodePostal.getText()),Email.getText(),Mdp.getText())) 
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
					Organisateur o = new Organisateur(Nom.getText(),Prenom.getText(),Rue.getText(),Integer.parseInt(Numero.getText()),Ville.getText(),Integer.parseInt(CodePostal.getText()),Email.getText(),Mdp.getText());
					if(o.verifierChamps(Nom.getText(),Prenom.getText(),Rue.getText(),Integer.parseInt(Numero.getText()),Ville.getText(),Integer.parseInt(CodePostal.getText()),Email.getText(),Mdp.getText())) 
					{	
						o.ajoutOrganisateur();
						JOptionPane.showMessageDialog(null, "Organisateur creer");
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "Erreur. L'organisateur n'a pas été créer ! ");
					}
				}
				
				if(rdbtnArtiste.isSelected())
				{
					Artiste a = new Artiste(Nom.getText(),Prenom.getText(),Rue.getText(),Integer.parseInt(Numero.getText()),Ville.getText(),Integer.parseInt(CodePostal.getText()),Email.getText(),Mdp.getText());
					if(a.verifierChamps(Nom.getText(),Prenom.getText(),Rue.getText(),Integer.parseInt(Numero.getText()),Ville.getText(),Integer.parseInt(CodePostal.getText()),Email.getText(),Mdp.getText())) 
					{	
						a.ajoutArtiste();
						JOptionPane.showMessageDialog(null, "Artiste creer");
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "Erreur. L'artiste n'a pas été créer ! ");
					}
				}
			}
		});	
	}
}
