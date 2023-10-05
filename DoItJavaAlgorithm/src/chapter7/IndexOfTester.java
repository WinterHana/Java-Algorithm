package chapter7;

import java.util.Scanner;

public class IndexOfTester {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("택스트 : ");
        String s1 = scan.next();

        System.out.print("패 턴 : ");
        String s2 = scan.next();

        int idx1 = s1.indexOf(s2);          // 앞쪽부터 검색
        int idx2 = s2.lastIndexOf(s2);      // 뒤쪽부터 검색

        if(idx1 == -1) System.out.println("택스트 안에 패턴이 없습니다.");
        else {
            int len1 = 0;
            for(int i = 0; i < idx1; i++)
                len1 += s1.substring(i, i + 1).getBytes().length;
            len1 += s2.length();

            int len2 = 0;
            for(int i = 0; i < idx1; i++)
                len2 += s1.substring(i, i + 1).getBytes().length;
            len2 += s2.length();

            System.out.println("텍스트 : " + s1);
            System.out.printf(String.format("패 턴 : %%%ds\n", len1), s2);
            System.out.println("텍스트 : " + s1);
            System.out.printf(String.format("패 턴 : %%%ds\n", len2), s2);
        }
    }
}
