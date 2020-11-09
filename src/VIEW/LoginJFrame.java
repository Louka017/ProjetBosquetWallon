package VIEW;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginJFrame extends JFrame {


	AcceuilJFrame acceuil = new AcceuilJFrame();
	InscriptionJFrame register = new InscriptionJFrame();
	
	private JPanel contentPane;
	private JTextField Email;
	private JTextField Mdp;

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
	public LoginJFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//EMAIL
		JLabel MotEmail = new JLabel("Email :");
		MotEmail.setHorizontalAlignment(SwingConstants.CENTER);
		MotEmail.setBounds(139, 63, 159, 13);
		contentPane.add(MotEmail);
		
		
		Email = new JTextField();
		Email.setToolTipText("");
		Email.setBounds(139, 97, 159, 19);
		contentPane.add(Email);
		Email.setColumns(10);
		
		
		//MOT DE PASSE
		JLabel MotMdp = new JLabel("Mot de passe :");
		MotMdp.setHorizontalAlignment(SwingConstants.CENTER);
		MotMdp.setBounds(139, 146, 159, 13);
		contentPane.add(MotMdp);
		
		
		Mdp = new JTextField();
		Mdp.setBounds(139, 176, 159, 19);
		contentPane.add(Mdp);
		Mdp.setColumns(10);
		
		
		//CONNEXION
		JButton btnConnexion = new JButton("Se connecter");
		btnConnexion.setBounds(153, 220, 128, 21);
		contentPane.add(btnConnexion);
		btnConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(Email.getText().equals("louka")) {
					if(Mdp.getText().equals("louna")) {
						
						acceuil.setVisible(true);	
					}else {
					acceuil.setVisible(false);
					}
				}else {
				acceuil.setVisible(false);
				}
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnConnexion);
		
		//INSCRIPTION
		JButton btnInscription = new JButton("S'inscrire");
		btnInscription.setBounds(315, 20, 111, 21);
		contentPane.add(btnInscription);
		btnInscription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					register.setVisible(true);
					
			}
		});
	
	}
}
