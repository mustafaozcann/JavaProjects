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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;


import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel implements ActionListener, KeyListener{
	private final int P_WIDTH = 400;
	private final int P_HEIGHT = 400;
	
	private Random random = new Random();
	
	private Timer timer;
	private final int timer_delay = 100;
	
	private boolean gameOver = false;
	
	private int point = 0;
	
	private int balldirX = 20;
	private int balldirY = 10;
	private int ballposX = 100;
	private int ballposY = 100;
	
	private int briquetX = 20;
	private int briquetY = 10;
	
	private ArrayList<Briquette> briquettes = new ArrayList<Briquette>();
	
	
	
	private int rectdirX = 35;
	private int rectposX = 0;
	private final int rectposY = 390;
	
	public Panel() {
		
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(P_WIDTH, P_HEIGHT));
		addKeyListener(this);
		
		for(int i = 0; i < 4;i++) {
			Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
			for (int j = 0; j < 8; j++) {
				
				briquettes.add(new Briquette(briquetX, briquetY, color));
				briquetX+=45;
			}
			briquetX = 20;
			briquetY+=25;
		}
		
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(timer_delay, this);
		timer.start();
		
	}
	
	
	
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.setColor(Color.RED);
		g.fillOval(ballposX, ballposY, 10, 10);
		g.setColor(Color.BLUE);
		g.fillRect(rectposX, rectposY, 50, 10);
		
		
			
			
		for(Briquette briquette : briquettes) {
			if(!briquette.isBreakdown()) {
				g.setColor(briquette.getColor());
				g.fillRect(briquette.getPosX(), briquette.getPosY(), briquette.getWidth(), briquette.getHeight());
				
			}
		}
		
		for (Iterator<Briquette> iterator = briquettes.iterator(); iterator.hasNext(); ) {
			Briquette value = iterator.next();
			if (value.isBreakdown()) {
				point++;
				iterator.remove();
			}
		}
			
		
		
		
		if(gameOver) {
			
			String msg = "Game Over !";
			String msgPoint = "Point = "+point; 
			Font small = new Font("Helvetica", Font.BOLD, 14);
			FontMetrics metr = getFontMetrics(small);
			
			g.setColor(Color.white);
			g.setFont(small);
			g.drawString(msg, (P_WIDTH - metr.stringWidth(msg)) / 2, P_HEIGHT / 2);
			g.drawString(msgPoint, (P_WIDTH - metr.stringWidth(msgPoint)) / 2, P_HEIGHT / 2 + 20);
			timer.stop();
			
		}
			
		
		
		
		

	}
	
	public void controlBreakdown() {
		
		for(Briquette briquette : briquettes) {
			
			if(new Rectangle(ballposX, ballposY, 10, 10).intersects(new Rectangle(briquette.getPosX(),
					briquette.getPosY(), briquette.getWidth(), briquette.getHeight()))) {
				briquette.setBreakdown(true);
				balldirX -= -random.nextInt(5);
				balldirX = -balldirX;
				balldirY = -balldirY;
				
			}
			
		}
	}
	
	public void controlRect() {
		if(new Rectangle(ballposX, ballposY, 10, 10).intersects(new Rectangle(rectposX, rectposY-10, 50, 10))) {
			balldirY = -balldirY;
			
		}
		
		
	}
	
	@Override
	public void repaint() {
		// TODO Auto-generated method stub
		super.repaint();
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			
			if(rectposX > P_WIDTH - 60) {
				
			}
			
			else {
				rectposX+= rectdirX;
				
			}
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			
			if(rectposX - 10 < 0) {
				
			}
			else {
				rectposX -= rectdirX;
			}
			
		}
		
		repaint();
		
		
		
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(ballposX+21 > P_WIDTH || ballposX-11 < 0) {
			balldirX = -balldirX;
		}
		
		if(ballposY-11 < 0) {
			balldirY = -balldirY;
		}
		
		if(ballposY+11 > P_HEIGHT) {
			gameOver = true;
		}
		
		
		ballposX += balldirX;
		ballposY += balldirY;
		
		controlBreakdown();
		controlRect();
		
		repaint();
		
	}

}
