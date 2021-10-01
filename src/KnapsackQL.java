import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
class Khoi {
    double weight;
    double cost;

    public Khoi(double w, double c) {
        this.weight = w;
        this.cost = c;
    }

    public double getWeight() {
        return weight;
    }

    public double getCost() {
        return cost;
    }
}
public class KnapsackQL {
    private static List<Khoi> Bag;
    private static int max = 20;
    private static double costMax = 0;
    private static LinkedList<Double> listMax = new LinkedList<>();

    private static void init() {
        Bag = new ArrayList<>();
        Bag.add(new Khoi(12, 4));
        Bag.add(new Khoi(4, 10));
        Bag.add(new Khoi(3, 2));
        Bag.add(new Khoi(2, 2));
        Bag.add(new Khoi(1, 1));
    }

    public static void Try(double weightBag, double costBag, int index, LinkedList<Double> list) {
        if(weightBag == 0) {
//            System.out.print(list.toString());
//            System.out.println(" Cost Bag: " + costBag);
            if(costBag > costMax) {
                costMax = costBag;
                listMax = (LinkedList<Double>) list.clone();
            }
            return ;
        }

        if(weightBag < 0)
            return ;

        for(int i=index ; i < Bag.size();i++) {
            double weight = Bag.get(i).getWeight();
            if(weightBag >= weight) {
                list.add(Bag.get(i).getWeight());
                costBag += Bag.get(i).getCost();
                Try(weightBag - weight ,costBag, i,list );
                costBag -= Bag.get(i).getCost();
                list.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        int weightBag = 20;
        init();
        long startTime = System.currentTimeMillis();
        Try(weightBag,0,0,new LinkedList<Double>());
        long endTime = System.currentTimeMillis();
        System.out.println("Time : " + (endTime - startTime));
        System.out.print(listMax.toString());
        System.out.println(" Cost Max: " + costMax);


    }
}
