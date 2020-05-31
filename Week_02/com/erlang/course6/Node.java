package com.erlang.course6;

import java.util.List;

/**
 * @description: n 叉树模型
 * @author: erlang
 * @since: 2020-05-31 10:54
 */

public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
