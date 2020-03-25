package JTableEX2;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Tab_2_Canvas extends Canvas {

	Image img;
	String imgSourcePath = "1.jpg";
	String imgTargetPath = "11.jpg";
	String imgFormat ="jpg";
	int newWidth=600;
	int newHeight=350;

	public void paint(Graphics g) {
		
		imgResize(imgSourcePath, imgTargetPath, imgFormat, newWidth, newHeight);

		Toolkit tk = Toolkit.getDefaultToolkit();
		img = tk.getImage(imgTargetPath);

		g.drawImage(img, 0, 0, this);
	}
	
	public void imgResize(String imgSourcePath,
			              String imgTargetPath,
			              String imgFormat,
			              int newWidth, int newHeight) {
		try {
			Image imgSrc = ImageIO.read(new File(imgSourcePath));
			Image resizeImg = imgSrc.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
			BufferedImage newImage = new BufferedImage(newWidth, newHeight,
					BufferedImage.TYPE_INT_RGB);
			Graphics g = newImage.getGraphics();
			g.drawImage(resizeImg,0,0,null);
			g.dispose();
			ImageIO.write(newImage, imgFormat, new File(imgTargetPath));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
			              

}













