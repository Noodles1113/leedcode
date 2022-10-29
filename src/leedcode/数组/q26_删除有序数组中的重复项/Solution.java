package leedcode.数组.q26_删除有序数组中的重复项;

public class Solution {

    public static int removeDuplicates(int[] nums) {
        // 使用双指针
        if (nums.length <= 1) {
            return nums.length;
        }
        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        return i + 1;
    }

    public static int removeDuplicates2(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int fast = 1, slow = 1; // 删除重复元素之后也至少剩下一个元素
        while (fast < nums.length) {
            if (nums[fast] != nums[slow - 1]) { // 说明nums[fast] 和之前的元素都不同
                nums[slow] = nums[fast];        // nums[fast] 的值复制到 nums[slow]
                ++slow;
            }
            ++fast;
        }
        return slow; // 从nums[0]到nums[slow−1]的每个元素都不相同
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1,1,1,1, 2, 2, 3, 4, 5, 5};
//        int[] nums = new int[]{1,2,3,4,5};
        System.out.println(removeDuplicates2(nums));
    }
}
