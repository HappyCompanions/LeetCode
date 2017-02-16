#!/usr/bin/python


class Solution(object):
    def verifyPreorder(self, preorder):
        """
        :type preorder: List[int]
        :rtype: bool
        """
        from sys import maxint
        min_node = -maxint - 1
        index = 0
        for node in preorder:
            if node < min_node:
                return False
            while index and node > preorder[index - 1]:
                min_node = preorder[index - 1]
                index -= 1
            preorder[index] = node
            index += 1
        return True

        """
        from sys import maxint
        min_node = -maxint - 1
        stack = []
        for node in preorder:
            if node < min_node:
                return False
            while stack and node > stack[-1]:
                min_node = stack.pop()
            stack.append(node)
        return True
        """

print(Solution().verifyPreorder([1, 2, 3, 4]))
print(Solution().verifyPreorder([4, 3, 2, 1]))
print(Solution().verifyPreorder([3, 4, 2, 1]))
print(Solution().verifyPreorder([1, 3, 2]))
