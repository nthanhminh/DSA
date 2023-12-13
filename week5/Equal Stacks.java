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
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
     */

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) 
    {
        Map<Integer, Integer> mp1 = new HashMap<>();
        Map<Integer, Integer> mp2 = new HashMap<>();
        Map<Integer, Integer> mp3 = new HashMap<>();

        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;

        for (int i = h1.size() - 1; i >= 0; i--) {
            sum1 += h1.get(i);
            mp1.put(sum1, 1);
        }

        for (int i = h2.size() - 1; i >= 0; i--) {
            sum2 += h2.get(i);
            mp2.put(sum2, 1);
        }

        for (int i = h3.size() - 1; i >= 0; i--) {
            sum3 += h3.get(i);
            mp3.put(sum3, 1);
        }

        int res = 0;

        for (Integer key : mp3.keySet()) {
            if (mp1.containsKey(key) && mp2.containsKey(key)) {
                res = Math.max(res,key);
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

        int n1 = Integer.parseInt(firstMultipleInput[0]);

        int n2 = Integer.parseInt(firstMultipleInput[1]);

        int n3 = Integer.parseInt(firstMultipleInput[2]);

        List<Integer> h1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> h2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> h3 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
