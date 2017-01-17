/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
#include <stack>
using std::stack;

class Solution {
public:
    vector<vector<int>> findLeaves(TreeNode* root) {
        vector<vector<int>> result;
        if (root != nullptr) {
            while (!isLeaf(root)) {
                result.emplace_back(gatherAndRemoveLeafNode(root));
            }
            result.push_back({root->val});
        }
        return result;
    }

private:
    static vector<int> gatherAndRemoveLeafNode(TreeNode* root) {
        vector<int> result;
        
        stack<TreeNode*> dfsStack;
        dfsStack.push(root);
        
        auto processNode = [&result, &dfsStack] (TreeNode*& node) {
            if (node == nullptr) {
                return ;
            }

            if (isLeaf(node)) {
                result.emplace_back(node->val);
				delete node;
                node = nullptr;
            } else {
                dfsStack.push(node);
            }
        };
        
        while (!dfsStack.empty()) {
            TreeNode* cur = dfsStack.top();
            dfsStack.pop();
            processNode(cur->left);
            processNode(cur->right);
        }
        
        return result;
    }
    
    static bool isLeaf (TreeNode* node) {
        return node->left == nullptr && node->right == nullptr;
    }
};
