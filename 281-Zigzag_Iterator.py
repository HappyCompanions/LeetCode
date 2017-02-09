#!/usr/bin/python


class ZigzagIterator(object):
    def __init__(self, *args):
        """
        Initialize your data structure here.
        :type v1: List[int]
        :type v2: List[int]
        """
        from collections import deque
        self.deque = deque(list(reversed(arg)) for arg in args if arg)

    def next(self):
        """
        :rtype: int
        """
        v = self.deque.popleft()
        num = v.pop()
        if v:
            self.deque.append(v)
        return num

    def hasNext(self):
        """
        :rtype: bool
        """
        return True if self.deque else False

# Your ZigzagIterator object will be instantiated and called as such:
# i, v = ZigzagIterator(v1, v2), []
# while i.hasNext(): v.append(i.next())
v1 = [1, 2]
v2 = [3, 4, 5, 6]
i, v = ZigzagIterator(v1, v2), []
while i.hasNext():
    v.append(i.next())
print(v)
#  output: [1, 3, 2, 4, 5, 6]
