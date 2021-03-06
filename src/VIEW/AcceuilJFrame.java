package VIEW;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import POJO.*;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Color;

public class AcceuilJFrame extends JFrame {

	//Attributs
	private static final long serialVersionUID = -983079349898984600L;
	private JPanel contentPane;
	JMenuBar menuBar;
	JMenu mnNewMenu;
	private JList<Spectacle> listeTousLesSpec;
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
	 * 
	 * Create the frame.
	 */
	public AcceuilJFrame(Personne p) {
		setResizable(false);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 355);
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

		//MENU BAR
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu mnNewMenu = new JMenu("Que voulez-vous faire ?");
		menuBar.add(mnNewMenu);
			
		//Liste des spectacles
		JLabel lblLstSpectacles = new JLabel("Liste des spectacles :");
		lblLstSpectacles.setForeground(Color.WHITE);
		lblLstSpectacles.setBounds(54, 10, 123, 13);
		contentPane.add(lblLstSpectacles);
	    Spectacle spec = new Spectacle();
		DefaultListModel<Spectacle> model = new DefaultListModel<>();
		model.addAll(spec.listeSpectacles());
		listeTousLesSpec = new JList<>(model);
		listeTousLesSpec.setBounds(21, 33, 166, 262);
		contentPane.add(listeTousLesSpec);
		
		//DETAIL
		JButton btnDetail = new JButton("D\u00E9tail");
		btnDetail.setForeground(Color.RED);
		btnDetail.setBackground(Color.DARK_GRAY);
		btnDetail.setBounds(270, 144, 85, 21);
		contentPane.add(btnDetail);

		//BOUTON AJOUTER REPRESENTATION
		JButton btnRepresentation = new JButton("Ajouter une representation");
		btnRepresentation.setForeground(Color.RED);
		btnRepresentation.setBackground(Color.DARK_GRAY);
		btnRepresentation.setBounds(214, 63, 206, 28);
		btnRepresentation.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{				
				Spectacle s = listeTousLesSpec.getSelectedValue();
				int idSalle = s.trouveidSalle();	
				PlanningSalle ps = new PlanningSalle(idSalle);
				ps = ps.find(idSalle);
				Representation2JFrame Rep = new Representation2JFrame(s, ps, p);
				Rep.setVisible(true);
			}
		});

		//BOUTTON ORGANISER SPECTACLE
		JButton btnOrganiserSpectacle = new JButton("Organiser un spectacle");
		btnOrganiserSpectacle.setForeground(Color.RED);
		btnOrganiserSpectacle.setBackground(Color.DARK_GRAY);
		btnOrganiserSpectacle.setBounds(214, 25, 206, 28);
		btnOrganiserSpectacle.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				ReservationSpectacleJFrame ResSpec = new ReservationSpectacleJFrame(p);
				ResSpec.setVisible(true);
			}
		});
		
		//BOUTTON RESERVER UN SPECTACLE
		JButton btnReservationSpectacle = new JButton("Rerserver spectacle");
		btnReservationSpectacle.setForeground(Color.RED);
		btnReservationSpectacle.setBackground(Color.DARK_GRAY);
		btnReservationSpectacle.setBounds(214, 101, 206, 28);
		contentPane.add(btnReservationSpectacle);
		btnReservationSpectacle.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				Spectacle s = listeTousLesSpec.getSelectedValue();
				ClientReservationSpectacleJFrame CRes = new ClientReservationSpectacleJFrame(p,s);
				CRes.setVisible(true);
			}
		});
		
		
		//BOUTTON GESTIONNAIRE
		JButton btnGestionnaire = new JButton("Voir les plannings");
		btnGestionnaire.setForeground(Color.RED);
		btnGestionnaire.setBackground(Color.DARK_GRAY);
		btnGestionnaire.setBounds(214, 175, 206, 28);
		btnGestionnaire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Personne pp = p.findbyMail();
				GestionnaireJFrame frame = new GestionnaireJFrame(pp);
				frame.setVisible(true);
			}
		});
		
		
		
		
		//ORGANISATEUR
		if(p.getDiscriminator().equals("Organisateur")) {
			contentPane.add(btnRepresentation);
			contentPane.add(btnOrganiserSpectacle);
		}
		//GESTIONNAIRE
		if(p.getDiscriminator().equals("Gestionnaire")) {
		contentPane.add(btnGestionnaire);
		contentPane.add(btnRepresentation);
		contentPane.add(btnOrganiserSpectacle);
		}
	}	
}
