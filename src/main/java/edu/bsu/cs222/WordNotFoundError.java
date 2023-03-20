package edu.bsu.cs222;

import java.io.IOException;

public class WordNotFoundError {
    protected static Error throwWordNotFoundError(){
        throw new Error("This word was not found in the dictionary. Re-run program and try again with a new word or different spelling.");
    }
    public static String checkForWordNotFoundError(String wordSearch) throws IOException{
        String definition;
        try{
            definition = new DefinitionParser(new APIConnection(wordSearch).getDefinitionsInputStream()).parseForDefinition();

        }catch(Error e){
            return e.getMessage();
        }return definition;
    }
}
