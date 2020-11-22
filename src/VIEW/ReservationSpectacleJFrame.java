package VIEW;


import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JCalendar;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;

import POJO.PlanningSalle;

public class ReservationSpectacleJFrame extends JFrame {

	private static final long serialVersionUID = -3316631793028294179L;
	private JPanel contentPane;
	Date dateDebut = null;
	Date dateeFin = null;


	
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
	public ReservationSpectacleJFrame() {
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
				dateDebut = new java.sql.Date (dateDeb.getDate().getTime());
				dateeFin = new java.sql.Date (dateFin.getDate().getTime());
				
				
				
				PlanningSalle s = new PlanningSalle(dateDebut,(java.sql.Date)dateeFin);
				s.ajouterPlanning();
				System.out.println("reservation : ok");
				CreationSpectacleJFrame CreSpec = new CreationSpectacleJFrame(s);
				CreSpec.setVisible(true);		
			}
		});
		BtnValider.setBounds(329, 209, 85, 21);
		contentPane.add(BtnValider);
	}
}
