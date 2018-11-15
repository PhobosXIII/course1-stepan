package e.user.weatherapplication;

import java.util.Random;

public class DataGenerator {

    private static final int minTemp = -50;
    private static final int maxTemp = 50;

    private Random random = new Random();

    int getTemperature(){
        return minTemp + random.nextInt(maxTemp - minTemp + 1);
    }
}
