package VIEW;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class LoginJFrame extends JFrame {
	
	AcceuilJFrame acc = new AcceuilJFrame();
	InscriptionJFrame inscription = new InscriptionJFrame();
	
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
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(137, 39, 135, 13);
		contentPane.add(lblEmail);
		
		Email = new JTextField();
		Email.setBounds(137, 62, 135, 19);
		contentPane.add(Email);
		Email.setColumns(10);
		
		//MOT DE PASSE
		JLabel lblMdp = new JLabel("Mot de passe :");
		lblMdp.setBounds(137, 109, 135, 13);
		contentPane.add(lblMdp);
		
		Mdp = new JTextField();
		Mdp.setBounds(137, 132, 135, 19);
		contentPane.add(Mdp);
		Mdp.setColumns(10);
		
		//BOUTTON LOGIN
		JButton btnLogin = new JButton("Se connecter");
		btnLogin.setBounds(137, 197, 135, 35);
		contentPane.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				if(Email.getText().equals("a"))
				{
					if(Mdp.getText().equals("a"))
					{
						acc.setVisible(true);
						
					}
					else 
					{
						acc.setVisible(false);

					}
					
				}
				else
				{
					acc.setVisible(false);

				}
			}
		});
		
		//BOUTTON INSCRIPTION
		JButton btnInscription = new JButton("S'inscrire");
		btnInscription.setBounds(324, 10, 102, 21);
		contentPane.add(btnInscription);
		btnInscription.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				inscription.setVisible(true);
			}
		});
	}

}
