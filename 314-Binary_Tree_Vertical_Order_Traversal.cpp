/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    vector<vector<int>> verticalOrder(TreeNode* root) {
        vector<vector<int> > ans;
        if (!root) {
            return ans;
        }

        map<int, vector<int>> columeMap;
        queue<pair<int, TreeNode*>> queue;

        queue.emplace(make_pair(0,root));
        while (!queue.empty()) {
            int index  = queue.front().first;
            TreeNode *node = queue.front().second;
            queue.pop();

            columeMap[index].emplace_back(node->val);

            if (node->left) {
                queue.push(make_pair(index-1, node->left));
            }

            if (node->right) {
                queue.push(make_pair(index+1, node->right));
            }
        }

        for (auto m: columeMap) {
            ans.emplace_back(m.second);
        }
        return ans;
    }
};
