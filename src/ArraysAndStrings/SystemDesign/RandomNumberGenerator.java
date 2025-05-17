package ArraysAndStrings.SystemDesign;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomNumberGenerator {

    public static void main(String[] args) {
        Generate generate = new Generate(1,3);
        System.out.println("First Test: "+generate.next());
    }
}

class Generate{
    int start;
    int end;

    private Integer result;

    Set<Integer> set = new HashSet<>();

    Generate(Integer start, Integer end){
        this.start = start;
        this.end = end;
    }

    public void RandomNumberGenerator(int start, int end) {
        Random random = new Random();
        this.result = random.nextInt(end - start) - start;
    }

    public int next() {
        Random random = new Random();
        this.result = random.nextInt(end - start) - start;

        if (set.contains(result)) {
            next();
        } else {
            set.add(result);
        }
        return result;
    }
}
