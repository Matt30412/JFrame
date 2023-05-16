import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
public class SingUpa extends JDialog {

	
	private final JPanel contentPanel = new JPanel();
	private JTextField textNome;
	private JTextField textCognome;
	private JTextField textEmail;
	private JTextField textPassword;
	private JTextField textCV;
	protected Connection connection;
    static SingUpa Singup; 
	private JTextField textSkill;
	private JTextField textCodice;
	private JTextField textDI;
	private JTextField textDF;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SingUpa dialog = new SingUpa();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SingUpa() {
		setTitle("Registrazione");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		textNome = new JTextField();
		textNome.setBounds(88, 11, 143, 20);
		contentPanel.add(textNome);
		textNome.setColumns(10);
		
		textCognome = new JTextField();
		textCognome.setBounds(88, 42, 143, 20);
		contentPanel.add(textCognome);
		textCognome.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setBounds(88, 73, 143, 20);
		contentPanel.add(textEmail);
		textEmail.setColumns(10);
		
		textPassword = new JTextField();
		textPassword.setBounds(88, 104, 143, 20);
		contentPanel.add(textPassword);
		textPassword.setColumns(10);
		
		textCV = new JTextField();
		textCV.setBounds(88, 172, 143, 53);
		contentPanel.add(textCV);
		textCV.setColumns(10);
		
		JLabel lbNome = new JLabel("Nome : ");
		lbNome.setBounds(10, 14, 46, 14);
		contentPanel.add(lbNome);
		
		
		
		JLabel lbPassword = new JLabel("Password : ");
		lbPassword.setBounds(10, 107, 92, 14);
		contentPanel.add(lbPassword);
		
		JLabel lbCV = new JLabel("CV");
		lbCV.setBounds(10, 191, 46, 14);
		contentPanel.add(lbCV);
		
		JLabel lbCognome = new JLabel("Cognome : ");
		lbCognome.setBounds(10, 45, 78, 14);
		contentPanel.add(lbCognome);
		
		JLabel lbEmail = new JLabel("Email : ");
		lbEmail.setBounds(10, 76, 46, 14);
		contentPanel.add(lbEmail);
		
		JLabel lbskill = new JLabel("Voto Skill : ");
		lbskill.setBounds(10, 144, 78, 16);
		contentPanel.add(lbskill);
		
		textSkill = new JTextField();
		textSkill.setBounds(86, 140, 145, 20);
		contentPanel.add(textSkill);
		textSkill.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Codice  : ");
		lblNewLabel.setBounds(268, 13, 55, 16);
		contentPanel.add(lblNewLabel);
		
		textCodice = new JTextField();
		textCodice.setBounds(335, 11, 78, 20);
		contentPanel.add(textCodice);
		textCodice.setColumns(10);
		
		textDI = new JTextField();
		textDI.setBounds(335, 42, 77, 20);
		contentPanel.add(textDI);
		textDI.setColumns(10);
		
		textDF = new JTextField();
		textDF.setColumns(10);
		textDF.setBounds(336, 73, 77, 20);
		contentPanel.add(textDF);
		
		JLabel lblNewLabel_1 = new JLabel("Data Inizio : ");
		lblNewLabel_1.setBounds(249, 44, 74, 16);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Data FIne : ");
		lblNewLabel_1_1.setBounds(249, 75, 74, 16);
		contentPanel.add(lblNewLabel_1_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton NextButton = new JButton("Next");
				buttonPane.add(NextButton);
				NextButton.addActionListener(new ActionListener(){

					@SuppressWarnings("deprecation")
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
			String nome = textNome.getText();
			String cognome = textCognome.getText();						
			String  email = textEmail.getText();
			String password = textPassword.getText();
			String skill = textSkill.getText();
			String cv = textCV.getText();
			String controllo = textCodice.getText();
			String DataInizio = textDI.getText();
			String DataFine = textDF.getText();
			
			 
				try { connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/SM", "root", "");
					
				int sk = Integer.parseInt(skill);
				int c = Integer.parseInt(controllo);
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
				Date dateI = dateFormat.parse(DataInizio);
				Date dateF = dateFormat.parse(DataFine);
				java.sql.Date sqlDate = new java.sql.Date(dateI.getTime());
				java.sql.Date sqlDate1 = new java.sql.Date(dateF.getTime());

					String query = "INSERT INTO utente (Nome, Cognome, Email, Password, CV, Skill, Controllo, DataI, DataF)  VALUES ('"+ nome + "' , + '" + cognome + "'  ,  '" + email + "'  ,'" + password + "'  , '"+ cv + "', '"+ sk+ "' , '"+ c +"', '"+sqlDate+"','"+sqlDate1+"');";
					Statement stmt2 = connection.createStatement();
					int i = stmt2.executeUpdate(query);
					
					 if (i > 0) {
				           
						MainFrame Login = new MainFrame();
						Login.show();
						Singup.show(false);
						 
						 
				       } else {
				       
				    	SingUpa Singup = new SingUpa();
				    	Singup.show();
				    	Singup.setVisible(false);
				    	   
				    	   
				       }
				    } catch (Exception e1) {
				       System.out.println(e1);
				    }
				
			
			
			
			
			
			
			
			
			
					}
					
					
					
				});
				getRootPane().setDefaultButton(NextButton);
				
				
				
				
				
			}
			
				JButton NewCompBTN = new JButton("Nuove Competenze");
				NewCompBTN.setActionCommand("Cancel");
				buttonPane.add(NewCompBTN);
				NewCompBTN.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
					Coompetenze competenze =  new Coompetenze();
					competenze.show();
					Singup.setVisible(false);
					
						
					}
					
					
					
				});
				
		}							}	
}

