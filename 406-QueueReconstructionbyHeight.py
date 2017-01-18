#!/usr/bin/python


class Solution(object):
    def reconstructQueue(self, people):
        """
        :type people: List[List[int]]
        :rtype: List[List[int]]
        """
        people = sorted(people, key=lambda x:(-x[0], x[1]))
        result = []
        for person in people:
            result.insert(person[1], person)
        return result

# testcase = [[7, 0], [4, 4], [7, 1], [5, 0], [6, 1], [5, 2]]
# print(Solution().reconstructQueue(testcase))

# Output:
# [[5, 0], [7, 0], [5, 2], [6, 1], [4, 4], [7, 1]]
