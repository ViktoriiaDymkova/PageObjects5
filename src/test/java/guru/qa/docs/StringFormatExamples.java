package guru.qa.docs;

import static java.lang.String.format;

public class StringFormatExamples {
    public static void main(String[] args) {
        String name = "userName",
                subject = "you";


        System.out.println("Hello," + name +" How are " + subject +"?");
        System.out.println(format("Hello, %s! How are %s", "userName", "you"));

    }
}
