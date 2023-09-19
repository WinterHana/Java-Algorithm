package chapter6;

import java.util.Scanner;

public class MergeSort {
    static int[] buff;

    static void recurMergeSort(int[] a, int left, int right) {
        if(left < right) {
            int i;
            int center = (left + right) / 2;
            int p = 0;
            int j = 0;
            int k = left;

            recurMergeSort(a, left, center);
            recurMergeSort(a, center + 1, right);

            for(i = left; i < center; i++)
                buff[p++] = a[i];

            while(i <= right && j < p)
                a[k++] = (buff[j] <= a[i]) ? buff[j++] : a[i++]; // 병합 과정

            while(j < p)
                a[k++] = buff[j++];
        }
    }

    static void mergeSort(int[] a, int n) {
        buff = new int[n];

        recurMergeSort(a, 0, n - 1);

        buff = null;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("QuickSort 개선");
        System.out.print("요솟수 : ");

        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for(int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = stdIn.nextInt();
        }

        mergeSort(x, nx);

        // 결과 출력
        System.out.println("오름차순으로 정렬했습니다.");
        for(int i = 0; i < nx; i++) {
            System.out.println("x[" + i + "] = " + x[i]);
        }
    }
}
