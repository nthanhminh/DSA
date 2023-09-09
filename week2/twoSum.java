import edu.princeton.cs.algs4.*;
import java.util.*;
public class twoSum{
    public static void main(String[] args){
        In in=new In("C:\\Users\\laptop\\Downloads\\algs4-data\\myTest2Sum.txt");
        int[] a=in.readAllInts();   
        int l=0;
        int r=a.length-1;
        Arrays.sort(a);
        StdArrayIO.print(a);
        StdOut.println();
        while(l<r)
        {
            int sum=a[l]+a[r];
            if(sum==0)
            {
                StdOut.println(a[l]+ " " +a[r]);
                l++;
                r--;
                while(l<r && a[l]==a[l-1])
                {
                    l++;
                }
                while(l<r && a[r]==a[r+1])
                {
                    r--;
                }
            }
            else if(sum>0)
            {
                r--;
            }
            else{
                l++;
            }
        }
    }
}