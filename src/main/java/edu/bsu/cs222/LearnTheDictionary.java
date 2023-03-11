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
    private String[] fetchSearchedWordDefinition() throws IOException {
        APIConnection wordConnection = new APIConnection(userInput);
        DefinitionParser definitionFetcher = new DefinitionParser(wordConnection.getDefinitionsInputStream());
        //searchedWordArray will need to be expanded to length of 3 to implement SynonymParser class as well
        //with the third element being the synonym output for userInput
        String[] searchedWordArray = new String[2];
        searchedWordArray[0] = userInput;
        searchedWordArray[1] = definitionFetcher.fetchDefinition();
        return searchedWordArray;
    }

    private String fetchOutputForUser() throws IOException {
        String[] arrayForOutput;
        if(Objects.equals(userInput, "r")){
            RandomWord randomWord = new RandomWord();
            arrayForOutput = randomWord.getRandomWordAndDefinition();
        }else{
            arrayForOutput = fetchSearchedWordDefinition();
        }
        return formOutput(arrayForOutput);
    }
    private String formOutput(String[] arrayForOutput){
        //this will need updated to include SynonymParser output as well
        return "Your word : "+arrayForOutput[0]+"\n"+"Your definition : "+arrayForOutput[1];
    }
}
