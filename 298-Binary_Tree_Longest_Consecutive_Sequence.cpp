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
        return search(root, NULL, 0);
    }
    
    int search(TreeNode *curr, TreeNode* parent, int len) {
        int currlen = 1;
        if (!curr)
            return len;
            
        currlen = ((parent) && (1 + parent->val == curr->val))? len+1:1;
        return max(len, max(search(curr->left, curr, currlen),search(curr->right, curr, currlen)));
    }
};
