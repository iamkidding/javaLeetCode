package javaLeetCode;

import java.util.ArrayList;

public class PrintMatrix {
    public static ArrayList<Integer> printMatrixB(int[][] matrix){
        if (matrix == null) return null;

        ArrayList<Integer> clockWise = new ArrayList<>();
        int start = 0;//内圈的开始第一个点总在对角线上，所以用一个int表示即可
        int nRow = matrix.length;
        int nCol = matrix[0].length;

        while (nCol > start * 2 && nRow > start * 2){
            //将matrix看成一圈圈的嵌套，从外圈向内圈一个一个的顺时针添加到ArrayList中
            clockWise = incircleMatrix(clockWise, matrix, start);
            start++;
        }
        return clockWise;
    }

    private static ArrayList<Integer> incircleMatrix(ArrayList<Integer> al,
                                                     int[][] matrix, int start){
        //内圈
        int endX = matrix[0].length - 1 - start;
        int endY = matrix.length - 1 - start;
        //打印第一行,任何情况都要打印第一行
        for (int i=start; i<=endX; i++){
            al.add(matrix[start][i]);
        }
        //打印最右一列,matrix至少两行的时候
        if (start < endY){
            for (int i=start+1; i<=endY; i++){
                al.add(matrix[i][endX]);
            }
        }
        //打印最下面一行，matrix至少两行两列
        if (start < endX && start < endY){
            for (int i=endX-1; i>=start; i--){
                al.add(matrix[endY][i]);
            }
        }
        //打印最左一列，matrix至少三行两列
        if (start < endX && start < endY - 1){
            for (int i=endY-1; i>=start+1; i--){
                al.add(matrix[i][start]);
            }
        }

        return al;
    }

    public static void main(String[] args){
//        System.out.print();
    }
}
