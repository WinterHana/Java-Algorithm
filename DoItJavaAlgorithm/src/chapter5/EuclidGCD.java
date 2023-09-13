package chapter5;

import java.util.Scanner;

public class EuclidGCD {
    static int gcd(int x, int y) {
        if(y == 0)
            return x;
        else
            return gcd(y, x % y);
    }

    public static void main(String[] args) {
        Scanner stdId = new Scanner(System.in);

        System.out.println("두 정수의 최대공약수를 구합니다.");

        System.out.print("정수를 입력하세요 : "); int x = stdId.nextInt();
        System.out.print("정수를 입력하세요 : "); int y = stdId.nextInt();

        System.out.println("최대 공약수는 " + gcd(x, y) + "입니다.");
    }
}
