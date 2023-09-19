
public class Main{
    public static void main(String[] args) {
        short value = 1107;
        int C2 = value%2;
        System.out.println(C2);
        int C3 = value%3;
        System.out.println(C3);
        int C5 = value%5;
        System.out.println(C5);
        int C7 = value%7;
        System.out.println(C7);

        int  C = C3;


        short a = 1;
        short b = 1;
        short m = 2;
        short n = 2;

        short s = 0;
            if (n < a || m < b || a < 0 || b < 0 || n < 0 || m < 0){
                System.out.println("Wrong nums");
            } else {
            for (short i = (short) a; i <= (short)n; i++) {
                int num1 = i - C;
                short num = (short)num1;

                for (short j = (short)b; j <= m; j++) {
                    s += (short) ((i % j) / num);
                }
            }
            System.out.println("S = " + s);
    }}
}
