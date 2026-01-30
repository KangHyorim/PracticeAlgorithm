import java.io.*;
import java.util.*;

public class Main {
    static int R, C, N;
    static int[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        board = new int[R][C];
        for (int i = 0; i < R; i++) {
            Arrays.fill(board[i], -1);
        }

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                char ch = str.charAt(j);
                if (ch == 'O') board[i][j] = 3;  // 터져야 하는 시간
            }
        }

        for (int t = 2; t <= N; t++) {
            if (t % 2 == 0) {
                install(t);
            } else {
                bomb(t);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == -1) sb.append(".");
                else sb.append("O");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void install(int time) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = time + 3;
                }
            }
        }
    }

    private static void bomb(int time) {
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == time) {
                    list.add(new int[] {i,j});
                }
            }
        }

        for(int[] x : list){
            int i = x[0];
            int j = x[1];

            board[i][j] = -1;
            if (i - 1 >= 0) board[i - 1][j] = -1;
            if (i + 1 < R) board[i + 1][j] = -1;
            if (j - 1 >= 0) board[i][j - 1] = -1;
            if (j + 1 < C) board[i][j + 1] = -1;
        }
    }
}

