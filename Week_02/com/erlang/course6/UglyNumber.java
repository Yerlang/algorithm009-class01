package com.erlang.course6;

/**
 * @description: 我们把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:  
 * <p>
 * 1 是丑数。
 * n 不超过1690。
 * 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/chou-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: erlang
 * @since: 2020-05-31 12:24
 */
public class UglyNumber {
    public int nthUglyNumber(int n) {
        if (n < 1) {
            return 0;
        }
        int a = 0, b = 0, c = 0;
        int[] dq = new int[n];
        dq[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = dq[a] * 2;
            int n3 = dq[b] * 3;
            int n5 = dq[c] * 5;
            dq[i] = Math.min(Math.min(n2, n3), n5);
            if (dq[i] == n2) {
                a++;
            }
            if (dq[i] == n3) {
                b++;
            }
            if (dq[i] == n5) {
                c++;
            }
        }
        return dq[n - 1];
    }
}
