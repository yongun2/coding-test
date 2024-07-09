import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Main {

    private static int N;
    private static Set<String> set = new HashSet<>();
    private static List<String> inputs = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; ++i) {
            set.add(br.readLine());
        }

        inputs = new ArrayList<>(set);
        inputs.sort((s1, s2) -> {
            if (s1.length() > s2.length()) {
                return 1;
            } else if (s1.length() == s2.length()) {
                return s1.compareTo(s2);
            } else {

                return -1;
            }
        });
        for (String str : inputs) {
            bw.write(str + "\n");
        }
        bw.flush();
        bw.close();
        
    }
}