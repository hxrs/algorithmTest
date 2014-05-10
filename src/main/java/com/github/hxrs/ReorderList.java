package com.github.hxrs;



/**
 * Given a singly linked list L: L0¡úL1¡ú¡­¡úLn-1¡úLn, reorder it to:
 * L0¡úLn¡úL1¡úLn-1¡úL2¡úLn-2¡ú¡­ You must do this in-place without altering the nodes'
 * values. For example, Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * 
 * @author Huan
 * 
 */
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}

	@Override
	public String toString() {
		return "ListNode [val=" + val + ", next=" + next + "]";
	}	
}

public class ReorderList {
	
	public void reorderList(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}
		ListNode p = head;
		ListNode middleNode = getMiddleNode(p);
		ListNode q = middleNode.next;
		middleNode.next = null;
		q = reverseList(q);
		while (p != null && q != null) {
			ListNode temp = q.next;
			q.next = p.next;
			p.next = q;
			p = q.next;
			q = temp;
		}
	}

	private ListNode getMiddleNode(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	private ListNode reverseList(ListNode head) {
		ListNode p = head;
		ListNode q = p.next;
		p.next = null;
		while (q != null) {
			ListNode temp = q.next;
			q.next = p;
			p = q;
			q = temp;
		}
		return p;
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
		ReorderList reorderList = new ReorderList();
		reorderList.reorderList(head);
		System.out.println(head);
	}

}
