import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        Stack<String> st = new Stack<>();
        String now = "";
        for (int i=0;i<q;i++)
        {
            int choice = scanner.nextInt();
            if(choice == 1)
            {
                String add = scanner.next();
                st.push(now);
                now+=add;
            }
            else if (choice == 2)
            {
                int k = scanner.nextInt();
                st.push(now);
                int n = now.length();
                now = now.substring(0, n - k);
            }
            else if (choice == 3)
            {
                int k = scanner.nextInt();
                int n = now.length();
                if(k>0 && k<n+1)
                {
                    System.out.println(now.charAt(k-1));
                }
            }
            else 
            {
                if(!st.isEmpty())
                {
                    now = st.pop();
                }
            }
        }
        
    }
}