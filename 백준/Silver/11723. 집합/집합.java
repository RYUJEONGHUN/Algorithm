import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());

        int S = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            String[] cmd = br.readLine().split(" ");

            String op = cmd[0];
            int x = 0;
            if (cmd.length == 2) {
                x = Integer.parseInt(cmd[1]);
            }

            switch (op) {
                case "add":
                    S |= (1 << x);
                    break;
                case "remove":
                    S &= ~(1 << x);
                    break;
                case "check":
                    sb.append((S & (1 << x)) != 0 ? "1\n" : "0\n");
                    break;
                case "toggle":
                    S ^= (1 << x);
                    break;
                case "all":
                    S = (1 << 21) - 1; // 1~20까지 전부 ON
                    break;
                case "empty":
                    S = 0;
                    break;
            }
        }

        System.out.print(sb);
    }
}