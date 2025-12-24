import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        List<Integer>[] g = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) g[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            String line = br.readLine();
            while (line != null && line.trim().isEmpty()) line = br.readLine(); // 혹시 빈줄 방어
            String[] t = line.trim().split("\\s+");
            int a = Integer.parseInt(t[0]);
            int b = Integer.parseInt(t[1]);
            g[a].add(b);
            g[b].add(a);
        }

        int[] parent = new int[N + 1];
        boolean[] vis = new boolean[N + 1];

        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        vis[1] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nxt : g[cur]) {
                if (!vis[nxt]) {
                    vis[nxt] = true;
                    parent[nxt] = cur;
                    q.add(nxt);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) sb.append(parent[i]).append('\n');
        System.out.print(sb);
    }
}
