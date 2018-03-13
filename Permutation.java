package javaLeetCode;

import java.util.ArrayList;

public class Permutation {
    public ArrayList<String> permutation(String str){
        ArrayList<String> fullArray = new ArrayList<>();

        if (str == null) return fullArray;

        permutation(str, 0, fullArray);

        return fullArray;
    }

    private void permutation(String str, int begin, ArrayList<String> arrayList) {

    }

    public static void main(String[] args){
        System.out.print((new Permutation()).permutation("abc"));
    }
}
