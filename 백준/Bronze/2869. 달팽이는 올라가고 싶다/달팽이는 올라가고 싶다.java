import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 입력 값 파싱
        int A = Integer.parseInt(st.nextToken()); // 낮에 올라가는 높이
        int B = Integer.parseInt(st.nextToken()); // 밤에 미끄러지는 높이
        int V = Integer.parseInt(st.nextToken()); // 나무 막대의 높이

        // 공식 적용: (V - B) / (A - B)
        // 나머지가 있을 경우 하루를 더해야 함 (Ceiling 처리)
        int days = (V - B) / (A - B);
        
        // 나머지가 0이 아니라는 것은 도착하지 못하고 조금 남았다는 뜻이므로 하루 추가
        if ((V - B) % (A - B) != 0) {
            days++;
        }

        System.out.println(days);
    }
}