package tw.dy93;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Solution sol = new Solution();
        System.out.println(sol.parseTernary("F?1:T?4:5"));
        System.out.println(sol.parseTernary("T?2:3"));
        System.out.println(sol.parseTernary("T?T?F:5:3"));
    }
}
