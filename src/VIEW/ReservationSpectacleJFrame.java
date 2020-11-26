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
import javax.swing.SwingConstants;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;

import POJO.Personne;
import POJO.PlanningSalle;

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
		JLabel lblDisponibilite = new JLabel("Voir les dates disponibles pour louer la salle :");
		lblDisponibilite.setForeground(Color.WHITE);
		lblDisponibilite.setHorizontalAlignment(SwingConstants.CENTER);
		lblDisponibilite.setBounds(23, 25, 179, 13);
		contentPane.add(lblDisponibilite);
		
		//CALENDRIER
		JCalendar calendar = new JCalendar();
		calendar.getDayChooser().getDayPanel().setForeground(Color.BLACK);
		calendar.setBounds(20, 48, 206, 152);
		contentPane.add(calendar);
		
		/*
		 *
		 * 
		 * Afficher les dates déjà réservées.
		 * 
		 * 
		 */
		
		
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
				
				//FORMAT DATE
				DateFormat dateFormatLong = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				
				//CHANGEMENT DATE EN STRING
				strDateDebut = dateFormatLong.format(dateDebut);
				strDateFin = dateFormatLong.format(dateeFin);
				
				//SEPARER LA DATE ET L'HEURE
				String[] splitArray = null;
				String[] splitArray2 = null;
				splitArray = strDateDebut.split(" ");
				splitArray2 = strDateFin.split(" ");
				
				for(int i = 0; i< splitArray.length;i++){
					   //RECUPERE JUSTE LA DATE
						goodDateDebut = splitArray[0];
				}
				for(int i = 0; i< splitArray2.length;i++){
					   //RECUPERE JUSTE LA DATE
						goodDateFin = splitArray2[0];
				}
				
				//MODIFICATION POUR QUE HEURE = 12h00
				goodDateDebut = goodDateDebut + " 12:00:00";
				goodDateFin = goodDateFin + " 12:00:00";
				
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
				PlanningSalle s = new PlanningSalle((java.sql.Date)correctDateDebut,(java.sql.Date)correctDateFin);
				s.ajouterPlanning();
				PlanningSalle planningsalle = s.finfByDate(VraiDateDebut,VraiDateFin);
				PayementGestionnaireJFrame g = new PayementGestionnaireJFrame(planningsalle, personne);
				g.setVisible(true);	
			}
		});
		BtnValider.setBounds(329, 209, 85, 21);
		contentPane.add(BtnValider);
	}
}
