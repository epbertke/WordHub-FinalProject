package edu.bsu.cs222;
import java.io.IOException;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;
public class LearnTheDictionary {
    private final String userInput;
    public LearnTheDictionary(String word){
        this.userInput = word;
    }
    public LearnTheDictionary(){
        this.userInput = getUserInput();
    }
    public String getOutputForUser() throws IOException {
        return fetchOutputForUser();
    }
    private String getUserInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.next().toLowerCase(Locale.ROOT);
    }
    private String[] fetchSearchedWordInformation() throws IOException {
        APIConnection wordConnection = new APIConnection(userInput);
        DefinitionParser definitionFetcher = new DefinitionParser(wordConnection.getDefinitionsInputStream());
        SynonymParser synonymFetcher = new SynonymParser(wordConnection.getSynonymsInputStream());
        String[] searchedWordArray = new String[3];
        searchedWordArray[0] = userInput;
        searchedWordArray[1] = definitionFetcher.fetchDefinition();
        searchedWordArray[2] = synonymFetcher.fetchSynonyms();
        return searchedWordArray;
    }

    private String fetchOutputForUser() throws IOException {
        String[] arrayForOutput;
        if(Objects.equals(userInput, "r")){
            RandomWord randomWord = new RandomWord();
            arrayForOutput = randomWord.getRandomWordInformation();
        }else{
            arrayForOutput = fetchSearchedWordInformation();
        }
        return formOutput(arrayForOutput);
    }
    private String formOutput(String[] arrayForOutput){
        return "Your word : "+arrayForOutput[0]+"\n"+"Your definition : "+arrayForOutput[1]+"\n"+"Synonyms : "+arrayForOutput[2];
    }
}
