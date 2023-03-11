package edu.bsu.cs222;
import java.io.IOException;

public class CLI {
    public static void main(String[] args) throws IOException {
        printWelcomeStatement();
        LearnTheDictionary application = new LearnTheDictionary();
        System.out.println(application.getOutputForUser());
    }
    private static void printWelcomeStatement(){
        System.out.println("------------------------"+"\n"+ "Learn The Dictionary"+"\n"+"------------------------");
        System.out.println("If you would like to learn a random word; Enter R"+"\n"+
                "If you would like to search a specific word; Enter the word");
    }

}
