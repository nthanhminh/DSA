import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JavaMap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Map<String, String> mp = new HashMap<>();

        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            String phoneNumber = scanner.nextLine();
            mp.put(name, phoneNumber);
        }

        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            if (mp.containsKey(s)) {
                System.out.println(s + "=" + mp.get(s));
            } else {
                System.out.println("Not found");
            }
        }

        scanner.close();
    }
}
