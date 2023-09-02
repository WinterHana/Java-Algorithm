package chapter3;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchTester {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = stdIn.nextInt();
        int[] x = new int[num];

        System.out.println("오름차순으로 입력하세요. : ");

        // 첫 요소를 먼저 입력받고, 그 다음 요소가 이전 요소보다 작으면 다시 입력하도록 한다.
        System.out.print("x[0] : ");
        x[0] = stdIn.nextInt();
        for(int i = 1; i < num; i++) {
            do {
                System.out.print("x[" + i + "] : ");
                x[i] = stdIn.nextInt();
            } while(x[i] < x[i - 1]);
        }

        // 검색할 값을 입력받는다.
        System.out.print("검색할 값 : ");
        int ky = stdIn.nextInt();

        int idx = Arrays.binarySearch(x, ky);       // 값이 위치한 인덱스 값을 반환한다.

        // 결과를 출력한다.
        if(idx < 0)
            System.out.println("그 값의 요소가 없습니다.");
        else
            System.out.println("그 값은 x[" + idx + "]에 있습니다.");

    }
}
