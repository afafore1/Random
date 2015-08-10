package Cool;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

public class ChangePassword extends JFrame {

	
	private JPanel contentPane;
	private static JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JButton btnSubmit;

	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePassword frame = new ChangePassword();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	

	/**
	 * Create the frame.
	 */
	}
	private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {
		// the name of the text field in a variable
        String password = passwordField.getSelectedText();
        String password1 = passwordField_1.getSelectedText();
        boolean hasUppercase = !password.equals(password.toLowerCase());
        boolean hasUppercase1 = !password1.equals(password.toLowerCase());
        boolean hasLowercase = !password.equals(password.toUpperCase()); 
        boolean hasLowercase1 = !password.equals(password.toUpperCase());
        if(password.length() < 10  || password.length() > 32){	
            // print error message here
        	{
        if(!hasUppercase1){
            // print error.. No upper case
        }else if(!hasLowercase1){
            //print error. No lower case
        }else if(!password.matches("[0-9]*")){
            //print error. No number match.
        }
    }             
        }
	}
	public ChangePassword() {
		setTitle("Change Password");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(201, 81, 112, 20);
		passwordField.setEchoChar('*');
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(201, 123, 112, 20);
		passwordField_1.setEchoChar('*');
		contentPane.add(passwordField_1);
		
		
		JLabel lblNewPassword = new JLabel("New Password:");
		lblNewPassword.setBounds(94, 84, 97, 14);
		contentPane.add(lblNewPassword);
		
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setBounds(82, 126, 109, 14);
		contentPane.add(lblConfirmPassword);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}	
		});
		btnSubmit.setBounds(224, 163, 89, 23);
		contentPane.add(btnSubmit);
		
     
		
		
	}

}
