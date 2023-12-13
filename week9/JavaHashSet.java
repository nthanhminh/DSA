import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class JavaHashSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Set<String> s = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String first = scanner.next();
            String last = scanner.next();
            s.add(first + " " + last);
            System.out.println(s.size());
        }

        scanner.close();
    }
}
