import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel implements ActionListener,KeyListener {
	private final int P_WEIGHT = 400;
	private final int P_HEIGHT = 300;

	private int rect1Y = 110;
	private int rect2Y = 110;
	private int moveY = 10;
	private int move2Y = 10;
	private int topX = 190;
	private int topY = 135;
	private int topMoveX = 5;
	private int topMoveY = 5;
	private boolean out = false;

	private int redSkor = 0;
	private int blueSkor = 0;

	private Timer timer = new Timer(50, this);


	public Panel() {
		setPreferredSize(new Dimension(P_WEIGHT, P_HEIGHT));
		setBackground(Color.BLACK);
		addKeyListener(this);
		setFocusable(true);
		timer.start();


	}
	public boolean kontrolEt() {

		if(new Rectangle(topX, topY, 20, 20).intersects(new Rectangle(380, rect2Y, 20, 40))
				||new Rectangle(topX, topY, 20, 20).intersects(new Rectangle(0, rect1Y, 20, 40))) {
			return true;
		}

		return false;



	}
	public void winner() {

		if(blueSkor == 10 || redSkor == 10) {

			if(blueSkor > redSkor) {
				JOptionPane.showMessageDialog(this, "Mavi Takým Kazandý . Tebrikler !");
				System.exit(0);
			}
			else {
				JOptionPane.showMessageDialog(this, "Kýrmýzý Takým Kazandý . Tebrikler !");
				System.exit(0);
			}
		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.WHITE);
		g.drawLine(P_WEIGHT / 2, 0, P_WEIGHT / 2, P_HEIGHT);
		g.drawOval(P_WEIGHT / 2 - 50, P_HEIGHT / 3, 100, 100);
		g.setColor(Color.GREEN);
		g.fillOval(topX, topY, 20, 20);
		g.setColor(Color.RED);
		g.fillRect(0, rect1Y, 20, 40);
		g.setColor(Color.BLUE);
		g.fillRect(380, rect2Y, 20, 40);

		g.setColor(Color.WHITE);
        Font small = new Font("Helvetica", Font.BOLD, 26);
        FontMetrics metr = getFontMetrics(small);
        g.setFont(small);
        g.drawString(String.valueOf(blueSkor), P_WEIGHT / 2 + 25, P_HEIGHT / 2 +10);
        g.drawString(String.valueOf(redSkor), P_WEIGHT / 2 - 40, P_HEIGHT / 2 +10);

		if(out) {
			topX = 190;
			topY = 135;
			out = false;
		}
		winner();

	}

	@Override
	public void repaint() {
		super.repaint();
	}



	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			if(rect2Y <= 0) {

			}
			else {
				rect2Y -= move2Y;				
			}
		}

		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {

			if (rect2Y >= P_HEIGHT - 40) {

			}
			else {

				rect2Y += move2Y;
			}

		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			timer.start();
		}



	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (rect1Y >= P_HEIGHT - 40) {
			moveY = -moveY;
		}

		else if(rect1Y <= 0) {
			moveY = -moveY;
		}

		if(topX >= P_WEIGHT-20) {
			out = true;
			redSkor++;
			timer.stop();
		}
		else if(topX <= 0) {
			out = true;
			blueSkor++;
			timer.stop();
		}
		else if(topY >= P_HEIGHT-20 || topY <= 0) {
			topMoveY = -topMoveY;
		}

		if(kontrolEt()) {
			topMoveX = -topMoveX;
		}




		topX += topMoveX;
		topY += topMoveY;
		rect1Y += moveY;
		repaint();
	}




}
