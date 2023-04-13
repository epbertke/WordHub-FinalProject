package edu.bsu.cs222;
import java.io.IOException;
public class CLI {
    public static void main(String[] args) throws IOException, InterruptedException {
        LearnTheDictionary.start();
        printExitStatement();
    }
    private static void printExitStatement() {
        System.out.println("\n" + "-".repeat(40) + "\n" + "Re-run program to learn another word" + "\n" + "-".repeat(40) + "\n");
    }
}
