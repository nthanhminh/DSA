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
     * Complete the 'missingNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER_ARRAY brr
     */

     //C1
    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        Map<Integer, Integer> mp = new HashMap<>();

            for (Integer num : arr) {
                mp.put(num, mp.getOrDefault(num, 0) + 1);
            }

            for (Integer num : brr) {
                mp.put(num, mp.getOrDefault(num, 0) - 1);
            }

            List<Integer> res = new ArrayList<>();

            for (Integer key : mp.keySet()) {
                if (mp.get(key) != 0) {
                    res.add(key);
                }
            }

            Collections.sort(res);

            return res;
    }

    //C2
    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        Collections.sort(arr);
        Collections.sort(brr);
        int i = 0;
        int j = 0;
        int n = arr.size();
        int m = brr.size();
        List<Integer> res = new ArrayList<>();
        while(i<n && j<m)
        {
            if(arr.get(i).equals(brr.get(j)))
            {
                i++;
                j++;
            }
            else
            {
                if(!res.contains(brr.get(j)))
                {
                    res.add(brr.get(j));
                }
                j++;
            }
        }
        while (j<m)
        {
            if(!res.contains(brr.get(j)))
            {
                res.add(brr.get(j));
            }
            j++;
        }
        return res;
    }

    //C3

    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        List<Integer> res = new ArrayList<>();
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        for (Integer num : arr)
        {
            if (num < minVal)
            {
                minVal = num;
            }
            if (num > maxVal)
            {
                maxVal = num;
            }
        }
        for (Integer num : brr)
        {
            if (num < minVal)
            {
                minVal = num;
            }
            if (num > maxVal)
            {
                maxVal = num;
            }
        }
        int[] fre = new int[maxVal-minVal+1];
        for (Integer num : arr)
        {
            fre[num-minVal] ++;
        }
        for (Integer num : brr)
        {
            fre[num - minVal] --;
        }
        for (Integer num : brr)
        {
            if(fre[num - minVal] !=0)
            {
                if(!res.contains(num))
                {
                    res.add(num);
                }
            }
        } 
        Collections.sort(res);
        return res;
    }


}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.missingNumbers(arr, brr);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
