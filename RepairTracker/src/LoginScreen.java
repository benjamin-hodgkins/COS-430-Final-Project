import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;

/*
 * 
 *
 *
 *
 *  
 */
public class LoginScreen extends Validations {

	private JFrame userLogin;
	private JTextField userNameEntry;
	private JPasswordField passwordEntry;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginScreen window = new LoginScreen();
					window.userLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws IOException
	 */
	public LoginScreen() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws IOException
	 */
	private void initialize() throws IOException {

		userLogin = new JFrame();
		userLogin.setTitle("Repair Tracker");
		userLogin.getContentPane().setBackground(SystemColor.controlHighlight);
		userLogin.setResizable(false);
		//userLogin.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\z383932\\Downloads\\favicon.png"));
		userLogin.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
		userLogin.setBounds(100, 100, 450, 180);
		userLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		userLogin.setLocationRelativeTo(null);
		
		//userLogin.setContentPane(new JLabel(new ImageIcon("brokecar2.png")));
		//userLogin.setLayout(new FlowLayout());

		userNameEntry = new JTextField();
		userNameEntry.setBounds(191, 56, 97, 20);
		userNameEntry.setColumns(10);

		passwordEntry = new JPasswordField(10);
		passwordEntry.setToolTipText("Password must be 8 characters long with letters and numbers.");
		passwordEntry.setEchoChar('?');
		passwordEntry.setBounds(191, 87, 97, 20);
		passwordEntry.setColumns(8);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(183, 10, 39, 20);
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(104, 55, 77, 20);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(108, 85, 73, 20);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JButton btnLogin = new JButton("Login");
		btnLogin.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLogin.setBackground(Color.WHITE);
		btnLogin.setBounds(241, 112, 68, 23);
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {

				switch (userLoggingCheck(userNameEntry.getText(), passwordEntry.getText())) {
				case 1:
					JOptionPane.showMessageDialog(null, "When entering your clock number with the 'z' omitted");
					break;
				case 2:// Missing field.
					JOptionPane.showMessageDialog(null, "Please Enter username and password.");
					break;
				case 3:// when user info is not already saved within user database or information is
						// wrong
					JOptionPane.showMessageDialog(null,
							"User Not Found. Please double check that your Information is correct.");
					break;

				default:
					// Closes login screen and displays order screen. Find better way to accomplish
					// this task.
					userLogin.dispose();
					// OperatorScreen.main(null);

				}

			}
		});
		btnLogin.setAlignmentX(Component.RIGHT_ALIGNMENT);

		JButton btnExit = new JButton("Exit");
		btnExit.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnExit.setBackground(Color.WHITE);
		btnExit.setBounds(145, 112, 68, 23);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setMaximumSize(new Dimension(62, 23));
		btnExit.setPreferredSize(new Dimension(69, 23));
		userLogin.getContentPane().setLayout(null);
		userLogin.getContentPane().add(lblLogin);
		userLogin.getContentPane().add(lblUsername);
		userLogin.getContentPane().add(lblPassword);
		userLogin.getContentPane().add(userNameEntry);
		userLogin.getContentPane().add(passwordEntry);

		userLogin.getContentPane().add(btnExit);
		userLogin.getContentPane().add(btnLogin);

		JLabel lblV = new JLabel("V1.0");
		lblV.setBounds(413, 238, 46, 14);
		userLogin.getContentPane().add(lblV);
		userLogin.setFocusTraversalPolicy(
				new FocusTraversalOnArray(new Component[] { userNameEntry, passwordEntry, btnLogin, btnExit }));
	}
}
