import java.util.*;

public class NQueen {

    private static int N = 8;

    public static void printSolution(int b[][]) {
        System.out.println("Solution");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean checkIsSafed(int b[][], int row, int col) {
        //cot tren
        for (int i = 0; i < row; i++) {
            if (b[i][col] == 1) {
                return false;
            }
        }

        //trai tren
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (b[i][j] == 1) {
                return false;
            }
        }

        //phai tren
        for (int i = row, j = col; i >= 0 && j < N; i--, j++) {
            if (b[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    public static void setQueen(int b[][], int row) {
        if (row >= N) {
            printSolution(b);
        }
        for (int i = 0; i < N; i++) {
            if (checkIsSafed(b, row, i)) {
                b[row][i] = 1;      //dat hau
                setQueen(b, row + 1);
                b[row][i] = 0;      //lui lai
            }
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int rd = random.nextInt(N);
        System.out.println(rd);
        int b[][] = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                b[i][j] = 0;
            }
        }
        b[0][rd] = 1;
        setQueen(b, 1);
    }
}
