package chapter1;

import java.util.Scanner;

public class Practice1 {
    static int max4(int a, int b, int c, int d) {
        int tmp1 = (a > b) ? a : b;
        int tmp2 = (c > d) ? c : d;
        int max = (tmp1 > tmp2) ? tmp1 : tmp2;

        return max;
    }

    static int min3(int a, int b, int c) {
        int min = a;
        if(min > b) min = b;
        if(min > c) min = c;

        return min;
    }

    static int min4(int a, int b, int c, int d) {
        int tmp1 = (a < b) ? a : b;
        int tmp2 = (c < d) ? c : d;
        int min = (tmp1 < tmp2) ? tmp1 : tmp2;

        return min;
    }

    static int med3(int a, int b, int c) {
        if(a >= b) {
            if(b >= c)
                return b;
            else if(a <= c)
                return a;
            else
                return c;
        }
        else if (a > c)
            return a;
        else if(b > c)
            return c;
        else
            return b;
    }
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.println("a, b, c, d를 순서대로 입력해주세요");
        int a = stdIn.nextInt();
        int b = stdIn.nextInt();
        int c = stdIn.nextInt();
        int d = stdIn.nextInt();

        int result1 = max4(a, b, c, d);
        System.out.println("가장 큰 수는 " + result1 + "입니다.");

        int result2 = min4(a, b, c, d);
        System.out.println("가장 작은 수는 " + result2 + "입니다.");

        int result3 = min3(a, b, c);
        System.out.println("a, b, c 중에서 가장 작은 수는 " + result3 + "입니다.");

        int result4 = med3(a, b, c);
        System.out.println("a, b, c 중에서 중간값은 " + result4 + "입니다.");
    }
}
