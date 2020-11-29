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

import POJO.Categorie;
import POJO.Configuration;
import POJO.Personne;
import POJO.Representation;
import POJO.Spectacle;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;

public class ClientReservationSpectacleJFrame extends JFrame {

	private static final long serialVersionUID = -5778600096352586056L;
	private JPanel contentPane;
	Configuration conf = new Configuration();
	Categorie cat = new Categorie();
	private JList<Representation> listRepresentations;
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
	public ClientReservationSpectacleJFrame(Personne p, Spectacle s) {
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
		
		//TITRE
		JLabel lblTitre = new JLabel("titre");
		lblTitre.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitre.setForeground(Color.WHITE);
		lblTitre.setBounds(0, 21, 446, 49);
		lblTitre.setText(s.getTitre());
		contentPane.add(lblTitre);
		
		Representation r = new Representation();
		DefaultListModel<Representation> model = new DefaultListModel<>();
		model.addAll(r.listeRepresentations(s.getId()));
		listRepresentations = new JList<>(model);
		listRepresentations.setBounds(23, 115, 191, 138);
		contentPane.add(listRepresentations);

		//LABELS
		JLabel lblDate = new JLabel("Date");
		lblDate.setForeground(Color.LIGHT_GRAY);
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setBounds(34, 92, 45, 13);
		contentPane.add(lblDate);
		
		JLabel lblHeureD = new JLabel("Debut");
		lblHeureD.setForeground(Color.LIGHT_GRAY);
		lblHeureD.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeureD.setBounds(95, 92, 45, 13);
		contentPane.add(lblHeureD);
		
		JLabel lblHeureF = new JLabel("Fin");
		lblHeureF.setForeground(Color.LIGHT_GRAY);
		lblHeureF.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeureF.setBounds(160, 92, 45, 13);
		contentPane.add(lblHeureF);
		
		//BOUTTON VALIDER		
		JButton btnValider = new JButton("R\u00E9server");
		btnValider.setBounds(299, 128, 127, 21);
		contentPane.add(btnValider);
		btnValider.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				conf = conf.find(s);
				cat  = cat.findByConfiguration(conf);
				if(cat.getNbrPlaceDispo() < 1) {
					JOptionPane.showMessageDialog(null, "Désolé, toutes les places ont été vendues");
				}
				else {
					Representation rChoisie = listRepresentations.getSelectedValue();
					ClientPlaceJFrame c = new ClientPlaceJFrame(rChoisie, p, s);
					c.setVisible(true);
				}
			}
		});
	}
}
