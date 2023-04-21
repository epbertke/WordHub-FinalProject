package edu.bsu.cs222;
import edu.bsu.cs222.main.CLI.OutputFormatter;
import edu.bsu.cs222.english.dictionary.DefinitionParser;
import edu.bsu.cs222.english.dictionary.SynonymParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
public class ParserTests {
    @Test
    public void outputFormatterFormatsDefinitionTest() throws IOException {
        Assertions.assertEquals("a state of well-being and contentment : joy, a pleasurable or satisfying experience, felicity,  aptness", new OutputFormatter().formatOutputForUser(new DefinitionParser("happiness").parseForDefinition()));
    }
    @Test
    public void outputFormatterFormatsSynonymTest() throws IOException{
        Assertions.assertEquals("fluky, fortuitous, fortunate, heaven-sent, lucky, providential, blissful, chuffed, delighted, glad, gratified, joyful, joyous, pleased, satisfied, thankful, tickled, content, contented, gratified, pleased, satisfied, fortunate, lucky, applicable, appropriate, apt, becoming, befitting, felicitous, fit, fitted, fitting, good, meet, pretty, proper, right, suitable, hung up, obsessed, queer", new OutputFormatter().formatOutputForUser(new SynonymParser("happy").parseForSynonyms()));
    }
}
