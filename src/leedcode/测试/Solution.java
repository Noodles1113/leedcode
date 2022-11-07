package leedcode.测试;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

//    public static int[] findErrorNums(int[] nums) {
//        int n = nums.length;
//        int[] cnts = new int[n + 1];
//        for (int num : nums) {
//            cnts[num] = cnts[num] + 1;
//        }
////        for (int x : nums) cnts[x]++;
//        int[] ans = new int[2];
//        for (int i = 1; i <= n; i++) {
//            if (cnts[i] == 0) ans[1] = i;
//            if (cnts[i] == 2) ans[0] = i;
//        }
//        return ans;
//    }

    public static int findShortestSubArray(int[] nums) {
        // 寻找度=?
        // 长度=(最后一次出现度的i-最初出现度的i)+1
        int n = nums.length;
        if(n == 1) return 1;
        List<Integer> list = new ArrayList<>();
        list = findDuList(nums, n,list);
        int s = 0;
        int e = 0;
        int min = nums.length;
        for (int k = 0; k < list.size(); k++) {
            for (int i = 0; i < n; i++) {
                if (list.get(k) == nums[i]) {
                    s = i;
                    break;
                }
            }
            for (int j = n - 1; j > 0; j--) {
                if (list.get(k) == nums[j]) {
                    e = j;
                    break;
                }
            }
            int cur = e - s + 1;
            min = Math.min(cur, min);
        }
        return min;
    }

    public static List<Integer> findDuList(int[] nums, int n,List<Integer> list) {
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            map.put(cur,map.getOrDefault(cur,0)+1);
            max = Math.max(map.get(cur),max);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                list.add(entry.getKey());
            }
        }
        return list;
    }

    public static List<Integer> findDuplicates(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 2) {
                res.add(entry.getKey());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(nums));

    }
}
