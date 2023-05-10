package Data_test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class signup {

	private JFrame frame;
	private JTextField txtSignUp;
	private JTextField textfield1;
	private JTextField textfield2;
	private JTextField t1;
	private JPasswordField p1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signup window = new signup();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public signup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 884, 633);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtSignUp = new JTextField();
		txtSignUp.setFont(new Font("Verdana", Font.BOLD, 29));
		txtSignUp.setText("Sign up");
		txtSignUp.setBounds(359, 11, 130, 58);
		frame.getContentPane().add(txtSignUp);
		txtSignUp.setColumns(10);
		
		textfield1 = new JTextField();
		textfield1.setText("SET USER NAME   :");
		textfield1.setFont(new Font("Verdana", Font.BOLD, 20));
		textfield1.setColumns(10);
		textfield1.setBounds(34, 162, 227, 58);
		frame.getContentPane().add(textfield1);
		
		textfield2 = new JTextField();
		textfield2.setText("SET PASSWORD  :");
		textfield2.setFont(new Font("Verdana", Font.BOLD, 20));
		textfield2.setColumns(10);
		textfield2.setBounds(34, 340, 227, 58);
		frame.getContentPane().add(textfield2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.GRAY);
		lblNewLabel.setBounds(388, 188, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		t1 = new JTextField();
		t1.setBounds(273, 162, 352, 58);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		
		JButton btnNewButton = new JButton("sign in");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String u=t1.getText();
				String p=p1.getText();
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/madhue5","root","mrec");
					String w="insert into signup values('"+u+"','"+p+"')";
					Statement s=con.createStatement();
					s.execute(w);
					s.close();
					JOptionPane.showMessageDialog(btnNewButton, "signup done");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}					
					
				
			}
			
		});
		btnNewButton.setBounds(476, 521, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		p1 = new JPasswordField();
		p1.setBounds(271, 340, 354, 58);
		frame.getContentPane().add(p1);
	}
}
