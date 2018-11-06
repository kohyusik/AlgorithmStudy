package step001.leetcode.medium.addTwoNumbers;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public static void main(String[] args) {
        
        // test case 1
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
    
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(3);
    
        ListNode answer = new Solution().addTwoNumbers(l1, l2);
        System.out.println(answer);
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    
        ListNode sum = null;
        ListNode p = null;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1 != null && p2 != null) {
            
            if (sum == null) {
                sum = new ListNode(-1);
                p = sum;
            }
            
            p1 = p1.next;
            p2 = p2.next;
        }
        return sum;
    }
}