import java.awt.EventQueue;

import javax.swing.JFrame;



public class Pencere extends JFrame {


	public Pencere(String title) {
		super(title);
		initUI();

	}


	public void initUI() {

		add(new Panel());
		setFocusable(false);
		setResizable(false);
		pack();
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				Pencere pencere = new Pencere("Pong Game !");
				pencere.setVisible(true);
			}
		});

	}




}
