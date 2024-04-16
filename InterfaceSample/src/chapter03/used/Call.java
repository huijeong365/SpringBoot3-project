package chapter03.used;

public class Call {
    public static void main(String[] args) {
        //ctrl + shift + F10 : console 창에 결과 출력
        //Calculator calculator = new AddCalc();
        Calculator calculator = new SubCalc();
        Integer result = calculator.calc(10,5);
        System.out.println("계산 결과는 (" + result+ ") 입니다.");
        
    }
}
