package com.home.leetcode.top;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author hw
 * @create 2020/7/23
 */

public class Top20 {


        /*
        * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

    有效字符串需满足：

    左括号必须用相同类型的右括号闭合。
    左括号必须以正确的顺序闭合。
    注意空字符串可被认为是有效字符串。

    示例 1:

    输入: "()"
    输出: true
    示例 2:

    输入: "()[]{}"
    输出: true
    示例 3:

    输入: "(]"
    输出: false
    示例 4:

    输入: "([)]"
    输出: false
    示例 5:

    输入: "{[]}"
    输出: true
    */

    public  boolean isValid(String s) {
        Map<Character,Character> characterMap = new HashMap<>();
        characterMap.put('(',')');
        characterMap.put('{','}');
        characterMap.put('[',']');
        LinkedList<Character> list = new LinkedList<Character>();
        for(Character character : s.toCharArray()){
            if(characterMap.containsKey(character)){
                list.add(characterMap.get(character));
            } else if(!list.isEmpty() && list.getLast().equals(character)){
                list.removeLast();
            } else {
                return false;
            }
        }
        if(list.isEmpty()){
            return true;
        } else {
            return false;
        }
    }
}
