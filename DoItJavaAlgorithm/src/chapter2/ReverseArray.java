package chapter2;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseArray {

    static void swap(int[] arr, int index1, int index2)
    {
        System.out.println("arr[" + index1 + "]와 arr[" + index2 +"]을 교환합니다.");
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
        System.out.println(Arrays.toString(arr));
    }
    static void reverse(int[] arr) {
        for(int i = 0; i < arr.length / 2; i++) {
            swap(arr, i, arr.length - i - 1);
        }
    }

    static void sumOf(int[] a) {
        int sum = 0;
        for(int i = 0; i < a.length; i++) {
            sum += a[i];
        }

        System.out.println("배열 요소의 총 합은 " + sum + "입니다.");
    }

    static void copy(int a[], int b[]) {
        for(int i = 0; i < a.length; i++) {
            a[i] = b[i];
        }
    }

    static void rcopy(int a[], int b[]) {
        for(int i = 0; i < a.length; i++) {
            a[i] = b[a.length - i - 1];
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = stdIn.nextInt();

        int[] x = new int[num];
        int[] y = new int[num];

        for(int i = 0; i < num; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }
        sumOf(x);
        copy(y, x);
        System.out.println("복사한 y 행렬 : " + Arrays.toString(y));
        rcopy(y, x);
        System.out.println("뒤집고 난 후 복사한 y 행렬 : " + Arrays.toString(y));
        reverse(x);

        System.out.println("요소를 역순으로 정렬했습니다.");
        System.out.println("x = " + Arrays.toString(x));
    }
}
