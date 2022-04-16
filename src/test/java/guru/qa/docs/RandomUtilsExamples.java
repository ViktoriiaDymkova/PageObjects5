package guru.qa.docs;

import static guru.qa.utils.RandomUtils.*;

public class RandomUtilsExamples {
    public static void main(String[] args) {
        System.out.println("Rand str of 10 letters: "+ getRandomString(10));
        System.out.println("Rand int between 1234 and 999999: "+ getRandomInt(1234,9999));
        System.out.println("Rand email: "+ getRandomEmail());


    }
}
