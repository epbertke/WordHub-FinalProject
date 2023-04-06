package edu.bsu.cs222;

import java.io.IOException;

public class TranslationProcessor {
    private final String wordTranslatedToEnglish;
    public TranslationProcessor(String wordTranslatedToEnglish) {
        this.wordTranslatedToEnglish = wordTranslatedToEnglish;
    }
    public String fetchDefinitionForTranslatedWord() throws IOException {
        String definition =  new DefinitionParser(new APIConnection(wordTranslatedToEnglish).getDefinitionsInputStream()).parseForDefinition();
        return new OutputFormatter().formatOutputForUser(definition);
    }
}
