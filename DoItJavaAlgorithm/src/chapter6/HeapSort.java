package chapter6;

import java.util.Scanner;
public class HeapSort {
    static void swap(int[] arr, int idx1, int idx2) {
        int t = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = t;
    }

    // a[left] ~ arr[right]를 힙으로 만든다.
    static void downHeap(int[] arr, int left, int right) {
        int temp = arr[left];
        int child; int parent;

        for(parent = left; parent < (right + 1) / 2; parent = child) {
            int cl = parent * 2 + 1;
            int cr = cl + 1;
            child = (cr <= right && arr[cr] > arr[cl]) ? cr : cl;       // 두 자식 중에 큰 쪽을 선택
            if(temp >= arr[child]) break;                               // 만약, 부모가 자식보다 더 크면 반복 중지 -> 최종 자리 확정
            arr[parent] = arr[child];                                   // 그렇지 않다면 자식 노드를 부모 노드에 덮어씌운다.
        }
        arr[parent] = temp;                                             // 원래 부모였던 노드의 최종 자리를 찾으면 대입한다.
    }

    // 힙 정렬
    static void heapSort(int[] arr, int n) {
        // 1. a[i] ~ a[n - 1]을 힙으로 만든다.
        for(int i = (n - 1) / 2; i >= 0; i--) {
            downHeap(arr, i, n - 1);
        }

        // 2. 요소 교환 후 다시 힙으로 만들기 위해 정렬한다.
        for(int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);                    // 가장 큰 요소와 아직 정렬되지 않은 부분의 마지막 요소를 교환한다.
            downHeap(arr, 0, i - 1);        // a[0] ~ a[i - 1]을 힙으로 만든다.
        }
    }
    
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("힙 정렬");
        System.out.print("요솟수 : ");
        int nx = scan.nextInt();
        int[] x = new int[nx];

        for(int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = scan.nextInt();
        }

        heapSort(x, nx);

        System.out.println("오름차순으로 정렬했습니다.");
        for(int i = 0; i < nx; i++)
            System.out.println("x[" + i + "] = " + x[i]);
    }
}
