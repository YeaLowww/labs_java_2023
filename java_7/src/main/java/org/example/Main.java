package org.example;

import java.util.stream.IntStream;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int n = 100;
        int res = findNumberWithMaxZeros(n);
        System.out.println("Перше просте число з макс. к-сть нулів: " + res);
    }

    public static int findNumberWithMaxZeros(int n) {
        return IntStream.rangeClosed(2, n)
                .filter(Main::IsSimple)
                .boxed()
                .max((a,b) -> Integer.toBinaryString(a)
                        .replaceAll("1", "").length() -
                        Integer.toBinaryString(b).replaceAll("1","").length())
                .orElse(2);
    }
    public static boolean isPrime(int num) {
        return IntStream.rangeClosed(2, (int) Math.sqrt(num)).noneMatch(i -> num % i == 0);
                //Нехай n - число, і ми хочемо перевірити, чи воно просте.
                // Якщо воно не просте, то існує таке число m, де 1 < m <= n,
                // яке ділить n націло. Якщо m більше за корінь квадратний з n,
                // то обов'язково існує інше число k, таке, що 1 < k <= n і m * k = n.
                // Однак m * k буде більше за sqrt(n) * sqrt(n), тобто більше, ніж саме число n.
                // Отже, якщо ми перевіряємо лише числа до кореня квадратного з n,
                // ми вже виявимо всі можливі делітори, якщо такі існують.
    }
    public static boolean IsSimple(int ANum) {
        if (ANum < 2)
            return false;
        double s = Math.sqrt(ANum);
        for (int i = 2; i <= s; i++) {
            if (ANum % i == 0)
                return false;
        }
        return true;
    }
}