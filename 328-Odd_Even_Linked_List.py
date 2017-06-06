# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution(object):
    def oddEvenList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head is None:
            return head

        odd_tail = even_tail = None
        even_head = None
        cur = head
        counter = 1
        while cur is not None:
            next = cur.next
            if counter % 2 == 1:
                if odd_tail is None:
                    odd_tail = cur
                else:
                    odd_tail.next = cur
                    odd_tail = cur
            else:
                if even_tail is None:
                    even_tail = cur
                    even_head = cur
                else:
                    even_tail.next = cur
                    even_tail = cur

            cur.next = None
            counter += 1
            cur = next

        odd_tail.next = even_head
        return head
