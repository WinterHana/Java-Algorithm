package test;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfFloat;
import org.opencv.core.MatOfInt;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.util.ArrayList;
import java.util.List;

// https://blog.acronym.co.kr/580
public class ImageCompareScore {
    public static void main(String[] args) {
        String file1 = "C:\\Project\\Java-Algorithm\\OpenCVTest\\src\\test\\NaverOriginal.png";
        String file2 = "C:\\Project\\Java-Algorithm\\OpenCVTest\\src\\test\\NaverModified.png";

        int ret = compareHistogram(file1, file2);
    }

    /**
     *
     */

    public static int compareHistogram(String file1, String file2) {
        int retVal = 0;

        long startTime = System.currentTimeMillis();

        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        // 사진 업로드
        Mat img1 = Imgcodecs.imread(file1, Imgcodecs.IMREAD_COLOR);
        Mat img2 = Imgcodecs.imread(file2, Imgcodecs.IMREAD_COLOR);

        Mat hsvImg1 = new Mat();
        Mat hsvImg2 = new Mat();

        // 기존 사진의 색상 변경
        Imgproc.cvtColor(img1, hsvImg1,Imgproc.COLOR_BGR2HSV);
        Imgproc.cvtColor(img2, hsvImg2,Imgproc.COLOR_BGR2HSV);

        // 리스트로 받아서 저장한다.
        List<Mat> listImg1 = new ArrayList<Mat>();
        List<Mat> listImg2 = new ArrayList<Mat>();

        listImg1.add(hsvImg1);
        listImg2.add(hsvImg2);

        MatOfFloat ranges = new MatOfFloat(0, 255);
        MatOfInt histSize = new MatOfInt(50);
        MatOfInt channels = new MatOfInt(0);
        
        // 히스토그램 변경
        Mat histImg1 = new Mat();
        Mat histImg2 = new Mat();

        Imgproc.calcHist(listImg1, channels, new Mat(), histImg1, histSize, ranges);
        Imgproc.calcHist(listImg2, channels, new Mat(), histImg2, histSize, ranges);

        // 정규화
        Core.normalize(histImg1, histImg1, 0,1, Core.NORM_MINMAX, -1, new Mat());
        Core.normalize(histImg2, histImg2, 0,1, Core.NORM_MINMAX, -1, new Mat());

        double result = Imgproc.compareHist(histImg1, histImg2, 0);

        System.out.println("Method[0] " + result);

        return 0;
    }
}
