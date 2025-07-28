
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;



class Noint {
    int c;
    int count;

    public Noint(int tc, int tcount) {
        c = tc;
        count = tcount;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arg = br.readLine().split(" ");

        int N = Integer.parseInt(arg[0]);
        int M = Integer.parseInt(arg[1]);

        int[] map = new int[101];
        for (int i = 1; i <= 100; i++) {
            map[i] = i;  // 초기엔 자기 자신
        }

        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
            map[a] = b;  // 사다리
        }

        for (int i = 0; i < M; i++) {
            String[] temp = br.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
            map[a] = b;  // 뱀
        }

        boolean[] visited = new boolean[101];
        int result = bfs(map, visited);
        System.out.print(result);
    }

    public static int bfs(int[] map, boolean[] visited) {
        Queue<Noint> q = new LinkedList<>();
        q.add(new Noint(1, 0));
        visited[1] = true;

        while (!q.isEmpty()) {
            Noint current = q.poll();
            int pos = current.c;
            int count = current.count;

            if (pos == 100) return count;

            for (int dice = 1; dice <= 6; dice++) {
                int next = pos + dice;
                if (next > 100) continue;

                int finalPos = map[next];  // 사다리/뱀 이동

                if (!visited[finalPos]) {
                    visited[finalPos] = true;
                    q.add(new Noint(finalPos, count + 1));
                }
            }
        }

        return -1;
    }
}
