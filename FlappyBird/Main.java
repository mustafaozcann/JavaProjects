import java.awt.EventQueue;
import javax.swing.JFrame;



public class Main extends JFrame{


	public Main(String title) {
		super(title);
		initUI();
	}

	private void initUI() {
		setFocusable(false);
		add(new Panel());
		pack();



	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new Main("Flappy Bird !");
				frame.setVisible(true);

			}
		});



	}



}
