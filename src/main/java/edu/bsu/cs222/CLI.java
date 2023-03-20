package edu.bsu.cs222;
import java.io.IOException;
public class CLI {
    public static void main(String[] args) throws IOException {
        printWelcomeStatement();
        System.out.println(LearnTheDictionary.fetchOutputForUser());
        printExitStatement();
    }
    private static void printWelcomeStatement() {
        System.out.println("-".repeat(24)+"\n"+ "Learn The Dictionary"+"\n"+"-".repeat(24));
        System.out.println("If you would like to learn a random word; Enter R"+"\n"+
                "If you would like to search a specific word; Enter the word");
    }
    private static void printExitStatement() {
        System.out.println("\n" + "-".repeat(40) + "\n" + "Re-run program to learn another word" + "\n" + "-".repeat(40) + "\n");
    }
}
