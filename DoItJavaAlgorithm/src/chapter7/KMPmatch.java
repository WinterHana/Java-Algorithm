package chapter7;

import java.util.Scanner;

public class KMPmatch {
    static int kmpMactch(String txt, String pat) {
        int pt = 1;
        int pp = 0;
        int[] skip = new int[pat.length() + 1];

        skip[pt] = 0;
        while(pt != pat.length()) {
            if(pat.charAt(pt) == pat.charAt(pp))
                skip[++pt] = ++pp;
            else if(pp == 0)
                skip[++pt] = pp;
            else
                pp = skip[pp];
        }

        pt = pp = 0;
        while(pt != txt.length() && pt != pat.length()) {
            if(txt.charAt(pt) == pat.charAt(pp)) {
                pt++; pp++;
            } else if(pp == 0)
                pp++;
            else
                pp = skip[pp];
        }

        if(pp == pat.length()) return pt - pp;
        return -1;
    }



    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("텍스트 : ");
        String s1 = scan.next();

        System.out.print("패 턴 : ");
        String s2 = scan.next();

        int idx = kmpMactch(s1, s2);

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
