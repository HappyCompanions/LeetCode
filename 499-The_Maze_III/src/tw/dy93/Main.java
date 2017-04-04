package tw.dy93;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] maze = {
                {0, 0, 0, 0, 0},
                {1, 1, 0, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {0, 1, 0, 0, 0}
        };
        int[] ball = {4, 3};
        int[] hole = {0, 1};

//        int[][] maze = {
//                {0, 0, 0, 0, 0},
//                {1, 1, 0, 0, 1},
//                {0, 0, 0, 0, 0},
//                {0, 1, 0, 0, 1},
//                {0, 1, 0, 0, 0}
//        };
//        int[] ball = {4, 3};
//        int[] hole = {3, 0};

//        int[][] maze = {
//                {0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 1, 0, 0, 1, 0},
//                {0, 0, 0, 0, 1, 0, 0},
//                {0, 0, 0, 0, 0, 0, 1}
//        };
//        int[] ball = {0, 4};
//        int[] hole = {3, 5};//dldr

//        int[][] maze = {
//                {0, 0, 1, 0, 0},
//                {0, 0, 0, 0, 0},
//                {0, 0, 0, 1, 0},
//                {1, 1, 0, 1, 1},
//                {0, 0, 0, 0, 0}
//        };
//        int[] ball = {0, 4};
//        int[] hole = {4, 4};//ldldrdr
        System.out.println(sol.findShortestWay(maze, ball, hole));
    }
}
