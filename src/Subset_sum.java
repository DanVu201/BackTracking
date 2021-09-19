import java.util.Scanner;
import java.util.Stack;

/**
 * SubSet class chua ham khoi tao, ham tinh tong tap con, ham xuat ket qua ra man hinh.
 * @author DaoCuong
 * @version 1.0
 */
class SubSet {
    int[] set;
    int sum;

    Stack<Integer> tapCon;
    boolean kiemTra;

    /**
     * Ham khoi tao
     * @param set khoi tao tap ban dau.
     * @param sum tong can tinh.
     */
    SubSet(int[] set, int sum) {
        this.set = set;
        this.sum = sum;
        this.tapCon = new Stack<>();
        kiemTra = false;
    }


    /**
     * Ham tinh tong cua tap con
     * @param s bien luu gia tri cua tong tinh duoc trong ham.
     * @param index bien chi so the hien vi tri bat dau cua vong for.
     */
    public void tinhTong(int s, int index) {
        // tra ve false neu gia tri của s vuot qua tong.
        if (s > sum)
            return;
        // kiem tra xem tong tap con co bang tong can tim khong, neu co tra ve true va in ra man hinh.
        if (s == sum) {
            kiemTra = true;
            Xuat();
            // quay lai de tim them tap con khac.
            return;
        }

        for (int i = index; i < set.length; i++) {
            // them set[i] vao trong Stack.
            tapCon.push(set[i]);
            // gan gia tri s = s + set[i], bien index tang len 1.
            tinhTong(s + set[i], i + 1);
            // xoa phan tu khoi Stack (chinh la buoc Quay Lui).
            tapCon.pop();
        }
    }

    /**
     * Ham xuat ket qua ra man hinh.
     */
    private void Xuat() {
        // In ra tat ca phan tu cua tapCon.
        for (Integer item : tapCon) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

}

/**
 * Subset_sum class chua ham main.
 */
public class Subset_sum {
    /**
     * Ham main.
     * @param args
     */
    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        System.out.print("Nhap n: ");
        int n = kb.nextInt();

        System.out.println("Nhap tung phan tu cua mang: ");
        int[] set = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("[" + i + "]: ");
            set[i] = kb.nextInt();
        }

        System.out.print("Nhap tong can tim: ");
        int tong = kb.nextInt();

        SubSet ss = new SubSet(set, tong);
        ss.tinhTong(0, 0);

        if (!ss.kiemTra)
            System.out.print("Khong tim thay tong");
    }
}