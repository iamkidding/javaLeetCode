package javaLeetCode;

import java.util.Stack;

public class ReverseSentence {
    public String reverseSentence(String str){
        if (str == null) return null;

        String word = ""; // 即作为句子中的单词拆分，压入栈，又作为最后从栈中取出的倒序句子整体
//        StringBuilder word = new StringBuilder("");
        if (str.length() == 0) return word;
        Stack<String> sentence = new Stack<>();
        for (int i=0; i<str.length(); i++){
            // 将单词挨个压入栈
            if (str.charAt(i) == ' ' || i == str.length()-1){
                if (i == str.length()-1) word += str.charAt(i);
                sentence.push(word);
                word = "";
            }
            else
                word += str.charAt(i);
        }

        word = "";
        while (true) {
            word += sentence.pop();
            if (sentence.isEmpty()) break;
            word += " ";
        }
        return word;
    }

    public static void main(String[] args){
        String str = "i am a student";
        System.out.print((new ReverseSentence()).reverseSentence(str));
//        System.out.print(str.charAt(str.length()-1));
    }
}
