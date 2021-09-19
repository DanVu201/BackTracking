import java.util.Scanner;

public class SinhChinhHopQL {
    private static int n;
    private static int k;
    private static int a[] = new int[100];
    private static int c[] = new int[100];
    static int count = 0;

    static void chinhHop(int i) {
        for (int j = 1; j <= n; j++) {
            if (c[j] == 0) {
                a[i] = j;
                if (i == k) {
                    count++;
                    output(a, k);
                } else {
                    c[j] = 1;
                    chinhHop(i + 1);
                    c[j] = 0;
                }
            }
        }
    }

    static void output(int a[], int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Nhap n: ");
        n = keyboard.nextInt();
        System.out.print("Nhap k: ");
        k = keyboard.nextInt();
        chinhHop(1);
        System.out.println("So chinh hop = " + count);
    }


}
