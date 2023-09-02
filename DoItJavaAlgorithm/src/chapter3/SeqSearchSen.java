package chapter3;

import java.util.Scanner;

public class SeqSearchSen {
    static int seqSearchSen(int[] a, int n, int key) {
        int i = 0;

        a[n] = key;                 // 보초를 추가한다.

        while(true) {
            if(a[i] == key) break;  // 검색 성공 시 break
            i++;
        }
        return i == n ? -1 : i;
    }
    static int seqSearchSenFor(int[] a, int n, int key) {
        int i;
        a[n] = key;                 // 보초를 추가한다.

//        for(i = 0; i <= n; i++) {
//            if(a[i] == key) break;
//        }
        for(i = 0; a[i] != key; i++) {
            // 공백
        }

        return i == n ? -1 : i;
    }
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟 수 : ");
        int num = stdIn.nextInt();
        int[] x = new int[num + 1]; // 보초값을 저장할 공간 하나 더 추가

        for(int i = 0; i < num; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        System.out.print("검색할 값 : ");
        int ky = stdIn.nextInt();

        int idx = seqSearchSen(x, num, ky);
        if(idx == -1) System.out.println("그 값의 요소가 없습니다.");
        else System.out.println("그 값은 x[" + idx + "]에 있습니다.");

        int idx2 = seqSearchSenFor(x, num, ky);
        if(idx2 == -1) System.out.println("(For문)그 값의 요소가 없습니다.");
        else System.out.println("(For문)그 값은 x[" + idx2 + "]에 있습니다.");
    }
}
