package com.github.hxrs;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

import com.github.hxrs.ListHasCircle.ListNode;

public class ListHasCircleTest {

	@Test
	public void hasCycle() {
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
		assertFalse(list.hasCycle(head));
		node1.next = node3;
		System.out.println(list.hasCycle(head));
		assertTrue(list.hasCycle(head));
	}
}
