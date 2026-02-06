package utils;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static void main ()
    {
        System.out.println(getRandomString(8));
        System.out.println(getRandomEmail(8,5,3));
        System.out.println(getRandomInt(333,888));

    }
    public static String getRandomString (int len) {
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        SecureRandom rnd = new SecureRandom();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < len; i++) {
            result.append(AB.charAt(rnd.nextInt(AB.length())));
        }

        return result.toString();
    }

    public static String getRandomEmail (int lenName, int lenHost, int lenDomain)
    {
        return getRandomString(lenName)+"@"+getRandomString(lenHost)+"."+getRandomString(lenDomain);
    }

    public static int getRandomInt (int min, int max)
    {
        return ThreadLocalRandom.current().nextInt(min,max+1);
    }

    public static String getRandomIntAsString (int min, int max)
    {
        return getRandomInt(min,max)+"";
    }

    public static String getRandomGender()
    {
        String[] genders = {"Male","Female", "Other"};

       String randomGender = getRandomItemFromStringArrey(genders);

        return randomGender;
    }

    public static String getRandomItemFromStringArrey (String [] stringArray){

        int randomInt = getRandomInt(0,stringArray.length-1);

        return stringArray[randomInt];
    }
}
