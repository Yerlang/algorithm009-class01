### 习题
##### [1、最长有小括号](https://leetcode-cn.com/problems/longest-valid-parentheses/)
```java
class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        int[] dp = new int[s.length()];
        int res = 0;
        int leftCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftCount++;
            } else if (leftCount > 0) {
                dp[i] = dp[i - 1] + 2;
                dp[i] += dp[Math.max(i - dp[i], 0)];
                res = Math.max(res, dp[i]);
                leftCount--;
            }
        }
        return res;
    }
}
```
##### [2、最长上升子序列](https://leetcode-cn.com/problems/longest-increasing-subsequence/)
```java
class Solution {
    public int lengthOfLIS(int[] nums) {
        int len;
        if (nums == null || (len = nums.length) < 1) {
            return 0;
        }
        int[] dp = new int[len];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < len; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }
}
```
