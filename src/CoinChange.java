import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Print all the Combinations of Change for a given Amount
 */
class CoinChange {

    private static List<Integer> coins;
    private static int count = 0;
    private static List<Integer> listBest = new ArrayList<>();
    private static int numberCoinMin = 100000;

    /**
     * Initialising the Coing Denominations
     */
    private static void init() {
        coins = new ArrayList<>();
        coins.add(2);
        coins.add(20);
        coins.add(50);
    }

    /**
     * Prints all comninations of the coin change
     */
    public static void Try(int amount, int numberCoin, int index, LinkedList<Integer> list) {

        if (amount == 0) {
            count++;
            numberCoin = list.size();
//            System.out.print(list.toString());
//            System.out.println(" Number of coin: " + numberCoin);
            if(numberCoinMin > numberCoin) {
                numberCoinMin = numberCoin;
                listBest = (LinkedList<Integer>) list.clone();
            }
            return;
        }

        if (amount < 0)
            return;

        for (int i = index; i < coins.size(); i++) {
            int coin = coins.get(i);
            if (amount >= coin) {
                list.add(coin);
                Try(amount - coin,numberCoin, i, list);
                list.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        int amount = 60;
        init();
        long startTime = System.currentTimeMillis();
        Try(amount,0, 0, new LinkedList<Integer>());
        long endTime = System.currentTimeMillis();
        System.out.println("Time: " + (endTime - startTime));
        System.out.print("List best: " + listBest.toString());
        System.out.println(" Number of coin min: " + numberCoinMin);
    }
}
