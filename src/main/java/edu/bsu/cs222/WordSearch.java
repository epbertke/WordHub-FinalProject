package edu.bsu.cs222;
import java.io.IOException;
public class WordSearch {
    private final String searchedWord;
    public WordSearch(String userInput) {
        this.searchedWord = userInput;
    }
    public String[] getSearchedWordInformation() throws IOException {
        String[] searchedWordArray = new String[3];
        searchedWordArray[0] = searchedWord;
        searchedWordArray[1] = new DefinitionParser(searchedWord).parseForDefinition();
        searchedWordArray[2] = new SynonymParser(searchedWord).parseForSynonyms();
        return searchedWordArray;
    }
}
