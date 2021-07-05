package com.home.leetcode.top.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hw
 * @create 2021/7/1
 */

public class Top22 {


    /**
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = 3
     * 输出：["((()))","(()())","(())()","()(())","()()()"]
     * 示例 2：
     * <p>
     * 输入：n = 1
     * 输出：["()"]
     * 思路：一个个的插入 最后结果肯定是2n 且左（和右）都是n
     * 先插入（，接下去就有两种选下（，）
     */
    public static void main(String[] args) {
        int n = 0;
        Top22 top22 = new Top22();
        List<String> str = top22.generateParenthesis(n);
        for (String s : str) {
            System.out.println(s);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        getParenthesis(res, "", n, 0, 0);
        return res;
    }

    private void getParenthesis(List<String> str, String cur, int n, int left, int right) {
        if (cur.length() == 2 * n) {
            /*满足2n的要求*/
            str.add(cur.toString());
            return;
        }
        if (left < n) {
            getParenthesis(str, cur + "(", n, left + 1, right);
        }
        /*如果右边少于左边*/
        if (right < left) {
            getParenthesis(str, cur + ")", n, left, right + 1);
        }
    }
}
