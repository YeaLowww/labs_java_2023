
public class Main {
    public static void main(String[] args) {
        short value = 1107;
        int C2 = value % 2;
        System.out.println(C2);
        int C3 = value % 3;
        System.out.println(C3);
        int C5 = value % 5;
        System.out.println(C5);
        int C7 = value % 7;
        System.out.println(C7);

        int C = C3;


        short a = 1;
        short b = -100;
        short m = -10;
        short n = 3;

        short s = 0;
        if (n < a || m < b) {
            System.out.println("Wrong nums");
        } else {
            for (short i = a; i <= n; i++) {
                if (i == 0) {
                    System.out.println("i cant be 0");
                    return;
                } else {
                    int num1 = i - C;
                    short num = (short) num1;

                    for (short j = b; j <= m; j++) {
                        if (j == 0) {
                            System.out.println("j cant be 0");
                            return;
                        } else {
                            s += (short) ((i % j) / num);
                        }
                    }
                }
            }
            System.out.println("S = " + s);
        }
    }
}
