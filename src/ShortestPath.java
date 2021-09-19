public class ShortestPath {

    private static final int n = 5;
    private static int oo = 1000000;
    private static int C[][] = {{0, 2, 3, oo, oo},
                                {2, 0, oo, 5, 2},
                                {3, oo, 0, 1, 4},
                                {oo, 5, 1, 0, 3},
                                {oo, 2, 4, 3, 0}};
    private static int X[] = new int[n];        //luu all ways
    private static int Tot_nhat[] = new int[n];  //luu best way
    private static int CostX[] = new int[n];        //luu chi phi tu X[0]->X[i]
    private static boolean Chua_tham[] = new boolean[n];     //Free[i] = True neu chua tham i
    private static int BestCost = 100000;       //best cost`

    public static void print() {
        System.out.print("Path: ");
        for (int i = 0; i < n; i++) {
            System.out.print((Tot_nhat[i] + 1) + " -> ");
        }
        System.out.println("1");
        System.out.println("Cost: " + BestCost);
    }

    public static void Try(int i) {
        for (int j = 1; j < n; j++) {
            if (Chua_tham[j]) {
                X[i] = j;
                CostX[i] = CostX[i - 1] + C[X[i-1]][j];
                if (CostX[i] < BestCost ) {
                    if (i < n - 1 ) {
                        Chua_tham[j] = false;
                        Try(i + 1);
                        Chua_tham[j] = true;
                    } else {
                        if (CostX[i] + C[X[i]][0] < BestCost ) {
                            for (int k = 0; k < n; k++) {
                                Tot_nhat[k] = X[k];
                            }
                            BestCost = CostX[i] + C[X[i]][0];
                            print();
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < n; i++) {
            Chua_tham[i] = true;
            Tot_nhat[i] = 0;
            X[i] = 0;
            CostX[i] = 0;
        }
        Chua_tham[0] = false;
        Try(1);
    }


}
