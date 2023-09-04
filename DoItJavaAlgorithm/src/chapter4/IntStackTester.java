package chapter4;

import java.util.Scanner;

public class IntStackTester {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        IntStack s = new IntStack(64);

        while(true) {
            System.out.println();
            System.out.printf("현재 데이터 개수 : %d / %d \n", s.size(), s.getCapacity());
            System.out.print("(1) push (2) pop (3) peek (4) dump (0) exit -> Input : ");
            
            // 정수를 입력받고 만약 그 값이 0이라면 반복 종료
            int menu = stdIn.nextInt();
            if(menu == 0) break;
            
            // 기능 구현
            int x;
            switch(menu) {
                case 1:
                    System.out.print("데이터 : ");
                    x = stdIn.nextInt();
                    try {
                        s.push(x);
                    } catch (IntStack.OverflowIntStackException e) {
                        System.out.println("스택이 가득 찼습니다.");
                    }
                    break;

                case 2:
                    try {
                        x = s.pop();
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;

                case 3:
                    try {
                        x = s.peek();
                        System.out.println("peek result : " + x);
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;

                case 4:
                    s.dump();
                    break;
            }
        }
    }
}
