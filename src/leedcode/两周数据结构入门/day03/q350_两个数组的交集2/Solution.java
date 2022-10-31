package leedcode.两周数据结构入门.day03.q350_两个数组的交集2;

import java.util.*;

public class Solution {

    // 排序后使用双指针
    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length, length2 = nums2.length;
        int[] intersection = new int[Math.min(length1, length2)];
        int index1 = 0, index2 = 0, index = 0;
        while (index1 < length1 && index2 < length2) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                intersection[index] = nums1[index1];
                index1++;
                index2++;
                index++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }

    // 哈希记录重复次数 然后循环另一个数组
    public static int[] intersect2(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect2(nums2,nums1);
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] res = new int[nums1.length];
        int index = 0;
        for(int num : nums2) {
            if(map.containsKey(num) && map.get(num) > 0) {
                res[index++] = num;
                map.put(num, map.get(num) - 1);
            }
        }
        return Arrays.copyOfRange(res, 0, index);
    }


    public static void main(String[] args) {
//        int[] nums1 = new int[] {1,1,2,3,1,5};
//        int[] nums2 = new int[] {1,1,2,4};
        int[] nums1 = new int[] {3,2,1};
        int[] nums2 = new int[] {1,2,3,4};
        for (int i : intersect2(nums1, nums2)) {
            System.out.println(i);
        }
    }
}
