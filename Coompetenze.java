import java.awt.EventQueue;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Coompetenze extends JFrame {
	private JTextField textdatI;
	private JTextField textdataF;
	private JTextField textEmail;
	static Coompetenze comp;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Coompetenze frame = new Coompetenze();
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
	public Coompetenze() {
		getContentPane().setForeground(new Color(0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Competenze : ");
		lblNewLabel.setBounds(106, 21, 86, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Data Inizio: ");
		lblNewLabel_1.setBounds(318, 46, 66, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Data Fine : ");
		lblNewLabel_2.setBounds(319, 102, 76, 14);
		getContentPane().add(lblNewLabel_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(31, 46, 237, 172);
		getContentPane().add(textArea);
		
		textdatI = new JTextField();
		textdatI.setBounds(309, 71, 86, 20);
		getContentPane().add(textdatI);
		textdatI.setColumns(10);
		
		textdataF = new JTextField();
		textdataF.setColumns(10);
		textdataF.setBounds(309, 127, 86, 20);
		getContentPane().add(textdataF);
		
		textEmail = new JTextField();
		textEmail.setBounds(309, 183, 86, 20);
		getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel(" Email : ");
		lblNewLabel_3.setBounds(318, 158, 66, 14);
		getContentPane().add(lblNewLabel_3);
		
		Button buttonC = new Button("Inserisci altre competenze");
		buttonC.setForeground(new Color(255, 255, 255));
		buttonC.setBackground(new Color(255, 0, 0));
		buttonC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
					String competenze = textArea.getText();
					String dataInizio = textdatI.getText();
					String dataFine = textdataF.getText();
					String Email = textEmail.getText();
					
					
					 try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/SM", "root", "")) {
						 
						 SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
						 Date dataI = dateFormat.parse(dataInizio);
						 Date dataF = dateFormat.parse(dataFine);
					String sql = "INSET INTO Competenze (Competenze, Email, dataInizio, dataFine) VALUE('"+competenze+"','"+Email+"','"+dataI+"','"+dataF+"');";	
					
						 
					 } catch (SQLException | ParseException e1) {
					        System.out.println("Errore durante l'accesso al database: " + e1.getMessage());
					    }
						 
					 
				MainFrame frame = new MainFrame();
				frame.show();
				comp.setVisible(false);
				
				
				
			}
		});
		buttonC.setBounds(60, 224, 158, 27);
		getContentPane().add(buttonC);
		
		Button buttonInsert = new Button("Inserisci Competenze");
		buttonInsert.setForeground(new Color(255, 255, 255));
		buttonInsert.setBackground(new Color(255, 0, 0));
		buttonInsert.addActionListener(new ActionListener() {
			
	
			public void actionPerformed(ActionEvent e) {
				String competenze = textArea.getText();
				String dataInizio = textdatI.getText();
				String dataFine = textdataF.getText();
				String Email = textEmail.getText();
				
				
				 try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/SM", "root", "")) {
					 
					 SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
					 Date dataI = dateFormat.parse(dataInizio);
					 Date dataF = dateFormat.parse(dataFine);
				String sql = "INSET INTO Competenze (Competenze, Email, dataInizio, dataFine) VALUE('"+competenze+"','"+Email+"','"+dataI+"','"+dataF+"');";	
				
					 
				 } catch (SQLException | ParseException e1) {
				        System.out.println("Errore durante l'accesso al database: " + e1.getMessage());
				    }
					 
				 
			}
		});
		buttonInsert.setBounds(238, 224, 127, 27);
		getContentPane().add(buttonInsert);
	}
}
