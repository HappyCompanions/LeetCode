package tw.dy93;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Solution sol = new Solution();
        int[] ary = new int[]{-100, -84, -84, -82, -68, -56, -40, -30, 48, 56, 59, 73, 73, 73, 87};
//        int[] ary = new int[]{-4, -2, 2, 4};
//        int[] ary = new int[]{-97, -95, -82, -81, -76, -75, -74, -73, -72, -69, -68, -66, -64, -61, -56, -53, -51, -50, -47, -46, -43, -41, -39, -33, -30, -30, -29, -28, -27, -26, -25, -25, -23, -22, -18, -16, -16, -15, -9, -4, -2, -1, 5, 16, 20, 20, 21, 21, 24, 24, 33, 39, 40, 44, 44, 49, 51, 53, 54, 55, 57, 58, 58, 59, 62, 63, 65, 67, 68, 69, 71, 72, 73, 73, 74, 76, 77, 78, 79, 81, 88, 90, 91, 92, 92, 96, 97};
        ary = sol.sortTransformedArray(ary, 31, 71, 96);
        System.out.println(Arrays.toString(ary));
        Arrays.sort(ary);
        System.out.println(Arrays.toString(ary));
    }
}
