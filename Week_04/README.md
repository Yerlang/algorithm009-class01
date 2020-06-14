# 学习笔记
## 简单：
[柠檬水找零](https://leetcode-cn.com/problems/lemonade-change/description/)
```java
class Solution {
    public boolean lemonadeChange(int[] bills) {
        if (bills == null || bills.length < 2) {
            return false;
        }
        int five = 0;
        int ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                // 10
                ten++;
                five--;
            } else {
                // 20
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else {
                    five -= 3;
                } 
            }
            if (five < 0) {
                return false;
            }
        }
        return true;
    }
}
```
[](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/)
```java
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            while (i < prices.length - 1 && prices[i + 1] <= prices[i]) {
                i++;
            }
            int min = prices[i++];
            while (i < prices.length - 1 && prices[i + 1] > prices[i]) {
                i++;
            }
            maxProfit += i < prices.length ? prices[i] - min : 0;
        }
        return maxProfit;
    }
}
```
[分发饼干](https://leetcode-cn.com/problems/assign-cookies/description/)
```java
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if (g == null || g.length == 0 || s == null || s.length == 0) {
            return 0;
        }
        // g 孩子的胃口，s 饼干尺寸
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                i++;
            }
            j++;
        }
        return i;
    }
}
```
[模拟行走机器人](https://leetcode-cn.com/problems/walking-robot-simulation/description/)
```java
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        if (commands == null || commands.length == 0) {
            return 0;
        }
        Set<String> record = new HashSet<>();
        for (int[] obs : obstacles) {
            record.add(obs[0] + " " + obs[1]);
        }
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int d = 0, x = 0, y = 0, result = 0;
        for (int c : commands) {
            if (c == -1) {
                d++;
                if (d == 4) {
                    d = 0;
                }
            } else if (c == -2) {
                d--;
                if (d == -1) {
                    d = 3;
                }
            } else {
                while (c-- > 0 && !record.contains((x + dirs[d][0]) + " " + (y + dirs[d][1]))) {
                    x += dirs[d][0];
                    y += dirs[d][1];
                }
            }
            result = Math.max(result, x * x + y * y);
        }
        return result;
    }
}
```
## 中等：
[单词接龙](https://leetcode-cn.com/problems/word-ladder/description/)
```java
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited = new HashSet<String>();
        visited.add(beginWord);
        int res = 1;
        while (!visited.contains(endWord)) {
            Set<String> curr = new HashSet<String>();
            for (String visit : visited) {
                for (int i = 0; i < visit.length(); i++) {
                    char[] chars = visit.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String word = new String(chars);
                        if (wordList.contains(word)) {
                            curr.add(word);
                            wordList.remove(word);
                        }
                    }
                }
            }
            res++;
            if (curr.size() == 0) {
                return 0;
            }
            visited = curr;
        }
        return res;
    }    
}
```
[岛屿数量](https://leetcode-cn.com/problems/number-of-islands/)
```java
class Solution {
    public int numIslands(char[][] grid) {
        int numIslands = 0;
        if (grid == null || grid.length == 0) {
            return numIslands;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                numIslands += helper(grid, i, j);
            }
        }
        return numIslands;
    }

    public int helper(char[][] grid, int i, int j) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[i].length || grid[i][j] == '0') {
            return 0;
        }
        grid[i][j] = '0';
        helper(grid, i + 1, j);
        helper(grid, i - 1, j);
        helper(grid, i, j + 1);
        helper(grid, i, j - 1);
        return 1;
    }
}
```
[扫雷游戏](https://leetcode-cn.com/problems/minesweeper/description/)
```java
class Solution {

    private int rows;
    private int cols;
    private int[][] dirs = new int[][]{{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};

    public char[][] updateBoard(char[][] board, int[] click) {
        if (board == null || click == null) {
            return new char[0][0];
        }
        rows = board.length;
        cols = board[0].length;
        int row = click[0];
        int col = click[1];
        char c = board[row][col];
        if (c == 'M') {
            board[row][col] = 'X';
        } else if (c == 'E') {
            dfs(board, row, col);
        }
        return board;
    }

    public void dfs(char[][] board, int row, int col) {
        board[row][col] = 'B';
        int count = 0;
        for (int[] dir : dirs) {
            int nRow = row + dir[0];
            int nCol = col + dir[1];
            if (isValid(nRow, nCol) && board[nRow][nCol] == 'M') {
                count++;
            }
        }

        if (count > 0) {
            board[row][col] = (char) (count + '0');
        } else {
            for (int[] dir : dirs) {
                int nRow = row + dir[0];
                int nCol = col + dir[1];
                if (isValid(nRow, nCol) && board[nRow][nCol] == 'E') {
                    dfs(board, nRow, nCol);
                }
            }
        }
    }

    public boolean isValid(int row, int col) {
        return (row >= 0 && row < rows && col >=0 && col < cols);
    }    
}
```
[跳跃游戏](https://leetcode-cn.com/problems/jump-game/)
```java
class Solution {
    public boolean canJump(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > index) {
                return false;
            }
            index = Math.max(index, i + nums[i]);
        }
        return true;
    }
}
```
[搜索旋转排序数组](https://leetcode-cn.com/problems/search-in-rotated-sorted-array/)
```java
class Solution {
    public int search(int[] nums, int target) {
       int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + ((hi - lo) >> 1);
            if ((nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid]))
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo == hi && nums[lo] == target ? lo : -1;
    }
}
```
[搜索二维矩阵](https://leetcode-cn.com/problems/search-a-2d-matrix/)
```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int j = matrix[0].length - 1;
        int i = 0;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
```
[寻找旋转排序数组中的最小值](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/)
```java
class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right - 1) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return Math.min(nums[left], nums[right]);
    }
}
```
## 困难
[单词接龙 II](https://leetcode-cn.com/problems/word-ladder-ii/description/)
```java

```
[跳跃游戏 II](https://leetcode-cn.com/problems/jump-game-ii/)
```java
class Solution {
    public int jump(int[] nums) {
        int sc = 0;
        int e = 0;
        int max = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if(i == e) {
                sc++;
                e = max;
            } 
        }
        return sc;
    }
}
```

