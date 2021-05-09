import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.JPanel;

public class CPBPanel extends JPanel implements ActionListener{

	/**
	 * Create the panel.
	 */
	
	private int x = 100;
	private int y = 100;
	
	private int startAngle = 90;
	private int arcAngle = 1;
	
	private int width = 100;
	private int height = 100;
	
	private int percent = 1;
	
	private int move = 1;
	
	private javax.swing.Timer timer = new javax.swing.Timer(25, this);
	
	
	public CPBPanel() {
		setPreferredSize(new Dimension(300, 300));
		setBackground(Color.BLACK);
		timer.start();
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.setColor(Color.RED);
		g.drawOval(100, 100, 100, 100);
		
		g.setColor(Color.YELLOW);
		
		g.drawArc(x, y, width, height, startAngle, arcAngle);			
		
		//g.fillArc(x, y, width, height, startAngle, arcAngle);
		   
        String msg ="%" + Integer.toString(percent);
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.white);
        
        g.setFont(small);
        
        g.drawString(msg, (300 - metr.stringWidth(msg)) / 2, 155);
        
		
		
	}

	

	@Override
	public void repaint() {
		// TODO Auto-generated method stub
		super.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		percent = (arcAngle * 100) / 360;
		arcAngle += move;
		if (arcAngle == 361) {
			timer.stop();
		}
		repaint();
		
		
		
	}
	
	
	

}
