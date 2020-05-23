package com.erlang;

import com.erlang.comon.PrintlnUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: erlang
 * @since: 2020-05-23 11:08
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] result = twoSum(nums, 9);
        PrintlnUtil.printArray(result);
    }

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return new int[0];
        }

        Map<Integer, Integer> record = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            // 比较 record 中是否存在当前值
            if (record.containsKey(nums[i])) {
                // 满足条件的两个值的索引
                return new int[]{record.get(nums[i]), i};
            }
            // 将目标值和当前值的差和当前索引值存入 record
            record.put(target - nums[i], i);
        }
        return new int[0];
    }
}
