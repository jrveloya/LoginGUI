package practice;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FrameLogin extends JFrame {
	File f = new File("C:\\Users\\jvelo\\eclipse-workspace\\GUIPractice\\src\\practice\\res");
	private int ln;
	private Image img_people = new ImageIcon(FrameLogin.class.getResource("res/peopleIcon.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
	private Image img_key = new ImageIcon(FrameLogin.class.getResource("res/keyIcon.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	private Image img_lock = new ImageIcon(FrameLogin.class.getResource("res/lockIcon.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	private Image img_login = new ImageIcon(FrameLogin.class.getResource("res/loginIcon.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	private JPanel contentPane;
	private JTextField txtEmail;
	private JPasswordField txtPassword;
	private JLabel lblLoginMessage = new JLabel("");
	
	/**
	 * Create the frame.
	 */
	public FrameLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelUsername = new JPanel();
		panelUsername.setBounds(180, 150, 250, 40);
		panelUsername.setBackground(Color.WHITE);
		contentPane.add(panelUsername);
		panelUsername.setLayout(null);
		
		txtEmail = new JTextField();
		txtEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtEmail.selectAll();
			}
		});
		txtEmail.setBorder(null);
		txtEmail.setText("example@email.com");
		txtEmail.setBounds(10, 11, 170, 18);
		panelUsername.add(txtEmail);
		txtEmail.setColumns(10);
		
		JPanel panelPassword = new JPanel();
		panelPassword.setBounds(180, 201, 250, 40);
		panelPassword.setBackground(Color.WHITE);
		contentPane.add(panelPassword);
		panelPassword.setLayout(null);
		
		txtPassword = new JPasswordField();
		txtPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtPassword.getText().equals("Password")) {
					txtPassword.setEchoChar('●');
					txtPassword.setText("");
				}else{
					txtPassword.selectAll();
				}
			}
		});
		txtPassword.setBorder(null);
		txtPassword.setText("Password");
		txtPassword.setBounds(10, 11, 170, 20);
		panelPassword.add(txtPassword);
		
		lblLoginMessage.setForeground(Color.WHITE);
		
		lblLoginMessage.setFont(new Font("Arial", Font.BOLD, 12));
		lblLoginMessage.setBounds(180, 252, 250, 22);
		contentPane.add(lblLoginMessage);
		
		JPanel panelLogin = new JPanel();
		/*
		 * Event handler if Login button is clicked.
		 */
		panelLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(login(txtEmail.getText(), txtPassword.getText())) {
					lblLoginMessage.setText("");
					JOptionPane.showMessageDialog(null,"Login Successful.");
					FrameLogin.this.dispose();
					
			}else if(txtEmail.getText().equals("") || txtPassword.getText().equals("") ||
						 txtEmail.getText().equals("Username") || txtPassword.getText().equals("Password")) {
					/*
					 * if input was not changed, or empty
					 */
					lblLoginMessage.setText("Please enter all requirements.");
				}else {
					/*
					 * if user input does not match.
					 */
					lblLoginMessage.setText("Invalid Username/Password.Try again");
				}
			}
		});
		panelLogin.setBackground(Color.GRAY);
		panelLogin.setBounds(180, 285, 120, 40);
		contentPane.add(panelLogin);
		panelLogin.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOG IN");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(50, 0, 48, 40);
		panelLogin.add(lblNewLabel);
		
		JLabel lblIconLogin_1_1 = new JLabel("");
		lblIconLogin_1_1.setBounds(22, 0, 20, 39);
		panelLogin.add(lblIconLogin_1_1);
		lblIconLogin_1_1.setIcon(new ImageIcon(img_lock));
		setUndecorated(true);
		
		JLabel lblPasswordIcon = new JLabel("");
		lblPasswordIcon.setBounds(143, 201, 27, 39);
		contentPane.add(lblPasswordIcon);
		lblPasswordIcon.setIcon(new ImageIcon(img_key));
		
		JLabel lblIconPeople = new JLabel("");
		lblIconPeople.setBounds(143, 27, 96, 112);
		contentPane.add(lblIconPeople);
		lblIconPeople.setIcon(new ImageIcon(img_people));
		
		JLabel lblUsernameIcon = new JLabel("");
		lblUsernameIcon.setBounds(143, 150, 27, 39);
		contentPane.add(lblUsernameIcon);
		lblUsernameIcon.setIcon(new ImageIcon(img_login));
		
		JLabel lblExit = new JLabel("x");
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to close the Login Page?","Confirmation",JOptionPane.YES_NO_OPTION) == 0) {
					FrameLogin.this.dispose();
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
		
		JLabel lblTitle = new JLabel("The Unsocial Media");
		lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setBounds(259, 27, 171, 106);
		contentPane.add(lblTitle);

		
		JPanel panelSignup = new JPanel();
		panelSignup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Signup signup = new Signup();
				signup.setVisible(true);
			}
		});
		panelSignup.setLayout(null);
		panelSignup.setBackground(Color.GRAY);
		panelSignup.setBounds(310, 285, 120, 40);
		contentPane.add(panelSignup);
		
		JLabel lblSignUp = new JLabel("SIGN UP");
		lblSignUp.setHorizontalTextPosition(SwingConstants.CENTER);
		lblSignUp.setForeground(Color.WHITE);
		lblSignUp.setFont(new Font("Arial", Font.BOLD, 14));
		lblSignUp.setBounds(28, 0, 68, 40);
		panelSignup.add(lblSignUp);
		setLocationRelativeTo(null);
	}
	
	private boolean login(String userName, String password) {
		countLines();
		boolean login = false;
		try {
			RandomAccessFile raf = new RandomAccessFile(f + "\\users.txt", "rw");
			for (int i = 0; i < ln; i += 4) {
				String line = raf.readLine();
				String email = line.substring(7);
				String pass = raf.readLine().substring(10);
				if (txtEmail.getText().equals(email) && txtPassword.getText().equals(pass)) {
					login = true;
				} else if (i == (ln - 3)) {
					login = false;
				} else {
					login = false;
				}
				/*
				for(int k = 1; k<=2; k++) {
					raf.readLine();
				}
				*/
				//raf.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return login;
	}
	
    void countLines() {
    	try {
    		ln=0;
            RandomAccessFile raf = new RandomAccessFile("C:\\Users\\jvelo\\eclipse-workspace\\GUIPractice\\src\\practice\\res\\users.txt", "rw");
            for(int i=0;raf.readLine()!=null;i++){
                ln++;
            }
    	}catch (FileNotFoundException e) {
    		e.printStackTrace();
    	}catch (IOException e1) {
    		e1.printStackTrace();
    	}
    }

}
