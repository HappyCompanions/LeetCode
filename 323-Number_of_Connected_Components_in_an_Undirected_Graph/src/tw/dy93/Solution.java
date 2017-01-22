package tw.dy93;


/**
 * Created by dy93 on 2017/1/22.
 */
public class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] components = new int[n];
        for (int i = 0; i < n; i++) {
            components[i] = -1;
        }
        for (int i = 0; i < edges.length; i++) {
            int smallTop = Math.min(findTop(edges[i][0], components), findTop(edges[i][1], components));

            updateTop(edges[i][0], smallTop, components);
            updateTop(edges[i][1], smallTop, components);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (components[i] == i || components[i] == -1) {
                count++;
            }
        }
        return count;
    }

    private int findTop(int node, int[] components) {
        if (components[node] == -1 || components[node] == node) {
            return node;
        }
        return findTop(components[node], components);
    }

    private void updateTop(int node, int top, int[] components) {
        if (components[node] == -1) {
            components[node] = top;
        } else if (components[node] > top) {
            int tmp = components[node];
            components[node] = top;
            updateTop(tmp, top, components);
        }
    }
}