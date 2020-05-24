package com.erlang.course3;

import com.erlang.comon.PrintlnUtil;

/**
 * @description: 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * <p>
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 * <p>
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: erlang
 * @since: 2020-05-23 10:09
 */
public class RotateArray {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};
//        rotate(nums, 7);
        rotate2(nums, 7);
        PrintlnUtil.printArray(nums);
    }

    /**
     * leetcode 提交时，会超出时间限制
     *
     * @param nums 数组
     * @param k 移动位数
     */
    public static void rotate(int[] nums, int k) {
        if (k == 0 || nums == null || nums.length < 2) {
            return;
        }

        int length = nums.length;
        while (k % length > 0) {
            // 整体移动的范围 0 range
            int range = length - k;
            for (int i = 1; i <= range; i++) {
                int val = nums[length - i];
                nums[length - i] = nums[length - i - k];
                nums[length - i - k] = val;
            }
            // 需要调整再次移动的数组 [0, length - 1]
            length = k;
            // 移动位数
            k = length - (range % k);
        }
    }

    public static void rotate2(int[] nums, int k) {
        if (k == 0 || nums == null || nums.length < 2) {
            return;
        }
        int length = nums.length;
        k %= length;
        // 反转全部
        reverse(nums, 0, length - 1);
        // 反转 0 到 k - 1 ==> 再次反转使[0, k - 1]保持和原数组顺一致
        reverse(nums, 0, k - 1);
        // 反转 k 到 num.length - 1 ==> 再次反转使[k, length - 1]保持和原数组顺一致
        reverse(nums, k, length - 1);
    }

    /**
     * 反转数组 nums 的 [start, end]
     * @param nums 数组
     * @param start 反转开始指针
     * @param end 反转结束指针
     */
    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
