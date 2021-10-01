import java.util.ArrayList;
import java.util.List;

class ChangeMoney {
    static int[] deno = {2, 20, 50};
    static int n = deno.length;

    static void findMin(int V) {
        List<Integer> ans = new ArrayList<>();

        for (int i = n - 1; i >= 0; i--) {
            while (V >= deno[i]) {
                V -= deno[i];
                ans.add(deno[i]);
            }
        }

        for (Integer an : ans) {
            System.out.print(" " + an);
        }
    }

    public static void main(String[] args) {
        int n = 60;
        System.out.print("Following is minimal number of change for " + n + ": ");
        long startTime = System.currentTimeMillis();
        findMin(n);
        long endTime = System.currentTimeMillis();
        System.out.println("\nTime: " + (endTime - startTime));
    }
}
