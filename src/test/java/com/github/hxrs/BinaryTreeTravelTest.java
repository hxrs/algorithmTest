package com.github.hxrs;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BinaryTreeTravelTest {
	private final static Logger logger = LoggerFactory
			.getLogger(BinaryTreeTravelTest.class);

	private TreeNode root;
	private List<Integer> preorderResult;
	private List<Integer> inorderResult;
	private List<Integer> postorderResult;

	@BeforeClass
	public void init() {
		root = buildBinaryTree();
		preorderResult = Arrays.asList(4, 2, 1, 3, 6, 5, 7);
		inorderResult = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		postorderResult = Arrays.asList(1, 3, 2, 5, 7, 6, 4);
	}

	private TreeNode buildBinaryTree() {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		node2.left = node1;
		node2.right = node3;

		node6.left = node5;
		node6.right = node7;

		node4.left = node2;
		node4.right = node6;

		return node4;
	}

	private boolean isEqual(List<Integer> actual, List<Integer> expected) {
		if (actual == expected) {
			return true;
		}
		if (actual == null || expected == null) {
			return false;
		}
		if (actual.size() != expected.size()) {
			return false;
		}
		Iterator<Integer> iterActual = actual.iterator();
		Iterator<Integer> iterExpected = expected.iterator();
		while (iterActual.hasNext() && iterExpected.hasNext()) {
			if (!iterActual.next().equals(iterExpected.next())) {
				return false;
			}
		}
		return true;
	}

	@DataProvider
	public Object[][] preorderTraversalData() {
		return new Object[][] { { root, preorderResult } };
	}

	@DataProvider
	public Object[][] inorderTraversalData() {
		return new Object[][] { { root, inorderResult } };
	}

	@DataProvider
	public Object[][] postorderTraversalData() {
		return new Object[][] { { root, postorderResult } };
	}

	@Test(dataProvider = "preorderTraversalData")
	public void preorderTraversalRecursive(TreeNode root,
			List<Integer> expectedResult) {
		logger.info("=====================preorder traversal with recursive method ================ ");
		logger.info("expected Result: {}", expectedResult.toString());
		BinaryTreeTravel btravel = new BinaryTreeTravel();
		ArrayList<Integer> actual = btravel.preorderTraversalRecursive(root);
		logger.info("actual Result: {}", actual.toString());
		assertTrue(isEqual(actual, expectedResult), "The result is not right");
	}

	@Test(dataProvider = "inorderTraversalData")
	public void inorderTraversalRecursive(TreeNode root,
			List<Integer> expectedResult) {
		logger.info("=====================inorder traversal with recursive method ================ ");
		logger.info("expected Result: {}", expectedResult.toString());
		BinaryTreeTravel btravel = new BinaryTreeTravel();
		ArrayList<Integer> actual = btravel.inorderTraversalRecursive(root);
		logger.info("actual Result: {}", actual.toString());
		assertTrue(isEqual(actual, expectedResult), "The result is not right");
	}

	@Test(dataProvider = "postorderTraversalData")
	public void postorderTraversalRecursive(TreeNode root,
			List<Integer> expectedResult) {
		logger.info("=====================postorder traversal with recursive method ================ ");
		logger.info("expected Result: {}", expectedResult.toString());
		BinaryTreeTravel btravel = new BinaryTreeTravel();
		ArrayList<Integer> actual = btravel.postorderTraversalRecursive(root);
		logger.info("actual Result: {}", actual.toString());
		assertTrue(isEqual(actual, expectedResult), "The result is not right");
	}

	@Test(dataProvider = "preorderTraversalData")
	public void preorderTraversalStack(TreeNode root,
			List<Integer> expectedResult) {
		logger.info("=====================preorder traversal with stack method ================ ");
		logger.info("expected Result: {}", expectedResult.toString());
		BinaryTreeTravel btravel = new BinaryTreeTravel();
		ArrayList<Integer> actual = btravel.preorderTraversalStack(root);
		logger.info("actual Result: {}", actual.toString());
		assertTrue(isEqual(actual, expectedResult), "The result is not right");
	}

	@Test(dataProvider = "inorderTraversalData")
	public void inorderTraversalStack(TreeNode root,
			List<Integer> expectedResult) {
		logger.info("=====================inorder traversal with stack method ================ ");
		logger.info("expected Result: {}", expectedResult.toString());
		BinaryTreeTravel btravel = new BinaryTreeTravel();
		ArrayList<Integer> actual = btravel.inorderTraversalStack(root);
		logger.info("actual Result: {}", actual.toString());
		assertTrue(isEqual(actual, expectedResult), "The result is not right");
	}

}
