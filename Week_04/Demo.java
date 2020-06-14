/**
 * @description:
 * @author: erlang
 * @since: 2020-06-14 17:47
 */
public class Demo {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int min = findMinIndex(nums);
        System.out.println(min);
    }

    public static int findMinIndex(int[] nums) {
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
        return nums[left] < nums[right] ? left : right;
    }
}
