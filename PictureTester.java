/**
 * This class contains class (static) methods that will help you test the
 * Picture class methods. Uncomment the methods and the code in the main to
 * test.
 *
 * @author Barbara Ericson
 */
public class PictureTester {

    /**
     * Method to test the PictureExplorer
     */
    public static void testExplorer() {
        Picture prime = new Picture("transformersPrime.jpg");
        Picture smallPrime = prime.scale(1.5,1.5);
        smallPrime.write("smallMyPicture.jpg"); 
        smallPrime.explore();
    }

    /**
     * Method to test zeroBlue
     */
    public static void testZeroBlue() {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.zeroBlue();
        beach.explore();
    }

    /**
     * method to test keepOnlyBlue
     */
    public static void testKeepOnlyBlue() {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.keepOnlyBlue();
        beach.explore();
    }

    /**
     * method to test keepOnlyRed
     */
    public static void testKeepOnlyRed() {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.keepOnlyRed();
        beach.explore();
    }

    /**
     * method to test keepOnlyGreen
     */
    public static void testKeepOnlyGreen() {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.keepOnlyGreen();
        beach.explore();
    }

    /**
     * method to test negate
     */
    public static void testNegate() {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.negate();
        beach.explore();
    }

    /** 
     * a method that tests grayscale
     */
    public static void testGrayscale() {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.grayscale();
        beach.explore(); 
    }
    /**
     * a method to test fixing underwater
     */
    public static void testFixUnderwater() {
        Picture beach = new Picture("water.jpg");
        beach.explore();
        beach.FixUnderwater();
        beach.explore(); 
    }

    /**
     * Method to test mirrorVertical
     */
    public static void testMirrorVertical() {
        Picture caterpillar = new Picture("caterpillar.jpg");
        caterpillar.explore();
        caterpillar.mirrorVertical();
        caterpillar.explore();
    }

    /**
     * method to test mirrorVerticalRightToLeft
     */
    public static void testMirrorVerticalRightToLeft() {
        Picture caterpillar = new Picture("caterpillar.jpg");
        caterpillar.explore();
        caterpillar.mirrorVerticalRightToLeft();
        caterpillar.explore();
    }

    /**
     * method to test mirrorHorizontal
     */
    public static void testMirrorHorizontal() {
        Picture caterpillar = new Picture("redMotorcycle.jpg");
        caterpillar.explore();
        caterpillar.mirrorHorizontal();
        caterpillar.explore();
    }

    /**
     * method to test mirrorHorizontal bottom to top
     */
    public static void testMirrorHorizontalBottomToTop() {
        Picture caterpillar = new Picture("redMotorcycle.jpg");
        caterpillar.explore();
        caterpillar.mirrorHorizontalBottomToTop();
        caterpillar.explore();
    }

    /**
     * method to test mirrorHorizontal bottom to top
     */
    public static void testMirrorDiagonal() {
        Picture caterpillar = new Picture("beach.jpg");
        caterpillar.explore();
        caterpillar.mirrorDiagonal();
        caterpillar.explore();
    }

    /**
     * Method to test mirrorTemple
     */
    public static void testMirrorTemple() {
        Picture temple = new Picture("temple.jpg");
        temple.explore();
        temple.mirrorTemple();
        temple.explore();
    }

    /**
     * Method to test mirrorArms
     */
    public static void testMirrorArms() {
        Picture temple = new Picture("snowman.jpg");
        temple.explore();
        temple.mirrorArms();
        temple.explore();
    }

    /**
     * Method to test mirrorGulls
     */
    public static void testMirrorGull() {
        Picture temple = new Picture("seagull.jpg");
        temple.explore();
        temple.mirrorGull();
        temple.explore();
    }

    /**
     * method to test encode and decode
     */
    public static void testEncodeAndDecode() {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.encode();
        beach.explore();
        beach.decode();
        beach.explore();
    }

    /**
     * Method to test edgeDetection
     */
    public static void testEdgeDetection() {
        Picture swan = new Picture("swan.jpg");
        swan.edgeDetection(10);
        swan.explore();
    }

    /**
     * Method to test scaling a picture
     */
    public static void testScale() {
        Picture temple = new Picture("temple.jpg");
        temple.explore();
        Picture temple2 = temple.scale(0.5, 0.5);
        temple2.explore();
    }

    /**
     * Main method for testing. Every class can have a main method in Java
     */
    public static void main(String[] args) {
        // uncomment a call here to run a test
        // and comment out the ones you don't want
        // to run

        //testExplorer();
        //testScale();
        //testZeroBlue();
        //testKeepOnlyBlue();
        //testKeepOnlyRed();
        //testKeepOnlyGreen();
        //testNegate();
        //testGrayscale();
        //testFixUnderwater();
        //testMirrorVertical();
        //testMirrorVerticalRightToLeft();
        //testMirrorHorizontal();
        //testMirrorHorizontalBottomToTop();
        //testMirrorDiagonal();
        //testMirrorTemple();
        //testMirrorArms();
        //testMirrorGull();
        //testMirrorDiagonal();
        //testCollage();
        //testCopy();
        //testEdgeDetection();
        //testEdgeDetection2();
        //testChromakey();
        testEncodeAndDecode();
        //testGetCountRedOverValue(250);
        //testSetRedToHalfValueInTopHalf();
        //testClearBlueOverValue(200);
        //testGetAverageForColumn(0);
    }
}
