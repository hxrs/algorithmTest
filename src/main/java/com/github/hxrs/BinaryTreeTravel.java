package com.github.hxrs;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author huanxiao
 *
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x;
	}
}

public class BinaryTreeTravel {
    public ArrayList<Integer> preorderTraversalRecursive(TreeNode root) {
    	if (root == null) {
    		return null;
    	}
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	list.add(root.val);
    	ArrayList<Integer> leftList = preorderTraversalRecursive(root.left);
    	ArrayList<Integer> rightList = preorderTraversalRecursive(root.right);
    	if (leftList != null) {
    		list.addAll(leftList);
    	}
    	if (rightList != null) {
    		list.addAll(rightList);
    	}
    	return list;
    }

    public ArrayList<Integer> inorderTraversalRecursive(TreeNode root) {
    	if (root == null) {
    		return null;
    	}
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	ArrayList<Integer> leftList = inorderTraversalRecursive(root.left);
    	if (leftList != null) {
    		list.addAll(leftList);
    	}

    	list.add(root.val);

    	ArrayList<Integer> rightList = inorderTraversalRecursive(root.right);
    	if (rightList != null) {
    		list.addAll(rightList);
    	}
    	return list;
    }

    public ArrayList<Integer> postorderTraversalRecursive(TreeNode root) {
    	if (root == null) {
    		return null;
    	}
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	ArrayList<Integer> leftList = postorderTraversalRecursive(root.left);
    	if (leftList != null) {
    		list.addAll(leftList);
    	}

    	ArrayList<Integer> rightList = postorderTraversalRecursive(root.right);
    	if (rightList != null) {
    		list.addAll(rightList);
    	}
    	list.add(root.val);

    	return list;
    }

    public ArrayList<Integer> preorderTraversalStack(TreeNode root) {
    	if (root == null) {
    		return null;
    	}
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
    	TreeNode p = root;
    	if (p != null) {
    		stack.push(p);
    		while (!stack.isEmpty()) {
    			p = stack.pop();
    			list.add(p.val);
    			if (p.right != null) {
    				stack.push(p.right);
    			}
    			if (p.left != null) {
    				stack.push(p.left);
    			}
    		}
    	}
        return list;
    }

    public ArrayList<Integer> inorderTraversalStack(TreeNode root) {
    	if (root == null) {
    		return null;
    	}
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
    	TreeNode p = root;
    	do {
    		while (p != null) {
    			stack.push(p);
    			p = p.left;
    		}
    		if (!stack.isEmpty()) {
    			p = stack.pop();
    			list.add(p.val);
    			p = p.right;
    		}
    	} while (p != null || !stack.isEmpty());

        return list;
    }

    public ArrayList<Integer> postorderTraversalStack(TreeNode root) {
        return null;
    }

    public ArrayList<Integer> preorderTraversalMorris(TreeNode root) {
        return null;
    }

    public ArrayList<Integer> inorderTraversalMorris(TreeNode root) {
        return null;
    }

    public ArrayList<Integer> postorderTraversalMorris(TreeNode root) {
        return null;
    }
}
