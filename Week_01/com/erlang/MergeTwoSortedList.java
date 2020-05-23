package com.erlang;

import com.erlang.comon.ListNode;
import com.erlang.comon.PrintlnUtil;

/**
 * @description: 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: erlang
 * @since: 2020-05-23 11:30
 */
public class MergeTwoSortedList {

    public static void main(String[] args) {

        String split = "->";
        ListNode l1 = ListNode.buildListNode("1->2->4", split);
        ListNode l2 = ListNode.buildListNode("1->3->4->8->9", split);
        ListNode node = mergeTwoLists(l1, l2);
        PrintlnUtil.printList(node);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
