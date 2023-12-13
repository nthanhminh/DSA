import java.io.*;
import java.util.*;

public class Solution {

    private Stack<Integer> st1 = new Stack<>();
    
    private Stack<Integer> st2 = new Stack<>();

    public void enqueue(int x)
    {
        st1.push(x);
    }
    
    public void dequeue()
    {
        if(st2.isEmpty())
        {
            st1Tost2();
        }
        st2.pop();
    }
    
    public int peek()
    {
        if(st2.isEmpty())
        {
            st1Tost2();
        }
        return st2.peek();
    }
    
    public void st1Tost2()
    {
        while(!st1.isEmpty())
        {
            int tmp = st1.pop();
            st2.push(tmp);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        Solution q = new Solution();

        for (int i = 0; i < t; i++) {
            int choice = scanner.nextInt();
            if (choice == 1) {
                int x = scanner.nextInt();
                q.enqueue(x);
            } else if (choice == 2) {
                q.dequeue();
            } else if (choice == 3) {
                System.out.println(q.peek());
            }
        }
    }
}