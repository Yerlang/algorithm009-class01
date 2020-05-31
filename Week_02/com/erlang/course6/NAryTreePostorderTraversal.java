package com.erlang.course6;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 给定一个 N 叉树，返回其节点值的后序遍历。
 * <p>
 * 例如，给定一个 3叉树 :
 * <p>
 * <p>
 * 返回其后序遍历: [5,6,3,2,4,1].
 * <p>
 *  
 * <p>
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: erlang
 * @since: 2020-05-31 10:51
 */
public class NAryTreePostorderTraversal {
    public static void main(String[] args) {
    }
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    public void postorder(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        for (Node curr : root.children) {
            postorder(curr, res);
        }
        res.add(root.val);
    }
}
