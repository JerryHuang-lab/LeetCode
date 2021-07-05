package com.home.leetcode.top.dp;

/**
 * @author hw
 * @create 2020/7/30
 */

public class Top5 {

    /*
    * 给你一个字符串 s，找到 s 中最长的回文子串。
    示例 1：

    输入：s = "babad"
    输出："bab"
    解释："aba" 同样是符合题意的答案。
    示例 2：

    输入：s = "cbbd"
    输出："bb"
    示例 3：

    输入：s = "a"
    输出："a"
    示例 4：

    输入：s = "ac"
    输出："a"

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/longest-palindromic-substring
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
    public static void main(String[] args) {
        String str = "babad";
        DP dp = new DP();
        System.out.println(dp.longestPalindrome(str));
    }




    private class  Noraml{
        public String longestPalindrome(String s) {
            if(s.length() < 2){
                return s;
            }
            //最长
            int maxLen = 1;
            //起始位置
            int begin = 0;
            //最后一个无法向右判断是否存在回文串
            for(int i = 0; i < s.length() -1 ; i++){
                for(int j = i+1; j < s.length();j++){
                    if(isPalindrome(s,i,j) && j-i+1 > maxLen){
                        maxLen = j-i+1 ;
                        begin = i;
                    }
                }
            }
            return s.substring(begin, begin+maxLen);
        }

        private boolean isPalindrome(String s, int left, int right){
            while (left < right){
                if(s.charAt(left) != s.charAt(right)){
                    return false;
                } else {
                    left++;
                    right--;
                }
            }
            return true;
        }
    }

    private static class DP{

        /**
         * dp 精髓在状态转移方程 dp[i][j] = s[i] == s[j] && dp[i+1][j-1]
         *  边界 子串长度等于1 (j-1)-(i+1)+1<2
         * @param s
         * @return
         */
        public String longestPalindrome(String s) {
            if(s.length() < 2){
                return s;
            }
            //最长
            int maxLen = 1;
            //起始位置
            int begin = 0;
            boolean[][] dp = new boolean[s.length()][s.length()];
            for(int j = 0 ; j < s.length();j++){
                for(int i = 0; i < j;i++){
                    if(s.charAt(i) == s.charAt(j)){
                        if(j-i<3){
                            dp[i][j]=true;

                        } else if(dp[i+1][j-1]){
                            dp[i][j]=true;
                        } else {
                            dp[i][j] = false;
                        }
                    } else {
                        dp[i][j] = false;
                    }
                    if(dp[i][j] && maxLen < j-i+1){
                        begin = i;
                        maxLen = j-i+1;
                    }
                }
            }
            return s.substring(begin,begin+maxLen);
        }

    }

}
