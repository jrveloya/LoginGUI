package practice;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.Rectangle;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTextArea;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Signup extends JFrame{
	private User backend = new User();
	private JLabel lblpwMessage = new JLabel("");
	private JLabel lblConfirmpwMessage = new JLabel("");
	private Image img_people = new ImageIcon(FrameLogin.class.getResource("res/peopleIcon.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
	private JPanel contentPane;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtEmail;
	private JPasswordField pwdPassword;
	private JPasswordField pwdConfirmPassword;

	public Signup() {
		setUndecorated(true);
		setVisible(true);
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("The Unsocial Media");
		lblNewLabel.setBounds(0, 28, 600, 90);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setIcon(new ImageIcon(img_people));
		contentPane.add(lblNewLabel);
		
		JPanel _firstName = new JPanel();
		_firstName.setBounds(165, 162, 350, 40);
		contentPane.add(_firstName);
		_firstName.setLayout(null);
		
		txtFirstName = new JTextField();
		txtFirstName.setVerifyInputWhenFocusTarget(false);
		txtFirstName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtFirstName.selectAll();
			}
		});
		txtFirstName.setForeground(Color.GRAY);
		txtFirstName.setText("Hasbulla");
		txtFirstName.setBounds(new Rectangle(10, 10, 200, 30));
		txtFirstName.setBounds(10, 11, 300, 20);
		_firstName.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		JPanel panel_LastName = new JPanel();
		panel_LastName.setBounds(165, 228, 350, 40);
		contentPane.add(panel_LastName);
		panel_LastName.setLayout(null);
		
		txtLastName = new JTextField();
		txtLastName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtLastName.selectAll();
			}
		});
		txtLastName.setForeground(Color.GRAY);
		txtLastName.setText("Magomedov");
		txtLastName.setToolTipText("");
		txtLastName.setBounds(10, 11, 300, 20);
		panel_LastName.add(txtLastName);
		txtLastName.setColumns(10);
		
		JPanel panel_UserName = new JPanel();
		panel_UserName.setBounds(165, 302, 350, 40);
		contentPane.add(panel_UserName);
		panel_UserName.setLayout(null);
		
		txtEmail = new JTextField();
		txtEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtEmail.selectAll();
			}
		});
		txtEmail.setForeground(Color.GRAY);
		txtEmail.setText("catluvr2000@email.com");
		txtEmail.setBounds(10, 11, 300, 20);
		panel_UserName.add(txtEmail);
		txtEmail.setColumns(10);
		
		JPanel panel_Password = new JPanel();
		panel_Password.setBounds(165, 446, 350, 40);
		contentPane.add(panel_Password);
		panel_Password.setLayout(null);
		
		pwdPassword = new JPasswordField();
		pwdPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(pwdPassword.getText().equals("Password")) {
					pwdPassword.setText("");
					pwdPassword.setEchoChar('●');
				}else {
					pwdPassword.setEchoChar('●');
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				
				try {
					backend.isValid(pwdPassword.getText());
					lblpwMessage.setText("Password Valid");
				} catch (InvalidPasswordException e1) {
					lblpwMessage.setText(e1.getMessage() + " " + e1.printMessage());
				}
			}
		});
		pwdPassword.setForeground(Color.GRAY);
		pwdPassword.setEchoChar((char)0);
		pwdPassword.setText("Password");
		pwdPassword.setBounds(10, 11, 300, 20);
		panel_Password.add(pwdPassword);
		
		JPanel panel_ConfirmPassword = new JPanel();
		panel_ConfirmPassword.setBounds(165, 546, 350, 40);
		contentPane.add(panel_ConfirmPassword);
		panel_ConfirmPassword.setLayout(null);
		
		pwdConfirmPassword = new JPasswordField();
		pwdConfirmPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(pwdConfirmPassword.getText().equals("Confirm Password")) {
					pwdConfirmPassword.setText("");
					pwdConfirmPassword.setEchoChar('●');
				}else {
					pwdConfirmPassword.setEchoChar('●');
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				lblConfirmpwMessage.setText("");
				if(pwdConfirmPassword.getText().equals(pwdPassword.getText())) {
					lblConfirmpwMessage.setText("Password matched");
				}else {
					lblConfirmpwMessage.setText("Password not matched. Try again");
				}
			}
		});
		pwdConfirmPassword.setEchoChar((char)0);
		pwdConfirmPassword.setForeground(Color.GRAY);
		pwdConfirmPassword.setText("Confirm Password");
		pwdConfirmPassword.setBounds(10, 11, 300, 20);
		panel_ConfirmPassword.add(pwdConfirmPassword);
		
		JLabel lblNewLabel_1 = new JLabel("First Name :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 166, 145, 36);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Last Name :");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(10, 232, 145, 36);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblEmail = new JLabel("E-Mail :");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Arial", Font.BOLD, 14));
		lblEmail.setBounds(10, 302, 145, 36);
		contentPane.add(lblEmail);
		
		JLabel lblNewLabel_1_3 = new JLabel("Password :");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(10, 446, 145, 36);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Confirm Password :");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_4.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1_4.setBounds(10, 546, 145, 36);
		contentPane.add(lblNewLabel_1_4);
		
		JTextArea txtrYourPasswordShould = new JTextArea();
		txtrYourPasswordShould.setBounds(165, 353, 350, 82);
		contentPane.add(txtrYourPasswordShould);
		txtrYourPasswordShould.setFont(new Font("Arial", Font.PLAIN, 10));
		txtrYourPasswordShould.setForeground(Color.WHITE);
		txtrYourPasswordShould.setBackground(Color.DARK_GRAY);
		txtrYourPasswordShould.setText("Your Password Should Have: \r\n-Atleast 1 Uppercase Letter\r\n-Atleast 1 Lowercase Letter\r\n-1 Special Character\r\n-1 Numerical number\r\n-Minimum 8 characters.");
		
		JLabel lblExit = new JLabel("x");
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to close the Sign Up Page?","Confirmation",JOptionPane.YES_NO_OPTION) == 0) {
					Signup.this.dispose();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblExit.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblExit.setForeground(Color.WHITE);
			}
		});
		lblExit.setForeground(Color.WHITE);
		lblExit.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblExit.setBounds(583, 0, 17, 28);
		contentPane.add(lblExit);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(232, 681, 155, 57);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("SIGN UP");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				User user = new User(txtEmail.getText(), pwdPassword.getText(), txtFirstName.getText(), txtLastName.getText());
				user.addData(user.getEmail(), user.getPassword());
				String message = ("Success! You have been signed up. Your user ID is:" + user.getUserID());
				JOptionPane.showMessageDialog(null, message);
			}
		});
		lblNewLabel_2.setBounds(0, 0, 155, 57);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2.setBackground(Color.LIGHT_GRAY);
		lblpwMessage.setForeground(Color.WHITE);
		
		lblpwMessage.setBounds(164, 497, 350, 40);
		contentPane.add(lblpwMessage);
		
		
		lblConfirmpwMessage.setForeground(Color.WHITE);
		lblConfirmpwMessage.setBounds(165, 597, 350, 40);
		contentPane.add(lblConfirmpwMessage);
	}
}
