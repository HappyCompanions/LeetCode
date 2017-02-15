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
    int longestConsecutive(TreeNode* root) {
        int longest = 0;
        queue<pair<TreeNode*, int>> queue;
        if (root)
            queue.push(pair<TreeNode*, int>(root,1));
        while(!queue.empty()) {
            TreeNode *node = queue.front().first;
            int currentLevel = queue.front().second;
            longest = max(longest, currentLevel);
            queue.pop();
            if (node->left) {
                int left = 1;
                if (node->left->val == node->val + 1)
                    left = currentLevel +1;
                queue.push(pair<TreeNode*, int>(node->left, left));
            }
            if (node->right) {
                int right = 1;
                if (node->right->val == node->val + 1)
                    right = currentLevel +1;
                queue.push(pair<TreeNode*, int>(node->right, right));
            }
        }
        return longest;
    }
};
