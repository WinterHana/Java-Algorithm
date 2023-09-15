package chapter6;

import java.util.Scanner;
import java.util.Stack;

public class QuickSort2 {
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void quickSort(int[] a, int left, int right) {
        Stack<Integer> lstk = new Stack<>();
        Stack<Integer> rstk = new Stack<>();

        lstk.push(left);
        rstk.push(right);

        while(lstk.isEmpty() != true) {
            int pl = left = lstk.pop();
            int pr = right = rstk.pop();
            int x = a[(left + right) / 2];

            // 정렬 과정
            do {
                while(a[pl] < x) pl++;
                while(a[pr] > x) pr--;
                if(pl <= pr)
                    swap(a, pl++, pr--);
            } while(pl <= pr);

            if(left < pr) {
                lstk.push(left);        // 왼쪽 그룹 범위의 인덱스를 푸시
                rstk.push(pr);
            }

            if(pl < right) {
                lstk.push(pl);          // 오른쪽 그룹 범위의 인덱스를 푸시
                rstk.push(right);
            }
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("Partition 나누기");
        System.out.print("요솟수 : ");

        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for(int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = stdIn.nextInt();
        }

        quickSort(x, 0, nx - 1);
        // 결과 출력
        System.out.println("오름차순으로 정렬했습니다.");
        for(int i = 0; i < nx; i++) {
            System.out.println("x[" + i + "] = " + x[i]);
        }
    }
}
