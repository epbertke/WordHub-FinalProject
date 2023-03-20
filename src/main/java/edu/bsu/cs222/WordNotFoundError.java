package edu.bsu.cs222;
public class WordNotFoundError {
    protected static Error throwWordNotFoundError(){
        throw new Error("This word was not found in the dictionary. Re-run program and try again with a new word or different spelling.");
    }
}
