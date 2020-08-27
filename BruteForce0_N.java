import java.util.Collections;
import java.util.Set;
import java.util.HashSet;
import java.util.List;

public class BruteForce0_N {

    static Set<Integer> weights;
    static List<Testing.Item> v;

    public static int algorithm(List<Testing.Item> items, int knapsackCapacity) {
        weights = new HashSet<Integer>();
        v = items;

        for(Testing.Item item : items) {
            if(item.getWeight() <= knapsackCapacity)
                KS(0, 0, knapsackCapacity);
        }

        return Collections.max(weights);
    }

    public static void KS(int weight, int value, int c) {
        for(Testing.Item item : v) {
            if(weight + item.getWeight() <= c) {
                KS(weight + item.getWeight(), value + item.getValue(), c);
            }
            weights.add(value);
        }
    }
}
