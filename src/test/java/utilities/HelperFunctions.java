package utilities;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;

import javax.imageio.ImageIO;

import org.apache.commons.text.RandomStringGenerator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class HelperFunctions {
	
    public RandomStringGenerator Str_Gen = new RandomStringGenerator.Builder().withinRange('a','z').build();
	
	public String nameGenerator(int num) {
		return Str_Gen.generate(num);
	}
	
	public String emailGenerator(int num) {
		return Str_Gen.generate(num)+"@gmail.com";
	}
	
	public String numGenerator(int length) {
		StringBuilder number = new StringBuilder();
		for(int i=0;i<length;i++) {
			number.append((int) (Math.random() * 10) );
		}
		return number.toString();
	}
	
	
	

    // Compare two screenshots
    public boolean compareScreenshots(String expectedPath, String actualPath) throws IOException {
        BufferedImage expectedImg = ImageIO.read(new File(expectedPath));
        BufferedImage actualImg = ImageIO.read(new File(actualPath));

        // First compare dimensions
        if (expectedImg.getWidth() != actualImg.getWidth() ||
            expectedImg.getHeight() != actualImg.getHeight()) {
            System.out.println("❌ Image dimensions do not match!");
            return false;
        }

        // Compare pixel by pixel
        for (int y = 0; y < expectedImg.getHeight(); y++) {
            for (int x = 0; x < expectedImg.getWidth(); x++) {
                if (expectedImg.getRGB(x, y) != actualImg.getRGB(x, y)) {
                    System.out.println("❌ Images differ at position: (" + x + ", " + y + ")");
                    return false;
                }
            }
        }

        System.out.println("✅ Images are identical!");
        return true;
    }

}
