package javaLeetCode;

public class ReplaceSpace {
    public static String replaceSpace(StringBuffer str){ //时间复杂度为O(n^2)
        if (str == null) return null;
        int n = str.length();
        for (int i=0; i<n; i++){
            if (str.charAt(i) == ' '){
                str.replace(i, i+1, "%20");
            }
        }
        return str.toString();
    }

    public static String replaceSpaceB(StringBuffer str){ //时间复杂度为O(n)
        if (str == null) return null;

        int originLen = str.length();
        int countSpace = 0;
        for (int i=0; i<originLen; i++){
            if (str.charAt(i) == ' '){
                countSpace += 2;
            }
        }
        int p2 = 2 * countSpace + originLen - 1;
        int p1 = originLen - 1;
        char[] string = new char[p2+1];
        while (p1 >= 0 && p1 < p2){
            if (str.charAt(p1) == ' ') {
                string[p2--] = '0';
                string[p2--] = '2';
                string[p2--] = '%';
            }
            else {
                string[p2--] = str.charAt(p1);
            }
            p1--;
        }
        return new String(string);
    }

    public static void main(String[] args){
//        StringBuffer str = new StringBuffer(" ");
        StringBuffer str = new StringBuffer("hello world i am a Chinese");
//        StringBuffer str = new StringBuffer("");
        String str2 = replaceSpaceB(str);
//        char[] n = new char[5];
        System.out.print(str2);
//        System.out.print(1);
//        System.out.print(1);
    }
}
