package edu.bsu.cs222.GUI;
public class GUIInterpreter {
    protected static String sourceLanguageKey;
    protected static String targetLanguageKey;
    protected static String setSourceLanguageKey(String sourceLanguage){
        switch (sourceLanguage) {
            case "English" -> sourceLanguageKey = "e";
            case "Spanish" -> sourceLanguageKey = "s";
            case "German" -> sourceLanguageKey = "g";
            case "Chinese" -> sourceLanguageKey = "c";
            case "French" -> sourceLanguageKey = "f";
            case "Portuguese" -> sourceLanguageKey = "p";
        }return sourceLanguageKey;
    }
    protected static String setTargetLanguageKey(String targetLanguage){
        switch (targetLanguage) {
            case "English" -> targetLanguageKey = "e";
            case "Spanish" -> targetLanguageKey = "s";
            case "German" -> targetLanguageKey = "g";
            case "Chinese" -> targetLanguageKey = "c";
            case "French" -> targetLanguageKey = "f";
            case "Portuguese" -> targetLanguageKey = "p";
        }return targetLanguageKey;
    }
}
