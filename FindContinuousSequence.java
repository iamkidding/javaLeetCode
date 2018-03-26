package javaLeetCode;

import java.util.ArrayList;

public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum){
        ArrayList<ArrayList<Integer>> sequences = new ArrayList<>();

        if (sum == 0) return sequences;

        int maxNumInSequcne = 2;
        while (sum / maxNumInSequcne - maxNumInSequcne / 2 >= 0){
            maxNumInSequcne++;
        }

        while (maxNumInSequcne >= 2){
            ArrayList<Integer> sequence = new ArrayList<>();
            int init = sum / maxNumInSequcne - maxNumInSequcne / 2;
            if (sum % maxNumInSequcne == 0 && maxNumInSequcne % 2 != 0){
                for (int i = init; i <= init + maxNumInSequcne; i++)
                    sequence.add(i);
                sequences.add(sequence);
            }
            else if (maxNumInSequcne % 2 == 0){
                if ((float)sum / maxNumInSequcne == sum / maxNumInSequcne * 2 + 1){
                    for (int i=init; i <= init + maxNumInSequcne; i++)
                        sequence.add(i);
                    sequences.add(sequence);
                }
            }
        }

        return sequences;
    }

    public ArrayList<ArrayList<Integer>> findContinuousSequenceB(int sum){
        ArrayList<ArrayList<Integer>> sequences = new ArrayList<>();

        if (sum < 3) return sequences;

        int small = 1, big = 2;
        int middle = (1 + sum) / 2;
        int currSum = small + big;

        while (small < middle){
            ArrayList<Integer> se = new ArrayList<>();
            if (currSum == sum){
                for (int i=small; i<=big; i++)
                    se.add(i);
                sequences.add(se);
            }

            while (currSum > sum && small < middle){
                currSum -= small;
                small++;

                if (currSum == sum){
                    for (int i=small; i<=big; i++)
                        se.add(i);
                    sequences.add(se);
                }
            }

            big++;
            currSum += big;
        }

        return sequences;
    }
}
