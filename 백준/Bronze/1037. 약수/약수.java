import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int count = scanner.nextInt(); // 진짜 약수의 개수
        int[] divisors = new int[count];
        
        for (int i = 0; i < count; i++) {
            divisors[i] = scanner.nextInt();
        }
        
        scanner.close();
        
        Arrays.sort(divisors); // 약수들을 정렬
        
        int N = divisors[0] * divisors[count - 1]; // 최솟값과 최댓값을 곱하여 N을 구함
        
        System.out.println(N);
    }
}