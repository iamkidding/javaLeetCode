package javaLeetCode;
//        给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
//        其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
public class ArrayMultiply {
    public int[] arrayMultiply(int[] A){
        // 将B[i]看做A[0]*...*A[i-1]和A[i+1]*...*A[n-1]的乘积
        // 设C[i] = A[0]*...*A[i-1],D[i] = A[i-1]*...*A[n-1]
        // 则C[i] = C[i-1] * A[i-1],D[i] = D[i+1] * A[i+1](C[]从前往后算，D[]从后往前算
        if (A.length <= 1) return null;

        int[] B = new int[A.length];  //创建和A长度一致的数组
        B[0] = 1;
        for (int i=1; i<A.length; i++){
            B[i] = B[i-1] * A[i-1]; // 计算C[]
        }

        int temp = 1;
        for (int i=A.length-2; i>=0; i--){
            // 最后结果中B[n-1]即为C[n-1],所以i=A.length-2
            temp *= A[i+1]; // 计算D[i]
            B[i] = B[i] * temp;
        }

        return B;
    }
}
