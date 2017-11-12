package javaLeetCode;

public class LCA {
    public int getLCA(int a, int b) {
//    	递归题，共同祖先
        int aA = getA(a);
        int bA = getA(b);
        while(bA != aA){
            if (bA < aA) aA = getA(aA);
            if (bA > aA) bA = getA(bA);
        }
        return aA;
    }
    private int getA(int a){
    	int aA = 0;
        if(a % 2 == 0) aA = a / 2;
        else aA = (a-1) / 2;
        return aA;
    }
}
