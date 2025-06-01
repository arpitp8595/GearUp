package src.TwoPointers;

import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        System.out.println("Four sum: "+getFourSum(nums, target));
    }

    public static List<List<Integer>> getFourSum(int[] arr, int target) {
        Set<List<Integer> > set = new HashSet<>();
        Arrays.sort(arr);

        for(int i=0; i<arr.length-3; i++){
            for(int j=i+1; j<arr.length-2; j++){
                int left = j+1;
                int right = arr.length-1;

                while(left<right){
                    int sum = arr[i]+arr[j]+arr[left]+arr[right];

                    if(sum==target) {
                        set.add(Arrays.asList(arr[i],arr[j],arr[left],arr[right]));
                        left++;
                        right--;
                    }
                    else if(sum<target) left++;

                    else if(sum>target) right--;
                }
            }
        }
        return new ArrayList<>(set);
    }
}
