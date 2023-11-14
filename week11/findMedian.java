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

class Node {
    int data;
    int count;
    Node left, right;

    public Node(int item, int count) {
        this.data = item;
        this.count = count;
        this.left = this.right = null;
    }
}

class Result {

    private static Node root;

    private static void insert(int value) {
        root = insert(root, value);
    }

    private static Node insert(Node root, int value) {
        if (root == null) {
            return new Node(value, 1);
        }

        if (value < root.data) {
            root.left = insert(root.left, value);
        } else if (value > root.data) {
            root.right = insert(root.right, value);
        } else {
            root.count++;
        }

        return root;
    }

    private static int size(Node root) {
        return (root != null) ? root.count : 0;
    }

    private static double findKmin(Node root, int k) {
        int leftSize = size(root.left);
        if (k == leftSize + 1) {
            return root.data;
        } else if (k <= leftSize) {
            return findKmin(root.left, k);
        } else {
            return findKmin(root.right, k - leftSize - 1);
        }
    }

    public static List<Double> runningMedian(List<Integer> a) {
        List<Double> medians = new ArrayList<>();
        root = null;

        for (int i = 0; i < a.size(); i++) {
            insert(a.get(i));
            int size = i + 1;
            if (size % 2 == 1) {
                medians.add(findKmin(root, size / 2 + 1));
            } else {
                double median1 = findKmin(root, size / 2);
                double median2 = findKmin(root, size / 2 + 1);
                medians.add((median1 + median2) / 2.0);
            }
        }

        return medians;

}
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<Double> result = Result.runningMedian(a);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
