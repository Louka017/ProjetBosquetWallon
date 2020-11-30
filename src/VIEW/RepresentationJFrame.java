package VIEW;


import java.awt.Color;
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

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import POJO.Categorie;
import POJO.Personne;
import POJO.PlanningSalle;
import POJO.Representation;
import POJO.Spectacle;
import javax.swing.JRadioButton;
import com.toedter.calendar.JCalendar;

public class RepresentationJFrame extends JFrame {

	private static final long serialVersionUID = 3149333708461873234L;
	private JPanel contentPane;
	private JTextField HeureDebut;
	private JTextField HeureFin;
	private JTextField MinDebut;
	private JTextField MinFin;
	Representation rp = new Representation();
	String strDateDebut, strHeureDebut, strDateFin, strHeureFin;
	int error = 0;
	String goodDateDebut9 = null;
	Date VraiDateDebut = null;
	long heureDeb = 0;
	Date correctDateDebut = null;
	Date heuredb, heurefn,date,date2;
	
	
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
	public RepresentationJFrame(Spectacle s, PlanningSalle ps, Personne p) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 583, 294);
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
		
		//HEURE DEBUT
		JLabel lblHeureDebut = new JLabel("Heure de d\u00E9but :");
		lblHeureDebut.setForeground(Color.WHITE);
		lblHeureDebut.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeureDebut.setBounds(36, 69, 85, 13);
		contentPane.add(lblHeureDebut);
		HeureDebut = new JTextField();
		HeureDebut.setBounds(131, 66, 26, 19);
		contentPane.add(HeureDebut);
		HeureDebut.setColumns(10);
		MinDebut = new JTextField();
		MinDebut.setColumns(10);
		MinDebut.setBounds(187, 66, 26, 19);
		contentPane.add(MinDebut);
		
		//HEURE FIN
		JLabel lblHeureFin = new JLabel("Heure de fin :");
		lblHeureFin.setForeground(Color.WHITE);
		lblHeureFin.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeureFin.setBounds(36, 111, 85, 13);
		contentPane.add(lblHeureFin);
		HeureFin = new JTextField();
		HeureFin.setColumns(10);
		HeureFin.setBounds(131, 108, 26, 19);
		contentPane.add(HeureFin);
		MinFin = new JTextField();
		MinFin.setColumns(10);
		MinFin.setBounds(187, 108, 26, 19);
		contentPane.add(MinFin);
		
		//VALIDER
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(168, 216, 85, 21);
		contentPane.add(btnValider);
		
		//LABEL
		JLabel lblPoint = new JLabel("h");
		lblPoint.setForeground(Color.WHITE);
		lblPoint.setBackground(Color.BLACK);
		lblPoint.setBounds(167, 69, 19, 13);
		contentPane.add(lblPoint);
		JLabel lblPoint_1 = new JLabel("h");
		lblPoint_1.setForeground(Color.WHITE);
		lblPoint_1.setBounds(167, 111, 19, 13);
		contentPane.add(lblPoint_1);
		
		JLabel lblNewMin = new JLabel("min");
		lblNewMin.setForeground(Color.WHITE);
		lblNewMin.setBounds(227, 69, 45, 13);
		contentPane.add(lblNewMin);
		
		JLabel lblNewMin_1 = new JLabel("min");
		lblNewMin_1.setForeground(Color.WHITE);
		lblNewMin_1.setBounds(223, 111, 45, 13);
		contentPane.add(lblNewMin_1);
		
		//CALENDAR
		JCalendar calendar = new JCalendar();
		calendar.setBounds(325, 36, 206, 152);
		contentPane.add(calendar);		
		
		btnValider.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{	
				
				//FORMAT DE DATE
				DateFormat dateFormatCourt = new SimpleDateFormat("yyyy-MM-dd"); 
				DateFormat dateFormatLong = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

				//DATE CALENDAR
				Date daterecup = calendar.getDate();
				String strDateDebut2 = dateFormatCourt.format(daterecup);
				try {
						VraiDateDebut = dateFormatCourt.parse(strDateDebut2);
						heureDeb = VraiDateDebut.getTime();
						correctDateDebut = new java.sql.Date (heureDeb);	
				} catch (ParseException e1) {
					e1.printStackTrace();
				}	
				
				//VERIFICATION DE LA DATE
				rp.setDate(correctDateDebut);
				if(rp.verifyDateRepresentation(ps)) {
					//RECUPERATION HEURE
					String h1 = HeureDebut.getText();
					String h2 = HeureFin.getText();
					String m1 = MinDebut.getText();
					String m2 = MinFin.getText();
					//TRANSFORME EN HEURE CORRECTE LA RECUPERATION
					String heuredeb = h1 + ":" + m1;
					String heurefin = h2 + ":" + m2;
					//AJOUTE L'HEURE DE LA REPRESENTATION au J
					strDateDebut = dateFormatCourt.format(correctDateDebut);	
					strHeureDebut = strDateDebut +" "+ heuredeb+":00";
					strDateFin = dateFormatCourt.format(correctDateDebut);	
					strHeureFin = strDateDebut +" "+ heurefin+":00";
					//TRANSFORME LE STRING EN DATE
					try {
						error = 0;
						date =dateFormatLong.parse(strHeureDebut);
						date2= dateFormatLong.parse(strHeureFin);
						long heureDeb = date.getTime();
						long heureFin = date2.getTime();
						heuredb = new java.sql.Date (heureDeb);
						heurefn = new java.sql.Date (heureFin);
						
						if(date.getHours() > date2.getHours()) {
							error = 1;
							if(error == 0) {
								if(date.getMinutes() >= date2.getMinutes()) { 
									error = 1;
								}
							}
						}
						//POJO ET AJOUT DB
						if(error == 0) {
						rp = new Representation(correctDateDebut,(java.sql.Date) heuredb,(java.sql.Date)heurefn,s);
						rp.ajouterRps();
						rp = rp.findByDate();
						
						Categorie cat = new Categorie();
						cat.ajouterAvecReresentation(rp);
						
						
						}
					} 
					catch (ParseException e2) {
						e2.printStackTrace();
					}
				

					if(error == 0) {
					JOptionPane.showMessageDialog(null, "Représentation creer");
					AcceuilJFrame frame = new AcceuilJFrame(p);
					frame.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "Veuillez saisir une Heure de début inférieur à l'heure de fin");
					}
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Veuillez saisir un jour de votre planning de location");
				}
			}
		});
	}
}
