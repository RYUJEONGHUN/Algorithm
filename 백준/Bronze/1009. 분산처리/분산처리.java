import java.util.Scanner;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // 테스트 케이스 수

        for (int i = 0; i < T; i++) {
            BigInteger a = sc.nextBigInteger();
            BigInteger b = sc.nextBigInteger();

            // 10으로 나눈 나머지 계산
            BigInteger result = a.modPow(b, BigInteger.TEN);

            if (result.equals(BigInteger.ZERO)) {
                System.out.println(10); // 0이면 10번 컴퓨터
            } else {
                System.out.println(result);
            }
        }

        sc.close();
    }
}
