import javax.swing.JFrame;



public class Frame extends JFrame {
	
	
	public Frame() {
		
		super("Tic-tac-toe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		add(new Panel());
		pack();
		
		
		
	}
	
	public static void main(String[] args) {
		
		java.awt.EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				JFrame frame = new Frame();
				frame.setVisible(true);
			}
		});
		
	}
	

}
