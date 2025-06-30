import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String s = sc.next();
        
        final int r = 31;
        final int M = 1234567891;

        long hash = 0;
        long pow = 1;

        for (int i = 0; i < n; i++) {
            int value = s.charAt(i) - 'a' + 1;
            hash = (hash + value * pow) % M;
            pow = (pow * r) % M;
        }

        System.out.println(hash);
        sc.close();
    }
}