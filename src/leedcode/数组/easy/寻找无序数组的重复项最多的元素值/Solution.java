package leedcode.数组.easy.寻找无序数组的重复项最多的元素值;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    // 排序后在遍历过程中不断的比较赋值最大重复次数和返回值然后返回最大值
    public static int find1(int[] arr) {
        if (arr.length == 0) return -1;
        Arrays.sort(arr);
        int currentCount = 0;
        int result = -1;
        int currentMaxCount = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                if (currentCount++ > currentMaxCount) {
                    currentMaxCount = currentCount;
                    result = arr[i];
                }
            } else {
                currentCount = 0;
            }
        }
        return result;
    }

    // 哈希记录最大值遍历过程中不断的比较赋值最大重复次数和返回值然后返回最大值
    public static int find2(int[] arr) {
        if (arr.length == 0) return -1;
        int count = 0;
        int maxCount = 0;
        int result = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], count++);
                if (count > maxCount) {
                    maxCount = count;
                    result = arr[i];
                }
            } else {
                count = 0;
                map.put(arr[i], count);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, -2, 3, 5, 5, 3, 4, 5, 5, 22, 2, 2, 2, 2, 89, 11, 2, 2, 2, 2, 5};
        System.out.println(find1(arr));
        System.out.println(find2(arr));
    }
}
