package javaLeetCode;

public class LeftRotateString {
    public static String leftRotateString(String str, int n){
        if (str == null || n < 0) return null;
        if (n == 0 || n >= str.length()) return str;

        String rotatedStr = "";

        for (int i=n; i<str.length(); i++) {
            rotatedStr = rotatedStr.concat("" + str.charAt(i));
        }

        for (int i=0; i<n; i++){
            rotatedStr = rotatedStr.concat("" + str.charAt(i));
        }

        return rotatedStr;
    }

    public static void main(String[] args){
        String a = "dsafhkjaj";
        String b = leftRotateString(a, 3);
        System.out.print(b);
    }
}
