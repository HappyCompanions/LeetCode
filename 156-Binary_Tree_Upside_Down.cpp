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
    TreeNode * flipTree(TreeNode *root) {
        TreeNode* new_node = root;
        if (!root || !root->left)
            return root;
            
        new_node = flipTree(root->left);

        root->left->left = root->right;
        root->left->right = root;
        root->right = root->left = nullptr;

        return new_node;
    }

    TreeNode* upsideDownBinaryTree(TreeNode* root) {
        return flipTree(root);
    }
};
