### 习题

##### 1、[爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/)
```java
class Solution {
    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int f1 = 1;
        int f2 = 2;
        for (int i = 3; i <= n; i++) {
            int curr = f1 + f2;
            f1 = f2;
            f2 = curr;
        }
        return f2;
    }
}
```

##### 2、[实现 Trie (前缀树)](https://leetcode-cn.com/problems/implement-trie-prefix-tree/#/description)
```java
class Trie {

    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (!node.containsKey(ch)) {
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }
        node.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isWord();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    public TrieNode searchPrefix(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return null;
        }
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            if (node.containsKey(ch)) {
                node = node.get(ch);
            } else {
                return null;
            }
        }
        return node;
    }
}

class TrieNode {
    public boolean isWord;
    public TrieNode[] children = new TrieNode[26];

    public TrieNode() {}

    public boolean containsKey(char ch) {
        return children[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return children[ch - 'a'];
    }
    public void put(char ch, TrieNode node) {
        children[ch - 'a'] = node;
    }
    public void setWord() {
        isWord = true;
    }
    public boolean isWord() {
        return isWord;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
```

#### 3、[岛屿数量](https://leetcode-cn.com/problems/number-of-islands/)
```java
class Solution {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    public int numIslands(char[][] grid) {
        int numIslands = 0;
        if (grid == null || grid.length == 0) {
            return numIslands;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                numIslands += dfs(grid, i, j);
            }
        }
        return numIslands;
    }

    public int dfs(char[][] grid, int i, int j) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[i].length || grid[i][j] == '0') {
            return 0;
        }
        grid[i][j] = '0';
        for (int k = 0; k < 4; k++) {
            dfs(grid, i + dx[k], j + dy[k]);
        }
        return 1;
    } 
}
```
### 学习笔记