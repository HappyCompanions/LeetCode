package tw.dy93;

import java.util.Arrays;

/**
 * Created by dy93 on 2017/3/10.
 */
public class Solution {


    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] calculatedNums = Arrays.stream(nums)
                .map(num -> a * num * num + b * num + c).toArray();
        if (a == 0) {
            if (b < 0) {
                reverseArray(calculatedNums);
            }
            return calculatedNums;
        }

        float mid = -(float) b / (2 * a);
        int midIndex = binarySearch(nums, mid);
        int i, j;
        i = midIndex - 1;
        j = i + 1;

        int[] result = new int[nums.length];
        int k = 0;

        while (i >= 0 && j <= nums.length - 1) {
            if (a > 0) {
                if (calculatedNums[i] < calculatedNums[j]) {
                    result[k++] = calculatedNums[i--];
                } else {
                    result[k++] = calculatedNums[j++];
                }
            } else {
                if (calculatedNums[i] > calculatedNums[j]) {
                    result[k++] = calculatedNums[i--];
                } else {
                    result[k++] = calculatedNums[j++];
                }
            }
        }

        while (i >= 0) {
            result[k++] = calculatedNums[i--];
        }

        while (j <= nums.length - 1) {
            result[k++] = calculatedNums[j++];
        }

        if (a < 0) {
            reverseArray(result);
        }
        return result;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverseArray(int[] ary) {
        for (int i = 0; i < ary.length / 2; i++) {
            swap(ary, i, ary.length - i - 1);
        }
    }

    private int binarySearch(int[] ary, float key) {
        int begin = 0, end = ary.length - 1;

        while (begin <= end) {
            int mid = (begin + end) / 2;

            if (key < ary[mid]) {
                end = mid - 1;
            } else if (ary[mid] < key) {
                begin = mid + 1;
            } else {
                return mid;
            }
        }
        return begin;
    }

}
