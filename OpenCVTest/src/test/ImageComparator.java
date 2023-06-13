package test;

import org.opencv.core.*;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.util.ArrayList;
import java.util.List;

public class ImageComparator {
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        String originalPath = "C:\\Project\\Java-Algorithm\\OpenCVTest\\src\\test\\NaverOriginal.png";
        String modifiedPath = "C:\\Project\\Java-Algorithm\\OpenCVTest\\src\\test\\NaverModified.png";

        Mat original = Imgcodecs.imread(originalPath);
        Mat modified = Imgcodecs.imread(modifiedPath);

        // 크기가 맞지 않다면 다시 맞춰준다.
        if (original.width() != modified.width() || original.height() != modified.height()) {
            Imgproc.resize(modified, modified, original.size(), 0, 0, Imgproc.INTER_AREA);
        }

        Mat grayOriginal = new Mat(original.size(), CvType.CV_8UC1);
        Mat grayModified = new Mat(modified.size(), CvType.CV_8UC1);

        Imgproc.cvtColor(original, grayOriginal, Imgproc.COLOR_BGR2GRAY);
        Imgproc.cvtColor(modified, grayModified, Imgproc.COLOR_BGR2GRAY);

        Mat diff = new Mat();
        Core.absdiff(grayOriginal, grayModified, diff);

        Mat thresh = new Mat();
        Imgproc.threshold(diff, thresh, 30, 255, Imgproc.THRESH_BINARY_INV);

        HighGui.imshow("Test", thresh);

        List<MatOfPoint> contours = new ArrayList<>();
        Mat hierarchy = new Mat();
        Imgproc.findContours(thresh, contours, hierarchy, Imgproc.RETR_LIST, Imgproc.CHAIN_APPROX_SIMPLE);


        int count = 0;
        int areaControl = 40;             // 사각형을 그리는 정도를 판단하는 파라미터
        for (int i = 0; i < contours.size(); i++) {
            double area = Imgproc.contourArea(contours.get(i));
            if (area > areaControl) {
                count++;
                Rect rect = Imgproc.boundingRect(contours.get(i));
                Imgproc.rectangle(modified, rect.tl(), rect.br(), new Scalar(255, 0, 0), 1);
            }
        }

        HighGui.imshow("modified", modified);
        HighGui.imshow("original", original);
        HighGui.waitKey();
        HighGui.destroyAllWindows();
    }
}
