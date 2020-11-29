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

import POJO.Personne;
import POJO.PlanningSalle;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

import POJO.*;

public class PayementGestionnaireJFrame extends JFrame {

	private static final long serialVersionUID = -3108378940868530807L;
	private JPanel contentPane;
	Reservation reservation = new Reservation();

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
	@SuppressWarnings("deprecation")
	public PayementGestionnaireJFrame(PlanningSalle ps, Personne p) {
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
		
		JLabel lblEuro = new JLabel("\u20AC");
		lblEuro.setForeground(Color.WHITE);
		lblEuro.setHorizontalAlignment(SwingConstants.CENTER);
		lblEuro.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblEuro.setBounds(236, 91, 20, 40);
		contentPane.add(lblEuro);
		
		//MONTANT
		JLabel lblMontant = new JLabel("Prix de location : ");
		lblMontant.setForeground(Color.LIGHT_GRAY);
		lblMontant.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblMontant.setHorizontalAlignment(SwingConstants.CENTER);
		lblMontant.setBounds(0, 0, 436, 55);
		contentPane.add(lblMontant);
		JLabel lblPrix = new JLabel("New label");
		lblPrix.setForeground(Color.WHITE);
		lblPrix.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrix.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPrix.setBounds(26, 90, 205, 40);
		contentPane.add(lblPrix);

		//PAYE PLUS CHER SI DATE DEBUT EST VENDREDI ou SAMEDI
		reservation.setPlanningSale(ps);
		int nombreDeJoursEntreDBetDF = reservation.calculerDifferenceJour();
		reservation.calculPrix(nombreDeJoursEntreDBetDF);
		lblPrix.setText(String.valueOf(reservation.getPrix()));
		
		//VALIDER
		JButton btnValider = new JButton("PAYER");
		btnValider.setBounds(151, 188, 120, 40);
		contentPane.add(btnValider);
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//AJOUT DE LA RESERVATION DANS LA DB
				int prix = Integer.parseInt(lblPrix.getText());	
				Reservation res = new Reservation(prix, prix, "Payer", prix, ps);
				boolean ajout = p.ajouterReservation(res);
				if(ajout) {
					JOptionPane.showMessageDialog(null, "Payement valider");
					CreationSpectacleJFrame CreSpec = new CreationSpectacleJFrame(ps, p);
					CreSpec.setVisible(true);	
				}
				else{
					JOptionPane.showMessageDialog(null, "Erreur Réservation non effectuée.");
				}	
			}
		});
	}
}
