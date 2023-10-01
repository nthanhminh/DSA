import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.math.BigInteger;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int left = i + 1, right = nums.length - 1;
                BigInteger target = BigInteger.valueOf(-nums[i]);

                while (left < right) {
                    BigInteger sum = BigInteger.valueOf(nums[left]).add(BigInteger.valueOf(nums[right]));

                    if (sum.equals(target)) {
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    } else if (sum.compareTo(target) < 0) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        List<List<Integer>> triplets = threeSum(nums);

        if (triplets.isEmpty()) {
            System.out.println("No triplet found.");
        } else {
            for (List<Integer> triplet : triplets) {
                System.out.println("Triplet found: " + triplet.get(0) + " " + triplet.get(1) + " " + triplet.get(2));
            }
        }
    }
}
