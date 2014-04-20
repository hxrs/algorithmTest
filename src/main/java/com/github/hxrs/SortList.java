package com.github.hxrs;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * @author huanxiao
 *
 */
public class SortList {

	public static ListNode sortList(ListNode head) {
		if (head == null) {
			throw new NullPointerException("parameter is null!");
		}
		if (head.next == null) {
			return head;
		}
		ListNode lastNode = findLastNode(head);
		quickSortList(head, lastNode);
		return head;
	}

	private static void quickSortList(ListNode head, ListNode last) {
		if (head == null || last == null) {
			return;
		}

		if (head != last) {
			ListNode prePartitionNode = partition(head, last);
			ListNode partitionNode = prePartitionNode.next;
			ListNode afterPartitionNode = partitionNode.next;
			if (partitionNode == head) {
				prePartitionNode = null;
			} else if (partitionNode == last) {
				afterPartitionNode = null;
			}
			quickSortList(head, prePartitionNode);
			quickSortList(afterPartitionNode, last);
		}
	}

	private static ListNode partition(ListNode head, ListNode last) {
		int lastVal = last.val;
		ListNode ithNode = new ListNode(0);
		ithNode.next = head;
		ListNode jthNode = head;
		while (jthNode != null && jthNode != last){
			if (jthNode.val < lastVal) {
				ithNode = ithNode.next;
				exchange(ithNode, jthNode);
			}
			jthNode = jthNode.next;
		}
		exchange(ithNode.next, last);
		return ithNode; //return the node before the partition point
	}

	private static ListNode findLastNode(ListNode node) {
		if (node == null) {
			return null;
		}
		ListNode prev = node;
		ListNode last = node.next;

		while (last != null) {
			prev = last;
			last = last.next;
		}
		return prev;
	}

	private static void exchange(ListNode ln1, ListNode ln2) {
		if (ln1 == ln2 || ln1.val == ln2.val) {
			return;
		}
		int temp = ln1.val;
		ln1.val = ln2.val;
		ln2.val = temp;
	}

	/**
	 * @param args
	 */
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
		System.out.println(sortList(head));
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
			ListNode i = next;
			StringBuilder sb = new StringBuilder();
			sb.append(val);
			while(i != null) {
				sb.append(", ");
				sb.append(i.val);
				i = i.next;
			}
			return "ListNode [" + sb.toString() +"]";
		}
	}
}
