### 习题
##### 1、[LRU缓存机制](https://leetcode-cn.com/problems/lru-cache)
```java
class LRUCache {

    DLinkedNode data;

    int capacity;

    Map<Integer, DLinkedNode> cache = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        data = new DLinkedNode();
        DLinkedNode head = new DLinkedNode();
        DLinkedNode tail = new DLinkedNode();
        data.tail = tail;
        data.head = head;
        head.next = tail;
        tail.prev = head;

    }
    
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 如果 key 存在，先通过哈希表定位，再移到头部
        data.moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node != null) {
            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            node.value = value;
            data.moveToHead(node);
            return;
        }
        // 如果 key 不存在，创建一个新的节点
        DLinkedNode newNode = new DLinkedNode(key, value);
        // 添加到哈希表中
        cache.put(key, newNode);
        // 添加到双向链表头部
        data.addToHead(newNode);
        if (data.size > capacity) {
            // 如果超出容量，删除双向链表的尾部节点
            DLinkedNode tail = data.removeTail();
            // 删除哈希表中对应的项
            cache.remove(tail.key);
        }
    }
}

class DLinkedNode {

    int key;
    int value;

    DLinkedNode prev;
    DLinkedNode next;

    DLinkedNode head;
    DLinkedNode tail;

    int size;

    public DLinkedNode() {}

    public DLinkedNode(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        size++;
    }

    public void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        --size;
    }

    public void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    public DLinkedNode removeTail() {
        DLinkedNode tail = this.tail.prev;
        removeNode(tail);
        return tail;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
```
##### 2、[N皇后 II](https://leetcode-cn.com/problems/n-queens-ii/)
```java
class Solution {
    private int size; 
	private int count;

    public int totalNQueens(int n) { 
        count = 0; 
        size = (1 << n) - 1; 
        solve(0, 0, 0); 
        return count; 
    } 
    
	private void solve(int row, int ld, int rd) { 
		if (row == size) { 
			count++; 
			return; 
		}
		int pos = size & (~(row | ld | rd)); 
		while (pos != 0) { 
			int p = pos & (-pos); 
			pos -= p; // pos &= pos - 1; 
			solve(row | p, (ld | p) << 1, (rd | p) >> 1); 
		} 
	} 
}
```
##### 3、[颠倒二进制位](https://leetcode-cn.com/problems/reverse-bits/)
```java
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = (res << 1) | (n & 1);
            n >>= 1; 
        }
        return res;
    }
}
```
##### 4、[2的幂](https://leetcode-cn.com/problems/power-of-two/)
```java
class Solution {
    public boolean isPowerOfTwo(int n) {
        return ((n & (n - 1)) == 0 && n > 0);
    }   
}
```
### 学习笔记
##### 冒泡排序
```java
/**
 * @description:
 * @author: erlang
 * @since: 2020-07-12 21:50
 */
public class Solution {

    public static void main(String[] args) {
        int[] array = {3, 2, 6, 9, 8, 7, 0, 4};
//        bubbleSort(array);
//        insertionSort(array);
        selectionSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    /**
     * 冒泡
     *
     * @param array
     */
    public static void bubbleSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int temp = array[i];
                if (temp > array[j]) {
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    /**
     * 插入
     *
     * @param array
     */
    public static void insertionSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        for (int i = 1; i < array.length; i++) {
            int curr = array[i];
            int j = i - 1;
            while (j >= 0 && curr < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = curr;
        }
    }

    /**
     * 选择
     *
     * @param array
     */
    public static void selectionSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            int temp = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }
}

```