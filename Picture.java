import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.geom.AffineTransform;

/**
 * A class that represents a picture. This class inherits from SimplePicture and
 * allows the student to add functionality to the Picture class.
 *
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture {
    ///////////////////// constructors //////////////////////////////////

    /**
     * Constructor that takes no arguments
     */
    public Picture() {
        /* not needed but use it to show students the implicit call to super()
         * child constructors always call a parent constructor 
         */
        super();
    }

    /**
     * Constructor that takes a file name and creates the picture
     *
     * @param fileName the name of the file to create the picture from
     */
    public Picture(String fileName) {
        // let the parent class handle this fileName
        super(fileName);
    }

    /**
     * Constructor that takes a file name and creates the picture
     *
     * @param file the name of the file to create the picture from
     */
    public Picture(java.io.File file) {
        // let the parent class handle this fileName
        super(file);
    }

    /**
     * Constructor that takes the width and height
     * 
     * @param height the height of the desired picture
     * @param width the width of the desired picture
     */
    public Picture(int width, int height) {
        // let the parent class handle this width and height
        super(width, height);
    }

    /**
     * Constructor that takes a picture and creates a copy of that picture
     *
     * @param copyPicture the picture to copy
     */
    public Picture(SimplePicture copyPicture) {
        // let the parent class do the copy
        super(copyPicture);
    }

    /**
     * Constructor that takes a buffered image
     *
     * @param image the buffered image to use
     */
    public Picture(BufferedImage image) {
        super(image);
    }

    ////////////////////// methods ///////////////////////////////////////
    /**
     * Method to return a string with information about this picture.
     *
     * @return a string with information about the picture such as fileName,
     * height and width.
     */
    public String toString() {
        String output = "Picture, filename " + getFileName()
            + " height " + getHeight()
            + " width " + getWidth();
        return output;

    }

    /**
     * Method to create a new picture by scaling the current picture by the given
     * x and y factors
     *
     * @param xFactor the amount to scale in x
     * @param yFactor the amount to scale in y
     * @return the resulting picture
     */
    public Picture scale(double xFactor, double yFactor) {
        // set up the scale transform
        AffineTransform scaleTransform = new AffineTransform();
        scaleTransform.scale(xFactor, yFactor);

        // create a new picture object that is the right size
        Picture result = new Picture((int) (getWidth() * xFactor),
                (int) (getHeight() * yFactor));

        // get the graphics 2d object to draw on the result
        Graphics graphics = result.getGraphics();
        Graphics2D g2 = (Graphics2D) graphics;

        // draw the current image onto the result image scaled
        g2.drawImage(this.getImage(), scaleTransform, null);

        result.setTitle(getTitle());
        return result;
    }

    /**
     * Method to set the blue to 0
     */
    public void zeroBlue() {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                pixelObj.setBlue(0);
            }
        }
    }

    /**
     * keeps only blue in this image
     */
    public void keepOnlyBlue() {
        zeroGreen();
        zeroRed(); 
    }

    /**
     * Removes all the red from this image.
     */
    public void zeroRed() {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                pixelObj.setRed(0);
            }
        }
    }

    /**
     * keeps only red in this image
     */
    public void keepOnlyRed() {
        zeroGreen();
        zeroBlue(); 
    }

    /**
     * Removes all the green from this image.
     */
    public void zeroGreen() {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                pixelObj.setGreen(0);
            }
        }  
    }

    /**
     * keeps only green in this image
     */
    public void keepOnlyGreen() {
        zeroRed();
        zeroBlue(); 
    }

    /**
     * method that creates a negative picture
     */
    public void negate() {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                pixelObj.setGreen(255 - pixelObj.getGreen());
                pixelObj.setRed(255 - pixelObj.getRed());
                pixelObj.setBlue(255 - pixelObj.getBlue());
            }
        } 
    }

    /**
     * method to set a picture to greyscale
     */
    public void grayscale() {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                int avg = (pixelObj.getBlue() + pixelObj.getGreen() + pixelObj.getRed())/3;
                pixelObj.setGreen(avg);
                pixelObj.setRed(avg);
                pixelObj.setBlue(avg);
            }
        } 
    }
    public void blackAndWhite() {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                int avg = (pixelObj.getBlue() + pixelObj.getGreen() + pixelObj.getRed())/3;
                if(avg >= 127) {
                    pixelObj.setGreen(255);
                    pixelObj.setRed(255);
                    pixelObj.setBlue(255);
                } else {
                    pixelObj.setGreen(0);
                    pixelObj.setRed(0);
                    pixelObj.setBlue(0); 
                }
            }
        } 
    }

    public void FixUnderwater() {
        Pixel[][] pixels = this.getPixels2D();
        float mostRed = 0;
        float mostBlue = 0;
        float mostGreen = 0;
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                if(pixelObj.getRed() > mostRed) {
                    mostRed = pixelObj.getRed();
                }
                if(pixelObj.getGreen() > mostGreen) {
                    mostGreen = pixelObj.getGreen();
                }
                if(pixelObj.getBlue() > mostBlue) {
                    mostBlue = pixelObj.getBlue();
                }
            }
        } 
        mostRed = (225/mostRed);
        mostGreen = (225/mostGreen);
        mostBlue = (225/mostBlue);
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                pixelObj.setGreen(Math.round(pixelObj.getGreen() * mostGreen));
                pixelObj.setRed(Math.round(pixelObj.getRed() * mostRed));
                pixelObj.setBlue(Math.round(pixelObj.getBlue() * mostBlue));
            }
        } 
    }

    /**
     * Method that mirrors the picture around a vertical mirror in the center of
     * the picture from left to right
     */
    public void mirrorVertical() {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < width / 2; col++) {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }
    /**
     * Method that mirrors the picture around a vertical mirror in the center of
     * the picture from right to left
     */
    public void mirrorVerticalRightToLeft() {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < width / 2; col++) {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                leftPixel.setColor(rightPixel.getColor());
            }
        }
    }

    /**
    creates a horizontal mirror imafe of itself
    */
    public void mirrorHorizontal() {
        Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel = null;
        Pixel botPixel = null;
        int height = pixels.length;
        for (int col = 0; col < pixels[0].length; col++) {
            for (int row = 0; row < height / 2; row++) {
                topPixel = pixels[row][col];
                botPixel = pixels[height - 1 - row][col];
                botPixel.setColor(topPixel.getColor());
            }
        }
    }

    /**
    creates a horizontal mirror imafe of itself bot to top
    */
    public void mirrorHorizontalBottomToTop() {
        Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel = null;
        Pixel botPixel = null;
        int height = pixels.length;
        for (int col = 0; col < pixels[0].length; col++) {
            for (int row = 0; row < height / 2; row++) {
                topPixel = pixels[row][col];
                botPixel = pixels[height - 1 - row][col];
                topPixel.setColor(botPixel.getColor());
            }
        }
    }

    /**
    creates a horizontal mirror imafe of itself
    */
    public void mirrorDiagonal() {
        Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel = null;
        Pixel botPixel = null;
        int measure = 0;
        if(pixels.length < pixels[0].length) {
            measure = pixels.length;
        } else {
            measure = pixels[0].length;
        }
        
        for (int col = 0; col < pixels.length; col++) {
            for (int row = measure/2; row < measure; row++) {
                topPixel = pixels[col][row];
                botPixel = pixels[measure - 1 - row][col];
                botPixel.setColor(topPixel.getColor());
            }
        }
    }

    /**
     * Mirror just part of a picture of a temple
     */
    public void mirrorTemple() {
        int mirrorPoint = 276;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int count = 0;
        Pixel[][] pixels = this.getPixels2D();

        // loop through the rows
        for (int row = 27; row < 97; row++) {
            // loop from 13 to just before the mirror point
            for (int col = 13; col < mirrorPoint; col++) {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
                rightPixel.setColor(leftPixel.getColor());
                count++;
            }
        }
        System.out.println(count);
    }
    
    /**
     * mirror part of a snowman
     */
    public void mirrorArms() {
        int mirrorPoint = 200;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        // loop through the rows
        for (int row = 170; row < mirrorPoint; row++) {
            // loop from 13 to just before the mirror point
            for (int col = 100; col < 300; col++)
             {
                leftPixel = pixels[row][col];
                rightPixel = pixels[mirrorPoint - row + mirrorPoint][col];
                rightPixel.setColor(leftPixel.getColor());
            }
         }
    }

    /**
    * mirror part of a snowman
    */
    public void mirrorGull() {
        int mirrorPoint = 345;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        // loop through the rows
        for (int row = 230; row < 320; row++) {
            // loop from 13 to just before the mirror point
            for (int col = 240; col < mirrorPoint; col++)
             {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
                rightPixel.setColor(leftPixel.getColor());
            }
         }
    }
    
    public void encode() {
        Pixel[][] pixels = this.getPixels2D();
        Picture msg = new Picture("msg.jpg");
        Pixel[][] msgPixels = msg.getPixels2D();
        for (int row = 0; row < msgPixels.length; row++) {
            for (int col = 0; col < msgPixels[0].length; col++) {
                if(pixels[row][col].getRed() % 2 == 1) {
                    pixels[row][col].setRed(pixels[row][col].getRed() - 1);
                }
            }
        }
        for (int row = 0; row < msgPixels.length; row++) {
            for (int col = 0; col < msgPixels[0].length; col++) {
                if(msgPixels[row][col].getRed() < 225) {
                    pixels[row][col].setRed(pixels[row][col].getRed() + 1);
                }
            }
        }
    }

    /**
    * method to reveal a message in a picture 
    */
    public void decode() {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                if(pixelObj.getRed() % 2 == 1) {
                    pixelObj.setRed(0);
                    pixelObj.setBlue(0);
                    pixelObj.setGreen(0);
                } else {
                    pixelObj.setRed(255);
                    pixelObj.setBlue(255);
                    pixelObj.setGreen(255);
                }
            }  
        } 
    }

    /**
     * copy from the passed fromPic to the specified startRow and startCol in the
     * current picture
     *
     * @param fromPic the picture to copy from
     * @param startRow the start row to copy to
     * @param startCol the start col to copy to
     */
    public void copy(Picture fromPic, int startRow, int startCol) {
        Pixel fromPixel = null;
        Pixel toPixel = null;
        Pixel[][] toPixels = this.getPixels2D();
        Pixel[][] fromPixels = fromPic.getPixels2D();
        for (int fromRow = 0, toRow = startRow;
        fromRow < fromPixels.length
        && toRow < toPixels.length;
        fromRow++, toRow++) {
            for (int fromCol = 0, toCol = startCol;
            fromCol < fromPixels[0].length
            && toCol < toPixels[0].length;
            fromCol++, toCol++) {
                fromPixel = fromPixels[fromRow][fromCol];
                toPixel = toPixels[toRow][toCol];
                toPixel.setColor(fromPixel.getColor());
            }
        }
    }

    /**
     * 
     * @param fromPic The source image we are copying from
     * @param destRow the start row to copy to
     * @param destCol the start col to copy to
     * @param fromRow The start row of fromPic
     * @param fromCol The start col of fromPic
     * @param w Width of the area we wish to copy.
     * @param h Height of the area we wish to copy.
     */
    public void copy(Picture fromPic,int destRow, int destCol, int fromRow, int fromCol, int w, int h) {
        //TODO: Write and test this method
    }

    /**
     * Method to show large changes in color
     *
     * @param edgeDist the distance for finding edges
     */
    public void edgeDetection(int edgeDist) {
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        Color rightColor = null;
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0;
            col < pixels[0].length - 1; col++) {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][col + 1];
                rightColor = rightPixel.getColor();
                if (leftPixel.colorDistance(rightColor)
                > edgeDist)
                    leftPixel.setColor(Color.BLACK);
                else
                    leftPixel.setColor(Color.WHITE);
            }
        }
    }

    /* Main method for testing - each class in Java can have a main 
     * method 
     */
    public static void main(String[] args) {
        Picture beach = new Picture("beach.jpg");
        
    }

} // this } is the end of class Picture, put all new methods before this
