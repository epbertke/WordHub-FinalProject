package edu.bsu.cs222;
import java.io.IOException;
public class CLI {
    public static void main(String[] args) throws IOException, InterruptedException {
        printWelcomeStatement();
        System.out.println(LearnTheDictionary.fetchOutputForUser());
        printExitStatement();
    }
    private static void printWelcomeStatement() {
        System.out.println("-".repeat(24)+"\n"+ "Learn The Dictionary"+"\n"+"-".repeat(24));
        System.out.println("""
                If you would like to learn a random word; Enter R
                If you would like to search a specific word; Enter the word
                If you would like to use our translator; Enter T""");
    }
    private static void printExitStatement() {
        System.out.println("\n" + "-".repeat(40) + "\n" + "Re-run program to learn another word" + "\n" + "-".repeat(40) + "\n");
    }
}
