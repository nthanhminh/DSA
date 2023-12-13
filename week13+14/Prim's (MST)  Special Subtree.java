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
     * Complete the 'prims' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY edges
     *  3. INTEGER start
     */

 public static int prims(int n, List<List<Integer>> edges, int start) {
        int res = 0;
        PriorityQueue<Cost> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n + 1];
        List<List<Cost>> a = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            a.add(new ArrayList<>());
        }
        for (int i=0;i<edges.size();i++)
        {
            List<Integer> tmp = edges.get(i);
            int u = tmp.get(0);
            int v = tmp.get(1);
            int w = tmp.get(2);
            a.get(u).add(new Cost(w, v));
            a.get(v).add(new Cost(w, u));
        }
        pq.add(new Cost(0, start));
        while (!pq.isEmpty()) {
            Cost current = pq.poll();
            int curV = current.v;

            if (visited[curV]) continue;

            visited[curV] = true;
            res += current.r;

            for (int i=0;i<a.get(curV).size();i++)
            {
                int u = a.get(curV).get(i).v;
                if(!visited[u])
                {
                    pq.add(a.get(curV).get(i));
                }
            }
        }
        return res;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> edges = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                edges.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int start = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.prims(n, edges, start);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
