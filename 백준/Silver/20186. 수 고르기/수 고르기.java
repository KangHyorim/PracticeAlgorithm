import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 1. N과 K 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        // 2. 배열 입력 받기
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 3. 정렬 (오름차순)
        Arrays.sort(arr);
        
        // 4. 가장 큰 수 K개의 합 구하기
        int sum = 0;
        for (int i = 0; i < K; i++) {
            // 오름차순 정렬이므로 배열의 끝에서부터 값을 가져옴
            sum += arr[N - 1 - i];
        }
        
        // 5. 패널티(0부터 K-1까지의 합) 계산 후 차감
        // 공식: K * (K - 1) / 2
        int penalty = (K * (K - 1)) / 2;
        
        System.out.println(sum - penalty);
    }
}