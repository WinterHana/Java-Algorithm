package chapter1;

import java.util.Scanner;

public class Practice2 {
    static int Gauss(int n) {
        return n*(n+1) / 2;
    }

    static int sumof(int a, int b) {
        int sum = 0;
        for(int i = a; i <= b; i++) {
            sum += i;
        }

        return sum;
    }
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int n;
        System.out.println("1부터 n까지의 합을 구합니다.");
        do {
            System.out.print("n값(양수를 입력해주세요) : ");
            n = stdIn.nextInt();
        } while(n <= 0);


        int sum = 0;
        int i;
        for(i = 1; i <= n; i++) {
            sum += i;
        }
        System.out.println("i의 값 : " + i);
        System.out.println("1부터 " + n +"까지의 합은 " + sum + "입니다.");
        System.out.println("가우스 계산법 결과 : " + Gauss(n));

        System.out.println("a부터 b까지의 합을 구합니다.");
        System.out.print("a값 : "); int a = stdIn.nextInt();
        System.out.print("b값 : "); int b = stdIn.nextInt();

        System.out.println(a + "부터 " + b +"까지의 합은 " + sumof(a, b) + "입니다.");
    }
}
