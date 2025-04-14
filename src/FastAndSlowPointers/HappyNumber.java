package FastAndSlowPointers;

public class HappyNumber {

    public static void main(String[] args) {
        int num = 19;
        System.out.println("Is Happy Number? : "+isHappy(num));
    }

    public static boolean isHappy(int n) {

        int slow = n;
        int fast = n;
        //while loop is not used here because initially slow and
        //fast pointer will be equal only, so the loop won't run.
        do {
            //slow moving one step ahead and fast moving two steps ahead
            slow = square(slow);
            fast = square(square(fast));
        } while (slow != fast);

        //if a cycle exists, then the number is not a happy number
        //and slow will have a value other than 1
        return slow == 1;
    }

    //Finding the square of the digits of a number
    public static int square(int num) {

        int ans = 0;

        while(num > 0) {
            int remainder = num % 10;
            ans += remainder * remainder;
            num /= 10;
        }

        return ans;
    }
}
