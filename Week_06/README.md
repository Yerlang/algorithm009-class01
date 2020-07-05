### 习题
#### 1、[编辑距离](https://leetcode-cn.com/problems/edit-distance/)
```java
class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word1.length() == 0) {
            return word2.length();
        }
        int len1 = word1.length();
        int len2 = word2.length();

        int[][] cost = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            cost[i][0] = i;
        }
        for (int i = 0; i <= len2; i++) {
            cost[0][i] = i;
        }

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    cost[i + 1][j + 1] = cost[i][j];
                } else {
                    int a = cost[i][j];
                    int b = cost[i][j + 1];
                    int c = cost[i + 1][j];
                    cost[i + 1][j + 1] = a < b ? Math.min(a, c) : Math.min(b, c);
                    cost[i + 1][j + 1]++;
                }
            }
        }
        return cost[len1][len2];
    }
}
```

#### 2、[最小路径和](https://leetcode-cn.com/problems/minimum-path-sum/)
```java
class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int rowLen = grid.length - 1;
        int colLen = grid[0].length - 1;

        for (int i = 0; i <= rowLen; i++) {
            for (int j = 0; j <= colLen; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int leftSum = (j > 0) ? grid[i][j - 1] : Integer.MAX_VALUE;
                int topSum = (i > 0) ? grid[i - 1][j] : Integer.MAX_VALUE;
                grid[i][j] += Math.min(leftSum, topSum);
            }
        }
        return grid[rowLen][colLen];
    }
}
```
#### 3、[最长有效括号](https://leetcode-cn.com/problems/longest-valid-parentheses/)
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
```java
class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        Stack<Integer> record = new Stack<>();
        int res = 0;
        record.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && record.size() > 1 && s.charAt(record.peek()) == '(') {
                record.pop();
                res = Math.max(res, i - record.peek());
            } else {
                record.push(i);
            }
        }
        return res;
    }
}
```