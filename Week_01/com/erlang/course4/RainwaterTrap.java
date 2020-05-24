package com.erlang.course4;

import java.util.Stack;

/**
 * @description: 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * rainwatertrap.png
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: erlang
 * @since: 2020-05-23 14:25
 */
public class RainwaterTrap {

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
//        int trap = trap(height);
        int trap = trap2(height);
        System.out.println(trap);
    }

    public static int trap2(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }

        int maxWater = 0;
        int length = height.length;

        for (int i = 1; i < length - 1; i++) {
            int leftMax = 0;
            // 找出 i 左边最高柱子
            for (int j = 0; j < i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }
            int rightMax = 0;
            // 找出 i 右边最高柱子
            for (int j = i + 1; j < length; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }
            // 当前水位高度
            int currWater = Math.min(leftMax, rightMax) - height[i];
            maxWater += Math.max(currWater, 0);
        }

        return maxWater;
    }

    public static int trap(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int maxWater = 0;
        int index = 0;
        Stack<Integer> record = new Stack<>();
        while (index < height.length) {
            if (record.isEmpty() || height[index] <= height[record.peek()]) {
                record.push(index++);
            } else {
                int curr = record.pop();
                int pre;
                maxWater += record.isEmpty() ? 0 : (Math.min(height[pre = record.peek()], height[index]) - height[curr]) * (index - pre - 1);
            }
        }
        return maxWater;
    }
}
