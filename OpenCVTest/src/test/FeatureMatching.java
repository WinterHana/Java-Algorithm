package test;
// https://www.tutorialspoint.com/how-to-compare-two-images-using-java-opencv-library
import org.opencv.core.*;
import org.opencv.features2d.*;
import org.opencv.imgcodecs.Imgcodecs;

public class FeatureMatching {
    public static void main(String[] args) {
        String filename1 = "C:\\Project\\Java-Algorithm\\OpenCVTest\\src\\test\\NaverOriginal.png";
        String filename2 = "C:\\Project\\Java-Algorithm\\OpenCVTest\\src\\test\\NaverModified.png";

        int ret;
        ret = compareFeatrue(filename1, filename2);
    }

    /**
     * Feature mapping을 이용해서 두 이미지가 비슷한지 확인합니디.
     * @param filename1 : 첫번째 이미지
     * @param filename2 : 두번째 이미지
     * @return integer : 이미지들 사이의 유사도를 반환합니다.
     */

    public static int compareFeatrue(String filename1, String filename2) {
        int retVal = 0;
        long startTime = System.currentTimeMillis();

        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        // 이미지를 Load 합니다
        Mat img1 = Imgcodecs.imread(filename1, Imgcodecs.IMREAD_ANYCOLOR);
        Mat img2 = Imgcodecs.imread(filename1, Imgcodecs.IMREAD_ANYCOLOR);

        // 이미지의 Key point를 선언합니다.
        MatOfKeyPoint keyPoint1 = new MatOfKeyPoint();
        MatOfKeyPoint keyPoint2 = new MatOfKeyPoint();

        Mat descriptors1 = new Mat();
        Mat descriptors2 = new Mat();

        // ORB key point detector와 descriptor extractors를 정의합니다.
        FeatureDetector detector = FeatureDetector.create(FeatureDetector.AKAZE);
        DescriptorExtractor extractor = DescriptorExtractor.create(DescriptorExtractor.AKAZE);

        // keyPoint를 찾습니다.
        detector.detect(img1, keyPoint1);
        detector.detect(img2, keyPoint2);

        // 추출기를 계산합니다.
        extractor.compute(img1, keyPoint1, descriptors1);
        extractor.compute(img2, keyPoint2, descriptors2);

        // descriptor matcher를 정의합니다.
        DescriptorMatcher matcher = DescriptorMatcher.create(DescriptorMatcher.BRUTEFORCE_HAMMING);

        // 두 이미지를 비교하기 위한 객체를 생성합니다.
        MatOfDMatch matches = new MatOfDMatch();

        if(descriptors2.cols() == descriptors1.cols()) {
            matcher.match(descriptors1, descriptors2, matches);

            DMatch[] match = matches.toArray();;
            double max_dist = 0;
            double min_dist = 100;

            for(int i = 0; i < descriptors1.rows(); i++) {
                double dist= match[i].distance;
                if(dist < min_dist) min_dist = dist;
                if(dist > max_dist) max_dist = dist;
            }

            System.out.println("max_dist = " + max_dist + ", min_dist = " + min_dist );

            for(int i = 0; i < descriptors1.rows(); i++) {
                if(match[i].distance <= 10) {
                    retVal++;
                }
            }
            System.out.println("matching count = " + retVal);
        }

        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("estimatedTime = " + estimatedTime + " ms");

        return retVal;


    }
}
