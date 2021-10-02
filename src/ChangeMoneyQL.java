import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ChangeMoneyQL {

    private static List<Integer> moneys;
    private static int count = 0;
    private static List<Integer> listBest = new ArrayList<>();
    private static int numberMoneyMin = 100000;
    
    private static void init() {
        moneys = new ArrayList<>();
        moneys.add(10);
        moneys.add(20);
        moneys.add(50);
    }
    
    public static void Try(int amount, int numberMoney, int index, LinkedList<Integer> list) {

        if (amount == 0) {
            count++;
            numberMoney = list.size();
//            System.out.print(list.toString());
//            System.out.println(" Number of money: " + numberMoney);
            if(numberMoneyMin > numberMoney) {
                numberMoneyMin = numberMoney;
                listBest = (LinkedList<Integer>) list.clone();
            }
            return;
        }

        if (amount < 0)
            return;

        for (int i = index; i < moneys.size(); i++) {
            int money = moneys.get(i);
            if (amount >= money) {
                list.add(money);
                Try(amount - money,numberMoney, i, list);
                list.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        int amount = 100;
        init();
        long startTime = System.currentTimeMillis();
        Try(amount,0, 0, new LinkedList<Integer>());
        long endTime = System.currentTimeMillis();
        System.out.println("Time: " + (endTime - startTime));
        System.out.print("List best: " + listBest.toString());
        System.out.println(" Number of money min: " + numberMoneyMin);
    }
}
