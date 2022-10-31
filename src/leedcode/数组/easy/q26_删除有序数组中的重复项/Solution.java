package leedcode.数组.easy.q26_删除有序数组中的重复项;

public class Solution {

    // 使用双指针
    public static int removeDuplicates(int[] nums) {
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
        int fast = 1, slow = 1;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow - 1]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 1, 1, 1, 2, 2, 3, 4, 5, 5};
//        int[] nums = new int[]{1,2,3,4,5};
        System.out.println(removeDuplicates(nums));
    }
}
