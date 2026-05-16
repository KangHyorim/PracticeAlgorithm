import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Base64 디코딩 테이블 생성
        int[] decodeTable = new int[128];
        String base64Chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
        for (int i = 0; i < 64; i++) {
            decodeTable[base64Chars.charAt(i)] = i;
        }
        
        int T = sc.nextInt();
        
        for (int t = 1; t <= T; t++) {
            String encoded = sc.next();
            StringBuilder result = new StringBuilder();
            
            // 4글자씩 처리
            for (int i = 0; i < encoded.length(); i += 4) {
                char c1 = encoded.charAt(i);
                char c2 = encoded.charAt(i + 1);
                char c3 = encoded.charAt(i + 2);
                char c4 = encoded.charAt(i + 3);
                
                // 6비트 값 4개를 24비트 버퍼에 합치기
                int buffer = (decodeTable[c1] << 18)
                           | (decodeTable[c2] << 12)
                           | (decodeTable[c3] << 6)
                           | (decodeTable[c4]);
                
                // 24비트를 8비트씩 3개의 문자로 분리
                char out1 = (char) ((buffer >> 16) & 0xFF);
                char out2 = (char) ((buffer >> 8)  & 0xFF);
                char out3 = (char) ((buffer)        & 0xFF);
                
                // '=' 패딩 처리
                result.append(out1);
                if (c3 != '=') result.append(out2);
                if (c4 != '=') result.append(out3);
            }
            
            System.out.println("#" + t + " " + result.toString());
        }
        
        sc.close();
    }
}