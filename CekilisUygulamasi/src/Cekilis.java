import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.awt.event.ActionEvent;

public class Cekilis extends JFrame {
	private String dosya_yolu = "";
	private JPanel contentPane;
	private JTextField aramaText;
	private ArrayList<String> katýlanlar= new ArrayList<String>();
	private Set<String> kazananlar= new TreeSet<String>();
	private DefaultListModel<String> model= new DefaultListModel<String>();
	private Random random=new Random();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cekilis frame = new Cekilis();
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
	public void cekilisYap() {
		try(BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(dosya_yolu),"ISO-8859-9"))){
			
			
			String kisi;
			
			while((kisi = reader.readLine())!=null) {
				katýlanlar.add(kisi);
			}
			
			
			while(kazananlar.size() != 10) {
				
				int kazanan_index= random.nextInt(katýlanlar.size());
				
				kazananlar.add(katýlanlar.get(kazanan_index));
				
			}
			
			
			
			
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void alkisla() {
		
		try {
			AudioInputStream stream= AudioSystem.getAudioInputStream(new File("C:\\Users\\Mustafa\\Desktop\\Eclipse\\CekilisUygulamasi\\src\\alkýþ.wav"));
			Clip clip= AudioSystem.getClip();
			
			clip.open(stream);
			clip.start();
			
			
			
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public Cekilis() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setForeground(Color.WHITE);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
		);
		
		aramaText = new JTextField();
		aramaText.setEditable(false);
		aramaText.setColumns(10);
		JFileChooser fileChooser= new JFileChooser();
		
		JButton gozatButton = new JButton("G\u00F6zat");
		gozatButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = fileChooser.showOpenDialog(Cekilis.this);
				
				
				if(i== JFileChooser.APPROVE_OPTION) {
				
					dosya_yolu = fileChooser.getSelectedFile().getPath();
					aramaText.setText(dosya_yolu);
				}
				
				
			}
		});
		
		JList kazananlarListesi = new JList();
		kazananlarListesi.setModel(model);
		
		JLabel lblNewLabel = new JLabel("Kazananlar");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setForeground(Color.RED);
		
		JButton cekilisButton = new JButton("Cekilis Yap");
		cekilisButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dosya_yolu.equals("")) {
					JOptionPane.showMessageDialog(Cekilis.this,"Lütfen bir çekiliþ dosyasý seçin.");
					
				}
				else {
					cekilisYap();
					
					for(String kazanan: kazananlar) {
						model.addElement(kazanan);
					}
					kazananlar.clear();
					alkisla();
					
				}
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(aramaText, GroupLayout.PREFERRED_SIZE, 462, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
						.addComponent(kazananlarListesi, GroupLayout.PREFERRED_SIZE, 436, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(cekilisButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(gozatButton, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
					.addGap(92))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(aramaText, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(gozatButton, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(kazananlarListesi, GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
						.addComponent(cekilisButton, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
