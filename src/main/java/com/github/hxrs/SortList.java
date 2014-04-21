package com.github.hxrs;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * @author huanxiao
 *
 */
public class SortList {

	public static ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		head = mergeSort(head);
		//ListNode lastNode = findLastNode(head);
		//quickSortList(head, lastNode);
		return head;
	}

	//merge sort
	private static ListNode mergeSort(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode middleNode = getMiddleNode(head);
		ListNode nextPartHead = middleNode.next;
		middleNode.next = null;
		head = mergeSort(head);
		nextPartHead = mergeSort(nextPartHead);
		return merge(head, nextPartHead);
	}

	private static ListNode merge(ListNode firstHead, ListNode secondHead) {
		if (firstHead == null) {
			return secondHead;
		}
		if (secondHead == null) {
			return firstHead;
		}
		ListNode head = new ListNode(0);
		ListNode p = head;
		while (firstHead != null && secondHead != null) {
			if (firstHead.val <= secondHead.val) {
				p.next = firstHead;
				firstHead = firstHead.next;
			} else {
				p.next = secondHead;
				secondHead = secondHead.next;
			}
			p = p.next;
		}
		if (firstHead == null) {
			p.next = secondHead;
		} else {
			p.next = firstHead;
		}
		ListNode result = head.next;
		head = null;
		return result;
	}

	private static ListNode getMiddleNode(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	//quick sort
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

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((next == null) ? 0 : next.hashCode());
			result = prime * result + val;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ListNode other = (ListNode) obj;
			if (next == null) {
				if (other.next != null)
					return false;
			} else if (!next.equals(other.next))
				return false;
			if (val != other.val)
				return false;
			return true;
		}
	}
}
