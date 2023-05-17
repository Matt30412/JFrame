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
import java.awt.Desktop.Action;
import java.text.*;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.*;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JButton;


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
		
		
		JLabel lblNewLabel_4 = new JLabel("    Inserie directory  file (opzionale)");
		lblNewLabel_4.setBounds(33, 133, 200, 14);
		getContentPane().add(lblNewLabel_4);
		
		JTextArea textblob = new JTextArea();
		textblob.setBounds(43, 156, 160, 27);
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
			public <BufferReader> void actionPerformed1(ActionEvent e) throws IOException {
				
					String votoskill = textVotoSkill.getText();
					String competenze = textArea.getText();
					String dataInizio = textdatI.getText();
					String dataFine = textdataF.getText();
					String Email = textEmail.getText();
					String Blob = textblob.getText();
					
					 try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/SM", "root", "")) {
						
						 
//						InputStream is = new FileInputStream("data.txt");
//						Reader rdr = new InputStreamReader(is, StandardCharsets.ISO_8859_1);
						
						
						 
						 
						 int  voto = Integer.parseInt(votoskill);
						 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
						 Date dataI = dateFormat.parse(dataInizio);
						 Date dataF = dateFormat.parse(dataFine);
						
						 
						 
//						 String pdfFile1 = textblob.getText();
//						 File pdfFile = new File("path/to/pdf/file.pdf");
						
//						 FileInputStream inputStream = new FileInputStream(pdfFile);
						 //Ti fai inserire il nome file
						 

						
						    
						 
							java.sql.Date sqlDate = new java.sql.Date(dataI.getTime());
							java.sql.Date sqlDate1 = new java.sql.Date(dataF.getTime());
							String repository = textblob.getText();
						    FileInputStream is = new FileInputStream( repository );
						    Reader rdr = new InputStreamReader(is, StandardCharsets.ISO_8859_1);	
						
						    
						    
					BufferedReader br = new BufferedReader(new FileReader(Blob));	    
						    
					String line = null;
			        while ((line = br.readLine()) != null)
			        {
			            String tmp[] = line.split(",");
			          competenze = tmp[0];
			          

			            System.out.println(competenze + "\t");
			            
			            
			            String sql = "INSET INTO competenze (competenze) VALUE('"+competenze+"');";	
						Statement stmt = connection.createStatement();
						stmt.executeUpdate(sql);
			           
			        }
					 
						
						
					
						    
						    
					String sql = "INSET INTO competenze (Competenze, Email, dataInizio, dataFine, votoskill, CompetenzeMB) VALUE('"+competenze+"','"+Email+"','"+sqlDate+"','"+sqlDate1+"', '"+voto+"', ?);";	
					Statement s = connection.createStatement();
					s.executeUpdate(sql);
						 
					 } catch (SQLException | ParseException e1) {
					        System.out.println("Errore durante l'accesso al database: " + e1.getMessage());
					    } catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						
					 
					 comp.setVisible(false);
					 comp = new Coompetenze();
				
				
			
					
				
				
				
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		buttonC.setBounds(114, 224, 158, 27);
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
		buttonInsert.setBounds(278, 224, 127, 27);
		getContentPane().add(buttonInsert);
		
		JLabel lblNewLabel_51 = new JLabel("Voto Skill: ");
		lblNewLabel_51.setBounds(165, 21, 86, 14);
		getContentPane().add(lblNewLabel_51);
		
		textVotoSkill = new JTextField();
		textVotoSkill.setBounds(147, 48, 86, 27);
		getContentPane().add(textVotoSkill);
		textVotoSkill.setColumns(10);
		
		JButton btnHomePage = new JButton("Home Page");
		btnHomePage.setBounds(0, 224, 108, 27);
		getContentPane().add(btnHomePage);
		
		btnHomePage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MainFrame frame = new MainFrame();
				frame.show();
				
			}
		
		
	});
	}}

