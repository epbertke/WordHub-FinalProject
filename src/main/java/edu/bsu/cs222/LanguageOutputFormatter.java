package edu.bsu.cs222;

public class LanguageOutputFormatter {
    private final String originalWord;
    private final String translation;
    private final String definition;
    public LanguageOutputFormatter(String originalWord, String translation, String definition) {
        this.originalWord = originalWord;
        this.translation = translation;
        this.definition = new OutputFormatter().formatOutputForUser(definition);
    }
    public void formatOutput() {
        System.out.println("\n" + "Original : " + originalWord + "\n" + "Translation : " + translation + "\n" + "Definition : " + definition);
    }
}
