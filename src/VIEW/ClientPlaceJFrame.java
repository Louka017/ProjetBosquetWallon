package VIEW;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import POJO.Artiste;
import POJO.Categorie;
import POJO.Commande;
import POJO.Configuration;
import POJO.Personne;
import POJO.Place;
import POJO.Representation;
import POJO.Spectacle;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class ClientPlaceJFrame extends JFrame {

	private static final long serialVersionUID = -3379129441310621571L;
	private JPanel contentPane;
	private JButton btnValider;
	private JRadioButton rdbtnLibre;
	private JRadioButton rdbtnBronze;
	private JRadioButton rdbtnArgent;
	private JRadioButton rdbtnOr;
	private JRadioButton rdbtnDiamant;
	private JLabel lblObtenirPlace;
	private JRadioButton rdbtnNewRadioButton_5;
	private JRadioButton rdbtnNewRadioButton_6;
	private JRadioButton rdbtnNewRadioButton_7;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JRadioButton rdbtnNewRadioButton_8;
	private JRadioButton rdbtnNewRadioButton_9;
	private JRadioButton rdbtnNewRadioButton_10;
	private Configuration conf = new Configuration();
	private Categorie cat = new Categorie();
	private List<Categorie> cats= new ArrayList<>();
	private JTextField Libre;
	private JTextField Bronze;
	private JTextField Argent;
	private JTextField Or;
	private JTextField Diamant;
	private JLabel lblPrix;
	private JLabel lblPrix_1;
	private JLabel lblPrix_2;
	private JLabel lblPrix_3;
	private JLabel lblPrix_4;
	private JLabel lblVraiprix;
	private JLabel lblVraiprix_1;
	private JLabel lblVraiprix_2;
	private JLabel lblVraiprix_3;
	private JLabel lblVraiprix_4;
	private int prixLibre, prixBronze, prixArgent, prixOr, prixDiamant;
	private String strprixLibre, strprixBronze, strprixArgent, strprixOr, strprixDiamant;
	private int nbrLibreInt, nbrBronzeInt, nbrArgentInt, nbrOrInt, nbrDiamantInt;
	private int goodprixBronze=0, goodprixArgent=1,goodprixOr=2, goodprixDiamant=3;
	private int goodprixLibre=0, cpt=0;
	private JLabel lblEuro;
	private JLabel lblEuro_1;
	private JLabel lblEuro_2;
	private JLabel lblEuro_3;
	private JLabel lblEuro_4;
	String type ="";
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
	@SuppressWarnings("unchecked")
	public ClientPlaceJFrame(Representation r, Personne p, Spectacle s) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1012, 370);
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
		
		//NOMBRES DE PLACES
		JLabel lblNewLabel = new JLabel("Nombres de places : ");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(568, 25, 126, 13);
		contentPane.add(lblNewLabel);
		
		//LABEL PRIX
		lblPrix = new JLabel("Prix :");
		lblPrix.setForeground(Color.WHITE);
		lblPrix.setBackground(Color.WHITE);
		lblPrix.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrix.setBounds(852, 24, 45, 13);
		
		lblPrix_1 = new JLabel("Prix :");
		lblPrix_1.setForeground(Color.WHITE);
		lblPrix_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrix_1.setBounds(852, 53, 45, 13);
		
		lblPrix_2 = new JLabel("Prix :");
		lblPrix_2.setForeground(Color.WHITE);
		lblPrix_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrix_2.setBounds(852, 82, 45, 13);
		
		lblPrix_3 = new JLabel("Prix :");
		lblPrix_3.setForeground(Color.WHITE);
		lblPrix_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrix_3.setBounds(852, 111, 45, 13);
		
		lblPrix_4 = new JLabel("Prix :");
		lblPrix_4.setForeground(Color.WHITE);
		lblPrix_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrix_4.setBounds(852, 142, 45, 13);
		
		//SIGLE EURO
		lblEuro = new JLabel("\u20AC");
		lblEuro.setForeground(Color.WHITE);
		lblEuro.setHorizontalAlignment(SwingConstants.CENTER);
		lblEuro.setBounds(943, 24, 45, 13);

		
		lblEuro_1 = new JLabel("\u20AC");
		lblEuro_1.setForeground(Color.WHITE);
		lblEuro_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblEuro_1.setBounds(943, 53, 45, 13);

		
		lblEuro_2 = new JLabel("\u20AC");
		lblEuro_2.setForeground(Color.WHITE);
		lblEuro_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblEuro_2.setBounds(943, 82, 45, 13);
		
		lblEuro_3 = new JLabel("\u20AC");
		lblEuro_3.setForeground(Color.WHITE);
		lblEuro_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblEuro_3.setBounds(943, 111, 45, 13);

		
		lblEuro_4 = new JLabel("\u20AC");
		lblEuro_4.setForeground(Color.WHITE);
		lblEuro_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblEuro_4.setBounds(943, 142, 45, 13);
		
		//VRAI PRIX
		lblVraiprix = new JLabel("lol");
		lblVraiprix.setForeground(Color.WHITE);
		lblVraiprix.setHorizontalAlignment(SwingConstants.CENTER);
		lblVraiprix.setBounds(907, 24, 35, 13);
		
		lblVraiprix_1 = new JLabel("lol");
		lblVraiprix_1.setForeground(Color.WHITE);
		lblVraiprix_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblVraiprix_1.setBounds(907, 53, 35, 13);
		
		lblVraiprix_2 = new JLabel("lol");
		lblVraiprix_2.setForeground(Color.WHITE);
		lblVraiprix_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblVraiprix_2.setBounds(907, 82, 35, 13);
		
		lblVraiprix_3 = new JLabel("lol");
		lblVraiprix_3.setForeground(Color.WHITE);
		lblVraiprix_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblVraiprix_3.setBounds(907, 111, 35, 13);
		
		lblVraiprix_4 = new JLabel("lol");
		lblVraiprix_4.setForeground(Color.WHITE);
		lblVraiprix_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblVraiprix_4.setBounds(907, 142, 35, 13);
		
			JLabel lblLibre = new JLabel("Libre :");
			lblLibre.setHorizontalAlignment(SwingConstants.RIGHT);
			lblLibre.setForeground(Color.WHITE);
			lblLibre.setBounds(747, 24, 45, 13);
			Libre = new JTextField();
			Libre.setColumns(10);
			Libre.setBounds(802, 21, 35, 19);

		
			JLabel lblBronze = new JLabel("Bronze : ");
			lblBronze.setHorizontalAlignment(SwingConstants.RIGHT);
			lblBronze.setForeground(Color.WHITE);
			lblBronze.setBounds(732, 53, 60, 13);
			Bronze = new JTextField();
			Bronze.setColumns(10);
			Bronze.setBounds(802, 50, 35, 19);
		
			JLabel lblArgent = new JLabel("Argent  : ");
			lblArgent.setHorizontalAlignment(SwingConstants.RIGHT);
			lblArgent.setForeground(Color.WHITE);
			lblArgent.setBounds(735, 82, 60, 13);
			Argent = new JTextField();
			Argent.setColumns(10);
			Argent.setBounds(802, 79, 35, 19);
		
			JLabel lblOr = new JLabel("Or : ");
			lblOr.setHorizontalAlignment(SwingConstants.RIGHT);
			lblOr.setForeground(Color.WHITE);
			lblOr.setBounds(757, 111, 35, 13);
			Or = new JTextField();
			Or.setColumns(10);
			Or.setBounds(802, 108, 35, 19);
		
			JLabel lblDiamant = new JLabel("Diamant : ");
			lblDiamant.setHorizontalAlignment(SwingConstants.RIGHT);
			lblDiamant.setForeground(Color.WHITE);
			lblDiamant.setBounds(724, 140, 68, 17);
			Diamant = new JTextField();
			Diamant.setColumns(10);
			Diamant.setBounds(802, 139, 35, 19);
		
		
		//VOIR LES CONFIGURATIONS
		conf = conf.find(s);
		cats = cat.findAllByConfiguration(conf);
		

		//AFFICHER PRIX
		if(cats.size() == 1) {
			for (Categorie i : cats) {
				strprixLibre = String.valueOf((i.getPrix()));
				strprixBronze = "0";
				strprixArgent = "0";
				strprixOr= "0";
			}
			
		}else if(cats.size() == 3) {
			for (Categorie i : cats) {
				if(goodprixBronze == cpt) {
					strprixBronze= String.valueOf((i.getPrix()));
					}
				if(goodprixArgent == cpt) {
					strprixArgent= String.valueOf((i.getPrix()));
				}
				if(goodprixOr == cpt) {
					strprixOr= String.valueOf((i.getPrix()));
				}
				strprixLibre="0";
				strprixDiamant="0";
				cpt++ ;
			}
		}else if(cats.size() == 4) {
			for (Categorie i : cats) {
				if(goodprixBronze == cpt) {
					strprixBronze= String.valueOf((i.getPrix()));
				}
				if(goodprixArgent == cpt) {
					strprixArgent= String.valueOf((i.getPrix()));
				}
				if(goodprixOr == cpt) {
					strprixOr= String.valueOf((i.getPrix()));
				}
				if(goodprixDiamant == cpt) {
					strprixDiamant= String.valueOf((i.getPrix()));
				}
				strprixLibre="0";
				cpt++ ;
			}
		}



		
		//AFFICHAGE DES CONFIGURATION
		 type = conf.getType();
		if(type.equals("Debout")) {
			contentPane.add(lblLibre);
			contentPane.add(Libre);
			contentPane.add(lblPrix);
			lblVraiprix.setText(strprixLibre);
			contentPane.add(lblVraiprix);
			contentPane.add(lblEuro);
			
		}
		else if (type.equals("Concert")) {
			contentPane.add(lblBronze);		
			contentPane.add(Bronze);
			contentPane.add(lblArgent);
			contentPane.add(Argent);
			contentPane.add(lblOr);
			contentPane.add(Or);
			contentPane.add(lblPrix_1);
			contentPane.add(lblPrix_2);
			contentPane.add(lblPrix_3);
			lblVraiprix_1.setText(strprixBronze);
			lblVraiprix_2.setText(strprixArgent);
			lblVraiprix_3.setText(strprixOr);
			contentPane.add(lblVraiprix_1);
			contentPane.add(lblVraiprix_2);
			contentPane.add(lblVraiprix_3);
			contentPane.add(lblEuro_1);
			contentPane.add(lblEuro_2);
			contentPane.add(lblEuro_3);
		}
		else{
			contentPane.add(lblBronze);		
			contentPane.add(Bronze);
			contentPane.add(lblArgent);
			contentPane.add(Argent);
			contentPane.add(lblOr);
			contentPane.add(Or);
			contentPane.add(lblDiamant);
			contentPane.add(Diamant);
			contentPane.add(lblPrix_1);
			contentPane.add(lblPrix_2);
			contentPane.add(lblPrix_3);
			contentPane.add(lblPrix_4);
			lblVraiprix_1.setText(strprixBronze);
			lblVraiprix_2.setText(strprixArgent);
			lblVraiprix_3.setText(strprixOr);
			lblVraiprix_4.setText(strprixDiamant);
			contentPane.add(lblVraiprix_1);
			contentPane.add(lblVraiprix_2);
			contentPane.add(lblVraiprix_3);
			contentPane.add(lblVraiprix_4);
			contentPane.add(lblEuro_1);
			contentPane.add(lblEuro_2);
			contentPane.add(lblEuro_3);
			contentPane.add(lblEuro_4);
		}

		
		
		//OBTENIR LES PLACES
		lblObtenirPlace = new JLabel("Moyen d'obtenir les places :");
		lblObtenirPlace.setForeground(Color.WHITE);
		lblObtenirPlace.setBounds(10, 93, 166, 13);
		contentPane.add(lblObtenirPlace);
		
			rdbtnNewRadioButton_5 = new JRadioButton("Prendre sur place le jour J");
			rdbtnNewRadioButton_5.setSelected(true);
			rdbtnNewRadioButton_5.setForeground(Color.BLACK);
			rdbtnNewRadioButton_5.setBounds(181, 89, 335, 21);
			contentPane.add(rdbtnNewRadioButton_5);
		
			rdbtnNewRadioButton_6 = new JRadioButton("Se faire livr\u00E9 \u00E0 domicile");
			rdbtnNewRadioButton_6.setBounds(182, 112, 368, 21);
			contentPane.add(rdbtnNewRadioButton_6);
			
			rdbtnNewRadioButton_7 = new JRadioButton("Se faire livr\u00E9 \u00E0 domicile de mani\u00E8re s\u00E9curis\u00E9e ( +10 \u20AC )");
			rdbtnNewRadioButton_7.setBounds(182, 136, 430, 21);
			contentPane.add(rdbtnNewRadioButton_7);
		
		//FRAIS DE DOSSIERS
		lblNewLabel_1 = new JLabel("+ 5 \u20AC de frais de dossier");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(21, 188, 144, 13);
		contentPane.add(lblNewLabel_1);
		
		//MODE DE PAYEMENT
		lblNewLabel_2 = new JLabel("Mode de payement : ");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(21, 243, 126, 13);
		contentPane.add(lblNewLabel_2);
		
			rdbtnNewRadioButton_8 = new JRadioButton("Visa");
			rdbtnNewRadioButton_8.setSelected(true);
			rdbtnNewRadioButton_8.setBounds(146, 239, 103, 21);
			contentPane.add(rdbtnNewRadioButton_8);
			
			rdbtnNewRadioButton_9 = new JRadioButton("Paypal");
			rdbtnNewRadioButton_9.setBounds(146, 262, 103, 24);
			contentPane.add(rdbtnNewRadioButton_9);
			
			rdbtnNewRadioButton_10 = new JRadioButton("Virement SEPA (\u00E0 effectuer dans les 7 jours)");
			rdbtnNewRadioButton_10.setBounds(146, 288, 241, 21);
			contentPane.add(rdbtnNewRadioButton_10);
		
			
		//RADIO GROUP	
		ButtonGroup bgroup = new ButtonGroup();
		bgroup.add(rdbtnNewRadioButton_5);
		bgroup.add(rdbtnNewRadioButton_6);
		bgroup.add(rdbtnNewRadioButton_7);
		
		ButtonGroup bgroup2 = new ButtonGroup();
		bgroup2.add(rdbtnNewRadioButton_8);
		bgroup2.add(rdbtnNewRadioButton_9);
		bgroup2.add(rdbtnNewRadioButton_10);
		
		//BOUTTON VALIDER
		btnValider = new JButton("Payer");
		btnValider.setBounds(802, 243, 166, 66);
		contentPane.add(btnValider);
		btnValider.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				
				//RECUPERATION
				if(Libre.getText().isEmpty()) 
					nbrLibreInt = 0;
				else 
					nbrLibreInt = Integer.parseInt(Libre.getText());
																			
				if(Bronze.getText().isEmpty())
					nbrBronzeInt = 0;									
				else
					nbrBronzeInt = Integer.parseInt(Bronze.getText());
																			
				if(Argent.getText().isEmpty())
					nbrArgentInt =0;
				else
					nbrArgentInt = Integer.parseInt(Argent.getText());
					
				if(Or.getText().isEmpty())
					nbrOrInt = 0;
				else
					nbrOrInt = Integer.parseInt(Or.getText());
					
				if(Diamant.getText().isEmpty())
					nbrDiamantInt = 0;
				else
					nbrDiamantInt = Integer.parseInt(Diamant.getText());
				
				//PRIX TOTAL
				System.out.println("prix bronze = " +strprixBronze);
				
				int cout = (nbrLibreInt*Integer.parseInt(strprixLibre)) +(nbrBronzeInt*Integer.parseInt(strprixBronze)) + (nbrArgentInt*Integer.parseInt(strprixArgent)) + (nbrOrInt*Integer.parseInt(strprixOr)) + (nbrDiamantInt*Integer.parseInt(strprixDiamant));
				
				
				//MOYEN D'OBTENIR LES PLACES
				String ModeLivraison = "";
				
				if(rdbtnNewRadioButton_5.isSelected()) {
					ModeLivraison = "Prendre sur place le jour J";
				}
				
				if(rdbtnNewRadioButton_6.isSelected()) {
					ModeLivraison = "Se faire livré à domicile";
				}
				
				if(rdbtnNewRadioButton_7.isSelected()) {
					ModeLivraison = "Se faire livré à domicile de maninière sécurisée";
				}
				
				//MODE DE PAYEMENT
				String ModePayement = "";
				
				if(rdbtnNewRadioButton_8.isSelected()) {
					ModePayement = "Visa";
				}
				
				if(rdbtnNewRadioButton_9.isSelected()) {
					ModePayement = "Paypal";
				}
				
				if(rdbtnNewRadioButton_10.isSelected()) {
					ModePayement = "Virement SEPA";
				}
				
				//COMMANDE
				Commande commande = new Commande(ModePayement,ModeLivraison, cout);
				//AJOUT DB
				commande.ajoutAvecPersonne(p);
				
				Commande comm = commande.findByAll(p);
				
				//PLACE
				for(int i=0; i<nbrLibreInt; i++ ) {
					Place place = new Place(Integer.parseInt(strprixLibre));
					place.ajout(r);
					Place goodplace = place.findByAll();
					goodplace.ajoutCommande(comm);
				}
				
				for(int i=0; i<nbrBronzeInt; i++ ) {
					Place place = new Place(Integer.parseInt(strprixBronze));
					place.ajout(r);
					Place goodplace = place.findByAll();
					goodplace.ajoutCommande(comm);
				}
				
				for(int i=0; i<nbrArgentInt; i++ ) {
					Place place = new Place(Integer.parseInt(strprixArgent));
					place.ajout(r);
					Place goodplace = place.findByAll();
					goodplace.ajoutCommande(comm);
				}
				
				for(int i=0; i<nbrOrInt; i++ ) {
					Place place = new Place(Integer.parseInt(strprixOr));
					place.ajout(r);
					Place goodplace = place.findByAll();
					goodplace.ajoutCommande(comm);
				}
				
				for(int i=0; i<nbrDiamantInt; i++ ) {
					Place place = new Place(Integer.parseInt(strprixDiamant));
					place.ajout(r);
					Place goodplace = place.findByAll();
					goodplace.ajoutCommande(comm);
				}
				
				
				
				AcceuilJFrame c = new AcceuilJFrame(p);
				c.setVisible(true);
			}
		});

	}
}
