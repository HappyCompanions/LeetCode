package tw.dy93;

import java.util.ArrayList;
/**
 * Created by dy93_ on 2017/3/20.
 */
public class Solution {
    private class StackEntry {
        public StackEntry() {
            this.trueToken = '\0';
            this.falseToken = '\0';

        }

        char trueToken;
        char falseToken;
    }


    public String parseTernary(String expression) {
        return String.valueOf(parse(expression));
    }

    private char parse(String expr) {
        ArrayList<Object> stack = new ArrayList<>();
        for (int i = 0; i <= expr.length(); i++) {
            switch (i == expr.length() ? ':' : expr.charAt(i)) {
                case ':':
                    Object top, top2;
                    Character token;
                    StackEntry e;
                    while (stack.size() >= 2 &&
                            (top = stack.get(stack.size() - 1)) instanceof Character &&
                            (top2 = stack.get(stack.size() - 2)) instanceof StackEntry) {
                        stack.remove(stack.size() - 1);
                        token = (Character) top;
                        e = (StackEntry) top2;
                        if (e.trueToken == '\0') {
                            e.trueToken = token;
                        } else if (e.falseToken == '\0') {
                            e.falseToken = token;
                            stack.remove(stack.size() - 1);
                            token = (char) stack.remove(stack.size() - 1);
                            if (token == 'T') {
                                stack.add(e.trueToken);
                            } else if (token == 'F') {
                                stack.add(e.falseToken);
                            }
                        }
                    }

                    break;
                case '?':
                    stack.add(new StackEntry());
                    break;
                default:
                    stack.add(expr.charAt(i));
                    break;
            }
        }

        return ((char) stack.get(stack.size() - 1));
    }
}
