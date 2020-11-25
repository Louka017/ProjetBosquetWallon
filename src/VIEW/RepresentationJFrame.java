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

import POJO.Personne;
import POJO.PlanningSalle;
import POJO.Representation;
import POJO.Spectacle;
import javax.swing.JRadioButton;

public class RepresentationJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField HeureDebut;
	private JTextField HeureFin;
	private JTextField MinDebut;
	private JTextField MinFin;
	Representation rp = new Representation();
	String strDateDebut, strHeureDebut, strDateFin, strHeureFin;

	
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
		btnValider.setBounds(274, 186, 85, 21);
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
		
		JLabel lblNewLabelDate = new JLabel("Date : ");
		lblNewLabelDate.setForeground(Color.WHITE);
		lblNewLabelDate.setBounds(36, 22, 45, 13);
		contentPane.add(lblNewLabelDate);
		
		//RECUPERATION PLANNING
		PlanningSalle pp = ps.find(ps.getId());
		
		//RADIO 1
		JRadioButton rdbtnNewRadioButtonJ1 = new JRadioButton("New radio button");
		rdbtnNewRadioButtonJ1.setSelected(true);
		rdbtnNewRadioButtonJ1.setBounds(101, 18, 103, 21);
			//CONVERSTION DE LA DATE EN STRING
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); 
			
        	String myDateDebut = dateFormat.format(pp.getDateDebutSal());  
        	rdbtnNewRadioButtonJ1.setText(myDateDebut);
		contentPane.add(rdbtnNewRadioButtonJ1);
		
		//RADIO 2
		JRadioButton rdbtnNewRadioButtonJ2 = new JRadioButton("New radio button");
		rdbtnNewRadioButtonJ2.setBounds(227, 18, 103, 21);
			//CONVERSTION DE LA DATE EN STRING
			String myDateFin = dateFormat.format(pp.getDateFinSal());  
			rdbtnNewRadioButtonJ2.setText(myDateFin);
		contentPane.add(rdbtnNewRadioButtonJ2);
		
		//RADIOGROUP
		ButtonGroup bgroup = new ButtonGroup();
		bgroup.add(rdbtnNewRadioButtonJ1);
		bgroup.add(rdbtnNewRadioButtonJ2);
		
		
		btnValider.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{	
				//RECUPERATION
				String h1 = HeureDebut.getText();
				String h2 = HeureFin.getText();
				String m1 = MinDebut.getText();
				String m2 = MinFin.getText();
				//TRANSFORME EN HEURE CORRECTE LA RECUPERATION
				String heuredeb = h1 + ":" + m1;
				String heurefin = h2 + ":" + m2;
				//RECUPERE LA DATE DU J.1 et J.2 DE LA LOCATION DE LA SALLE 
				Date db = (Date)pp.getDateDebutSal();
				Date df = (Date)pp.getDateFinSal();
				//FORMAT DE DATE
				DateFormat dateFormatCourt = new SimpleDateFormat("yyyy-MM-dd"); 
				DateFormat dateFormatLong = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				//AJOUTE L'HEURE DE LA REPRESENTATION au J
				if(rdbtnNewRadioButtonJ1.isSelected()){
					strDateDebut = dateFormatCourt.format(db);	
					strHeureDebut = strDateDebut +" "+ heuredeb+":00";
					strDateFin = dateFormatCourt.format(db);	
					strHeureFin = strDateDebut +" "+ heurefin+":00";
				}
				else if(rdbtnNewRadioButtonJ2.isSelected())
				{
					strDateDebut = dateFormatCourt.format(df);	
					strHeureDebut = strDateDebut +" "+ heuredeb+":00";
					strDateFin = dateFormatCourt.format(df);	
					strHeureFin = strDateDebut +" "+ heurefin+":00";
				}
				
				//TRANSFORME LE STRING EN DATE
				try {
					Date date =dateFormatLong.parse(strHeureDebut);
					Date date2= dateFormatLong.parse(strHeureFin);
					long heureDeb = date.getTime();
					long heureFin = date2.getTime();
					Date heuredb = new java.sql.Date (heureDeb);
					Date heurefn = new java.sql.Date (heureFin);
					//POJO
					if(rdbtnNewRadioButtonJ1.isSelected())
						rp = new Representation(db,(java.sql.Date) heuredb,(java.sql.Date)heurefn, s.getId());
					
					if(rdbtnNewRadioButtonJ2.isSelected())
						rp = new Representation(df,(java.sql.Date) heuredb,(java.sql.Date)heurefn, s.getId());
						
					rp.ajouterRps();	
				} catch (ParseException e2) {
				
					e2.printStackTrace();
				}
			
				JOptionPane.showMessageDialog(null, "Représentation creer");
				AcceuilJFrame frame = new AcceuilJFrame(p);
				frame.setVisible(true);
			}
		});
	}
}
