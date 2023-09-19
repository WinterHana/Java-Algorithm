package chapter5;

public class QueenB {
    static int[] pos = new int[8];      // 8x8 체스판
    static int count = 0;               // 총 경우의 수 
    static void print() {
        for(int i = 0; i < 8; i++)
            System.out.printf("%2d", pos[i]);
        System.out.println();
    }

    static void set(int i) {
        for(int j = 0; j < 8; j++) {
            pos[i] = j;
            if(i == 7) {
                // count++;
                print();
            }
            else {
                set(i + 1);
            }
        }
    }

    public static void main(String[] args) {
        set(0);
        System.out.println("count : " + count);
    }
}
