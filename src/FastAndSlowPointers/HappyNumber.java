package FastAndSlowPointers;

public class HappyNumber {

    public static void main(String[] args) {
        int num = 19;
        System.out.println("Is Happy Number? : "+isHappy(num));
    }

    public static boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n); // Fast starts one step ahead to avoid do-while

        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }

        return fast == 1; // If fast reaches 1, it's a happy number
    }

    // Helper function to compute the sum of squared digits
    private static int getNext(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }
}
