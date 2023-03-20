package edu.bsu.cs222;
import java.io.IOException;
public class WordSearch {
    private final String searchedWord;
    public WordSearch(String userInput) {
        this.searchedWord = userInput;
    }
    public String[] getSearchedWordInformation() throws IOException {
        String[] searchedWordArray = new String[3];
        APIConnection wordConnection = new APIConnection(searchedWord);
        searchedWordArray[0] = searchedWord;
        searchedWordArray[1] = new DefinitionParser(wordConnection.getDefinitionsInputStream()).parseForDefinition();
        searchedWordArray[2] = new SynonymParser(wordConnection.getSynonymsInputStream()).parseForSynonyms();
        if(!WordNotFoundError.checkForUserInput(searchedWord)){
            WordNotFoundError.throwSearchNotProvidedError();
        }
        return searchedWordArray;
    }
}
