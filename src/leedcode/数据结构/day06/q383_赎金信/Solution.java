package leedcode.数据结构.day06.q383_赎金信;

public class Solution {
    public static boolean canConstruct(String ransomNote, String magazine) {
        //记录杂志字符串出现的次数
        int[] arr = new int[26];
        int temp;
        for (int i = 0; i < magazine.length(); i++) {
            temp = magazine.charAt(i) - 'a';
            arr[temp]++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            temp = ransomNote.charAt(i) - 'a';
            if (arr[temp] > 0) {
                arr[temp]--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("aa", "zaa"));

    }
}
