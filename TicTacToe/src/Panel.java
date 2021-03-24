import java.awt.Dimension;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.ButtonGroup;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JOptionPane;



public class Panel extends JPanel implements ActionListener{

	private final int WIDTH = 500;
	private final int HEIGHT = 500;
	
	private Random random = new Random();
	
	private int o_point = 0;
	private int x_point = 0;
	
	private int move = 1;
	
	
	private ArrayList<JLabel> arrayList = new ArrayList<JLabel>();
	
	private ArrayList<Integer> playerPositions = new ArrayList<Integer>();
	private ArrayList<Integer> pcPositions = new ArrayList<Integer>();
	
	private java.util.List<java.util.List> winningConditions = new ArrayList<java.util.List>();
	
	private JCheckBox o;
	private JCheckBox x;
	
	
	private String selectedRol = "";
	private String pc_selectedRol = "";
	private Timer timer = new Timer(1000, this);
	/**
	 * Create the panel.
	 */
	class MouseListen extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			//super.mouseClicked(e);
			
			if(move != 0) {
				JLabel label = (JLabel) e.getComponent();
				
				int index = arrayList.indexOf(label);
				
				playerPositions.add(index+1);
				
				if(selectedRol.equals("O")) {
					label.setForeground(Color.RED);
				}
				else {
					label.setForeground(Color.YELLOW);
				}
				label.setText(selectedRol);
				
				if(control()) {
					JOptionPane.showMessageDialog(Panel.this, "Player won !");
					
					
					again();
					
					if(selectedRol.equals("X")) {
						x_point++;
					}
					else {
						o_point++;
					}
					
					showScore();
				}
				
				if (scoreless()) {
					JOptionPane.showMessageDialog(Panel.this, "Scoreless !");
					again();
				}
				
				move--;
				timer.start();
			}
			
			
		}
		
	}
	
	public Panel() {
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 37, 480, 2);
		add(separator);
		
		x = new JCheckBox("X");
		x.setFocusable(false);
		x.setBounds(6, 10, 228, 21);
		add(x);
		
		o = new JCheckBox("O");
		o.setFocusable(false);
		o.setBounds(262, 10, 228, 21);
		add(o);
		
		ButtonGroup group = new ButtonGroup();
		group.add(o);
		group.add(x);
		
		ActionListener cb_action = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				o.setText("O          "
						+ "        "+o_point);
				x.setText("X          "
						+ "        "+x_point);
				o.setEnabled(false);
				x.setEnabled(false);
				
				if(x.isSelected()) {
					selectedRol = "X";
					pc_selectedRol = "O";
				}
				else {
					selectedRol = "O";
					pc_selectedRol = "X";
				}
				
			}
		};
		
		x.addActionListener(cb_action);
		o.addActionListener(cb_action);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(160, 91, 2, 386);
		add(separator_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_1_1.setBounds(333, 91, 2, 386);
		add(separator_1_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 207, 480, 2);
		add(separator_2);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBounds(10, 353, 480, 2);
		add(separator_2_1);
		
		JLabel lbl0 = new JLabel("");
		lbl0.setFont(new Font("Stencil", Font.BOLD, 91));
		lbl0.setHorizontalAlignment(SwingConstants.CENTER);
		lbl0.setForeground(Color.ORANGE);
		lbl0.setBounds(10, 91, 152, 118);
		add(lbl0);
		arrayList.add(lbl0);
		
		
		JLabel lbl1 = new JLabel("");
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setForeground(Color.ORANGE);
		lbl1.setFont(new Font("Stencil", Font.BOLD, 91));
		lbl1.setBounds(160, 91, 175, 118);
		add(lbl1);
		arrayList.add(lbl1);
		
		JLabel lbl2 = new JLabel("");
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setForeground(Color.ORANGE);
		lbl2.setFont(new Font("Stencil", Font.BOLD, 91));
		lbl2.setBounds(339, 91, 151, 118);
		add(lbl2);
		arrayList.add(lbl2);
		
		JLabel lbl_1_1 = new JLabel("");
		lbl_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_1_1.setForeground(Color.ORANGE);
		lbl_1_1.setFont(new Font("Stencil", Font.BOLD, 91));
		lbl_1_1.setBounds(160, 207, 175, 148);
		add(lbl_1_1);
		
		
		
		JLabel lbl_1_0 = new JLabel("");
		lbl_1_0.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_1_0.setForeground(Color.ORANGE);
		lbl_1_0.setFont(new Font("Stencil", Font.BOLD, 91));
		lbl_1_0.setBounds(10, 207, 152, 148);
		add(lbl_1_0);
		
		JLabel lbl_2_0 = new JLabel("");
		lbl_2_0.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_2_0.setForeground(Color.ORANGE);
		lbl_2_0.setFont(new Font("Stencil", Font.BOLD, 91));
		lbl_2_0.setBounds(10, 353, 152, 137);
		add(lbl_2_0);
		
		JLabel lbl_2_1 = new JLabel("");
		lbl_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_2_1.setForeground(Color.ORANGE);
		lbl_2_1.setFont(new Font("Stencil", Font.BOLD, 91));
		lbl_2_1.setBounds(160, 353, 175, 137);
		add(lbl_2_1);
		
		JLabel lbl_2_2 = new JLabel("");
		lbl_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_2_2.setForeground(Color.ORANGE);
		lbl_2_2.setFont(new Font("Stencil", Font.BOLD, 91));
		lbl_2_2.setBounds(339, 353, 151, 137);
		add(lbl_2_2);
		
		JLabel lbl_1_2 = new JLabel("");
		lbl_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_1_2.setForeground(Color.ORANGE);
		lbl_1_2.setFont(new Font("Stencil", Font.BOLD, 91));
		lbl_1_2.setBounds(339, 207, 151, 148);
		add(lbl_1_2);
		arrayList.add(lbl_1_0);
		arrayList.add(lbl_1_1);
		arrayList.add(lbl_1_2);
		arrayList.add(lbl_2_0);
		arrayList.add(lbl_2_1);
		arrayList.add(lbl_2_2);
		MouseListen listen = new MouseListen();
		
		for(JLabel label : arrayList) {
			label.addMouseListener(listen);
		}
		
		
		
	}
	
	public boolean scoreless() {
		
		for(JLabel label : arrayList) {
			
			if(label.getText().equals("")) {
				return false;
			}
			
		}
		
		return true;
		
	}
	
	public void showScore() {
		
		o.setText("O          "
				+ "        "+o_point);
		x.setText("X          "
				+ "        "+x_point);
	}
	
	public int smartMove() {
		
		
		for(List l : winningConditions) {
			
			List<Integer> difference = new ArrayList<Integer>(l); 
			
			Arrays.asList(playerPositions);
			
			if (difference.removeAll(playerPositions)) {
				
				if(difference.size() == 1) {
					
					
					
					if(pcPositions.contains(difference.get(0))) {
						
						break;
						
					}
					return difference.get(0);
					
				}
				
			}
			
			
		}
		
		return -1;
		
		
	}
	
	public int winningSmartpc() {
		
		for(List l : winningConditions) {
					
			List<Integer> difference = new ArrayList<Integer>(l); 
					
			Arrays.asList(pcPositions);
					
			if (difference.removeAll(pcPositions)) {
						
				if(difference.size() == 1) {
							
							
					if(playerPositions.contains(difference.get(0))) {
								
						break;
								
					}
					return difference.get(0);
							
				}
						
			}
					
					
		}
				
		return -1;
		
		
		
		
	}
	
	
	public boolean control() {
		
		java.util.List topRow = Arrays.asList(1, 2, 3);
		java.util.List midRow = Arrays.asList(4, 5, 6);
		java.util.List botRow = Arrays.asList(7, 8, 9);
		
		
		java.util.List leftCol = Arrays.asList(1, 4, 7);
		java.util.List midCol = Arrays.asList(2, 5, 8);
		java.util.List rightCol = Arrays.asList(3, 6, 9);
		
		
		java.util.List cross1 = Arrays.asList(1, 5, 9);
		java.util.List cross2 = Arrays.asList(3, 5, 7);
		
		
		
		winningConditions.add(topRow);
		winningConditions.add(midRow);
		winningConditions.add(botRow);
		
		winningConditions.add(leftCol);
		winningConditions.add(midCol);
		winningConditions.add(rightCol);
		
		winningConditions.add(cross1);
		winningConditions.add(cross2);
		
		for(List l : winningConditions) {
			if (playerPositions.containsAll(l)) {
				return true;
			}
			if(pcPositions.containsAll(l)) {
				return true;
			}
			
		}
		
		return false;
		
		
	}
	
	public void again() {
		
		for(JLabel label : arrayList) {
			label.setText("");
		}
		
		pcPositions.clear();
		playerPositions.clear();
		
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		
		int randIndex = random.nextInt(9);
		while(true) {
			
			if(smartMove() != -1 && winningSmartpc() == -1) {
				arrayList.get(smartMove()-1).setForeground(Color.white);
				arrayList.get(smartMove()-1).setText(pc_selectedRol);
				pcPositions.add(smartMove());
				break;
			}
			
			else {
				
				if(winningSmartpc() != -1) {
					
					arrayList.get(winningSmartpc()-1).setForeground(Color.white);
					arrayList.get(winningSmartpc()-1).setText(pc_selectedRol);
					pcPositions.add(winningSmartpc());
					break;
				}
				else {
					
					if(!arrayList.get(randIndex).getText().equals(""))
						randIndex = random.nextInt(9);
					else {
						arrayList.get(randIndex).setForeground(Color.white);
						arrayList.get(randIndex).setText(pc_selectedRol);
						pcPositions.add(randIndex+1);				
						break;
					}
					
					
					
				}
				
				
			}
			
		}
		
		
		if(scoreless() && !control()) {
			JOptionPane.showMessageDialog(Panel.this, "Scoreless !");
			again();
			
		}
		
		
		
		if(control()) {
			JOptionPane.showMessageDialog(Panel.this, "Pc won !");
			
			if (pc_selectedRol.equals("X")) {
				x_point++;
			}
			else {
				o_point++;
			}
			
			again();
			showScore();
		}
		
		move++;
		timer.stop();
	}
	
	
	
}










