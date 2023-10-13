package chapter6;

import java.util.Scanner;

public class CountingSort {
    static void countingSort(int[] a, int n, int max) {
        int[] f = new int[max + 1];     // 도수분포표 + 누적도수분포표
        int[] b = new int[n];           // 최종 정렬된 배열

        for(int i = 0; i < n; i++) f[a[i]]++;                   // 1. 도수분포표 만들기
        for(int i = 1; i <= max; i++) f[i] += f[i - 1];         // 2. 누적도수분포표 만들기
        for(int i = n - 1; i >= 0; i--) b[--f[a[i]]] = a[i];    // 3. 목표한 배열 만들기
        for(int i = 0; i < n; i++) a[i] = b[i];                 // 4. 배열 복사하기
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("도수 정렬");
        System.out.print("요솟수 : ");
        int nx = scan.nextInt();
        int[] x = new int[nx];

        for(int i = 0; i < nx; i++) {
            do {
                System.out.print("x[" + i + "] : ");
                x[i] = scan.nextInt();
            } while(x[i] < 0);      // 키보드에 입력된 값을 0 이상으로 제한
        }

        // 배열 x의 최댓값을 구해서  max에 대입한다.
        int max = x[0];
        for(int i = 1; i < nx; i++)
            if(x[i] > max) max = x[i];

        countingSort(x, nx, max);

        System.out.println("오름차순으로 정렬했습니다.");
        for(int i = 0; i < nx; i++)
            System.out.println("x[" + i + "] = " + x[i]);
    }
}
