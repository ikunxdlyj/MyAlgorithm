package class017;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeTraversalRecursion {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    public static List<Integer> preOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        f1(root, list);
        return list;
    }

    public static void f1(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        f1(root.left, list);
        f1(root.right, list);
    }

    public static List<Integer> inOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        f2(root, list);
        return list;
    }

    public static void f2(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        f2(root.left, list);
        list.add(root.val);
        f2(root.right, list);
    }

    public static List<Integer> postOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        f3(root, list);
        return list;
    }

    public static void f3(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        f3(root.left, list);
        f3(root.right, list);
        list.add(root.val);
    }
}