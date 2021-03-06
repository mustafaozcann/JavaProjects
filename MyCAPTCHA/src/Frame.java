import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.Random;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frame extends JFrame {

	private JPanel contentPane;
	private JTextField verifyField;
	private Random random = new Random();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
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
	
	public String newCaptcha() {
		//Büyük harfler 65-90 arasý
		String captcha = "";
		for(int i = 0; i < 10;i++) {
			int value = random.nextInt(26)+65;
			captcha += Character.toString((char)value);
		}
		
		return captcha;
	}
	
	public Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBorder(new TitledBorder(null, "MyCAPTCHA", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel.setBounds(0, 0, 585, 263);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.RED);
		panel_1.setBounds(125, 85, 341, 48);
		panel.add(panel_1);
		
		JLabel captchaLabel = new JLabel(newCaptcha());
		panel_1.add(captchaLabel);
		captchaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		captchaLabel.setBackground(Color.WHITE);
		captchaLabel.setFont(new Font("DialogInput", Font.PLAIN, 33));
		captchaLabel.setForeground(Color.ORANGE);
		
		JLabel lblNewLabel = new JLabel("Verify it's not a robot.");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		lblNewLabel.setBounds(125, 46, 214, 29);
		panel.add(lblNewLabel);
		
		JLabel lblEnterTheCharacters = new JLabel("Enter the characters you see.");
		lblEnterTheCharacters.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		lblEnterTheCharacters.setBounds(124, 143, 273, 29);
		panel.add(lblEnterTheCharacters);
		
		verifyField = new JTextField();
		verifyField.setBounds(125, 171, 164, 29);
		panel.add(verifyField);
		verifyField.setColumns(10);
		
		JButton verifyButton = new JButton("Verify");
		verifyButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		verifyButton.setBounds(311, 171, 60, 25);
		panel.add(verifyButton);
		verifyButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(captchaLabel.getText().equals(verifyField.getText())) {
					JOptionPane.showMessageDialog(Frame.this, "Congratulations !");
				}
				else {
					JOptionPane.showMessageDialog(Frame.this, "Sorry, wrong answer.");
				}
				
			}
		});
		
		JButton changeButton = new JButton("Change");
		changeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				captchaLabel.setText(newCaptcha());
			}
		});
		changeButton.setBounds(476, 85, 85, 48);
		panel.add(changeButton);
	}
}
