package chapter3;

import java.util.Arrays;
import java.util.Scanner;

public class SeqSearch {
    static int seqSearch(int[] a, int n, int key) {
        int i = 0;

        while(true) {
            if(i == n) return -1;       // 검색 실패
            if(a[i] == key) return i;   // 검색 성공, 인덱스를 반환한다.
            i++;
        }
    }

    static int seqSearchFor(int[] a, int n, int key) {
        for(int i = 0; i < n; i++) {
            if(a[i] == key) return i;
        }
        return -1;
    }

    static int seqSearchScanner(int[] a, int n, int key) {
        for(int i = 0; i < n; i++) {
            // 선형탐색 과정을 택스트로 확인
            System.out.print("     ");
            for(int j = 0; j < i; j++) System.out.print("   ");
            System.out.println("*");
            System.out.println(i + " | " + Arrays.toString(a));
            
            // 탐색 성공 여부 확인
            if(a[i] == key) {
                // 탐색 성공
                System.out.println("그 값은 x[" + i + "]에 있습니다.");
                return i;
            }
        }
        // 탐색 실패
        System.out.println("그 값의 요소가 없습니다.");
        return -1;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟 수 : ");
        int num = stdIn.nextInt();
        int[] x = new int[num];

        for(int i = 0; i < num; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        System.out.print("검색할 값 : ");
        int ky = stdIn.nextInt();

        int idx = seqSearch(x, num, ky);
        if(idx == -1) System.out.println("그 값의 요소가 없습니다.");
        else System.out.println("그 값은 x[" + idx + "]에 있습니다.");

        int idxFor = seqSearchFor(x, num, ky);
        if(idxFor == -1) System.out.println("(For문)그 값의 요소가 없습니다.");
        else System.out.println("(For문)그 값은 x[" + idx + "]에 있습니다.");

        int idxScanner = seqSearchScanner(x, num, ky);
    }
}
