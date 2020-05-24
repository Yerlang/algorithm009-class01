package com.erlang.course3;

import com.erlang.comon.PrintlnUtil;

/**
 * @description: 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: erlang
 * @since: 2020-05-23 11:11
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 9};
        int[] result = plusOne(nums);
        PrintlnUtil.printArray(result);
    }

    public static int[] plusOne(int[] digits) {
        if (digits == null || digits.length < 1) {
            return new int[0];
        }

        int plusNme = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += plusNme;
            if (digits[i] < 10) {
                return digits;
            }
            // 加 1 进位时，当前位设为 0，继续遍历加 1
            digits[i] = 0;
        }

        // 到这一步，说明最高位需要进位即增加数组的长度，索引 0 的值为 1
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
