
public class SinhDayNhiPhan {

    public static void PrintCH(String[] CH) {
        for (int j = 0; j < CH.length; j++) {
            System.out.print(CH[j]);
        }

    }

    public static void Try(int i, String[] CH) {
        for (int j = 0; j <= 1; j++) {
            CH[i - 1] = "" + j + "";
            System.out.print("Cau hinh hien thoi:");
            PrintCH(CH);
            System.out.println();
            if (i == CH.length) {
                System.out.println("(Tim thay nghiem)");
            } else {
                Try(i + 1, CH);
            }
            CH[i - 1] = "-";
        }
    }


    public static void main(String[] args) {
        int n = 4;
        String[] CH = new String[n];
        for (int j = 0; j < CH.length; j++) {
            CH[j] = "-";
        }
        System.out.print("Cau hinh hien thoi:");
        PrintCH(CH);
        System.out.println();
        Try(1, CH);

    }
}