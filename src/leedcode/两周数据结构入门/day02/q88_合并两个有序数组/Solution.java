package leedcode.两周数据结构入门.day02.q88_合并两个有序数组;

public class Solution {

    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int i = nums1.length ;
        while (n > 0) {
            if (m > 0 && nums1[m-1] > nums2[n-1]) {
                nums1[--i] = nums1[--m];
            }else{
                nums1[--i] = nums2[--n];
            }
        }
        return nums1;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {1,2,3,3,4,0,0,0};
        int[] nums2 = new int[] {1,2,3};
        for (int i : merge(nums1,5, nums2,3)) {
            System.out.println(i);
        }
    }

}
