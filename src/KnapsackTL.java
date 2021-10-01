import java.util.Arrays;
import java.util.Comparator;

public class KnapsackTL {

    static class Item {
        double W, V, I;
        Double r; // Double class khong phai double.

        public Item(int weight, int value, int index) {
            this.W = weight;
            this.V = value;
            this.I = index;
            r = (double) value / (double) weight;
        }
    }

    public static void main(String[] args) {
        int[] weights = {12, 4, 3, 2, 1};
        int[] values = {4, 10, 2, 2, 1};
        int max = 15;
        double Max_Values = Knapsack(max, values, weights);
        System.out.println("Tong so gia tri co the chua: " + Max_Values);
    }

    public static double Knapsack(int max, int[] V, int[] W) {

        Item[] items = new Item[V.length];

        for (int i = 0; i < V.length; i++) {
            items[i] = new Item(W[i], V[i], i);
        }

        Arrays.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o2.r.compareTo(o1.r);
            }
        });
        double tong_kl = max;
        double tong_gt = 0;
        int i = 0;
        System.out.println("weight|value|ratio");
        while (tong_kl > 0 && i < V.length) {
            while (items[i].W <= tong_kl) {
                tong_kl -= items[i].W;
                tong_gt += items[i].V;
                System.out.println("(" + items[i].W + "," + items[i].V + "," + items[i].r + ")");
            }
            i++;
        }
        return tong_gt;
    }
}