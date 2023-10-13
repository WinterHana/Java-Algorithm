package chapter8;

import java.util.Comparator;

public class LinkedList<E> {
    // 노드 클래스
    class Node<E> {
        private E data;
        private Node<E> next;

        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head;       // 머리 노드
    private Node<E> crnt;       // 현재 선택한 노드

    public LinkedList() {
        head = crnt = null;
    }

    public E search(E obj, Comparator<? super E> c) {
        Node<E> ptr = head;

        // 노드가 비어있을 때까지 앞으로 전진
        while (ptr != null) {
            // 검색 성공 : 값을 비교해서 확인한다.
            if(c.compare(obj, ptr.data) == 0) {
                crnt = ptr;
                return ptr.data;
            }
            // 다음 노드 검색
            ptr = ptr.next;
        }
        
        // 검색 실패
        return null;
    }

    public void addFirst(E obj) {
        Node<E> ptr = head;                     // 임시 저장
        head = crnt = new Node<E>(obj, ptr);    // 노드 생성
    }

    public void addLast(E obj) {
        if(head == null) addFirst(obj);
        else {
            Node<E> ptr = head;
            while(ptr.next != null) ptr = ptr.next;
            ptr.next = crnt = new Node<E>(obj, null);
        }
    }

    public void removeFirst() {
        if(head != null) head = crnt = head.next;
    }

    public void removeLast() {
        if(head != null) {
            if(head.next == null) removeFirst();
            else {
                Node<E> ptr = head;     // 스캔 중
                Node<E> pre = head;     // 스캔 중인 노드의 앞 노드

                while(ptr.next != null) {
                    pre = ptr;
                    ptr = ptr.next;
                }
                pre.next = null;
                crnt = pre;
            }
        }
    }

    // 노드 p를 삭제
    public void remove(Node p) {
        if(head != null) {
            if(p == head)
                removeFirst();
            else {
                Node<E> ptr = head;

                while(ptr.next != p) {
                    ptr = ptr.next;
                    if(ptr == null) return;
                }

                ptr.next = p.next;
                crnt = ptr;
            }
        }
    }

    // 선택 노드 삭제
    public void removeCurrentNode() {
        remove(crnt);
    }

    public void clear() {
        while(head != null) removeFirst();
        crnt = null;
    }

    public boolean next() {
        if (crnt == null || crnt.next == null)
            return false;
        crnt = crnt.next;
        return true;
    }

    public void printCurrentNode() {
        if(crnt == null)
            System.out.println("선택한 노드가 없습니다.");
        else
            System.out.println(crnt.data);
    }

    public void dump() {
        Node<E> ptr = head;

        while(ptr != null) {
            System.out.println(ptr.data);
            ptr = ptr.next;
        }
    }
}
