package chapter7;

import java.util.Scanner;

public class BFmatch {
    static int bfMatch(String txt, String pat) {
        int pt = 0;                 // 본래 택스트 커서
        int pp = 0;                 // 검색할 택스트 커서

        while(pt != txt.length() && pp != pat.length()) {
            if(txt.charAt(pt) == pat.charAt(pp)) {
                pt++; pp++;
            } else {
                pt = pt - pp + 1;       // 다음 위치로 이동
                pp = 0;                 // 검색하는 택스트는 초기화
            }
        }
        if(pp == pat.length()) return pt - pp;      // 검색 성공 : 위치의 인덱스를 반환한다.
        return -1;                                  // 검색 실패
    }

    static int bfMatchLast(String txt, String pat) {
        int pt = txt.length() - pat.length();                   // 본래 택스트 커서
        int pp = 0;                                                 // 검색할 택스트 커서

        while(pt != 0 && pp != pat.length()) {
            if(txt.charAt(pt) == pat.charAt(pp)) {
                pt++; pp++;
            } else {
                pt = pt - pp - 1;       // 다음 위치로 이동
                pp = 0;                 // 검색하는 택스트는 초기화
                System.out.println("pt : " + pt);
            }
        }
        if(pp == pat.length()) return pt - pp;      // 검색 성공 : 위치의 인덱스를 반환한다.
        return -1;                                  // 검색 실패
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("텍스트 : ");
        String s1 = scan.next();

        System.out.print("패 턴 : ");
        String s2 = scan.next();

        int idx = bfMatchLast(s1, s2);

        if(idx == -1) System.out.println("택스트에 패턴이 없습니다.");
        else {
            // 일치하는 문자 바로 앞까지의 문자 개수를 반각 문자로 환산하여 구한다.
            int len = 0;
            for(int i = 0; i < idx; i++) len += s1.substring(i, i + 1).getBytes().length;
            len += s2.length();

            System.out.println((idx + 1) + "번째 문자부터 일치합니다.");
            System.out.println("텍스트 : " + s1);
            System.out.printf(String.format("패 턴 : %%%ds\n", len), s2);
        }
    }
}
