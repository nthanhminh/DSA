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

class unionFind {
    private int[] root; 
    public unionFind(int n)
    {
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
    public int find2(int i)
    {
        return root[i];
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
    public void connect(int x,int y,int n)
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
     * Complete the 'roadsAndLibraries' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER c_lib
     *  3. INTEGER c_road
     *  4. 2D_INTEGER_ARRAY cities
     */

    public static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {
    // Write your code here
        long res = 0;
        unionFind uf = new unionFind(n+1);
        for (List<Integer> city : cities)
        {
            int f = city.get(0);
            int s = city.get(1);
            uf.connect(f, s, n+1);
        }
        for (int i=1;i<=n;i++)
        {
            if(uf.find2(i) < 0)
            {
                int num = Math.abs(uf.find2(i));
                res += Math.min(num*c_lib,c_lib + (num-1) * c_road);
            }
        }
        return res;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int c_lib = Integer.parseInt(firstMultipleInput[2]);

                int c_road = Integer.parseInt(firstMultipleInput[3]);

                List<List<Integer>> cities = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        cities.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                long result = Result.roadsAndLibraries(n, c_lib, c_road, cities);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
