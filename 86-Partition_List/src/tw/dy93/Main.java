package tw.dy93;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = s.makeList(new int[]{1, 4, 3, 2, 5, 2});

        s.partition(head, 3);
    }


}
