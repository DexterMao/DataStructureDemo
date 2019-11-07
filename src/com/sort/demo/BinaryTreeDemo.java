package com.sort.demo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeDemo {

    static class TreeNode {
        public Object data;
        public TreeNode leftNode;
        public TreeNode rightNode;

        public TreeNode(Object data) {
            this.data = data;
        }
    }

    /**
     * 创建二叉树
     *
     * @param list
     * @return
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> list) {
        TreeNode node = null;
        if (list == null || list.isEmpty()) {
            return null;
        }
        Integer data = list.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            node.leftNode = createBinaryTree(list);
            node.rightNode = createBinaryTree(list);
        }
        return node;
    }

    /**
     * 递归-前序遍历二叉树
     *
     * @param node
     */
    public static void preOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrderTraveral(node.leftNode);
        preOrderTraveral(node.rightNode);
    }

    /**
     * 非递归-前序遍历二叉树
     *
     * @param root
     */
    public static void preOrderStackTraveral(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                System.out.print(treeNode.data + " ");
                stack.push(treeNode);
                treeNode = treeNode.leftNode;
            }
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.rightNode;
            }
        }
    }

    /**
     * 递归-中序遍历二叉树
     *
     * @param node
     */
    public static void midOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        midOrderTraveral(node.leftNode);
        System.out.print(node.data + " ");
        midOrderTraveral(node.rightNode);
    }

    /**
     * 非递归-中序遍历二叉树
     *
     * @param root
     */
    public static void midOrderStackTraveral(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.leftNode;
            }
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                System.out.print(treeNode.data + " ");
                treeNode = treeNode.rightNode;
            }
        }

    }

    /**
     * 递归-后序遍历二叉树
     *
     * @param node
     */
    public static void postOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraveral(node.leftNode);
        postOrderTraveral(node.rightNode);
        System.out.print(node.data + " ");
    }

    /**
     * 非递归-后序遍历二叉树
     * <p>
     * 思路：利用辅助栈实现
     * 1、先把根节点压入辅助栈
     * 2、然后循环，判断辅助栈是否为空，如果不为空，则栈顶元素压入主栈，同时存在左右节点的，分别压入左右节点到辅助栈
     * 3、最后主栈遍历，按出栈顺序打印节点信息，得到到便是后序遍历到顺序节点信息
     *
     * @param root
     */
    public static void postOrderStackTraveral(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack1 = new Stack<>();
        TreeNode treeNode = root;
        stack1.push(treeNode);
        while (!stack1.isEmpty()) {
            treeNode = stack1.pop();
            stack.push(treeNode);
            if (treeNode.leftNode != null) {
                stack1.push(treeNode.leftNode);
            }
            if (treeNode.rightNode != null) {
                stack1.push(treeNode.rightNode);
            }
        }

        while (!stack.isEmpty()) {
            treeNode = stack.pop();
            System.out.print(treeNode.data + " ");
        }
    }

    public static void levelOrderTraveral(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            System.out.print(treeNode.data + " ");
            if (treeNode.leftNode != null) {
                queue.offer(treeNode.leftNode);
            }
            if (treeNode.rightNode != null) {
                queue.offer(treeNode.rightNode);
            }
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(3, 2, 9, null, null, 10, null, null, 8, null, 4));
        TreeNode node = createBinaryTree(linkedList);
        System.out.println("\n前序遍历：");
        preOrderTraveral(node);
        System.out.println("");
        preOrderStackTraveral(node);
        System.out.println("\n中序遍历：");
        midOrderTraveral(node);
        System.out.println("");
        midOrderStackTraveral(node);
        System.out.println("\n后序遍历：");
        postOrderTraveral(node);
        System.out.println("");
        postOrderStackTraveral(node);
        System.out.println("\n层序遍历：");
        levelOrderTraveral(node);
    }


}
