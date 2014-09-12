import java.util.*;

public class projecteuler78 {
    static int[] a = {1};
    static int[] b = {1};
    static int[] c = {1, 2};
    static int[] d = {1, 2, 3};
    static int[] e = {1, 3, 4, 5};
    static int[] f = {1, 3, 5, 6, 7};

    static ArrayList<int[]> combs = new ArrayList<int[]>();
    static int mil = 1000000;

    public static void main(String[] args) {
        combs.add(a);
        combs.add(b);
        combs.add(c);
        combs.add(d);
        combs.add(e);
        combs.add(f);

        for (int i = 6; i < 60000; i++) {
            System.out.println(i);
            findPoss(i);
        }
    }


    public static void findPoss(int n) {
        int[] numarr = new int[n];
        numarr[0] = 1;
        int nextnum = 1;
        for (int i = n - 2; i > 1; i--) {
            if (i > (n - i)) {
                nextnum = (nextnum + (combs.get(i))[n-i-1]) % mil;
                numarr[n-i-1] = nextnum;
            }
            else {
                nextnum = (nextnum + (combs.get(i))[i-1]) % mil;
                numarr[n-i-1] = nextnum;
            }
        }
        nextnum++;
        numarr[n-2] = nextnum;
        nextnum = (nextnum + 1) % mil;
        numarr[n-1] = nextnum;
        combs.add(numarr);

        if (nextnum == 0) {
            System.out.println("Found it at " + n);
        }
    }
}
