package chapter4;

public class GenericStack<E> {
    private E [] stk;
    private int capacity;
    private int ptr;

    // 실행 시 예외 : 스택이 비어 있음
    public static class EmptyGenericStackException extends RuntimeException {
        public EmptyGenericStackException() {}
    }

    // 실행 시 예외 : 스택이 가득 참
    public static class OverflowGenericStackException extends RuntimeException {
        public OverflowGenericStackException() {}
    }

    // 생성자
    public GenericStack(int maxlen) {
        ptr = 0;

        capacity = maxlen;

        try {
            stk = (E[])new Object[capacity];;        // 스택 본체용 배열을 생성
        } catch (OutOfMemoryError e) {      // 생성할 수 없을 때 예외 처리
            capacity = 0;                   // capacity를 0으로 해서 다른 메서드가 존재하지 않은 배열 stk에 잘못 접근하는 것을 막는다.
        }
    }

    // 삽입 : push
    public E push(E x) throws OverflowGenericStackException {   // 스택이 가득찬 경우 예외 처리
        if(ptr >= capacity)
            throw new OverflowGenericStackException();
        return stk[ptr++] = x;
    }

    // 삭제 : pop
    public E pop() throws EmptyGenericStackException {            // 스택이 비었을 경우 예외 처리
        if(ptr <= 0)
            throw new EmptyGenericStackException();
        return stk[--ptr];
    }
    
    // 꼭대기의 요소 확인 : peek
    public E peek() throws  EmptyGenericStackException {
        if(ptr <= 0)
            throw new EmptyGenericStackException();
        return stk[ptr - 1];
    }

    // 스택을 비움 : clear
    public void clear() {
        ptr = 0;
    }

    // 인덱스로 검색 : indexOf
    public int indexOf(E x) {
        for(int i  = ptr - 1; i >= 0; i--) {
            if(stk[i] == x) {
                return i;
            }
        }
        return -1;
    }
    // 배열의 크기 반환 : getCapacity
    public int getCapacity() {
        return capacity;
    }

    // 현재 데이터 크기 반환 : size
    public int size() {
        return ptr;
    }

    // 스택이 비어있는지 확인 : isEmpty
    public boolean isEmpty() {
        return ptr <= 0;
    }

    // 스택이 가득 찼는지 확인 : isFull
    public boolean isFull() {
        return ptr >= capacity;
    }

    // 스택 안의 모든 데이터를 바닥에서 꼭대기 순서대로 출력 : dump
    public void dump() {
        if(ptr <= 0)
            System.out.println("스택이 비어있습니다.");
        else {
            for(int i = 0; i < ptr; i++)
                System.out.println(stk[i] + " ");
            System.out.println();
        }
    }
}
