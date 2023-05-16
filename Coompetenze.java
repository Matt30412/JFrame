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
import java.text.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class Coompetenze extends JFrame {
	private JTextField textdatI;
	private JTextField textdataF;
	private JTextField textEmail;
	static Coompetenze comp;
	private JTextField textVotoSkill;
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
		lblNewLabel.setBounds(33, 21, 86, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Data Inizio: ");
		lblNewLabel_1.setBounds(329, 21, 66, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Data Fine : ");
		lblNewLabel_2.setBounds(319, 68, 76, 14);
		getContentPane().add(lblNewLabel_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(33, 46, 96, 27);
		getContentPane().add(textArea);
		
		textdatI = new JTextField();
		textdatI.setBounds(319, 37, 86, 20);
		getContentPane().add(textdatI);
		textdatI.setColumns(10);
		
		textdataF = new JTextField();
		textdataF.setColumns(10);
		textdataF.setBounds(319, 99, 86, 20);
		getContentPane().add(textdataF);
		
		textEmail = new JTextField();
		textEmail.setBounds(319, 158, 86, 20);
		getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel(" Email : ");
		lblNewLabel_3.setBounds(319, 133, 66, 14);
		getContentPane().add(lblNewLabel_3);
		
		
		JLabel lblNewLabel_4 = new JLabel("    Inserie file (opzionale)");
		lblNewLabel_4.setBounds(50, 133, 168, 14);
		getContentPane().add(lblNewLabel_4);
		
		JTextArea textblob = new JTextArea();
		textblob.setBounds(60, 153, 133, 45);
		getContentPane().add(textblob);
		
		JLabel lblNewLabel_5 = new JLabel("Voto Skill: ");
		lblNewLabel_5.setBounds(165, 21, 86, 14);
		getContentPane().add(lblNewLabel_5);
		
		textVotoSkill = new JTextField();
		textVotoSkill.setBounds(147, 48, 86, 27);
		getContentPane().add(textVotoSkill);
		textVotoSkill.setColumns(10);
		
		
		
		
		Button buttonC = new Button("Inserisci altre competenze");
		buttonC.setForeground(new Color(0, 0, 0));
		buttonC.setBackground(new Color(255, 255, 255));
		buttonC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					String votoskill = textVotoSkill.getText();
					String competenze = textArea.getText();
					String dataInizio = textdatI.getText();
					String dataFine = textdataF.getText();
					String Email = textEmail.getText();
					String Blob = textblob.getText();
					
					 try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/SM", "root", "")) {
						
						 
						 
						 
						 
						 int  voto = Integer.parseInt(votoskill);
						 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
						 Date dataI = dateFormat.parse(dataInizio);
						 Date dataF = dateFormat.parse(dataFine);
						
						 
						 
						 String pdfFile1 = textblob.getText();
						 File pdfFile = new File("path/to/pdf/file.pdf");
						
//						 FileInputStream inputStream = new FileInputStream(pdfFile);
						 //Ti fai inserire il nome file
						 

						
						    
						 
							java.sql.Date sqlDate = new java.sql.Date(dataI.getTime());
							java.sql.Date sqlDate1 = new java.sql.Date(dataF.getTime());
							String repository = textblob.getText();
						    FileInputStream is = new FileInputStream( repository );
						    Reader rdr = new InputStreamReader(is, StandardCharsets.ISO_8859_1);	
						    
					String sql = "INSET INTO competenze (Competenze, Email, dataInizio, dataFine, votoskill, CompetenzeMB) VALUE('"+competenze+"','"+Email+"','"+sqlDate+"','"+sqlDate1+"', '"+voto+"', '"+pdfFile+"', ?);";	
					Statement stmt2 = connection.createStatement();
					stmt2.executeUpdate(sql);
						 
					 } catch (SQLException | ParseException e1) {
					        System.out.println("Errore durante l'accesso al database: " + e1.getMessage());
					    } catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						 
					 comp.setVisible(false);
					 comp = new Coompetenze();
				
				
			
				
				
				
				
			}
		});
		buttonC.setBounds(60, 224, 158, 27);
		getContentPane().add(buttonC);
		
		Button buttonInsert = new Button("Inserisci Competenze");
		buttonInsert.setForeground(new Color(0, 0, 0));
		buttonInsert.setBackground(new Color(255, 255, 255));
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
				String sql1 = "INSET INTO Competenze (Competenze, Email, dataInizio, dataFine) VALUE('"+competenze+"','"+Email+"','"+dataI+"','"+dataF+"');";	
				Statement stmt3 = connection.createStatement();
				stmt3.executeUpdate(sql1);
					 
				 } catch (SQLException | ParseException e1) {
				        System.out.println("Errore durante l'accesso al database: " + e1.getMessage());
				    }
					 
					MainFrame frame = new MainFrame();
					frame.show();
					comp.setVisible(false);
					
			}
		});
		buttonInsert.setBounds(238, 224, 127, 27);
		getContentPane().add(buttonInsert);
		
		JLabel lblNewLabel_51 = new JLabel("Voto Skill: ");
		lblNewLabel_51.setBounds(165, 21, 86, 14);
		getContentPane().add(lblNewLabel_51);
		
		textVotoSkill = new JTextField();
		textVotoSkill.setBounds(147, 48, 86, 27);
		getContentPane().add(textVotoSkill);
		textVotoSkill.setColumns(10);
		
		
	}
}
