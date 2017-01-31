package tw.dy93;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by dy93 on 2017/1/31.
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = head, curr = head;
        ListNode partitionHead = null, partitionTail = null;
        while (curr != null) {
            ListNode next = curr.next;
            if (curr.val < x) {
                // remove curr from origin
                if (curr == head) {
                    head = curr.next;
                    prev = head;
                } else {
                    prev.next = curr.next;
                }

                // add to partitionList
                if (partitionHead == null) {
                    partitionHead = curr;
                    partitionTail = curr;
                } else {
                    partitionTail.next = curr;
                    partitionTail = curr;
                }
                curr = next;
            } else {
                prev = curr;
                curr = next;
            }

            if (partitionTail != null) {
                partitionTail.next = null;
            }
        }

        if (partitionHead != null) {
            partitionTail.next = head;
            head = partitionHead;
        }
        return head;
    }

    public ListNode makeList(int[] values) {
        ListNode head = null, tail = null;
        for (int i : values) {
            if (head == null) {
                head = new ListNode(i);
                tail = head;
            } else {
                tail.next = new ListNode(i);
                tail = tail.next;
            }
            tail.next = null;
        }
        return head;
    }

    private void printList(ListNode head) {
        ArrayList<Integer> ary = new ArrayList();
        for (ListNode cur = head; cur != null; cur = cur.next) {
            ary.add(cur.val);
        }
        System.out.println(Arrays.toString(ary.toArray()));
    }
}
