package com.home.leetcode.top;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author hw
 * @create 2020/7/27
 */

public class Top3 {

    /*
    给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

    示例 1:

    输入: "abcabcbb"
    输出: 3
    解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
    示例 2:

    输入: "bbbbb"
    输出: 1
    解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
    示例 3:

    输入: "pwwkew"
    输出: 3
    解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
         请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串

    */
    public static void main(String[] args) {
        String str = "pwwkew";
        Top3 top3 = new Top3();
        System.out.println(top3.lengthOfLongestSubstring(str));
    }

    public int lengthOfLongestSubstring(String s) {
        Integer size = 0;
        if(s == null || s.isEmpty()){
            return size ;
        }
        List<Character> characters = new ArrayList<>();
        for(Character character : s.toCharArray()){
            if(characters.contains(character)){
                Integer index = characters.indexOf(character);
                characters = characters.subList(index+1, characters.size());
                characters.add(character);
            } else {
                characters.add(character);
            }

            if(size < characters.size()){
                size = characters.size();
            }
        }
        return size;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0)
            return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;

    }
}
