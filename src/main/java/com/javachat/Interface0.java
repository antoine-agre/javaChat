package interface_graphique;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javachat.Client;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.SystemColor;
import java.awt.Window.Type;
import javax.swing.JSeparator;

public class Interface0 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtKoko;
	private boolean pseudoChoisi=false;
	//proprietes
	
	public String pseudo() {
		while(pseudoChoisi==false) {}
		return txtKoko.getText();
		 
	 };
	 
	 
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface0 frame = new Interface0();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	
	
	/**
	 * Create the frame.
	 */
	public Interface0() {
		
		Messagerie fram = new Messagerie(this);
		setBackground(new Color(0, 255, 127));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Interface0.class.getResource("/image/user.png")));
		setFont(new Font("Century", Font.PLAIN, 13));
		setTitle("Creation d'identifiant");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 362);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		
		txtKoko = new JTextField();
		txtKoko.setForeground(Color.LIGHT_GRAY);
		txtKoko.setText("saisir un pseudo");
		txtKoko.setFont(new Font("Source Code Pro Light", Font.BOLD, 15));
		txtKoko.setBounds(141, 145, 237, 20);
		txtKoko.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Veuillez entrer votre pseudonyme de connexion");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(101, 68, 325, 20);
		lblNewLabel.setFont(new Font("Century Schoolbook", Font.PLAIN, 14));
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pseudoChoisi=true;
				//pseudo();
				
				//client.frame.setVisible(false);
				removeAll();
				fram.setVisible(true);
				
			}
		});
		btnNewButton.setBackground(Color.ORANGE);
		
		btnNewButton.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 12));
		btnNewButton.setBounds(199, 215, 107, 29);
		
		JLabel lblNewLabel_1 = new JLabel("PSEUDONYME");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setIcon(new ImageIcon(Interface0.class.getResource("/image/user.png")));
		lblNewLabel_1.setBounds(27, 144, 107, 20);
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		contentPane.setLayout(null);
		contentPane.add(txtKoko);
		contentPane.add(lblNewLabel);
		contentPane.add(btnNewButton);
		contentPane.add(lblNewLabel_1);
	}
}
