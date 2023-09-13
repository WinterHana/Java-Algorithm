package chapter5;

public class QueenBB {
    static boolean[] flag = new boolean[8]; // 각 행에 퀸이 배치되었는지 확인함
    static boolean[] flagUp = new boolean[15]; // / 방향에 퀸이 배치되었는지 확인함
    static boolean[] flagDown = new boolean[15]; // \ 방향에 퀸이 배치되었는지 확인함
    static int[] pos = new int[8];          // 각 열에 있는 퀸의 위치

    static int count = 0;

    static void print() {
        for(int i = 0; i < 8; i++)  {
            System.out.printf("%2d", pos[i]);
        }
        System.out.println();
    }

    static void set(int i) {
        for(int j = 0; j < 8; j++) {
            if(flag[j] == false &&
            flagUp[i + j] == false &&
            flagDown[i - j + 7] == false) {
                pos[i] = j;
                if (i == 7) {                // 모든 열에 배치
                    count++;
                    print();
                } else {                      // 아니라면 재귀 함수로 해결
                    flag[j] = flagUp[i + j] = flagDown[i - j + 7] = true;
                    set(i + 1);
                    flag[j] = flagUp[i + j] = flagDown[i - j + 7] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        set(0);
        System.out.println(count);
    }
}
