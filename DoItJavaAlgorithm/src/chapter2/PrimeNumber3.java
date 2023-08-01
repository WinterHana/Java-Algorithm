package chapter2;

public class PrimeNumber3 {
    public static void main(String[] args) {
        int counter = 0;
        int ptr = 0;
        int[] prime = new int[500];

        prime[ptr++] = 2;
        prime[ptr++] = 3;
        
        // 조사 대상은 홀수만 한다.
        for(int n = 5; n <= 1000; n += 2) {
            boolean flag = false;
            // 값의 제곱근까지 소수를 판단한다.
            for(int i = 1; prime[i] * prime[i] <= n; i++) {
                counter += 2;
                // 나누어 떨어지면 소수가 아니다.
                if(n % prime[i] == 0) {
                    flag = true;
                    break;
                }
            }
            // 소수는 배열에 넣어서 다시 쓴다.
            if(!flag) {
                prime[ptr++] = n;
                counter++;
            }
        }

        for(int i = 0; i < ptr; i++) System.out.println(prime[i]);

        System.out.println("곱셈과 나눗셈을 수행한 횟수 : " + counter);
    }
}
