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
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        queue<TreeNode*> queue;
        vector<vector<int>> result;
        
        if (root) {
            queue.push(root);
        }
        while(!queue.empty()){
            int size = queue.size();;
            vector<int> row(size);
            
            for (int i = 0; i < size; i++) {
                TreeNode * node = queue.front();
                int index;
                
                queue.pop();
                index = (0 == result.size()%2)? i: size - i - 1;
                auto push = [&](TreeNode *node) {
                    if (node) {
                        queue.push(node);
                    }
                };

                
                row[index] = node->val;
                push(node->left);
                push(node->right);
            }
            result.push_back(row);
        }
        return result;
    }
};
