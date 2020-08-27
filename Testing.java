import org.junit.Test;

import java.util.List;

public class Testing {

    public class Item {
        private final int weight;
        private final int value;

        Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        public int getWeight() {
            return weight;
        }

        public int getValue() {
            return value;
        }
    }

    private static void runTest(List<Item> items, int knapsackCapacity) {
        long start = System.currentTimeMillis();
        int dp01 = KnapSack0_1.algorithm(items, knapsackCapacity);
        long dp01Time = System.currentTimeMillis()-start;

        start = System.currentTimeMillis();
        int bf0N = BruteForce0_N.algorithm(items, knapsackCapacity);
        long bf0NTime = System.currentTimeMillis()-start;

        start = System.currentTimeMillis();
        int dp0N = DynamicProgramming0_N.algorithm(items, knapsackCapacity);
        long dp0NTime = System.currentTimeMillis()-start;

        printResults(dp01, bf0N, dp0N);
        printTimes(dp01Time, bf0NTime, dp0NTime);
    }

    private static void printResults(int dp01, int bf0N, int dp0N) {
        System.out.println("Results:");
        System.out.printf("DP01: %d \nBF0N: %d \nDP0N: %d\n\n", dp01, bf0N, dp0N);
    }

    private static void printTimes(long dp01, long bf0N, long dp0N) {
        System.out.println("Times:");
        System.out.printf("DP01: %d \nBF0N: %d \nDP0N: %d\n\n", dp01, bf0N, dp0N);
    }

    @Test
    public void test1() {
        List<Item> items = List.of(
                new Item(5, 10),
                new Item(3, 7),
                new Item(2, 4)
        );

        Testing.runTest(items, 6);
    }

    @Test
    public void test2() {
        List<Item> items = List.of(
                new Item(1,5),
                new Item(2,3),
                new Item(4,5),
                new Item(2,3),
                new Item(5,2)
        );

        Testing.runTest(items, 10);
    }

    @Test
    public void test3() {
        List<Item> items = List.of(
                new Item(1,1),
                new Item(2,4),
                new Item(3,7),
                new Item(5,10)
        );

        Testing.runTest(items, 8);
    }
}
