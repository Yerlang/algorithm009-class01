package com.erlang.course6;

import java.util.*;

/**
 * @description: 给定一个 N 叉树，返回其节点值的前序遍历。
 * <p>
 * 例如，给定一个 3叉树 :
 * <p>
 * <p>
 * 返回其前序遍历: [1,3,5,6,2,4]。
 * <p>
 *  
 * <p>
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。。
 * @author: erlang
 * @since: 2020-05-31 10:51
 */
public class NAryTreePreorderTraversal {
    public static void main(String[] args) {
    }

    public List<Integer> preorder(Node root) {
        LinkedList<Integer> res = new LinkedList<Integer>();
        if (root == null) {
            return res;
        }

        Stack<Node> visited = new Stack<>();
        visited.push(root);
        while (!visited.isEmpty()) {
            Node curr = visited.pop();
            res.addLast(curr.val);
            List<Node> children = curr.children;
            for (int i = children.size() - 1; i >= 0; i--) {
                visited.push(children.get(i));
            }
        }

        return res;
    }

}
