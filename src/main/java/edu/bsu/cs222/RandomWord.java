package edu.bsu.cs222;
import java.io.IOException;
import java.util.ArrayList;

public class RandomWord {
    private final String randomWord;
    private final String randomWordDefinition;
    public RandomWord() throws IOException {
        this.randomWord = fetchRandomWord();
        this.randomWordDefinition = fetchRandomWordDefinition();
    }
    public String getRandomWord(){
        return randomWord;
    }
    public String getRandomWordDefinition(){
        return randomWordDefinition;
    }
    public String[] getRandomWordAndDefinition(){
        String[] randomWordAndDefinition = new String[2];
        randomWordAndDefinition[0] = this.randomWord;
        randomWordAndDefinition[1] = this.randomWordDefinition;
        return randomWordAndDefinition;
    }
    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    private String fetchRandomWord() throws IOException {
        ArrayList<String> wordsArray = new Dictionary().getWordsInDictionary();
        int randomWordIndex = getRandomNumber(0, wordsArray.size());
        return wordsArray.get(randomWordIndex);
    }
    private String fetchRandomWordDefinition() throws IOException {
        APIConnection randomWordConnection = new APIConnection(this.randomWord);
        DefinitionParser randomWordDefinitionFetcher = new DefinitionParser(randomWordConnection.getDefinitionsInputStream());
        return randomWordDefinitionFetcher.fetchDefinition();
    }


}
