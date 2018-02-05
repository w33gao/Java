//main for the vedio recording program
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;


public class Main extends JFrame implements ActionListener{
	//start and stop buttons for the tool
	JButton startButton = new JButton("Start");
	JButton stopButton = new JButton("Stop");
	
	public Main() {
		
		add(startButton);
		add(stopButton);
		
		startButton.addActionListener(this);
		stopButton.addActionListener(this);
		//set layout and title
		setLayout(new java.awt.FlowLayout());
		
		setTitle ("ScreenRecord Winston");
		
		setResizable(false);
		
		setBounds(100,100,200,60);
	}
	
	public static void main(String[] args){
		new Main().setVisible(true);
	}

	File selectFile = null;
	
	boolean state = false;

	public class GetImage extends Thread{
	  public void run(){
	    try {
	    	Robot r = new Robot();
	    	Toolkit toolk = Toolkit.getDefaultToolkit();
	    	int w = toolk.getScreenSize().width;
	    	int h = toolk.getScreenSize().height;
	    	//where to record the pictures
			while (state){
			BufferedImage image= 	r.createScreenCapture(new Rectangle(w,h));
			ImageIO.write(image,"jpeg",new File(selectFile, new Date().getTime() + ".png"));
			Thread.sleep(500);
			}
			
		}
		catch (Exception e){
			
		}
	  }
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (startButton == e.getSource()){
			JFileChooser f = new JFileChooser();
			f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			f.showSaveDialog(this);
			//file selection
			selectFile = f.getSelectedFile();
			selectFile.mkdirs();
			state = true;
			new GetImage().start();
		}
		else if (stopButton == e.getSource()){
			
			state = false;
		}
		
		
	}

}
