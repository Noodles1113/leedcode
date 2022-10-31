package leedcode.数组.easy.q1_两数之和;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    // 双重for循环 暴力破解 n*(n-1)/2
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    // 哈希
    public static int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 若该target的补数命中hash的key则ac
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{hashMap.get(target - nums[i]),i};
            }
            // key:值 value:索引位置
            hashMap.put(nums[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 6, 3, 4};
        int[] result = twoSum2(nums, 6);
        System.out.println("[" + result[0] + "," + result[1] + "]");

    }

}
