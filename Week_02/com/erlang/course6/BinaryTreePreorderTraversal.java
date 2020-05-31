package com.erlang.course6;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: erlang
 * @since: 2020-05-28 22:12
 */
public class BinaryTreePreorderTraversal {
    public static void main(String[] args) {

    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> record = new ArrayList<Integer>();
        if (root == null) {
            return record;
        }
        record.add(root.val);
        record.addAll(preorderTraversal(root.left));
        record.addAll(preorderTraversal(root.right));
        return record;
    }
}
