import java.util.*;
public class CountEqualPairs {
    public static int count(ArrayList<Integer> numbers){
            Collections.sort(numbers);
            // Tính số cặp số có giá trị bằng nhau
            int count = 0;
            int currentNumber = numbers.get(0);
            int currentCount = 1;
            for (int i = 1; i < numbers.size(); i++) {
                int num = numbers.get(i);
                if (num == currentNumber) {
                    currentCount++;
                } else {
                    // Có currentCount * (currentCount - 1) / 2 cặp số bằng nhau cho mỗi giá trị
                    count += (currentCount * (currentCount - 1)) / 2;
                    currentNumber = num;
                    currentCount = 1;
                }
            }

            // Xử lý trường hợp cuối cùng
            count += (currentCount * (currentCount - 1)) / 2;
            return count;
    }
    public static void main(String[] args) {
    }
}