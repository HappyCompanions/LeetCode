package tw.dy93;

/**
 * Created by dy93 on 2017/1/13.
 */
public class Solution {
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public void wiggleSort(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return;
        }
        if (len % 2 == 1) {
            len = len - 1;
        }

        for (int i = 0; i <= len - 2; i += 2) {
            if (nums[i] > nums[i + 1]) {
                swap(nums, i, i + 1);
            }
        }

        for (int i = 1; i < len - 2; i += 2) {
            if (nums[i] < nums[i + 1]) {
                swap(nums, i, i + 1);
            }
        }

        if (nums.length % 2 == 1 && nums[len - 1] <= nums[len]) {
            swap(nums, len - 1, len);
        }
        return;
    }
}