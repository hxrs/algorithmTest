package com.github.hxrs;

/**
 * @author Huan
 *
 */
public class ListHasCircle {
    public boolean hasCycle(ListNode head) {
    	if (head == null) {
    		return false;
    	}
    	
    	ListNode slow = head;
    	ListNode fast = head;
    	while (fast.next != null && fast.next.next != null) {
    		slow = slow.next;
    		fast = fast.next.next;
    		if (slow == fast) {
    			return true;
    		}
    	}
    	
        return false;
    }
    
    public ListNode detectCirclePoint(ListNode head) {
    	if (head == null) {
    		return head;
    	}
    	
    	ListNode slow = head;
    	ListNode fast = head;
    	while (fast.next != null && fast.next.next != null) {
    		slow = slow.next;
    		fast = fast.next.next;
    		if (slow == fast) {
    			ListNode p = head;
    			ListNode q = slow;
    			while (p != q) {
    				p = p.next;
    				q = q.next;
    			}
    			return p;
    		}
    	}
    	return null;
    	
    }
    
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}

		@Override
		public String toString() {
			return "ListNode [val=" + val + "]";
		}	
	}
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode head = node6;
		node6.next = node5;
		node5.next = node4;
		node4.next = node3;
		node3.next = node2;
		node2.next = node1;
		ListHasCircle list = new ListHasCircle();
		System.out.println(list.hasCycle(head));
		System.out.println(list.detectCirclePoint(head));
		node1.next = node3;
		System.out.println(list.hasCycle(head));
		System.out.println(list.detectCirclePoint(head));
	}

}
