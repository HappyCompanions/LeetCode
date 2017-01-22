package tw.dy93;

public class Main {

    public static void main(String[] args) {
        int[][] input = new int[][]{{0, 1}, {3, 6}, {3, 9}, {6, 9}, {2, 5}, {7, 2}, {7, 5}};
//        int[][] input = new int[][]{{2, 3}, {1, 2}, {1, 3}};
        Solution s = new Solution();
        System.out.println(s.countComponents(10, input));
    }
}
