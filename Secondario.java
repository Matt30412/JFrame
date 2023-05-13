import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.List;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTextArea;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.JButton;

public class Secondario extends JFrame {

	
	
	static Secondario DataBase;
	
	private JPanel contentPane;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Secondario frame = new Secondario();
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
	public Secondario() throws SQLException {
		setTitle("Database");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textEmail = new JTextArea();
		textEmail.setBounds(10, 28, 414, 184);
		contentPane.add(textEmail);
		
		txtEmail = new JTextField();
		txtEmail.setText("              User");
		txtEmail.setColumns(10);
		txtEmail.setBounds(146, 0, 113, 20);
		contentPane.add(txtEmail);
		
		
		
		
		
		
	 try{Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/SM", "root", "");
	
	 
	 String queryEmail = "SELECT Email FROM utente";
	 PreparedStatement stmt = connection.prepareStatement(queryEmail);   
	 ResultSet rs = stmt.executeQuery();

	 StringBuilder sb = new StringBuilder(); // StringBuilder per concatenare tutti gli indirizzi email

	 while (rs.next()) {
	     String email = rs.getString("Email");
	     sb.append(email).append('\n'); // concatenazione dell'email e di un separatore spazio
	 }

	 String emails = sb.toString(); // conversione del StringBuilder in una stringa

	 textEmail.setText(emails); // impostazione della stringa come contenuto del campo di testo
	 
	 JButton btnRTN = new JButton(" CV page");
	 btnRTN.setBounds(118, 223, 203, 34);
	 contentPane.add(btnRTN);
	  btnRTN.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			MainFrame Login = new MainFrame();
			Login.show();
		
				MainFrame frame = new MainFrame();
//				frame.show();
				DataBase.setVisible(false);
				
			}
				
			
	  });
			
	  

	}   catch (SQLException e1) {
        System.out.println("Errore durante l'accesso al database: " + e1.getMessage());
    }

	 try {Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/SM", "root", "");
		
	
 	
		
		
	
	
	
	}catch (SQLException e2) {
		        System.out.println("Errore durante l'accesso al database: " + e2.getMessage());
		    }
		
	}
	
}
