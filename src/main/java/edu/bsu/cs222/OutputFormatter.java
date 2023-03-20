package edu.bsu.cs222;
import java.util.Objects;
public class OutputFormatter {
    private  String[] outputArray = new String[3];
    public OutputFormatter(String[] output) {
        this.outputArray = output;
    }
    public OutputFormatter(){}
    protected String formOutput() {
        return "Your word : "+outputArray[0]+"\n"+"Your definition : "+formatOutputForUser(outputArray[1])+"\n"+"Synonyms : "+formatOutputForUser(getSynonymsOutput());
    }
    private String getSynonymsOutput() {
        if(Objects.equals(outputArray[2], "null") ||outputArray[2]==null){
            return "none";
        }return outputArray[2];
    }
    public String formatOutputForUser(String wordOutput){
        StringBuilder output = new StringBuilder();
        for(int i=0; i<=wordOutput.length()-1; i++){
            if(!(wordOutput.charAt(i)==']')&&!(wordOutput.charAt(i)=='[')&&!(wordOutput.charAt(i)=='"')){
                output.append(wordOutput.charAt(i));
            }
        }return output.toString();
    }
}
