using System;

//Forest is not allowed

public class Solution {
    bool [] used;
    int [] parent;
    bool valid;

    public void dfs(int now, int[,] edges) {
        if (!valid) return ;
        used[now] = true;

        for (int i = 0; i < edges.GetLength(0); ++i) {
            if (now == edges[i,0]) {
                if (false == used[edges[i,1]]) {
                    parent[edges[i,1]] = now+1;
                    dfs(edges[i,1], edges);
                }
                else if (edges[i,1]+1 != parent[now]) {
                    valid = false;
                    break;
                }
            }
            else if (now == edges[i,1]) {
                if (false == used[edges[i,0]]) {
                    parent[edges[i,0]] = now+1;
                    dfs(edges[i,0], edges);
                }
                else if (edges[i,0]+1 != parent[now]) {
                    valid = false;
                    break;
                }
            }
        }
    }

    public bool ValidTree(int n, int[,] edges) {
        used = new bool[n];
        parent = new int[n];
        valid = true;

        dfs(0, edges);

        for (int i = 0; i < n; ++i) {
            if (false == used[i]) {
                valid = false;
                break;
            }
        }

        return valid;
    }
}