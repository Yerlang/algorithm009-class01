package com.erlang;

import com.erlang.comon.PrintlnUtil;

/**
 * @description: 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 *  
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *  
 * <p>
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: erlang
 * @since: 2020-05-23 11:10
 */
public class MergeTwoSortedArray {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
//        mergeTwoArray(nums1, 3, nums2, nums2.length);
        mergeTwoArray(nums1, 3, nums2, nums2.length);
        PrintlnUtil.printArray(nums1);
    }

    public static void mergeTwoArray2(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }

        if (nums1 == null || nums2 == null || nums1.length < m + n) {
            return;
        }
        int tail1 = m - 1;
        int tail2 = n - 1;
        int index = m + n - 1;
        while (tail1 >= 0 && tail2 >= 0) {
            int num1 = nums1[tail1];
            int num2 = nums1[tail2];
            if (num1 < num2) {
                nums1[index--] = num2;
                tail2--;
            } else {
                nums1[index--] = num1;
                tail1--;
            }
        }
    }

    public static void mergeTwoArray(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }

        if (nums1 == null || nums2 == null || nums1.length < m + n) {
            return;
        }

        while (n > 0) {
            // 指针从右向左移动
            if (m == 0 || nums2[n - 1] > nums1[m - 1]) {
                // m == 0 表示 nums1 的数据
                // nums2[n - 1] 大于 nums1[m - 1]，表示 nums2[n - 1] 的值是数组 nums2[0, n - 1] 和 数组 nums1[0, m - 1] 中最大的数
                // 将最大值放到两个数组长度之和 - 1 位
                // 移动 n 指针，m 指针不动
                n = --n;
                nums1[m + n] = nums2[n];
            } else {
                // 将最大值放到两个数组长度之和 - 1 位
                // 移动 m 指针，n 指针不动
                m = --m;
                nums1[m + n] = nums1[m];
            }
        }
    }
}
