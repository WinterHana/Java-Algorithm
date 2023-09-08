package chapter4;

public class IntQueue {
    private int[] que;      // 큐 배열 본체
    private int capacity;   // 큐의 용량
    private int front;      // 맨 앞의 요소 커서
    private int rear;       // 맨 뒤의 요소 커서
    private int num;        // 현재 데이터 개수

    public class EmptyIntQueueException extends RuntimeException {
        public EmptyIntQueueException() {}
    }

    public class OverflowIntQueueException extends RuntimeException {
        public OverflowIntQueueException() {}
    }

    public IntQueue(int maxlen) {
        num = front = rear = 0;
        capacity = maxlen;
        try {
            que = new int[capacity];
        } catch (OutOfMemoryError e) {
            capacity = 0;
        }
    }

    public int enque(int x) throws OverflowIntQueueException {
        if (num >= capacity)
            throw new OverflowIntQueueException();
        que[rear++] = x;            // 추가
        num++;                      // 데이터 증가

        if(rear == capacity)        // 원형 큐이기 때문에 rear이 배열 끝까지 오면 다시 뒤로 되돌린다.
            rear = 0;

        return x;
    }

    public int deque() throws EmptyIntQueueException {
        if(num <= 0)
            throw new EmptyIntQueueException();
        int x = que[front++];           // 반환을 위해서 임시 저장
        num--;                          // 데이터 감소

        if(front == capacity)           // enque와 같은 원리
            front = 0;
        return x;
    }

    public int peek() throws EmptyIntQueueException {
        if (num <= 0)
            throw new EmptyIntQueueException();
        return que[front];
    }

    public void clear() {
        num = front = rear = 0;
    }

    public int indexOf(int x) {
        for(int i = 0; i < num; i++) {
            int idx = (i + front) % capacity;
            if(que[idx] == x)
                return idx;
        }
        return -1;
    }

    // 나머지는 생략

}
