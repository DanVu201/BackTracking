import java.util.Scanner;

public class FindWays {

    private static int n = 7;
    private static int s, t;
    private static boolean Daxet[] = new boolean[n];
    private static int Truoc[] = new int[n];
    private static int graph[][] = {{0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 1, 1, 1, 1, 0},
                                    {0, 1, 0, 0, 0, 0, 0},
                                    {0, 1, 0, 0, 1, 0, 1},
                                    {0, 1, 0, 1, 0, 1, 1},
                                    {0, 1, 0, 0, 1, 0, 1},
                                    {0, 0, 0, 1, 1, 1, 0}};

    public static void print() {
        System.out.print((t) + " <-- ");
        int j = t;
        while (Truoc[j] != s) {
            System.out.print((Truoc[j]) + " <-- ");
            j = Truoc[j];
        }
        System.out.println(s);
    }

    public static void Try(int s) {
        Daxet[s] = true;
        for (int i = 0; i < n ; i++) {
            if (graph[s][i] == 1 && !Daxet[i]) {
                Truoc[i] = s;
                if (i == t) {
                    print();
                } else {
                    Try(i);
                }
                Daxet[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Nhap diem xuat phat: ");
        s = keyboard.nextInt() ;
        System.out.print("Nhap diem ket thuc: ");
        t = keyboard.nextInt() ;
        for (int i = 0; i < n; i++) {
            Daxet[i] = false;
        }
        Try(s);
    }
}
