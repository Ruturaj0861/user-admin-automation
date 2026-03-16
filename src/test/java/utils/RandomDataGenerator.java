package utils;

import java.util.Random;

public class RandomDataGenerator {

    public static String generateEmail(){

        int num = new Random().nextInt(10000);

        return "automation_testing"+num+"@gmail.com";

    }

    public static String generateName(){

        int num = new Random().nextInt(10000);

        return "User"+num;

    }

}