package com.erlang.comon;

/**
 * @description: 控制台输出工具类
 * @author: erlang
 * @since: 2020-05-23 10:10
 */
public class PrintlnUtil {

    public static void printArray(int[] nums, int length) {
        System.out.print("[");
        for (int i = 0; i < length; i++) {
            System.out.print(nums[i] + (i < length - 1 ?  ", " : "") );
        }
        System.out.println("]");
    }

    public static void printArray(int[] nums) {
        printArray(nums, nums.length);
    }

    public static void printList(ListNode node) {
        System.out.print("[");

        while (node != null) {
            System.out.print(node.val + (node.next != null ?  ", " : "") );
            node = node.next;
        }
        System.out.println("]");
    }
}
