import java.util.List;

public class DynamicProgramming0_N {

    private static int table[][];

    public static int algorithm(List<Testing.Item> items, int knapsackCapacity) {
        table = new int[items.size()+1][knapsackCapacity+1];

        for(int i = 0; i < table.length; i++) {
            for(int j = 0; j < table[0].length; j++) {
                int result;
                if(i == 0 || j == 0) result = 0;
                else if(items.get(i-1).getWeight() <= j) {
                    int amount = (int)(j / items.get(i-1).getWeight());
                    int v_n = amount * items.get(i-1).getValue();
                    result = Math.max(table[i-1][j], v_n + table[i-1][j-(amount * items.get(i-1).getWeight())]);
                }
                else result = table[i-1][j];
                table[i][j] = result;
            }
        }

//        printResults(); // commented out for accurate runtime testing

        return table[items.size()][knapsackCapacity];
    }

    private static void printResults() {
        for(int i = 0; i < table.length; i++) {
            for(int j = 0; j < table[0].length; j++) {
                System.out.print(" " + table[i][j]);
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
}
