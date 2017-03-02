#!/usr/bin/python


# The knows API is already defined for you.
# @param a, person a
# @param b, person b
# @return a boolean, whether a knows b
# def knows(a, b):

class Solution(object):
    def findCelebrity(self, n):
        """
        :type n: int
        :rtype: int
        """
        candidate = 0
        for p in xrange(1, n):
            if knows(candidate, p):
                candidate = p
        if any(knows(candidate, p) for p in xrange(candidate)) or \
           any(not knows(p, candidate) for p in xrange(n) if p != candidate):
            return -1
        return candidate

print(Solution().findCelebrity(3))
