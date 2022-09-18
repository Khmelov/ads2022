package by.it.group151004.haiko.lesson01;

import java.math.BigInteger;

/*
 * Вам необходимо выполнить способ вычисления чисел Фибоначчи с вспомогательным массивом
 * без ограничений на размер результата (BigInteger)
 */

public class FiboB {

    private long startTime = System.currentTimeMillis();

    private long time() {
        return System.currentTimeMillis() - startTime;
    }

    public static void main(String[] args) {

        //вычисление чисел простым быстрым методом
        FiboB fibo = new FiboB();
        int n = 55555;
        System.out.printf("fastB(%d)=%d \n\t time=%d \n\n", n, fibo.fastB(n), fibo.time());
    }

    BigInteger fastB(Integer n) {
        BigInteger First = BigInteger.ONE;
        BigInteger Second = BigInteger.ONE;
        BigInteger Res = BigInteger.ZERO;
        for (int i=2; i<n; i++){
            Res = First.add(Second);
            First = Second;
            Second = Res;
        }
        // 1 1 2 3 5 8
        //здесь нужно реализовать вариант с временем O(n) и памятью O(n)
        return Res;
    }

}

