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

	public void Blur(int blurLvl) { //changes the colour scheme/theme of an image by averaging pixels
		
	
	for (int y = 0; y < blurLvl; y++) {	
		for(int i = 2; i <JPEGimage.getWidth()-2; i++) {
			for(int k = 2; k < JPEGimage.getHeight()-2; k++) {
				
				int CurpixCol = JPEGimage.getRGB(i, k); //the current pixel you are on
				Color colour = new Color(CurpixCol);
				
				
				int pixCol0 = JPEGimage.getRGB(i-1, k+1);
				Color colour0 = new Color(pixCol0);
				
				int pixCol1 = JPEGimage.getRGB(i, k+1);
				Color colour1 = new Color(pixCol1);
				
				int pixCol2 = JPEGimage.getRGB(i+1, k+1);
				Color colour2 = new Color(pixCol2);

				int pixCol3 = JPEGimage.getRGB(i-1, k);
				Color colour3 = new Color(pixCol3);

				int pixCol4 = JPEGimage.getRGB(i+1, k);
				Color colour4 = new Color(pixCol4);

				int pixCol5 = JPEGimage.getRGB(i-1, k-1);
				Color colour5 = new Color(pixCol5);

				int pixCol6 = JPEGimage.getRGB(i, k-1);
				Color colour6 = new Color(pixCol6);

				int pixCol7 = JPEGimage.getRGB(i+1, k-1);
				Color colour7 = new Color(pixCol7);
				
				
				int pixCol8 = JPEGimage.getRGB(i-2, k+2);
		        Color colour8 = new Color(pixCol8);

		        int pixCol9 = JPEGimage.getRGB(i-1, k+2);
		        Color colour9 = new Color(pixCol9);

		        int pixCol10 = JPEGimage.getRGB(i, k+2);
		        Color colour10 = new Color(pixCol10);

		        int pixCol11 = JPEGimage.getRGB(i+1, k+2);
		        Color colour11 = new Color(pixCol11);

		        int pixCol12 = JPEGimage.getRGB(i+2, k+2);
		        Color colour12 = new Color(pixCol12);

		        int pixCol13 = JPEGimage.getRGB(i-2, k+1);
		        Color colour13 = new Color(pixCol13);

		        int pixCol14 = JPEGimage.getRGB(i+2, k+1);
		        Color colour14 = new Color(pixCol14);

		        int pixCol15 = JPEGimage.getRGB(i-2, k);
		        Color colour15 = new Color(pixCol15);

		        int pixCol16 = JPEGimage.getRGB(i+2, k);
		        Color colour16 = new Color(pixCol16);

		        int pixCol17 = JPEGimage.getRGB(i-2, k-1);
		        Color colour17 = new Color(pixCol17);

		        int pixCol18 = JPEGimage.getRGB(i+2, k-1);
		        Color colour18 = new Color(pixCol18);

		        int pixCol19 = JPEGimage.getRGB(i-2, k-2);
		        Color colour19 = new Color(pixCol19);

		        int pixCol20 = JPEGimage.getRGB(i-1, k-2);
		        Color colour20 = new Color(pixCol20);

		        int pixCol21 = JPEGimage.getRGB(i, k-2);
		        Color colour21 = new Color(pixCol21);

		        int pixCol22 = JPEGimage.getRGB(i+1, k-2);
		        Color colour22 = new Color(pixCol22);

		        int pixCol23 = JPEGimage.getRGB(i+2, k-2);
		        Color colour23 = new Color(pixCol23);
				
				int surpixRed [] = {colour0.getRed(), colour1.getRed(), colour2.getRed(),
					 				colour3.getRed(),  colour.getRed(), colour4.getRed(),
					 				colour5.getRed(), colour6.getRed(), colour7.getRed(),
					 				
					 				colour8.getRed(), colour9.getRed(), colour10.getRed(),
					 	            colour11.getRed(), colour12.getRed(), colour13.getRed(),
					 	            colour14.getRed(), colour15.getRed(), colour16.getRed(),
					 	            colour17.getRed(), colour18.getRed(), colour19.getRed(),
					 	            colour20.getRed(), colour21.getRed(), colour22.getRed(),
					 	            colour23.getRed()};
					 				
					 		
				
				int surpixGreen [] = {colour0.getGreen(), colour1.getGreen(), colour2.getGreen(),
		 							  colour3.getGreen(),  colour.getGreen(), colour4.getGreen(),
		 							  colour5.getGreen(), colour6.getGreen(), colour7.getGreen(),
		 							  
		 							  colour8.getGreen(), colour9.getGreen(), colour10.getGreen(),
			 				          colour11.getGreen(), colour12.getGreen(), colour13.getGreen(),
			 				          colour14.getGreen(), colour15.getGreen(), colour16.getGreen(),
			 				          colour17.getGreen(), colour18.getGreen(), colour19.getGreen(),
			 				          colour20.getGreen(), colour21.getGreen(), colour22.getGreen(),
			 				          colour23.getGreen()};
				
				int surpixBlue [] = {colour0.getBlue(), colour1.getBlue(), colour2.getBlue(),
		 							 colour3.getBlue(),  colour.getBlue(), colour4.getBlue(),
		 							 colour5.getBlue(), colour6.getBlue(), colour7.getBlue(),
		 							 
		 							colour8.getBlue(), colour9.getBlue(), colour10.getBlue(),
		 				            colour11.getBlue(), colour12.getBlue(), colour13.getBlue(),
		 				            colour14.getBlue(), colour15.getBlue(), colour16.getBlue(),
		 				            colour17.getBlue(), colour18.getBlue(), colour19.getBlue(),
		 				            colour20.getBlue(), colour21.getBlue(), colour22.getBlue(),
		 				            colour23.getBlue()};
				  
				int totRed = 0;
				int totGreen = 0;
				int totBlue = 0;
				for (int x = 0; x < surpixRed.length; x++) {
					
					totRed = totRed + surpixRed[x];
					totGreen = totGreen + surpixGreen[x];
					totBlue = totBlue + surpixBlue[x];
				}
				
				int avgRed = (totRed) / 25; 
				int avgGreen = (totGreen) / 25;
				int avgBlue = (totBlue) / 25;
				
				int newRGB = (avgRed << 16) | (avgGreen << 8) | avgBlue; //converts the new RGB values back to bit integer 
				JPEGimage.setRGB(i, k, newRGB); //sets coordinate pixel to have newly generated colour
				
				
				
				
				
				
				
				
				
				
				
				
				
				}
				
				
			}
			
			
		}
	}
		
		
	

	
	
	

	
	
	

	

	
	
	

	
	
	

	

	

	
	

	
	
	
	

}
