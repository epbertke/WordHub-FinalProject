package edu.bsu.cs222;
import java.io.IOException;
import java.util.ArrayList;
public class RandomWord {
    private String randomWord;
    public RandomWord() throws IOException {
        randomWord = generateRandomWord();
    }
    public String[] getRandomWordInformation() throws IOException {
        String[] randomWordInformation = new String[3];
        try{
            randomWordInformation[0] = randomWord;
            String definition = new DefinitionParser(new APIConnection(randomWord).getDefinitionsInputStream()).parseForDefinition();
            if(definition==null||definition.isEmpty()||definition.isBlank()|| definition.equals("[]")){
                WordNotFoundError.throwWordNotFoundError();
            }else {
                randomWordInformation[1] = definition;
            }
            randomWordInformation[2] = new SynonymParser(new APIConnection(randomWord).getSynonymsInputStream()).parseForSynonyms();
        }catch (Error e){
            randomWord = generateRandomWord();
            getRandomWordInformation();
        }
        return randomWordInformation;
    }
    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    private String generateRandomWord() throws IOException {
        ArrayList<String> randomWords = new Dictionary().getWordsInDictionary();
        return randomWords.get(getRandomNumber(0, randomWords.size()));
    }
}
