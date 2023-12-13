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

class Result {

    /*
     * Complete the 'connectedCell' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     */

    public static int connectedCell(List<List<Integer>> matrix) {
    // Write your code here
        int res = 0;
        int n = matrix.size();
        int m = matrix.get(0).size();
        for (int i=0;i<n;i++)
        {
            for (int j=0;j<m;j++)
            {
                if(matrix.get(i).get(j) == 1)
                {
                    int cnt = dfs(matrix,i,j,n,m);
                    res = Math.max(res,cnt);
                }
            }
        }
        return res;
    }
    
    public static int dfs(List<List<Integer>> matrix, int i, int j,int n, int m)
    {
        if(i<0 || i>=n || j<0 || j>=m || matrix.get(i).get(j)==0)
        {
            return 0;
        }
        int res = 1;
        matrix.get(i).set(j,0); 
        res += dfs(matrix,i+1,j+1,n,m) + dfs(matrix,i+1,j-1,n,m) 
             + dfs(matrix,i-1,j-1,n,m) + dfs(matrix,i-1,j+1,n,m)
             + dfs(matrix,i,j-1,n,m) + dfs(matrix,i,j+1,n,m)
             + dfs(matrix,i-1,j,n,m) + dfs(matrix,i+1,j,n,m);
        return res;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                matrix.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.connectedCell(matrix);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
