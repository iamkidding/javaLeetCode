package javaLeetCode;

public class ReorderArray {
    public static int[] reorderArray(int[] array){
        int indexEven = array.length - 1;
        int indexOdd = 0;
        while (indexEven > indexOdd){
            while (indexEven >= 0 && (array[indexEven] & 0x1) == 0) indexEven--;
            while (indexOdd >= 0 && (array[indexOdd] & 0x1) == 1) indexOdd++;
            if (indexEven > indexOdd){
                int cache;
                cache = array[indexEven];
                array[indexEven] = array[indexOdd];
                array[indexOdd] = cache;
            }
        }
        return array;
    }
    public static void main(String[] args){
//        System.out.println(12 & 0x1);
        int[] array = {1, 4, 6, 5, 7, 9, 10, 12};
        array = reorderArray(array);
        for (int i=0; i<array.length; i++){
            System.out.print(array[i]);
        }
    }
}
