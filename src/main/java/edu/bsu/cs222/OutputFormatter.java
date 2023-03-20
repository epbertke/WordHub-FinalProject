package edu.bsu.cs222;
import java.util.Objects;
public class OutputFormatter {
    private final String[] outputArray;
    public OutputFormatter(String[] output) { this.outputArray = output; }
    protected String formOutput() {
        return "Your word : "+outputArray[0]+"\n"+"Your definition : "+outputArray[1]+"\n"+"Synonyms : "+getSynonymsOutput();
    }
    private String getSynonymsOutput() {
        if(Objects.equals(outputArray[2], "null") ||outputArray[2]==null){
            return "none";
        }return outputArray[2];
    }
}
