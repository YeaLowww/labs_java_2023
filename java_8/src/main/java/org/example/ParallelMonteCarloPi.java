package org.example;

import java.util.Random;
import java.util.Scanner;

class ParallelMonteCarloPi extends Thread {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the num of threads: ");
        int numThreads = scanner.nextInt();

        int iterationsPerThread = 1000000000 / numThreads;
        long startTime = System.currentTimeMillis();

        MonteCarloPiThread[] threads = new MonteCarloPiThread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            threads[i]= new MonteCarloPiThread(iterationsPerThread);
            threads[i].start();
        }
        try {
            for (int i = 0; i < numThreads; i++) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int totalPointsInCircle =0;
        for (int i = 0; i < numThreads; i++) {
            totalPointsInCircle +=threads[i].getPointsInCircle();
        }
        double piApproximation = 4.0 * totalPointsInCircle / (iterationsPerThread * numThreads);

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        System.out.println("PI is " + piApproximation);
        System.out.println("THREADS " + numThreads);
        System.out.println("ITERATIONS " + (iterationsPerThread * numThreads));
        System.out.println("TIME " + elapsedTime + "ms");

        scanner.close();
    }
}
