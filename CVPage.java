import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.w3c.dom.Text;
import java.sql.*;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class CVPage extends JFrame {

	static CVPage cv;
	
	private JPanel contentPane;
	private JTextField textEMAIL;
	private JTextField textINSERT;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CVPage frame = new CVPage();
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
	public CVPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textEMAIL = new JTextField();
		textEMAIL.setBounds(153, 11, 212, 20);
		textEMAIL.setHorizontalAlignment(SwingConstants.LEFT);
		textEMAIL.setBackground(new Color(255, 255, 255));
		contentPane.add(textEMAIL);
		textEMAIL.setColumns(10);
		
		textINSERT = new JTextField();
		textINSERT.setText("Inserisci Email : ");
		textINSERT.setBounds(10, 11, 109, 20);
		contentPane.add(textINSERT);
		textINSERT.setColumns(10);
		

		JTextArea TextCV = new JTextArea();
		TextCV.setBounds(10, 99, 401, 140);
		contentPane.add(TextCV);
		
		JButton btnNewButton = new JButton("RICERCA \n CV");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String EMAIL = textEMAIL.getText();
				
				try{Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/SM", "root", "");
				
				StringBuilder sb = new StringBuilder();
				String sql = "SELECT  C.Competenze as Competenze1, C.DataI AS DataInizio, C.DataF AS DataFine, U.CV as Competenze, U.DataI AS DataInizio, U.DataF AS DataFIne FROM competenze C, utente U         ON C.Email = U.Email      WHERE C.Email = ?  ";
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setString(1, EMAIL);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
				   
					String ccompetenze = rs.getString("C.Competenze");
					String ucompetenze = rs.getString("U.CV");
					String cdataI = rs.getString("C.DataI");
				    String cdataF = rs.getString("C.DataF");
				    String dataI = rs.getString("U.DataI");
				    String dataF = rs.getString("U.DataF");
				    
				    
				    
				    sb.append(ccompetenze).append(" - ").append(ucompetenze).append(dataI).append(" - ").append(dataF).append(cdataI).append(" - ").append(cdataF).append('\n');
				                   }

				String competenzeConcatenate = sb.toString();

			    TextCV.setText(competenzeConcatenate); // impostazione della stringa come contenuto del campo di testo
				 
				 
				 
				 

//StringBuilder sb = new StringBuilder();
//while (rs.next()) {
//    String competenze = rs.getString("C.Competenze");
//    String DataInizio = rs.getString("U.DataI");
//    String DataFine = rs.getString("U.DataF");
//    sb.append(competenze).append(", ").append(DataInizio).append(", ").append(DataFine); // concatenazione della competenza e della virgola come separatore
//}
//
//String competenzeConcatenate = sb.toString();
//
//TextCV.setText(competenzeConcatenate); // impostazione della stringa come contenuto del campo di testo
//				 
//				 
//				 
				 
				 
				 
//				 StringBuilder sb = new StringBuilder(); 
//				 while(rs.next()) {
//					 
//					 String Competenze = rs.getString("Competenze");
//					 sb.append(Competenze).append('\n');
//					 
//				 }
//				 
//				 String competenze = sb.toString();
//				 TextCV.setText(competenze);
//						 
				 
				 
				 
				 
				 
				
				}catch (SQLException e1) {
			        System.out.println("Errore durante l'accesso al database: " + e1.getMessage());
			    }
				
			
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(20, 35, 354, 53);
		contentPane.add(btnNewButton);
		
	}
}
