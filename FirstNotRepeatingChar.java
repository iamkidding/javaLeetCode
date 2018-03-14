package javaLeetCode;

public class FirstNotRepeatingChar {
    public static int firstNotRepeatingChar(String str){
        // 大小写认为是同一个
        if (str == null || str.length() == 0) return -1;

        int[] allChar = new int[26]; // 记录字符出现的次数
        int[] location = new int[26]; // 记录字符的位置
        int finalLocation = str.length(); // 记录第一个不重复的字符的位置

        for (int i=0; i<str.length(); i++){
            // 通过与A的比较判断是哪个字符
            int gap = "A".compareTo(""+str.charAt(i));

            if (gap > -26 && gap <= 0) {
                allChar[-gap]++; // 记录次数
                location[-gap] = i; // 记录位置
            }
            else if (-57 <= gap && gap <= -32) {
                allChar[-32-gap]++;
                location[-32-gap] = i;
            }
            else return -1;
        }

        for (int i=0; i<allChar.length; i++){
            if (allChar[i] == 1){ // 在只出现一次的位置中找到靠前的一个
                if (location[i] < finalLocation)
                    finalLocation = location[i];
            }
        }

        return finalLocation;
    }

    public static int firstNotRepeatingCharNoCapital(String str) {
        // 大小写分开
        if (str == null || str.length() == 0) return -1;

        int[] allChar = new int[58];
        int[] location = new int[58];
        int finalLocation = str.length();

        for (int i = 0; i < str.length(); i++) {
            int gap = "A".compareTo("" + str.charAt(i));

            if (gap <= 0 && gap >= -57) {
                allChar[-gap]++;
                location[-gap] = i;
            } else return -1;
        }

        for (int i = 0; i < allChar.length; i++) {
            if (allChar[i] == 1) {
                if (location[i] < finalLocation)
                    finalLocation = location[i];
            }
        }

        return finalLocation;
    }

    public static void main(String[] args){
        String str = "abgjkanbhdgewhajkakw";
        System.out.print(firstNotRepeatingChar(str));
    }
}
