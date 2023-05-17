import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.Font;






public class MainFrame extends JFrame {
	
	  private static final String DB_URL = "jdbc:mysql://localhost:3306/SM";
	    private static final String DB_USER = "root";
	    private static final String DB_PASSWORD = "";
	
	private JPanel contentPane;
	private JTextField textUser;
	private JTextField textPass;
	 static MainFrame frame;
	
	
	
	Connection connection = null;
	Statement st = null;
	ResultSet set = null;
	protected JLabel lblAccesso;
	private JTextField texVerifica;
	
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new MainFrame();
					frame.setResizable(true);
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
	public MainFrame() {
		setTitle("Welcome");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setAutoscrolls(true);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username : ");
		lblNewLabel.setBounds(63, 54, 81, 14);
		contentPane.add(lblNewLabel);
		
		textUser = new JTextField();
		textUser.setBounds(178, 51, 184, 20);
		contentPane.add(textUser);
		textUser.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password : ");
		lblNewLabel_1.setBounds(63, 85, 81, 14);
		contentPane.add(lblNewLabel_1);
		
		textPass = new JTextField();
		textPass.setBounds(178, 82, 184, 20);
		contentPane.add(textPass);
		textPass.setColumns(10);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Codice Verifica : ");
		lblNewLabel_2.setBounds(63, 110, 105, 14);
		contentPane.add(lblNewLabel_2);
		
		texVerifica = new JTextField();
		texVerifica.setBounds(178, 107, 66, 20);
		contentPane.add(texVerifica);
		texVerifica.setColumns(10);
		
		
		
		
		
		
		
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
			
			String email = textUser.getText();
			String password = textPass.getText();
			String controllo = texVerifica.getText();
			
			
			
			
			
			
			  try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/SM", "root", "")) {
			
				  
				 int Controllo = Integer.parseInt(controllo);
				 
				 
				 if (Controllo == 456) {
			        String sql= "SELECT Email, Password FROM utente WHERE Email = ? AND PASSWORD = ?  AND Controllo = 456";
			        PreparedStatement stmt1 = connection.prepareStatement(sql);    
			        stmt1.setString(1, email);
			        stmt1.setString(2, password);
			        ResultSet rs = stmt1.executeQuery();
				 
				 
			        Secondario  FinestraDatabase = new Secondario();
		        	FinestraDatabase.show();
		        	frame.setVisible(false);
		        	
			        
			        
				 						}else {
				 					Coompetenze comp = new Coompetenze();
				 					comp.show();
				 					frame.setVisible(false);
				 					
				 						}	

                  {
					
				String sql1 = "SELECT Email, CV FROM utente WHERE Email = ? AND PASSWORD = ? ";	 
				PreparedStatement stmt2 = connection.prepareStatement(sql1);
				ResultSet rs1 = stmt2.executeQuery();
				
				
				
				// altra INSERT per inserire la variabile accesso a 1, così da far capire a chi accede che edeve prendere solo chi ha la variabile di accesso a 1, ovvero chi ha fatto l'accesso
				
				  Secondario  FinestraDatabase = new Secondario();
		        	FinestraDatabase.show();
		        	frame.setVisible(false);

                 }


			  
			  
			  } catch (SQLException e1) {
			        System.out.println("Errore durante l'accesso al database: " + e1.getMessage());
			    }
			
			
			
		
			
			}
			
			
			
		
//			
//					}
//					
//			}
			

			
			
		});
		btnLogin.setBounds(88, 147, 89, 23);
		contentPane.add(btnLogin);
		
		JButton btnSIngUp = new JButton("Sing Up");
		btnSIngUp.setBounds(187, 147, 89, 23);
		contentPane.add(btnSIngUp);
		btnSIngUp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			SingUpa Singup = new SingUpa();
			Singup.show();
			frame.setVisible(false);
				
				
			}
			
			
			
			
		});
		
		
		
		
		
	}
}



