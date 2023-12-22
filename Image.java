import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
//import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;
//import java.awt.*;
import java.awt.Color;
//imported libraries use of image files

public class Image {
	
	private static String Loc;
	BufferedImage JPEGimage = null; //new image not created (first set to null)
	File f = null; //new file not created (first set to null)
	
	//put and get methods:
	
	public void putLoc(String x) {
		
		Loc = x;
	}
	
	public String getLoc() {
		
		return Loc;
	}
	
	//constructor:
	
	public Image(String location) {
		
		Image.Loc = location;
	}
	
	//instance methods:
	
	public void readIn() {
		
		//both BufferedImage and File are classes which have instance methods. Their constructors are used untraditionally
		//to specify the type of file that needs to be read
		
		try { //reads in image file
		
		f = new File(Image.Loc);// specifying an image file using constructor of File class
		JPEGimage = new BufferedImage(500, 500, BufferedImage.TYPE_INT_ARGB);
		//BufferedImage class constructor used to establish characteristics of image file specified by new File variable
		
		JPEGimage = ImageIO.read(f);//read in image file specified by new File variable and established dimensions 
		//System.out.println("Reading Complete.");
		
		}catch(IOException e) { //catches errors without crashing program
			
			System.out.println("Error: "+e);
		}
	}
	
	public void Output(String outputURL) {
		
		try { //outputs an image file
			
			f = new File(outputURL); // specifying a new image file using constructor of File class
			ImageIO.write(JPEGimage, "jpg", f); //writes new image which takes image, format, and file information to output image
		//	System.out.println("Writing complete.");
		
		}catch(IOException e) { //catches errors without crashing program
			
			System.out.println("Error: "+e);
		}
	}
	
	public void Brighten(int amount) {
		
		for (int i = 0; i < JPEGimage.getWidth(); i++) { //iterates through each pixel
			for(int k = 0; k < JPEGimage.getHeight(); k++) { 
				
				int pixCol = JPEGimage.getRGB(i, k); //returns long bit value (takes x and y coordinate of pixel)
				Color colour = new Color(pixCol); //constructor can take bit of pixel RGB value
				
				int newRed = Math.min(255, colour.getRed() + amount); //alters brightness
                int newGreen = Math.min(255, colour.getGreen() + amount);
                int newBlue = Math.min(255, colour.getBlue() + amount);
                
                int newRGB = (newRed << 16) | (newGreen << 8) | newBlue; //converts the new RGB values back to bit integer 
                JPEGimage.setRGB(i, k, newRGB); //sets coordinate pixel to have newly generated colour
			}
		}
	}
	
	public void Darken(int amount) {
		
		for (int i = 0; i < JPEGimage.getWidth(); i++) { //iterates through each pixel
			for(int k = 0; k < JPEGimage.getHeight(); k++) { 
				
				int pixCol = JPEGimage.getRGB(i, k); //returns long bit value (takes x and y coordinate of pixel)
				Color colour = new Color(pixCol); //constructor can take bit of pixel RGB value
				
				int newRed = Math.max(0, colour.getRed() - amount);				
				int newGreen = Math.max(0, colour.getGreen() - amount);	
				int newBlue = Math.max(0, colour.getBlue() - amount);	
				
				int newRGB = (newRed << 16) | (newGreen << 8) | newBlue; //converts the new RGB values back to bit integer 
                JPEGimage.setRGB(i, k, newRGB); //sets coordinate pixel to have newly generated colour	
			}
		}
	}

	
	
	

	
	
	

	

	

	
	

	
	
	
	

}
