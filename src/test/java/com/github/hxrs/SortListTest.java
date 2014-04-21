package com.github.hxrs;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.hxrs.SortList.ListNode;

public class SortListTest {

	private ListNode buildList(int... values) {
		if (values == null || values.length == 0) {
			return null;
		}
		ListNode head = new ListNode(values[0]);
		ListNode p = head;
		for (int i = 1; i < values.length; i++) {
			ListNode newNode = new ListNode(values[i]);
			p.next = newNode;
			p = p.next;
		}
		return head;
	}

	@DataProvider(name = "testData")
	public Object[][] testData() {
		ListNode nullNode = null;
		ListNode singleNode = new ListNode(0);
		ListNode unorderedList1 = buildList(1, 3, 2);
		ListNode unorderedList2 = buildList(3, 2, 1);
		ListNode orderedList1 = buildList(1, 2, 3);
		ListNode unorderedList3 = buildList(2, 1);
		ListNode orderedList2 = buildList(1, 2);
		ListNode unorderedList5 = buildList(1, 2, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3,
				3, 2, 2, 2, 2, 1, 1, 1, 1, 2, 2, 2, 3, 2, 3, 2, 3, 1, 3, 2, 2,
				1);
		ListNode unorderedList6 = buildList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2,
				2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3,
				3);
		return new Object[][] { { nullNode, null }, { singleNode, singleNode },
				{ unorderedList1, orderedList1 },
				{ unorderedList2, orderedList1 },
				{ unorderedList3, orderedList2 },
				{ unorderedList5, unorderedList6 } };
	}

	@Test(dataProvider = "testData")
	public void testSortList(ListNode unordered, ListNode ordered) {
		ListNode actual = SortList.sortList(unordered);
		assertEquals(actual, ordered, "The nodes is not ordered");
	}
}
