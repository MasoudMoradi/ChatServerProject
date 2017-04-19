

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Connect = new JButton("Connect");
		Connect.setBounds(165, 200, 89, 23);
		contentPane.add(Connect);
		
		JLabel ServerIP = new JLabel("Server IP");
		ServerIP.setBounds(61, 53, 89, 14);
		contentPane.add(ServerIP);
		
		JLabel ServerPort = new JLabel("Server Port");
		ServerPort.setBounds(61, 84, 89, 14);
		contentPane.add(ServerPort);
		
		JLabel ClientUsername = new JLabel("Client Username");
		ClientUsername.setBounds(61, 119, 89, 14);
		contentPane.add(ClientUsername);
		
		JLabel ClientPassword = new JLabel("Client Password");
		ClientPassword.setBounds(61, 155, 89, 14);
		contentPane.add(ClientPassword);
		
		textField = new JTextField();
		textField.setBounds(218, 50, 153, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(218, 81, 153, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(218, 116, 153, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(218, 152, 153, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label = new JLabel("\u0644\u0637\u0641\u0627 \u0645\u0634\u062E\u0635\u0627\u062A \u0632\u06CC\u0631 \u0631\u0627 \u0628\u0627 \u062F\u0642\u062A \u0648\u0627\u0631\u062F  \u0646\u0645\u0627\u06CC\u06CC\u062F");
		label.setBounds(110, 11, 222, 14);
		contentPane.add(label);
	}
}
