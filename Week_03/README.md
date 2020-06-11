## 第七课课后习题：
[https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/][二叉树的最近公共祖先]
```java
class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }
}
```

[https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal][从前序与中序遍历序列构造二叉树]
```java
class Solution {

    private Map<Integer, Integer> recordIn = new HashMap<>(16);

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for(int i = 0; i < inorder.length; i++) {
            recordIn.put(inorder[i], i);
        }

        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    /**
    * 
    * 从下而上的构建树
    * 
    */
    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = recordIn.get(root.val);
        int numLeft = inRoot - inStart;

        // 构建左子树
        root.left = buildTree(preorder, preStart + 1, preStart + numLeft, inorder, inStart, inRoot - 1);
        // 构建右子树
        root.right = buildTree(preorder, preStart + numLeft + 1, preEnd, inorder, inRoot + 1, inEnd);
        return root;
    }
}
```

[https://leetcode-cn.com/problems/combinations/][组合]
```java
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n == 0 || k == 0) {
            return res;
        }
        helper(res, new ArrayList<>(), 1, n, k);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> comb, int start, int n, int k) {
        if (k == 0) {
            res.add(new ArrayList<>(comb));
            return;
        }
        for (int i = start; i <= n; i++) {
            comb.add(i);
            helper(res, comb, i + 1, n, k - 1);
            comb.remove(comb.size() - 1);
        }
    }
}
```
[https://leetcode-cn.com/problems/permutations/][全排列]
```java
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        helper(list, new ArrayList<>(), nums);
        return list;
    }

    private void helper(List<List<Integer>> list , List<Integer> curr, int [] nums){
        if (curr.size() == nums.length) {
            list.add(new ArrayList<>(curr));
            return;
        }
        for (int num: nums) {
            if (curr.contains(num)) {
                continue;
            }
            curr.add(num);
            helper(list, curr, nums);
            curr.remove(curr.size() - 1);
        } 
    }
}
```

[https://leetcode-cn.com/problems/permutations-ii/][全排列 II]
```java
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 1) {
            return res;
        }
        Arrays.sort(nums);
        helper(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> curr, int[] nums, boolean[] visited) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            curr.add(nums[i]);
            visited[i] = true;
            helper(res, curr, nums, visited);
            visited[i] = false;
            curr.remove(curr.size() - 1);
        }
    }
}
```

## 第八课课后习题：
[https://leetcode-cn.com/problems/majority-element/description/][多数元素]
````java
class Solution {
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[(nums.length >> 1)];
    }
    
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0, ret = 0;
        for (int num : nums) {
            if (count == 0) {
                ret = num;
            }
            if (num != ret) {
                count--;
            } else {
                count++;
            }
        }
        return ret;
    }
}
````

[https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/][电话号码的字母组合] 
```java
class Solution {
    
    String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        helper(res, new StringBuilder(), digits, 0);
        return res;
    }

    public void helper(List<String> res, StringBuilder sb, String digits, int index) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String digit = letters[digits.charAt(index) - '0'];
        for (char curr : digit.toCharArray()) {
            sb.append(curr);
            helper(res, sb, digits, index + 1);
            sb.setLength(sb.length() - 1);
        }
    }
}
```

[https://leetcode-cn.com/problems/n-queens/][N皇后] 
```java
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), 0, new boolean[n], new boolean[2 * n], new boolean[2 * n], n);
        return res;
    }

    public void helper(List<List<String>> res, List<String> curr, int row, boolean[] cols, boolean[] d1, boolean[] d2, int n) {
        // row 列
        if (row == n) {
            res.add(new ArrayList<>(curr));
        } 
        for (int col = 0; col < n; col++) {
            int id1 = col - row + n;
            int id2 = col + row;
            if (!cols[col] && !d1[id1] && !d2[id2]) {
                char[] r = new char[n];
                // 初始化数组值
                Arrays.fill(r, '.');
                // 填充皇后，其中 col 皇后的行号
                r[col] = 'Q';
                curr.add(new String(r));
                cols[col] = true;
                d1[id1] = true;
                d2[id2] = true;
                helper(res, curr, row + 1, cols, d1, d2, n);
                curr.remove(curr.size() - 1);
                cols[col] = false;
                d1[id1] = false;
                d2[id2] = false;
            }
        }
    }
}
```
## 总结
### 递归
一种优雅的问题解决办法。为了解决一个给定的问题，算法一次或多次递归调用其自身已解决紧密相关的若干子问题。
递归遵循的是分治法的思想，将原问题分解为若干个规模较小的但类似于原问题的子问题，递归地求解这鞋子问题，然后在合并这些子问题的解来建立原问题的解
一个问提只要同时满足以下三个条件，就可以用递归来解决。
1. 一个问题的解可以分解为几个子问题的解。何为子问题？规模较小的但类似于原问题的子问题
2. 这个问题与分解之后的子问题，除了数据规模不同
3. 存在递归终止条件把问题分解为子问题
写递归时，要注意的问题
1. 要警惕堆栈溢出
2. 要警惕重复计算
#### 递归代码模板
```java
public void recur(int level, int param) { 
  // terminator 
  if (level > MAX_LEVEL) { 
    // process result 
    return; 
  }
  // process current logic 
  process(level, param); 
  // drill down 
  recur( level: level + 1, newParam); 
  // restore current status 
}
```
### 分治法
分治算法是一种处理问题的思想，递归是一种编程技巧。
分治模式的在每层递归时，都有三个步骤：
* 分解：分解原问题为若干子问题，这些子问题石原问题的规模较小的实例
* 解决：解决这些子问题，递归地求解各子问题，然而，若子问题足够小，则直接求解
* 合并：合并这些子问题的解成原问题的解
#### 分治法代码模板
```Python
def divide_conquer(problem, param1, param2, ...): 
  # recursion terminator 
  if problem is None: 
	print_result 
	return 
  # prepare data 
  data = prepare_data(problem) 
  subproblems = split_problem(problem, data) 
  # conquer subproblems 
  subresult1 = self.divide_conquer(subproblems[0], p1, ...) 
  subresult2 = self.divide_conquer(subproblems[1], p1, ...) 
  subresult3 = self.divide_conquer(subproblems[2], p1, ...) 
  …
  # process and generate the final result 
  result = process_result(subresult1, subresult2, subresult3, …)
	
  # revert the current level states
```
### 回溯
回溯法采用采用试错的思想，它尝试分步的去解决一个问题。在分步解决问题的过程中，当它通过尝试发现现有问题的分步答案不能得到有效正确的解答的时候，它将取消上一步甚至是几步的计算，再通过其它可能的分步解答再次尝试寻找问题答案。
回溯法通常使用最简单的递归方法来实现，在反复重复上述步骤后可能出现两种情况：
* 找到可能存在的正确的答案
* 在尝试了所有可能的分布方法后宣告该问题没有答案
再最坏的情况下，回溯法导致一次复杂度为指数级时间的计算

就是不断的在每个问题上去试