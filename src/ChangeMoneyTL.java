import java.util.ArrayList;
import java.util.List;

public class ChangeMoneyTL {
    static int[] moneys = {2, 20, 50};
    static int n = moneys.length;

    static void Try(int money) {
        List<Integer> ans = new ArrayList<>();

        for (int i = n - 1; i >= 0; i--) {
            while (money >= moneys[i]) {
                money -= moneys[i];
                ans.add(moneys[i]);
            }
        }

        for (Integer an : ans) {
            System.out.print(" " + an);
        }
    }

    public static void main(String[] args) {
        int money = 60;
        System.out.print(money + " = ");
        long startTime = System.currentTimeMillis();
        Try(money);
        long endTime = System.currentTimeMillis();
        System.out.println("\nTime: " + (endTime - startTime));
    }
}
