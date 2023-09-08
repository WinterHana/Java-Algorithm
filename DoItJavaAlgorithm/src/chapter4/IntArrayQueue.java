package chapter4;

public class IntArrayQueue {
    private int[] que;      // 배열 큐
    private int capacity;   // 총 용량
    private int num;        // 현재 데이터 개수

    public IntArrayQueue(int maxLen) {
        num = 0;
        capacity = maxLen;

        try {
            que = new int[capacity];
        } catch (OutOfMemoryError e) {
            capacity = 0;
        }
    }

    public class EmptyIntQueue extends RuntimeException {
        public EmptyIntQueue() {}

        public EmptyIntQueue(String message) {
            super(message);
        }
    }
    public boolean isEmpty() {
        return num <= 0;
    }

    public boolean isFull() {
        return num <= capacity;
    }
    public int enqueue(int x) {
        if(isFull()) return -1;
        else {
            que[num++] = x;
            return x;
        }
    }

    public int dequeue() {
        if(isEmpty()) return -1;
        else {
            for(int i = num - 1; i > 0; i--)
                que[i - 1] = que[i];
            return 0;
        }
    }
}
