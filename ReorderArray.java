package javaLeetCode;

import java.lang.reflect.Type;
import java.util.ArrayList;
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

    public void reorderArrayC(int[] array){
        if (array == null ||array.length == 0) return;

        ArrayList<Integer> aux = new ArrayList<>();
        for (int i=0; i<array.length; i++){
            if ((array[i] & 0x1) == 1) aux.add(array[i]);
        }
        for (int i=0; i<array.length; i++){
            if ((array[i] & 0x1) == 0) aux.add(array[i]);
        }
        for (int i=0; i<array.length; i++){
            array[i] = aux.get(i);
        }
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
