package edu.bsu.cs222;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
public class RandomWord {
    private final ArrayList<String> dictionaryWords;
    private String[] randomWordInformation;
    public RandomWord() throws IOException {
        dictionaryWords = Dictionary.getWordsInDictionary();
        randomWordInformation = getRandomWordInformation();
    }
    public String[] getRandomWordInformation() throws IOException {
        String randomWord = generateRandomWord();
        randomWordInformation = new String[3];
        try{
            ErrorHandler.checkForWordNotFoundError(randomWord);
            randomWordInformation[0] = randomWord;
            randomWordInformation[1] = new DefinitionParser(randomWord).parseForDefinition();
            randomWordInformation[2] = new SynonymParser(randomWord).parseForSynonyms();
        }catch (Error e){
            getRandomWordInformation();
        }
        return randomWordInformation;
    }
    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    public String generateRandomWord() {
        return dictionaryWords.get(getRandomNumber(0, dictionaryWords.size()));
    }
}
