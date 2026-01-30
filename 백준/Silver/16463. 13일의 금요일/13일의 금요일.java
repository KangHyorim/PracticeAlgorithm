import java.io.*;

public class Main {
    static int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int current = 1;
        int cnt = 0;

        for (int i = 2019; i <= N; i++) {
            for (int m = 1; m <= 12; m++) {
                if ((current + 12) % 7 == 4) cnt++;

                int daysInMonth = days[m];

                if (m == 2 && isLeapYear(i)) daysInMonth = 29;

                current = (current + daysInMonth) % 7;
            }
        }
        System.out.println(cnt);
    }

    private static boolean isLeapYear(int year) {
        if (year % 400 == 0) return true;
        if (year % 100 == 0) return false;
        return (year % 4 == 0);
    }
}