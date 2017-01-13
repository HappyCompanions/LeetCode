package tw.dy93;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static int TESTS = 100;

    public static int[] genInput() {
        Random rand = new Random();
        int length = rand.nextInt(100) + 1;
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = rand.nextInt(100) + 1;
        }
        return nums;
    }

    public static boolean verify(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (i % 2 == 1 && nums[i] < nums[i - 1]) {
                return false;
            } else if (i % 2 == 0 && nums[i] > nums[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        Solution s = new Solution();
        for (int i = 0; i < TESTS; i++) {
            int[] nums = genInput();
            try {
                s.wiggleSort(nums);
            } catch (Exception e) {
                System.out.println(Arrays.toString(nums));
            }
            if (!verify(nums)) {
                System.out.println(Arrays.toString(nums));
                throw new Exception("fail");
            }
        }
    }
}
