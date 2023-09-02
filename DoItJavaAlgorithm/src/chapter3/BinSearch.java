package chapter3;

import java.util.Scanner;

public class BinSearch {
    static int binSearch(int[] a, int n, int key) {
        int pl = 0;
        int pr = n - 1;

        do {
            int pc = (pl + pr) / 2; // 중간 범위 초기화
            if(key > a[pc]) {
                pl = pc + 1;    // 검색 범위를 오른쪽으로 좁힘
            }
            else if(key < a[pc]) {
                pr = pc - 1;    // 검색 범위를 왼쪽으로 좁힘
            }
            else {
                return pc;      // 검색 성공
            }
        } while(pl <= pr);

        return -1;
    }

    static int binSearchFor(int[] a, int n, int key) {
        int pl = 0;
        int pr = n - 1;

        for(int pc = n / 2; pl <= pr ; pc = (pl + pr) / 2) {
            if(key > a[pc]) {
                pl = pc + 1;    // 검색 범위를 오른쪽으로 좁힘
            }
            else if(key < a[pc]) {
                pr = pc - 1;    // 검색 범위를 왼쪽으로 좁힘
            }
            else {
                return pc;      // 검색 성공
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = stdIn.nextInt();
        int[] x = new int[num];

        System.out.println("오름차순으로 입력하세요 : ");

        // 첫 요소를 입력받음.
        System.out.print("x[0] : ");
        x[0] = stdIn.nextInt();

        for(int i = 1; i < num; i++) {
            do {
               System.out.print("x[" + i + "] : ");
               x[i] = stdIn.nextInt();
            } while (x[i] < x[i - 1]);
        } // 바로 앞의 요소보다 작으면 다시 입력받는다.

        System.out.print("검색할 값 : ");
        int ky = stdIn.nextInt();

        int idx = binSearch(x, num, ky);
        if(idx == -1) System.out.println("그 값의 요소는 없습니다.");
        else System.out.println("그 값은 x[" + idx + "]에 있습니다.");

        int idx2 = binSearchFor(x, num, ky);
        if(idx2 == -1) System.out.println("(For문)그 값의 요소는 없습니다.");
        else System.out.println("(For문)그 값은 x[" + idx2 + "]에 있습니다.");
    }
}
