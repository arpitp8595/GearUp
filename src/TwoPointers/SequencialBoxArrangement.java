package src.TwoPointers;

import java.util.Arrays;

public class SequencialBoxArrangement {
    public static void main(String[] args) {
        int[] boxes = {1,2,5,6,9,10,14};
        int[] boxes1 = {6,5,7,4,2,1,26,0,12,14,15,16,18,19,20,25};
    /*
    we need to find the number of sequences where consecutive numbers form groups.
    For example, in the given array [1,2,5,6,9,10,14], the sequences are:
    1,2
    5,6
    9,10
    14
    This gives us a total of 4 sequences.
    */
    System.out.println("Total sequences: "+getTotalNoOfSequences(boxes1));
    }

    private static int getTotalNoOfSequences(int[] boxes) {
        if (boxes.length == 0) {
            return 0;
        }
        Arrays.sort(boxes);
        //System.out.println("Sorted list: "+Arrays.toString(boxes));
        int totalSequences = 1;

        for (int i=1; i<boxes.length; i++) {
            if (boxes[i] != boxes[i-1]+1) {
                totalSequences++;
            }
        }
        return totalSequences;
    }
}
