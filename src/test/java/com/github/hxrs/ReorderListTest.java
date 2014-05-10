package com.github.hxrs;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

public class ReorderListTest {

  @Test
  public void reorderList() {
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
		assertEquals(head.val, 6);
		assertEquals(head.next.val, 1);
		assertEquals(head.next.next.val, 5);
		System.out.println(head);
  }
}
