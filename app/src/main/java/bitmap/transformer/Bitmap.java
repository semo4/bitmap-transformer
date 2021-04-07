package bitmap.transformer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bitmap {

    File bitFile;
    File newBitFile;
    String newName;

    //define the constructor
    public Bitmap (String inputPath, String outputPath, String tranName) {
        this.bitFile = new File(inputPath);
        this.newBitFile = new File(outputPath + "/" + tranName);
        this.newName = tranName;
    }

    //instance methods
    public void bitOutputFile (BufferedImage image) {
        try {

            ImageIO.write(image, "bmp", this.newBitFile);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // convert image to black and white
    public Bitmap blackWhite () {

        try {
            BufferedImage bitOG = ImageIO.read(this.bitFile);

            for(int i=0; i <bitOG.getHeight(); i++) {
                for(int j=0; j<bitOG.getWidth(); j++){
                    Color bitColor = new Color(bitOG.getRGB(i,j));
                    int r = (int)(bitColor.getRed()*0.299);// 0 255
                    int g = (int)(bitColor.getGreen()*0.587);
                    int b = (int)(bitColor.getBlue()*0.114);
                    Color newBitColor = new Color(r+b+g,r+b+g,r+b+g);

                    bitOG.setRGB(j,i,newBitColor.getRGB());
                }
            }
            this.bitOutputFile(bitOG);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    // delete blue color
    public Bitmap bluifyBlue () {
        try {
            BufferedImage bitOG = ImageIO.read(this.bitFile);
            // iterate over all pixels
            for(int i=0; i <bitOG.getHeight(); i++) {
                for(int j=0; j<bitOG.getWidth(); j++){
                    Color bitColor = new Color(bitOG.getRGB(i,j));

                    int green = (int)(bitColor.getGreen());
                    int red = (int)(bitColor.getRed());
                    Color newBitColor = new Color(red, green, 0);

                    bitOG.setRGB(i,j,newBitColor.getRGB());
                }
            }
            this.bitOutputFile(bitOG);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    // delete green color
    public Bitmap bluifyGreen () {
        try {
            BufferedImage bitOG = ImageIO.read(this.bitFile);
            // iterate over all pixels
            for(int i=0; i <bitOG.getHeight(); i++) {
                for(int j=0; j<bitOG.getWidth(); j++){
                    Color bitColor = new Color(bitOG.getRGB(i,j));

                    int blue = (int)(bitColor.getBlue());
                    int red = (int)(bitColor.getRed());
                    Color newBitColor = new Color(red, 0, blue);

                    bitOG.setRGB(i,j,newBitColor.getRGB());
                }
            }
            this.bitOutputFile(bitOG);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    // delete red color
    public Bitmap bluifyRed () {
        try {
            BufferedImage bitOG = ImageIO.read(this.bitFile);
            // iterate over all pixels
            for(int i=0; i <bitOG.getHeight(); i++) {
                for(int j=0; j<bitOG.getWidth(); j++){
                    Color bitColor = new Color(bitOG.getRGB(i,j));

                    int green = (int)(bitColor.getGreen());
                    int blue = (int)(bitColor.getBlue());
                    Color newBitColor = new Color(0, green, blue);

                    bitOG.setRGB(i,j,newBitColor.getRGB());
                }
            }
            this.bitOutputFile(bitOG);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    // flip the image
    public Bitmap mirror () {
        try {
            BufferedImage bitOG = ImageIO.read(this.bitFile);
            // iterate over all pixels
            for(int i=0; i <bitOG.getHeight(); i++) {
                for(int j= bitOG.getWidth() -1; j > bitOG.getWidth() / 2; j--){
                    Color bitColor = new Color(bitOG.getRGB(i,j));

                    bitOG.setRGB(i,bitOG.getWidth() - 1 - j,bitColor.getRGB());
                }
            }
            this.bitOutputFile(bitOG);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
