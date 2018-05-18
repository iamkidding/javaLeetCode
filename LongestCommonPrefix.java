package javaLeetCode;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs){
        if (strs == null) return null;
        if (strs.length == 0) return "";
        if (strs.length == 1) return null;
        // 先找到前两个字符串的最大公共前缀
        StringBuffer longestCP = compareTwoWords(strs[0], strs[1]);
        // 用已找到的前缀和之后的字符串依次找共同前缀，新前缀比原前缀短的话，新前缀就是最大公共前缀
        for (int i=2; i < strs.length; i++){
            StringBuffer temp = compareTwoWords(longestCP.toString(), strs[i]);
            if (temp.length() < longestCP.length()) longestCP = temp;
        }

        return longestCP.toString();
    }

    private StringBuffer compareTwoWords(String s1, String s2){
        StringBuffer commonPrefix = new StringBuffer();
        for (int i=0; i<s1.length() && i<s2.length() && s1.charAt(i) == s2.charAt(i); i++){
            commonPrefix.append(s1.charAt(i));
        }
        return commonPrefix;
    }

    public static void main(String[] args){
        String[] strs = {"al", "alll", "along"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
    }
}
