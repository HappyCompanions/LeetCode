package tw.dy93;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Solution sol = new Solution();
//        List<List<Integer>> ans = sol.getFactors(32);
        List<List<Integer>> ans = sol.getFactors(23848713);
        // expected: [[2,24],[3,16],[4,12],[2,2,12],[6,8],[2,3,8],[2,4,6],[2,2,2,6],[3,4,4],[2,2,3,4],[2,2,2,2,3]]
        System.out.print(ans);
    }
}
