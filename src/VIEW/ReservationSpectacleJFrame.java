package VIEW;


import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JCalendar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Component;

import com.toedter.calendar.JDateChooser;

import POJO.*;


public class ReservationSpectacleJFrame extends JFrame {
	private static final long serialVersionUID = -3316631793028294179L;
	private JPanel contentPane;
	Date dateDebut = null;
	Date dateeFin = null;
	String strDateDebut, strDateFin, goodDateDebut, goodDateFin;
	Date VraiDateDebut;
	Date VraiDateFin;
	Date correctDateDebut;
	Date correctDateFin;
	PlanningSalle ps = new PlanningSalle();
	boolean valeur ;
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
	public ReservationSpectacleJFrame(Personne personne) {
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
		
		//LABEL DATES DISPO
		JLabel lblDisponibilite = new JLabel("Dates disponibles pour louer la salle :");
		lblDisponibilite.setForeground(Color.WHITE);
		lblDisponibilite.setHorizontalAlignment(SwingConstants.CENTER);
		lblDisponibilite.setBounds(0, 25, 251, 13);
		contentPane.add(lblDisponibilite);
		
		//OBTENIR UN FORMAT DATE CORRECT
		DateFormat dateFormatLong2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		//CALENDRIER
		JCalendar calendar = new JCalendar();
		calendar.getDayChooser().getDayPanel().setForeground(Color.BLACK);
		calendar.setBounds(20, 48, 206, 152);
		contentPane.add(calendar);
		
		//ICI LE BAIL
		System.out.println("Bail en ligne 93 RESERVATIONSPECTACLEJFRAME");
		Component[] tab = calendar.getDayChooser().getDayPanel().getComponents();
		tab[7].setEnabled(false);
		
		
		//DATE DE DEBUT
		JDateChooser dateDeb = new JDateChooser();
		dateDeb.setBounds(298, 45, 116, 19);
		contentPane.add(dateDeb);
		JLabel lblDateDebut = new JLabel("Date de d\u00E9but :");
		lblDateDebut.setForeground(Color.WHITE);
		lblDateDebut.setBounds(298, 25, 126, 13);
		contentPane.add(lblDateDebut);
		
		//DATE DE FIN
		JLabel lblDateFin = new JLabel("Date de fin :");
		lblDateFin.setForeground(Color.WHITE);
		lblDateFin.setBounds(298, 96, 83, 13);
		contentPane.add(lblDateFin);
		JDateChooser dateFin = new JDateChooser();
		dateFin.setBounds(298, 119, 116, 19);
		contentPane.add(dateFin);
		
		//VALIDATION
		JButton BtnValider = new JButton("Valider");
		BtnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//RECUPERATION
				dateDebut = dateDeb.getDate();
				dateeFin  = dateFin.getDate();
				
				//OBTENIR UN FORMAT DATE CORRECT
				DateFormat dateFormatLong = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				goodDateDebut = ps.obtenirEnFormatCorrect(dateDebut);
				goodDateFin = ps.obtenirEnFormatCorrect(dateeFin);
				
				//PARSE EN DATE
				try {
						VraiDateDebut = dateFormatLong.parse(goodDateDebut);
						VraiDateFin = dateFormatLong.parse(goodDateFin);
						long heureDeb = VraiDateDebut.getTime();
						long heureFin = VraiDateFin.getTime();
						correctDateDebut = new java.sql.Date (heureDeb);
					    correctDateFin = new java.sql.Date (heureFin);		
				} catch (ParseException e1) {
					e1.printStackTrace();
				}				
				
				//CREE UN CONSTRUCTEUR AVEC LES DATES CHOISIES
				ps = new PlanningSalle((java.sql.Date)correctDateDebut,(java.sql.Date)correctDateFin);
				valeur = ps.verify();
				
				//REGARDE SI LA SALLE EST DEJA LOUER
				if (valeur == true) {
					ps.ajouterPlanning();
					ps = ps.finfByDate();
					
					//FRAME SUIVANTE
					PayementGestionnaireJFrame g = new PayementGestionnaireJFrame(ps, personne);
					g.setVisible(true);	
				}
				else {
						JOptionPane.showMessageDialog(null, "Réservation annulée! La salle est déjà loué à cette date là.");
				}
			}
		});
		BtnValider.setBounds(329, 209, 85, 21);
		contentPane.add(BtnValider);
	}
}
