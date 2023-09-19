package chapter4;

public class DoubleIntStack {
    private int [] stk;
    private int capacity;           // 전체 배열의 크기
    private int ptrA;              // 앞 스택의 top
    private int ptrB;            // 뒤 스택의 top

    public enum selectStack {StackA, StackB};
    // 실행 시 예외 : 스택이 비어 있음
    public static class EmptyGenericStackException extends RuntimeException {
        public EmptyGenericStackException() {}
    }

    // 실행 시 예외 : 스택이 가득 참
    public static class OverflowGenericStackException extends RuntimeException {
        public OverflowGenericStackException() {}
    }

    // 생성자
    public DoubleIntStack(int maxlen) {
        ptrA = 0;               // 첫번째 스택
        ptrB = maxlen - 1;    // 두번째 스택

        capacity = maxlen;

        try {
            stk = new int[capacity];      // 스택 본체용 배열을 생성
        } catch (OutOfMemoryError e) {              // 생성할 수 없을 때 예외 처리
            capacity = 0;                           // capacity를 0으로 해서 다른 메서드가 존재하지 않은 배열 stk에 잘못 접근하는 것을 막는다.
        }
    }

    // 첫번째 스택 삽입 : pushFirst
    public int push(selectStack sk, int x) throws OverflowGenericStackException {   // 스택이 가득찬 경우 예외 처리
        if(ptrA >= ptrB + 1)
            throw new OverflowGenericStackException();
        switch (sk) {
            case StackA: stk[ptrA++] = x; break;
            case StackB: stk[ptrB--] = x; break;
        }
        return x;
    }

    // 삭제 : pop
    public int pop(selectStack sk) throws EmptyGenericStackException {            // 스택이 비었을 경우 예외 처리
        int x = 0;
        switch (sk) {
            case StackA:
                if(ptrA <= 0)
                    throw new EmptyGenericStackException();
                x = stk[--ptrA];
                break;
            case StackB:
                if(ptrB >= capacity - 1)
                    throw new EmptyGenericStackException();
                x = stk[++ptrB];
                break;
        }
        return x;
    }
    
    // 꼭대기의 요소 확인 : peek
    public int peek(selectStack sk) throws  EmptyGenericStackException {
        int x = 0;
        switch (sk) {
            case StackA:
                if(ptrA <= 0)
                    throw new EmptyGenericStackException();
                x = stk[ptrA - 1];
                break;
            case StackB:
                if(ptrB >= capacity - 1)
                    throw new EmptyGenericStackException();
                x = stk[ptrB + 1];
                break;
        }
        return x;
    }

    // 스택을 비움 : clear
    public void clear(selectStack sk) {
        switch (sk) {
            case StackA: ptrA = 0; break;
            case StackB: ptrB = capacity - 1; break;
        }
    }

    // 인덱스로 검색 : indexOf
    public int indexOf(selectStack sk, int x) {
        switch (sk) {
            case StackA:
                for(int i  = ptrA - 1; i >= 0; i--) {
                    if(stk[i] == x) {
                        return i;
                    }
                }
                break;
            case StackB:
                for(int i  = ptrB + 1; i < capacity; i++) {
                    if(stk[i] == x) {
                        return i;
                    }
                }
                break;
        }
        return -1;
    }
    // 배열의 크기 반환 : getCapacity
    public int getCapacity() {
        return capacity;
    }

    // 현재 데이터 크기 반환 : size
    public int size(selectStack sk) {
        switch (sk) {
            case StackA: return ptrA;
            case StackB: return capacity - ptrB - 1;
        }
        return 0;
    }

    // 스택이 비어있는지 확인 : isEmpty
    public boolean isEmpty(selectStack sk) {
        switch (sk) {
            case StackA: return ptrA <= 0;
            case StackB: return ptrB >= capacity - 1;
        }
        return true;
    }

    // 스택이 가득 찼는지 확인 : isFull
    public boolean isFull() {
        return ptrA >= ptrB + 1;
    }

    // 스택 안의 모든 데이터를 바닥에서 꼭대기 순서대로 출력 : dump
    public void dump(selectStack sk) {
        switch (sk) {
            case StackA:
                if (ptrA <= 0)
                    System.out.println("스택이 비어 있습니다.");
                else {
                    for (int i = 0; i < ptrA; i++)
                        System.out.print(stk[i] + " ");
                    System.out.println();
                }
                break;
            case StackB:
                if (ptrB >= capacity - 1)
                    System.out.println("스택이 비어 있습니다.");
                else {
                    for (int i = capacity - 1; i > ptrB; i--)
                        System.out.print(stk[i] + " ");
                    System.out.println();
                }
                break;
        }
    }
}
