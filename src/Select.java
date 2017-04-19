

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JTable;
import javax.swing.JSplitPane;
import javax.swing.JList;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;

public class Select extends JFrame {

	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Select frame = new Select();
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
	public Select() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnShowOnlineIdle = new JButton("Show Online Idle Hosts");
		btnShowOnlineIdle.setBounds(233, 64, 166, 23);
		contentPane.add(btnShowOnlineIdle);
		
		JButton btnConnectToThis = new JButton("Connect to this host . . .");
		btnConnectToThis.setBounds(233, 143, 166, 23);
		contentPane.add(btnConnectToThis);
		
		JList list = new JList();
		list.setBackground(Color.PINK);
		list.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
		list.setBounds(31, 53, 137, 141);
		contentPane.add(list);
	}
	public JTable getTable() {
		return table;
	}
}
