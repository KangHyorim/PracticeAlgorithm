class Solution {
    char[][] arr;
    int M, N;

    public int solution(int m, int n, String[] board) {
        this.M = m;
        this.N = n;
        arr = new char[M][N];

        for(int i = 0; i < M; i++){
            arr[i] = board[i].toCharArray();
        }

        int answer = 0;

        while(true) {
            boolean[][] isChecked = new boolean[M][N];
            boolean found = false;

            for(int i = 0; i < M - 1; i++){
                for(int j = 0; j < N - 1; j++){
                    if(arr[i][j] == '0') continue;

                    char c = arr[i][j];
                    if(c == arr[i][j+1] && c == arr[i+1][j] && c == arr[i+1][j+1]) {
                        isChecked[i][j] = true;
                        isChecked[i][j+1] = true;
                        isChecked[i+1][j] = true;
                        isChecked[i+1][j+1] = true;
                        found = true;
                    }
                }
            }

            if(!found) break;

            answer += remove(isChecked);

            applyGravity();
        }

        return answer;
    }

    private int remove(boolean[][] isChecked) {
        int cnt = 0;
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(isChecked[i][j] && arr[i][j] != '0') {
                    arr[i][j] = '0';
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private void applyGravity() {
        for(int j = 0; j < N; j++) {
            for(int i = M - 1; i >= 0; i--) {
                if(arr[i][j] == '0') {
                    for(int k = i - 1; k >= 0; k--) {
                        if(arr[k][j] != '0') {
                            arr[i][j] = arr[k][j];
                            arr[k][j] = '0';     
                            break; 
                        }
                    }
                }
            }
        }
    }
}