package test;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class CompareImagesPixel {
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        Mat image1 = Imgcodecs.imread("C:\\Project\\Java-Algorithm\\OpenCVTest\\src\\test\\NaverOriginal.png");
        Mat image2 = Imgcodecs.imread("C:\\Project\\Java-Algorithm\\OpenCVTest\\src\\test\\NaverModified.png");

        Mat diff = new Mat();
        Core.absdiff(image1, image2, diff);
        Mat reshaped = diff.reshape(1);
        int nonZeroPixels = Core.countNonZero(reshaped);

        System.out.println("다른 픽셀의 수 : " + nonZeroPixels);

        if (nonZeroPixels == 0) {
            System.out.println("동일한 이미지입니다..");
        } else {
            System.out.println("다른 이미지입니다. 다른 픽셀의 개수 : " + nonZeroPixels);
        }

    }
}
