package org.example;
import java.util.Random;
public class MonteCarloPiThread extends Thread {
    private int iterations;
    private int pointsInCircle;

    public MonteCarloPiThread(int iterations){
        this.iterations=iterations;
    }
    @Override
    public void run(){
        Random random = new Random();
        for (int i = 0; i < iterations; i++) {
            double x = random.nextDouble();
            double y =random.nextDouble();
            double distance = Math.sqrt(x*x+y*y);

            if (distance <= 1.0) {
                pointsInCircle++;
            }
        }
    }

    public int getPointsInCircle() {
        return pointsInCircle;
    }
}
