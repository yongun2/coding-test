import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        int result = 0;

        String input = br.readLine();

        if (!input.contains("-")) {
            StringTokenizer st = new StringTokenizer(input, "+");
            while (st.hasMoreTokens()) {
                result += Integer.parseInt(st.nextToken());
            }
        } else {
            StringTokenizer stMinus = new StringTokenizer(input, "-");

            String start = stMinus.nextToken();
            StringTokenizer stStart = new StringTokenizer(start, "+");
            while (stStart.hasMoreTokens()) {
                result += Integer.parseInt(stStart.nextToken());
            }

            while (stMinus.hasMoreTokens()) {
                int minusSum = 0;
                StringTokenizer stPlus = new StringTokenizer(stMinus.nextToken(), "+");
                while (stPlus.hasMoreTokens()) {
                    minusSum += Integer.parseInt(stPlus.nextToken());
                }

                result = result - minusSum;
            }
        }



        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}