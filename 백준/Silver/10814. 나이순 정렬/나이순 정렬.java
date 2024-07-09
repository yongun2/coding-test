import java.io.*;
import java.util.*;

class Main {

    static class Member {
        public int id;
        public int age;
        public String name;

        public Member(int id, int age, String name) {
            this.id = id;
            this.age = age;
            this.name = name;
        }

    }

    private static List<Member> members = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            members.add(new Member(i, age, name));
        }

        members.sort((m1, m2) -> {
            if (m1.age > m2.age) {
                return 1;
            } else if (m1.age == m2.age) {
                return m1.id - m2.id;
            } else {
                return -1;
            }
        });

        for (Member member : members) {
            bw.write(member.age + " " + member.name + "\n");
        }
        bw.flush();
        bw.close();

    }
}