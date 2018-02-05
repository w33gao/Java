//action frame to start the program
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.Toolkit;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JButton;


public class ActionJFrame extends JFrame implements ActionListener{
	public ActionJFrame(){
        //creat the button to start
		JButton jb = new JButton("ScreenShot");
		jb.addActionListener(this);
		this.add(jb);
		this.setSize(100, 60);
		this.setAlwaysOnTop(true);
		this.setVisible(true);
	}
	public static void main(String[] args){
		new ActionJFrame();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		this.setVisible(false);
		
		try{
			
			Thread.sleep(100);
			
			Robot r = new Robot();
			
			Toolkit t =Toolkit.getDefaultToolkit();
			
			int width = t.getScreenSize().width;
			int height = t.getScreenSize().height;
			
			BufferedImage image=r.createScreenCapture(new Rectangle(width,height));
			
			//ImageIO.write(image, "jpeg", new File("/Users/Winston/Desktop/a.png"));
			new ImageJFrame (image);
			
		}
		catch (Exception e2){
			e2.printStackTrace();
		}
		
	}

}
