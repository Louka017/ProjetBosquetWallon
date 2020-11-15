package VIEW;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.ArtisteDAO;
import POJO.*;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JList;
import javax.swing.JButton;

public class AcceuilJFrame extends JFrame {

	//Attributs
	private static final long serialVersionUID = -983079349898984600L;
	private JPanel contentPane;
	public Artiste mm;
	CreationSpectacleJFrame test = new CreationSpectacleJFrame();
	
	
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
	public AcceuilJFrame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
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
		
			//ACCEUIL
			JMenu mnNewMenu = new JMenu("Acceuil");
			menuBar.add(mnNewMenu);
			
			//RESERVATION SPECTACLE
			JMenu mnNewMenu_1 = new JMenu("R\u00E9servation de spectacle");
			menuBar.add(mnNewMenu_1);
		
		//JLISTE	
	    Artiste mm = new Artiste();
	    List<Artiste> n = mm.TESTONS();
		JList WESH = new JList<>(n.toArray());
		WESH.setBounds(21, 63, 113, 123);
		contentPane.add(WESH);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(203, 92, 85, 21);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				test.setVisible(true);
			}
		});

		
		
	}
}
