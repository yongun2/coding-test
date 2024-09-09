import java.io.*;
import java.util.*;

class Main {

    static int N, K;
    static int[] inputs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        inputs = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }
        int[] numbers = new int[100001];

        int left = 0;
        int right = left + 1;
        numbers[inputs[left]] = 1;

        int cnt = 1;
        int result = Integer.MIN_VALUE;
        while (left <= right && right < N) {

            if (numbers[inputs[right]] < K) {
                numbers[inputs[right]] += 1;
                right++;
                cnt++;
            } else {
                numbers[inputs[left]] -= 1;
                left += 1;
                cnt--;
            }
            result = Math.max(result, cnt);
        }

        System.out.println(result);



    }
}
