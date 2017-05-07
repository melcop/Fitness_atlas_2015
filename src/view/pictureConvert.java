package view;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author Pelle & Mikkel
 */
public class pictureConvert {
 
    private static final int IMG_WIDTH = 100;
    private static final int IMG_HEIGHT = 100;
 
    /**
     * This method resize the image to 100*100 pixels
     * @param originalImage
     * @param type
     * @return a resized image
     */
    public static BufferedImage resizeImage(BufferedImage originalImage, int type){
	BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
	Graphics2D g = resizedImage.createGraphics();
	g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
	g.dispose();
 
	return resizedImage;
    }	
}
