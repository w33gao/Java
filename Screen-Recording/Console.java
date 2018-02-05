//console for the screen recoring program
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;


public class Console extends JFrame implements ActionListener{
//button to control 
	JButton startButton = new JButton("Play");
	JLabel image = new JLabel();
	JProgressBar loading = new JProgressBar();
	
	
	
	public Console(){
		
		this.setTitle("video play");
		
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		setLayout(new java.awt.BorderLayout());
		
		JScrollPane j1 = new JScrollPane();
		
		j1.getViewport().setView(image);
		
		this.add(j1,BorderLayout.CENTER);
		
		JPanel jp1 = new JPanel();
		
		jp1.setLayout(new java.awt.FlowLayout());
		
		jp1.add(startButton);
		startButton.addActionListener(this);
		
		jp1.add(loading);
		
		this.add(jp1,BorderLayout.SOUTH);
		
		setSize(500,500);
		setVisible(true);
		
		
		}
	public static void main(String args[]){
		new Console();
	}
	
	
	
		
	File selectFile = null;
	
public class Image extends Thread{
		
		
		public void run(){
			File[] fs = selectFile.listFiles();
			loading.setMaximum(fs.length);
			int index = 0;
			
			for(File file :fs){
				image.setIcon(new ImageIcon(file.getPath()));
				loading.setValue(++index);
				
				try{
					Thread.sleep(500);
				}
				catch(Exception e){
					
				}
				}
			}
		}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		JFileChooser jf = new JFileChooser();
		
		jf.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		jf.showOpenDialog(this);
		
		selectFile = jf.getSelectedFile();
		
		new Image().start();
		
	}

}
