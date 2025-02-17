import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        int[] stack = new int[n]; // 스택을 배열로 구현 (Deque 대신 사용)
        int top = -1; // 스택의 맨 위를 가리키는 변수
        int cnt = 1; // 1부터 push할 숫자

        for (int i = 0; i < n; i++) {
            int input = sc.nextInt();

            // input까지 push
            while (cnt <= input) {
                stack[++top] = cnt++; // push
                sb.append("+\n");
            }

            // pop 진행
            if (stack[top] == input) {
                top--; // pop
                sb.append("-\n");
            } else {
                System.out.println("NO"); // 스택의 top 값이 다르면 NO 출력 후 즉시 종료
                return;
            }
        }

        System.out.print(sb); // 결과 한 번에 출력
        sc.close();
    }
}