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

import POJO.Personne;
import POJO.PlanningSalle;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class PayementGestionnaireJFrame extends JFrame {

	private JPanel contentPane;

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
	public PayementGestionnaireJFrame(PlanningSalle s, Personne p) {
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
		
		//MONTANT
		JLabel lblMontant = new JLabel("Prix de location : ");
		lblMontant.setForeground(Color.LIGHT_GRAY);
		lblMontant.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblMontant.setHorizontalAlignment(SwingConstants.CENTER);
		lblMontant.setBounds(0, 0, 436, 55);
		contentPane.add(lblMontant);
		JLabel lblPrix = new JLabel("New label");
		lblPrix.setForeground(Color.WHITE);
		lblPrix.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrix.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPrix.setBounds(105, 90, 205, 40);
		contentPane.add(lblPrix);

		if(s.getDateDebutSal().getDay() == 5 || s.getDateDebutSal().getDay() == 6) {
			lblPrix.setText("4 500 €");
		}
		else {
			lblPrix.setText("3 000 €");
		}

			
		
		//VALIDER
		JButton btnValider = new JButton("PAYER");
		btnValider.setBounds(151, 188, 120, 40);
		contentPane.add(btnValider);
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreationSpectacleJFrame CreSpec = new CreationSpectacleJFrame(s, p);
				CreSpec.setVisible(true);	
			}
		});
		
		
	}
}
