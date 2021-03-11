import java.awt.EventQueue;

import javax.swing.JFrame;

public class Frame extends JFrame{
	
	public Frame() {
		
		setTitle("Brick Breaker Game !");
		setLocationRelativeTo(null);
		setFocusable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, ABORT, WIDTH, HEIGHT);
		
		setResizable(false);
		add(new Panel());
		pack(); 
		
		
	}
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				JFrame frame = new Frame();
				frame.setVisible(true);				
			}
		});
		
		
		
	}
	
	
	
	
}
