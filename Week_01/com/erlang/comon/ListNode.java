package com.erlang.comon;

/**
 * @description:
 * @author: erlang
 * @since: 2020-05-23 11:30
 */

public class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static ListNode buildListNode(String src, String split) {
        if (src == null) {
            return null;
        }
        String[] nodes = src.split(split);
        if (nodes == null || nodes.length < 1) {
            return null;
        }

        ListNode root = new ListNode(0);
        ListNode curr = root;

        for (String node : nodes) {
            curr.next = new ListNode(Integer.valueOf(node));
            curr = curr.next;
        }
        return root.next;
    }

}
