import java.io.*;
import java.util.*;

public class Solution {
    public static boolean check(String input)
    {
       int l = 0;
        int r = input.length() - 1;

        while (l <= r) {
            if (input.charAt(l) != input.charAt(r)) {
                return false;
            }
            l++; 
            r--; 
        }

        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (check(input)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        scanner.close();
    }
}
