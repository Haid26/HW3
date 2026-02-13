package utils;

import com.github.javafaker.Faker;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    static Faker faker = new Faker();

    public static String getRandomGender()
    {
        return faker.options().option("Male","Female", "Other");

    }
    public static String[] getRandomHobbie()
    {
       String[] hobbies = {"Sports", "Reading", "Music"};
        return getRandomItemsFromStringArrey(hobbies);
    }
    public static String[] getRandomSubjects()
    {
        String[] subjects = {"English", "Maths", "Arts"};
        return getRandomItemsFromStringArrey(subjects);
    }
    public static String[] getRandomItemsFromStringArrey (String [] stringArray){

        String[] result = new String[4];
        switch (faker.number().numberBetween(0,7)){
            case 7 -> {
                result[0]= stringArray[0];
                result[1]= stringArray[1];
                result[2]= stringArray[2];
                result[3]= stringArray[0]+", "+stringArray[1]+", "+stringArray[2];
            }
            case 6 -> {
                result[0]= "";
                result[1]= stringArray[1];
                result[2]= stringArray[2];
                result[3]= stringArray[1]+", "+stringArray[2];
            }
            case 5 -> {
                result[0]= "";
                result[1]= "";
                result[2]= stringArray[2];
                result[3]= stringArray[2];
            }
            case 4 -> {
                result[0] = "";
                result[1]=stringArray[1];
                result[2]="";
                result[3]= stringArray[1];
            }
            case 3 -> {
                result[0] = stringArray[0];
                result[1]="";
                result[2]=stringArray[2];
                result[3]= stringArray[0]+", "+stringArray[2];
            }
            case 2 -> {
                result[0] = stringArray[0];
                result[1]=stringArray[1];
                result[2]="";
                result[3]= stringArray[0]+", "+stringArray[1];
            }
            case 1 -> {
                result[0] = stringArray[0];
                result[1]="";
                result[2]="";
                result[3]= stringArray[0];
            }
            case 0 -> {
                result[0] = "";
                result[1]="";
                result[2]="";
                result[3]= "";
            }
        }
        return result;
    }
    static public String getRandomState()
    {
        return faker.options().option("NCR","Uttar Pradesh","Haryana","Rajasthan");
    }
    static public String getRandomCity(String state)
    {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> null;
        };
    }
    static public String getRandomDay()
    {
        return  ""+faker.number().numberBetween(10,28);
    }
    static public String getRandomMonth(){
        return faker.options().option("January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December");
    }
    static public int getRandomYear()
    {
        return faker.number().numberBetween(1900,2008);
    }
    static public String getRandomFirstName(){ return faker.name().firstName();    }
    static public String getRandomLastName(){ return faker.name().lastName();    }
    static public String getRandomEmail() { return faker.internet().emailAddress();  }
    static public String getRandomNumber() { return faker.phoneNumber().subscriberNumber(10);  }
    static public String getRandomAdress() { return faker.address().fullAddress();  }
    static public String getRandomImage() { return faker.options().option("cat.jpg", "dog.jpg");  }
}
