import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LapLichQL {
    private static List<Activity> activity = new ArrayList<>();
    private static int[] actResult;
    private static boolean[] Daxet;
    private static int[] hoatdong_hientai;
    private static int max;

    public static void main(String[] args) {

        activity.add(new Activity(1, 3));
        activity.add(new Activity(2, 5));
        activity.add(new Activity(4, 7));
        activity.add(new Activity(3, 8));
        activity.add(new Activity(5, 9));
        activity.add(new Activity(8, 10));
        activity.add(new Activity(9, 11));
        activity.add(new Activity(11, 14));
        activity.add(new Activity(13, 16));

        Daxet = new boolean[activity.size()];
        actResult = new int[activity.size()];
        hoatdong_hientai = new int[activity.size()];

        Arrays.fill(Daxet, false);
        max = 0;
        long startTime = System.currentTimeMillis();
        lapLich(0);
        long endTime = System.currentTimeMillis();
        System.out.println("Time : " + (endTime - startTime));
    }

    public static void lapLich(int count) {
        for (int j = 0; j < activity.size(); j++) {
            if (count == 0) {
                Daxet[j] = true;
                hoatdong_hientai[count] = j;
                lapLich(count + 1);
                Daxet[j] = false;
            } else {
                if (activity.get(j).getStart() >= activity.get(hoatdong_hientai[count - 1]).getFinish() && !Daxet[j]) {
                    hoatdong_hientai[count] = j;
                    if (count >= max) {
                        max = count;
                        Inlich();
                        System.arraycopy(hoatdong_hientai, 0, actResult, 0, count + 1);
                    }
                    Daxet[count] = true;
                    lapLich(count + 1);
                    Daxet[count] = false;
                }
            }
        }
    }

    public static void Inlich() {
        for (int count = 0; count <= max; count++) {
            System.out.print(activity.get(actResult[count]).toString());
        }
        System.out.println("\nSo hoat dong toi da: " + (max + 1));
    }

    static class Activity {
        int start, finish;

        public Activity(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }

        public int getStart() {
            return start;
        }

        public int getFinish() {
            return finish;
        }

        @Override
        public String toString() {
            return "{" + start + ", " + finish + "}";
        }
    }
}