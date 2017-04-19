package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;

public class ChatPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatPage frame = new ChatPage();
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
	public ChatPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(48, 31, 154, 217);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(244, 31, 154, 217);
		contentPane.add(panel_1);
		
		JLabel lblMe = new JLabel("Me :");
		lblMe.setBounds(63, 11, 46, 14);
		contentPane.add(lblMe);
		
		JLabel lblSheHe = new JLabel("She\\ He :");
		lblSheHe.setBounds(244, 6, 67, 14);
		contentPane.add(lblSheHe);
		
		JButton btnSend = new JButton("Send");
		btnSend.setBounds(319, 259, 90, 37);
		contentPane.add(btnSend);
		
		textField = new JTextField();
		textField.setBounds(35, 260, 276, 36);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
