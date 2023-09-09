import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdArrayIO;
import edu.princeton.cs.algs4.StdOut;

public class threeSum {
    public static void main(String[] args){
        In in=new In("C:\\Users\\laptop\\Downloads\\algs4-data\\1Kints.txt");
        int[] a=in.readAllInts();   
        Arrays.sort(a);
        StdArrayIO.print(a);
        StdOut.println();
        for(int i=0;i<a.length;i++)
        {
            if(i>0 && a[i]==a[i-1])
            {
                continue;
            }
            int l=i+1;
            int r=a.length-1;
            while(l<r)
            {
                int sum=a[i]+a[l]+a[r];
                if(sum==0)
                {
                    StdOut.println(a[i] + " " +a[l] + " " + a[r]);
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
                else if(sum<0)
                {
                    l++;
                }
                else
                {
                    r--;
                }
            }
        }
    }
}
