package chapter2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class ReverseArrayRand {
    // 배열의 위치를 서로 바꾼다.
    static void swap(int[] a, int idx1, int idx2) {
        int tmp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = tmp;
    }

    // 배열을 역순으로 정렬한다.
    static void reverse(int[] a) {
        for(int i = 0; i < a.length / 2; i++) {
            swap(a, i, a.length - 1 - i);
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        Random rand = new Random();

        int num = 1 + rand.nextInt(10);
        System.out.println("숫자의 개수 : " + num);
        int[] x = new int[num];

        for(int i = 0; i < num; i++) {
            x[i] = rand.nextInt(20);
        }
        System.out.println("생성된 배열 : " + Arrays.toString(x));

        reverse(x);
        System.out.println("역순으로 된 배열 : " + Arrays.toString(x));
    }
}
