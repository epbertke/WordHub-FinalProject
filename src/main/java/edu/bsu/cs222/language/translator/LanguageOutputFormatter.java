package edu.bsu.cs222.language.translator;

import edu.bsu.cs222.OutputFormatter;

public class LanguageOutputFormatter {
    private final String originalWord;
    private final String translation;
    private final String definition;
    public LanguageOutputFormatter(String originalWord, String translation, String definition) {
        this.originalWord = originalWord;
        this.translation = translation;
        this.definition = new OutputFormatter().formatOutputForUser(definition);
        System.out.println(formatOutput());
    }
    public String formatOutput() {
        return "Original : " + originalWord + "\n" + "Translation : " + translation + "\n" + "Definition : " + definition;
    }

}
