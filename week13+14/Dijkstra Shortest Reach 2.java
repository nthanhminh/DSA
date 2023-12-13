import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Cost implements Comparable<Cost> {
    public int r, v;
    public Cost(int cost, int vertex) {
        r = cost;
        v = vertex;
    }
    @Override
    public int compareTo(Cost c) {
        if (r < c.r) return -1;
        if (r> c.r) return 1;
        if (v < c.v) return -1;
        if (v > c.v) return 1;
        return 0;
    }
    
}


class Result {

    /*
     * Complete the 'shortestReach' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY edges
     *  3. INTEGER s
     */

    public static List<Integer> shortestReach(int n, List<List<Integer>> edges, int s) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Cost> q = new PriorityQueue<>();
        List<List<Cost>> a = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            a.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.size(); i++) {
            int u = edges.get(i).get(0);
            int v = edges.get(i).get(1);
            int dis = edges.get(i).get(2);
            a.get(u).add(new Cost(dis, v));
            a.get(v).add(new Cost(dis, u));
        }

        int[] distance = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[s] = 0;
        q.add(new Cost(0, s));

        while (!q.isEmpty()) {
            Cost cur = q.poll();
            int v = cur.v;

            if (visited[v]) continue;
            visited[v] = true;

            for (int i = 0; i < a.get(v).size(); i++) {
                Cost curCost = a.get(v).get(i);
                int curV = curCost.v;
                int dis = curCost.r;
                if (distance[curV] > distance[v] + dis) {
                    distance[curV] = distance[v] + dis;
                }
                q.add(new Cost(distance[curV], curV));
            }
        }

        for (int i = 1; i <= n; i++) {
            if (i != s) {
                res.add(distance[i] == Integer.MAX_VALUE ? -1 : distance[i]);
            }
        }

        return res;
    }

}

public class Solution {
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            if (st == null || !st.hasMoreElements ()) {
                do {
                    try {
                        st = new StringTokenizer (br.readLine ());
                    } catch (IOException e) {
                        e.printStackTrace ();
                    }
                } while (st == null || !st.hasMoreElements ());
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {
        FastReader in=new FastReader();//creating the object
        int t1=in.nextInt();//taking input of the number of testcases to be solved
        for(int gj=0;gj<t1;gj++){//taking input of hte odes ad edges
            int n=in.nextInt();
            int m=in.nextInt();
            long w[][]=new long [n+1][n+1];
            for (long[] row: w)
                Arrays.fill(row, 1000000l);
            IntStream.range (0, m).forEach (i -> {
                int x = in.nextInt (), y = in.nextInt ();
                long cmp = in.nextLong ();
                if (w[x][y] > cmp) {
                    w[x][y] = cmp;
                    w[y][x] = cmp;
                }
            });
            Stack <Integer> t=new Stack<Integer>();
            int src=in.nextInt();
            for(int i=1;i<=n;i++){
                if(i!=src){t.push(i);}}
            Stack <Integer> p=new Stack<Integer>();
            p.push(src);
            w[src][src]=0;
            if (!t.isEmpty ()) {
                do {
                    int min = 989997979, loc = -1;
                    for (int i = 0; i < t.size (); i++) {
                        w[src][t.elementAt (i)] = Math.min (w[src][t.elementAt (i)], w[src][p.peek ()] + w[p.peek ()][t.elementAt (i)]);
                        if (w[src][t.elementAt (i)] <= min) {
                            min = (int) w[src][t.elementAt (i)];
                            loc = i;
                        }
                    }
                    p.push (t.elementAt (loc));
                    t.removeElementAt (loc);
                } while (!t.isEmpty ());
            }
            int i=1;
            while (i<=n) {
                if(i!=src && w[src][i]!=1000000l){System.out.print(w[src][i]+" ");}
                else if(i!=src){System.out.print("-1"+" ");}
                i++;
            }
            System.out.println();
        }
    }
}
