import java.util.*;

public class SinhToHopQL {
    private static int a[] = new int[100];
    private static int n, k;

    static void output(int[] a, int k) {
        for (int i = 1; i <= k; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    static void next(int i) {
        for (int j = a[i-1] + 1; j <= n - k + i; j++) {
            a[i] = j;
            if (i == k)
                output(a, k);
            else
                next(i + 1);
        }
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Nhap n: ");
        n = keyboard.nextInt();
        System.out.print("Nhap k: ");
        k = keyboard.nextInt();
        next(1);


    }
}
