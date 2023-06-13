package chapter1;

import java.util.Scanner;

/**
 * 양의 정수를 입력하고 자릿수를 출력하는 프로그램을 작성하세요
 * 예시 : "135"를 입력하면 "그 수는 3자리입니다."라고 출력한다.
 */
public class Practice3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num;
        do {
            System.out.print("양의 정수를 입력해주세요 : ");
            num = scanner.nextInt();
        } while(num <= 0);

        int pos = 0;
        do {
            num = num / 10;
            pos++;
        } while(num > 0);

        System.out.println("입력한 수는 " + pos + "자리 입니다.");
    }
}
