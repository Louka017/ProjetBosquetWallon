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
import POJO.Representation;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class ClientPlaceJFrame extends JFrame {

	private static final long serialVersionUID = -3379129441310621571L;
	private JPanel contentPane;
	private JTextField textField;
	private JButton btnValider;
	private JLabel lblChoix;
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
	public ClientPlaceJFrame(Representation r, Personne s) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 903, 364);
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
		lblNewLabel.setBounds(10, 24, 126, 13);
		contentPane.add(lblNewLabel);
		textField = new JTextField();
		textField.setBounds(144, 21, 40, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		//CHOIX
		lblChoix = new JLabel("Choix :");
		lblChoix.setForeground(Color.WHITE);
		lblChoix.setHorizontalAlignment(SwingConstants.RIGHT);
		lblChoix.setBounds(702, 24, 45, 13);
		contentPane.add(lblChoix);
		
			rdbtnLibre = new JRadioButton("Libre");
			rdbtnLibre.setBounds(765, 20, 103, 21);
			contentPane.add(rdbtnLibre);
		
			rdbtnBronze = new JRadioButton("Bronze");
			rdbtnBronze.setBounds(765, 43, 103, 21);
			contentPane.add(rdbtnBronze);
		
			rdbtnArgent = new JRadioButton("Argent");
			rdbtnArgent.setBounds(765, 66, 103, 21);
			contentPane.add(rdbtnArgent);
		
			rdbtnOr = new JRadioButton("Or");
			rdbtnOr.setBounds(765, 89, 103, 21);
			contentPane.add(rdbtnOr);
			
			rdbtnDiamant = new JRadioButton("Diamant");
			rdbtnDiamant.setBounds(765, 112, 103, 21);
			contentPane.add(rdbtnDiamant);
		
		//OBTENIR LES PLACES
		lblObtenirPlace = new JLabel("Moyen d'obtenir les places :");
		lblObtenirPlace.setForeground(Color.WHITE);
		lblObtenirPlace.setBounds(10, 93, 166, 13);
		contentPane.add(lblObtenirPlace);
		
			rdbtnNewRadioButton_5 = new JRadioButton("Prendre sur place le jour J");
			rdbtnNewRadioButton_5.setForeground(Color.BLACK);
			rdbtnNewRadioButton_5.setBounds(182, 89, 335, 21);
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
			rdbtnNewRadioButton_8.setBounds(146, 239, 103, 21);
			contentPane.add(rdbtnNewRadioButton_8);
			
			rdbtnNewRadioButton_9 = new JRadioButton("Paypal");
			rdbtnNewRadioButton_9.setBounds(146, 262, 103, 24);
			contentPane.add(rdbtnNewRadioButton_9);
			
			rdbtnNewRadioButton_10 = new JRadioButton("Virement SEPA (\u00E0 effectuer dans les 7 jours)");
			rdbtnNewRadioButton_10.setBounds(146, 288, 241, 21);
			contentPane.add(rdbtnNewRadioButton_10);
		
		//BOUTTON VALIDER
		btnValider = new JButton("Payer");
		btnValider.setBounds(702, 241, 166, 66);
		contentPane.add(btnValider);
		btnValider.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				AcceuilJFrame c = new AcceuilJFrame(s);
				c.setVisible(true);
			}
		});

	}

}
