package edu.bsu.cs222;
import java.io.IOException;
public class CLI {
    public static void main(String[] args) throws IOException {
        LearnTheDictionary.startForClI();
        CLIMenu.printExitStatement();
    }
}
