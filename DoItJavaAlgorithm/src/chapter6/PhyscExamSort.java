package chapter6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PhyscExamSort {
    static class PhyscData {
        String  name;
        int     height;
        double  vision;

        PhyscData(String name, int height, double vision) {
            this.name = name; this.height = height; this.vision = vision;
        }

        public String toString() {
            return name + " " + height + " " + vision;
        }

        static final Comparator<PhyscData> HEIGHT_ORDER = new HeightOrderComparator();

        private static class HeightOrderComparator implements Comparator<PhyscData> {
            @Override
            public int compare(PhyscData o1, PhyscData o2) {
                return (o1.height > o2.height) ? 1 : (o1.height < o2.height) ? -1 : 0;      // 오름차순 정렬
            }
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        PhyscData[] x = {
                new PhyscData("강민하", 162, 0.3),
                new PhyscData("김찬우", 173, 0.7),
                new PhyscData("박준서", 175, 2.0),
                new PhyscData("유서범", 171, 1.5),
                new PhyscData("장경오", 169, 1.2),
                new PhyscData("황지안", 180, 0.1),
        };

        Arrays.sort(x,
                PhyscData.HEIGHT_ORDER
        );

        for(int i = 0; i < x.length; i++)
            System.out.printf("%-8s%3d%5.1f\n", x[i].name, x[i].height, x[i].vision);
    }
}
