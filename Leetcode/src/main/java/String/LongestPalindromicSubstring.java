package String;

import org.junit.Test;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        String res = "";
        for (int i=0;i<s.length();i++){
            String s1 = palindrome(s, i, i);
            String s2 = palindrome(s, i, i + 1);
            res = res.length()>s1.length()? res:s1;
            res = res.length()>s2.length()? res:s2;
        }
        return res;
    }

    public String palindrome(String s,int l, int r){
        while (l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)){
            l--;r++;
        }
        return s.substring(l+1,r);
    }

    @Test
    public void test(){
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        String res = longestPalindromicSubstring.palindrome("aaaacvvfd", 1, 2);
        System.out.println(res);
    }
}
