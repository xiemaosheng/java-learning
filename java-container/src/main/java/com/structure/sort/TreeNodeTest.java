package com.structure.sort;

import java.util.*;

/**
 * Created by Administrator on 2017/8/14 0014.
 */
public class TreeNodeTest {
    public static List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            list.add(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return list;
    }

    public static List<Integer> test(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        result.add(root.val);
        if (root.left != null) {
            left = test(root.left);
        }

        if (root.right != null) {
            right = test(root.right);
        }
        result.addAll(left);
        result.addAll(right);
        return result;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        root.left = node3;
        root.right = node1;
        node1.left = node2;
        node3.left = node4;
        node3.right = node5;

        System.out.println(preorderTraversal(root));
        System.out.println(test(root));

        Test test = new Test("test");
        System.out.println(test.getNickName());
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        this.left = null;
        this.right = null;
    }
}

class Test {
    private String name;
    private String nickName = get();

    public String get(){
        nickName = null == name ? null : name;
        return nickName;
    }

    public Test(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
