
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

//show the image
public class ImageJFrame extends JFrame implements java.awt.event.MouseListener{
	
	BufferedImage image = null;
	
	public ImageJFrame(BufferedImage image){
		this.image = image;//save to property
		Toolkit t = Toolkit.getDefaultToolkit();
		int width = t.getScreenSize().width;
		int height = t.getScreenSize().height;
		this.setSize(width,height);
		this.addMouseListener(this);
		this.setUndecorated(true);
		
		this.setVisible(true);
		
	}
	//Window paint method
    //paint a rectangle to show how bid your image is
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(image, 0, 0, new ImageObserver(){

			@Override
			public boolean imageUpdate(Image arg0, int arg1, int arg2,
					int arg3, int arg4, int arg5) {
				// TODO Auto-generated method stub
				return false;
			}
			
		});
		g.drawRect(x,y,w,h);
		
	}
	@Override
    //mouse operations
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (b&&e.getClickCount()==2){

		try {	
			Robot r = new Robot();
			
			BufferedImage image=r.createScreenCapture(new Rectangle(x+1,y+1,w-1,h-1));
			
			ImageIO.write(image, "jpeg", new File("/Users/Winston/Desktop/a.png"));
			System.exit(0);
			
		}
		catch (Exception e2){
			e2.printStackTrace();
		}
			
		}
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	//mouse operations
	int x,y;
	int w,h;
	boolean b = false;
	public void mousePressed(MouseEvent e) {
		if(b==false){
		x = e.getX();
		y = e.getY();}
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	 if(b==false){	
		w = e.getX()-x; 
		h = e.getY()-y;
		this.repaint(); 
		b = true;
	 }
	}

}
