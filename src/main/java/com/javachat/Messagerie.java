package interface_graphique;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Window.Type;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JTree;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;

public class Messagerie extends JFrame {

	private JPanel contentPane;
	private JTextField txtEntrezVosMessages;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Messagerie frame = new Messagerie();
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
	public Messagerie(Interface0 frame) {
		setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		setTitle("Boite de discussion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setBounds(132, 117, 1, 1);
		contentPane.add(list);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 74, 327, 294);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setForeground(new Color(25, 25, 112));
		lblNewLabel_2.setFont(new Font("Source Sans Pro", Font.PLAIN, 15));
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		scrollPane.setViewportView(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Bienvenue dans votre messagerie");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("Source Serif Pro Light", Font.BOLD, 18));
		lblNewLabel.setBounds(157, 0, 286, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("boites de dialogues ");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Century", Font.BOLD, 14));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(10, 53, 154, 17);
		contentPane.add(lblNewLabel_1);
		
		txtEntrezVosMessages = new JTextField();
		txtEntrezVosMessages.setForeground(Color.LIGHT_GRAY);
		txtEntrezVosMessages.setFont(new Font("Century Schoolbook", Font.PLAIN, 14));
		txtEntrezVosMessages.setText("\u00C9crivez vos messages");
		txtEntrezVosMessages.setBounds(369, 214, 203, 44);
		contentPane.add(txtEntrezVosMessages);
		txtEntrezVosMessages.setColumns(10);
		
		JButton btnNewButton = new JButton("envoyer");
		btnNewButton.setBounds(369, 282, 99, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Deconnexion");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.setBounds(233, 379, 154, 17);
		contentPane.add(btnNewButton_1);
	}
}
