package com.erlang.course6;

import java.util.PriorityQueue;

/**
 * @description: 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 * <p>
 *  
 * <p>
 * 进阶：
 * <p>
 * 你能在线性时间复杂度内解决此题吗？
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: erlang
 * @since: 2020-05-30 13:18
 */
public class MaxSlidingWindow {

    public static void main(String[] args) {
        int nums[] = {1, 3, 2, 10, 5, 3, 5, 6, 7};
        int[] ints = maxSlidingWindow(nums, 4);
        System.out.println(ints);
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k || k == 0) {
            return new int[0];
        }

        int length = nums.length;
        int[] result = new int[length - k + 1];

        // 大顶堆
        PriorityQueue<Integer> record = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < length; i++) {
            int start = i - k;
            if (start >= 0) {
                record.remove(nums[start]);
            }
            record.offer(nums[i]);
            if (record.size() == k) {
                result[i - k + 1] = record.peek();
            }
        }
        return result;
    }
}
