package com.erlang.course6;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @description: 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 * <p>
 * 例如，给定一个 3叉树 :
 * narytreeexample.png
 * [
 * [1],
 * [3,2,4],
 * [5,6]
 * ]
 *  
 * <p>
 * 说明:
 * <p>
 * 树的深度不会超过 1000。
 * 树的节点总数不会超过 5000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: erlang
 * @since: 2020-05-31 12:02
 */
public class NAryTreeLevelorderTraversal {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<Node> visited = new ArrayDeque<>();
        visited.add(root);

        while (!visited.isEmpty()) {
            int size = visited.size();
            List<Integer> currList = new ArrayList<>();
            while (size > 0) {
                Node node = visited.poll();
                currList.add(node.val);
                if (node.children != null) {
                    visited.addAll(node.children);
                }
                size--;
            }
            res.add(currList);
        }
        return res;
    }
}
