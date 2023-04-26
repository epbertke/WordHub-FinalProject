package edu.bsu.cs222.language.translator;
import edu.bsu.cs222.main.CLI.OutputFormatter;
public class LanguageOutputFormatter {
    private final String originalWord;
    private final String translation;
    private final String definition;
    public LanguageOutputFormatter(String originalWord, String translation, String definition) {
        this.originalWord = originalWord;
        this.translation = translation;
        this.definition = new OutputFormatter().formatOutputForUser(definition);
    }
    public String formatOutput() {
        return "Original : " + originalWord + "\n" + "\n" + "Translation : " + translation + "\n" + "\n" + "Definition : " + definition;
    }
}
