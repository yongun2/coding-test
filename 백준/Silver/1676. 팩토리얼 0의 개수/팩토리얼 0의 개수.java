import java.io.*;
import java.math.BigInteger;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());


        BigInteger val = BigInteger.ONE;
        for (long i = 1; i <= N; ++i) {
            val = val.multiply(BigInteger.valueOf(i));
        }
        String lookup = val.toString();
        int result = 0;
        
        for (int i = lookup.length() - 1; i >= 0; --i) {
            if (lookup.charAt(i) != '0') {
                break;
            }
            result++;
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }


}