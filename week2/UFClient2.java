import edu.princeton.cs.algs4.*;
public class UFClient2 { 
   public static void main(String[] args) { 
        int N = StdIn.readInt(); 
        QuickUnionUF uf = new QuickUnionUF(N); 
        int cnt=N;
        int res=0;
        while (!StdIn.isEmpty()) { 
            int p = StdIn.readInt(); 
            int q = StdIn.readInt(); 
            if(cnt==1)
            {   
                StdOut.println(res);
                break; 
            }
            else {
                res++;
            }
            if (uf.find(p)!=uf.find(q)) { 
                uf.union(p, q); 
                // StdOut.println(p + " " + q); 
                cnt--;
            }
        }
        if(cnt!=1) {
            StdOut.println("FAILED ");
        } 
   }
}