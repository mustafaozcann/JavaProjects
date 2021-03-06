import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;



public class Panel extends JPanel implements ActionListener, KeyListener {
	private final int P_WIDTH = 400;
	private final int P_HEIGHT = 250;
	
	private int xMove1 = 200;
	private int xMove2 = 400;
	private int width = 40;
	private int height = 80;
	private int height2 = 60;
	
	private int birdX = 0;
	private int birdY = 100;
	
	private int point = 0;
	
	private boolean run = true;
	
	private Random random = new Random();
	
	private Timer timer = new Timer(250, this);
	
	public Panel() {
		
		setPreferredSize(new Dimension(P_WIDTH, P_HEIGHT));
		setFocusable(true);
		setBackground(Color.BLACK);
		addKeyListener(this);
		timer.start();
	}
	
	
	@Override
	public void paint(Graphics g) {
		if(run) {
			super.paint(g);
			g.setColor(Color.RED);
			g.fillOval(birdX, birdY, 20, 20);
			g.setColor(Color.GREEN);
			g.fillRect(xMove1, P_HEIGHT - height, width, height);
			g.fillRect(xMove2, P_HEIGHT - height2, width, height2);
			
			g.fillRect(xMove1, 0, width, P_HEIGHT -height - 80);
			g.fillRect(xMove2, 0, width, P_HEIGHT -height2 - 80);
		}
		
		else {
			timer.stop();
			JOptionPane.showMessageDialog(this, "Game Over !\nPoint ="+(point/6+1));
			System.exit(0);
		}
		
		
		
	}
	
	@Override
	public void repaint() {
		super.repaint();
	}
	
	
	public boolean checkCollision() {
		if(new Rectangle(birdX, birdY, 20, 20).intersects(new Rectangle(xMove1, P_HEIGHT - height, width, height))
				|| new Rectangle(birdX, birdY, 20, 20).intersects(new Rectangle(xMove2, P_HEIGHT - height2, width, height2))){
			return true;
		}
		else if(new Rectangle(birdX, birdY, 20, 20).intersects(new Rectangle(xMove1, 0, width, P_HEIGHT -height - 80))
				|| new Rectangle(birdX, birdY, 20, 20).intersects(new Rectangle(xMove2, 0, width, P_HEIGHT -height2 - 80))){
			return true;
		}
		
		return false;
	}
	
	
	public void checkScoring() {
		if(new Rectangle(birdX, birdY, 20, 20).intersects(new Rectangle(xMove1, P_HEIGHT - height -80, width, 80))
				|| new Rectangle(birdX, birdY, 20, 20).intersects(new Rectangle(xMove2, P_HEIGHT - height2-80, width, 80))){
			point++;
		}
		
		
		
		
	}
	
	                                     
	
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			birdY-= 10;
			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (xMove1 < 0) {
			xMove1 = P_WIDTH;
			height = random.nextInt(70) + 10;
			
		}
		else if(xMove2 < 0) {
			xMove2 = P_WIDTH;
			height2 = random.nextInt(70)+ 10;
		}
		
		else {
			xMove1-=10;
			xMove2-=10;
			birdY+=5;
			checkScoring();
		}
		
		if(checkCollision()) {
			run = false;
		}
		
		
		
		repaint();
	}
	
	
	

}
