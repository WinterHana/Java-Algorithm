package chapter5;

import java.util.Scanner;
import java.util.Stack;

public class RecurX2 {
    static void recur(int n) {
        Stack<Integer> s = new Stack<>();

        while(true) {
            if(n > 0) {
                s.push(n);
                n = n - 1;
                continue;
            }
            if(s.isEmpty() != true) {
                n = s.pop();
                System.out.println(n);
                n = n - 2;
                continue;
            }
            break;
        }
    }

    static void recurMemo(int n) {
        String[] memo = new String[10];
        if (memo[n + 1] != null)
            System.out.print(memo[n + 1]);
        else {
            if (n > 0) {
                recurMemo(n - 1);
                System.out.println(n);
                recurMemo(n - 2);
                memo[n + 1] = memo[n] + n + "\n" + memo[n - 1];
            } else {
                memo[n + 1] = "";
            }
        }
    }
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("정수를 입력하세요 : ");
        int x = stdIn.nextInt();

        recur(x);

        recurMemo(x);
    }
}
