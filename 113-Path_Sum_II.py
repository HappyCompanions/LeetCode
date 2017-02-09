#!/usr/bin/python

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution(object):
    def pathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: List[List[int]]
        """
        def traverse(root, current_list, current_sum, sum, result):
            if not root:
                return
            current_list.append(root.val)
            current_sum += root.val
            if not root.left and not root.right:
                if current_sum == sum:
                    result.append(current_list[:])
            traverse(root.left, current_list, current_sum, sum, result)
            traverse(root.right, current_list, current_sum, sum, result)
            current_list.pop()

        result = []
        current_list = []
        traverse(root, current_list, 0, sum, result)
        return result
