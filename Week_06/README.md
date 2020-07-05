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
### 学习笔记
##### “一个模型三个特征”理论讲解
什么样的问题适合用动态规划来解决呢？换句话说，动态规划能解决的问题有什么规律可循呢？实际上，动态规划作为一个非常成熟的算法思想，很多人对此已经做了非常全面的总结。我把这部分理论总结为“一个模型三个特征”。

首先，我们来看，什么是“一个模型”？它指的是动态规划适合解决的问题的模型。我把这个模型定义为“多阶段决策最优解模型”。下面我具体来给你讲讲。

我们一般是用动态规划来解决最优问题。而解决问题的过程，需要经历多个决策阶段。每个决策阶段都对应着一组状态。然后我们寻找一组决策序列，经过这组决策序列，能够产生最终期望求解的最优值。

现在，我们再来看，什么是“三个特征”？它们分别是最优子结构、无后效性和重复子问题。这三个概念比较抽象，我来逐一详细解释一下。
###### 1. 最优子结构
最优子结构指的是，问题的最优解包含子问题的最优解。反过来说就是，我们可以通过子问题的最优解，推导出问题的最优解。如果我们把最优子结构，对应到我们前面定义的动态规划问题模型上，那我们也可以理解为，后面阶段的状态可以通过前面阶段的状态推导出来。
###### 2. 无后效性
无后效性有两层含义，第一层含义是，在推导后面阶段的状态的时候，我们只关心前面阶段的状态值，不关心这个状态是怎么一步一步推导出来的。第二层含义是，某阶段状态一旦确定，就不受之后阶段的决策影响。无后效性是一个非常“宽松”的要求。只要满足前面提到的动态规划问题模型，其实基本上都会满足无后效性。
###### 3. 重复子问题
这个概念比较好理解。前面一节，我已经多次提过。如果用一句话概括一下，那就是，不同的决策序列，到达某个相同的阶段时，可能会产生重复的状态。

##### 两种动态规划解题思路
解决动态规划问题，一般有两种思路。我把它们分别叫作，状态转移表法和状态转移方程法。
###### 1. 状态转移表法 
我们先画出一个状态表。状态表一般都是二维的，所以你可以把它想象成二维数组。其中，每个状态包含三个变量，行、列、数组值。我们根据决策的先后过程，从前往后，根据递推关系，分阶段填充状态表中的每个状态。最后，我们将这个递推填表的过程，翻译成代码，就是动态规划代码了。

尽管大部分状态表都是二维的，但是如果问题的状态比较复杂，需要很多变量来表示，那对应的状态表可能就是高维的，比如三维、四维。那这个时候，我们就不适合用状态转移表法来解决了。一方面是因为高维状态转移表不好画图表示，另一方面是因为人脑确实很不擅长思考高维的东西。
###### 2. 状态转移方程法
状态转移方程法有点类似递归的解题思路。我们需要分析，某个问题如何通过子问题来递归求解，也就是所谓的最优子结构。根据最优子结构，写出递归公式，也就是所谓的状态转移方程。有了状态转移方程，代码实现就非常简单了。一般情况下，我们有两种代码实现方法，一种是递归加“备忘录”，另一种是迭代递推。