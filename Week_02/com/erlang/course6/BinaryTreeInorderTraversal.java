package com.erlang.course6;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: erlang
 * @since: 2020-05-27 22:04
 */
public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
//        List<Integer> res = inorderTraversal(null);
        List<Integer> res = new ArrayList<>();
        helper(null, res);
        System.out.println(res);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            // 遍历完当前节点的左子树，分别入栈
            while (curr != null) {
                stack.add(curr);
                curr = curr.left;
            }
            // 将左节点弹出
            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;
        }
        return list;
    }

    public static void helper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
    }
}
