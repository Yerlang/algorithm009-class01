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
