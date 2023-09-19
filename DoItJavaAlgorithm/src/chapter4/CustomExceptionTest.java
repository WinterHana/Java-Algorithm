package chapter4;
/*
getMessage()
- String 타입의 매개변수 메시지를 갖는 생성자를 이용하였다면, 메시지는 자동적으로 예외 객체 내부에 저장되게 되는데 이 메시지를 리턴하는 함수입니다.
- 예외 메시지의 내용에는 왜 예외가 발생했는지에 대한 간단한 설명이 포함됩니다.

printStackTrace()
- 예외 발생 코드를 추적해서 모두 콘솔에 출력합니다.
- 어떤 예외가 어디에서 발생했는지 상세하게 출력해주기 때문에 프로그램을 테스트하면서 오류를 찾을 때 활용합니다.
 */
public class CustomExceptionTest {
    public static void main(String[] args) {
        try{
            test();
        } catch (CustomException e) {
            System.out.println("커스텀 예외 테스트");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void test() throws CustomException {
        throw new CustomException("예외 테스트 입니다.");
    }
}

class CustomException extends RuntimeException {
    // 1. 매개 변수가 없는 기본 생성자
    CustomException() {

    }

    // 2. 예외 발생 원인(예외 메시지)을 전달하기 위해 String 타입의 매개변수를 갖는 생성자
    CustomException(String message) {
        super(message); // RuntimeException 클래스의 생성자를 호출합니다.
    }
}
