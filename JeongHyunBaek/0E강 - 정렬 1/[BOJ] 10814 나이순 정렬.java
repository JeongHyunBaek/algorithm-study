import java.io.*;
import java.util.*;

class Main {
    static class Member {
        private int age;
        private String name;

        public Member(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Member> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int age = sc.nextInt();
            String name = sc.next();

            list.add(new Member(age, name));
        }

        list.sort((o1, o2) -> o1.getAge() - o2.getAge());

        for (Member member : list) {
            System.out.println(member.getAge() + " " + member.getName());
        }
    }
}
