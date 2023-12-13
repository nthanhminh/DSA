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
    public int r, v, u;
    public Cost(int cost, int v,int u) {
        this.r = cost;
        this.v = v;
        this.u = u;
    }
    @Override
    public int compareTo(Cost c) {
        if (r < c.r) return -1;
        if (r> c.r) return 1;
        if (v < c.v) return -1;
        if (v > c.v) return 1;
        if (u < c.u) return -1;
        if (u > c.u) return 1;
        return 0;
    }
}

class unionFind {
    private int[] root; 
    public unionFind(int n)
    {
        //initial root
        root = new int[n];
        Arrays.fill(root,-1);
    }
    public int find(int p)
    {
        while(root[p] > 0)
        {
            p=root[p];
        }
        return p;
    }
    public boolean isconnected(int p,int q)
    {
        int parent_p=find(p);
        int parent_q=find(q);
        if(parent_p!=parent_q)
        {
            return false;
        }
        return true;
    }
    public int getRoot(int p)
    {
        if(root[p]<0)
        {
            return p;
        }
        return root[p]=getRoot(root[p]);
    }
    public void union(int x,int y,int n)
    {
        int parentX = getRoot(x);
        int parentY = getRoot(y);
        if(parentX != parentY)
        {
            if(root[parentX] <= root[parentY])
            {
                root[parentX] += root[parentY];
                root[parentY] = parentX;
            }
            else {
                root[parentY] += root[parentX];
                root[parentX] = parentY;
            }
        }
    }
}

class Result {

    /*
     * Complete the 'kruskals' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts WEIGHTED_INTEGER_GRAPH g as parameter.
     */

    /*
     * For the weighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] and <name>To[i]. The weight of the edge is <name>Weight[i].
     *
     */

    public static int kruskals(int n, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
        int res = 0; 
        PriorityQueue<Cost> q =new PriorityQueue<>();
        List<List<Cost>> a = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            a.add(new ArrayList<>());
        }
        for (int i=0; i < gFrom.size();i++)
        {
            int u = gFrom.get(i);
            int v = gTo.get(i);
            int w = gWeight.get(i);
            a.get(u).add(new Cost(w,u,v));
            a.get(v).add(new Cost(w,v,u));
        }
        unionFind qf = new unionFind(n+1);
        for (int i=0;i<a.size();i++)
        {
            for (Cost cost:a.get(i))
            {
                q.add(cost);
            }
        }
        
      while (!q.isEmpty()) {
            Cost curCoss = q.poll();
            int v = curCoss.v;
            int u = curCoss.u;

            if (!qf.isconnected(u, v)) {
                System.out.println(curCoss.r + " " + v + " " + u);
                qf.union(u, v,n+1);
                res += curCoss.r;
            }
        }

        
        return res;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] gNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int gNodes = Integer.parseInt(gNodesEdges[0]);
        int gEdges = Integer.parseInt(gNodesEdges[1]);

        List<Integer> gFrom = new ArrayList<>();
        List<Integer> gTo = new ArrayList<>();
        List<Integer> gWeight = new ArrayList<>();

        IntStream.range(0, gEdges).forEach(i -> {
            try {
                String[] gFromToWeight = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                gFrom.add(Integer.parseInt(gFromToWeight[0]));
                gTo.add(Integer.parseInt(gFromToWeight[1]));
                gWeight.add(Integer.parseInt(gFromToWeight[2]));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int res = Result.kruskals(gNodes, gFrom, gTo, gWeight);

        // Write your code here.
        bufferedWriter.write(String.valueOf(res));

        bufferedReader.close();
        bufferedWriter.close();
    }
}
