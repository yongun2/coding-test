import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        int[] alpha = new int[26];

        Arrays.fill(alpha, -1);

        String input = br.readLine();

        for (int i = 0; i < input.length(); ++i) {
            int index = input.charAt(i) - 97;
            int val = alpha[index];
            if (val == -1){
                alpha[index] = i;
            }
        }

        for(int val: alpha) {
            bw.write(val + " ");
        }
        bw.flush();
        bw.close();
    }
}