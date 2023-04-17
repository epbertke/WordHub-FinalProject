package edu.bsu.cs222.english.dictionary;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Dictionary {
    private static final ArrayList<String> allWordsInDictionary = new ArrayList<>();
    public static ArrayList<String> getWordsInDictionary() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("src/main/resources/dictionary_words"));
        while (scanner.hasNext()) {
            allWordsInDictionary.add(formatDictionaryWord(scanner.next()));
        }
        return allWordsInDictionary;
    }
    private static String formatDictionaryWord(String word){
        StringBuilder dictionaryEntry = new StringBuilder();
        for(int i=0; i<=word.length()-1; i++){
            if(!(word.charAt(i)==',') && !(word.charAt(i)==' ') && !(word.charAt(i)==']' && !(word.charAt(i)=='['))){
                dictionaryEntry.append(word.charAt(i));
            }
        }return dictionaryEntry.toString();
    }
}