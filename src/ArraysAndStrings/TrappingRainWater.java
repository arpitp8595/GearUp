package ArraysAndStrings;

public class TrappingRainWater {

    public static void main(String[] args) {

        int height[] = {4,2,0,6,3,2,5};
        int height1[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("Total trapped water: " + trappedRainWater(height));

    }

    private static int trappedRainWater(int[] height) {

        int n = height.length;

        //calculate left max boundary - array
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }

        //calculate right max boundary - array
        int[] rightMax = new int[n];
        rightMax[n-1] = height[n-1];
        for (int i = n-2; i>=0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }

        int trappedWater = 0;
        // loop
        for (int i = 0; i < n; i++) {
            //waterLevel = min(leftmax bound , rightmax bound)
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            //trapped water = waterLevel - height[i]
            trappedWater += waterLevel - height[i];
        }
        return trappedWater;
    }
}
