import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        StringTokenizer st = null;

        while (true) {
            String number = br.readLine();

            if ("0".equals(number)) {
                break;
            }

            if (isP(number)) {
                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }


        }
        bw.flush();
        bw.close();
    }

    private static boolean isP(String number) {

        int start = 0;
        int end = number.length() - 1;
        while (start <= end) {
            if (number.charAt(start) != number.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;

    }
}