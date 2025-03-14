
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    int x, y, c;
    public Point(int i, int j, int count) {
        x = i;
        y = j;
        c = count;
    }
}

public class Main {
    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1}; 
    static Queue<Point> q; 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        q = new LinkedList<>();

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N][M];
        visited = new boolean[N][M];

        // 입력 받기
        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0, 0)); // (0,0)에서 시작
        sc.close();
    }

    public static int bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y, 1)); // 시작 위치 (0,0), 이동 거리 1
        visited[x][y] = true; // 🔥 여기서 방문 체크!!

        while (!q.isEmpty()) {
            Point current = q.poll();
            
            // 목적지 도착하면 최단 거리 반환
            if (current.x == N - 1 && current.y == M - 1) {
                return current.c;
            }

            for (int k = 0; k < 4; k++) {
                int ni = current.x + dx[k];
                int nj = current.y + dy[k];

                // 범위 체크 및 방문 체크
                if (ni >= 0 && ni < N && nj >= 0 && nj < M) {
                    if (arr[ni][nj] == 1 && !visited[ni][nj]) {
                        q.add(new Point(ni, nj, current.c + 1));
                        visited[ni][nj] = true; // 🔥 큐에 넣을 때 방문 처리!!
                    }
                }
            }
        }
        return -1; // 도달할 수 없는 경우 (이론적으로 문제에서 보장되므로 필요 없음)
    }
}