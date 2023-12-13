import java.io.*;
import java.util.*;

public class SelectionSort {
    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("thoigian.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            int[] arr = {1, 5, 2, 9, 8, -2, -1, -9};

            long startTime = System.currentTimeMillis();

            selectionSort(arr);

            long endTime = System.currentTimeMillis();
            long executionTime = endTime - startTime;

            System.out.print("Dãy số sau khi sắp xếp: ");
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();

            System.out.println("Thời gian thực thi: " + executionTime + " ms");

            bw.write("Thời gian thực thi: " + executionTime + " ms");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
