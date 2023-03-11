package edu.bsu.cs222;

import java.io.IOException;
import java.util.ArrayList;

public class RandomWord {
    private final String randomWord;
    private final String randomWordDefinition;
    public RandomWord() throws IOException {
        this.randomWord = fetchRandomWord();
        this.randomWordDefinition = fetchRandomWordDefinition();
    }
    public String getRandomWord(){
        return randomWord;
    }
    public String getRandomWordDefinition(){
        return randomWordDefinition;
    }
    public String[] getRandomWordAndDefinition(){
        String[] randomWordAndDefinition = new String[2];
        randomWordAndDefinition[0] = randomWord;
        randomWordAndDefinition[1] = randomWordDefinition;
        return randomWordAndDefinition;
    }
    //the rest of the words available in the dictionary we are using must be added to allWordsInDictionary
    //there is a list I found in a doc in the folder for our group with our pitch and project plan
    private ArrayList<String> generateWordsInDictionary(){
        String allWordsInDictionary = "A, an, ability, able, above, abroad, absent, absolutely, accent, accept, access, accident, accommodation, accompany,\n" +
                "according, account, accountant, accurate, ache, achieve, across, act, action, active, activity, actor, actress, actually,\n" +
                "agency, ago, agree, ahead, aim, air, air conditioning, air force, airline, airport, alarm, alarm clock, album, alike, alive,\n" +
                "all, alright, allow, almost, alone, along, aloud, alphabet, already, also, although, altogether always, am, amazed, amazing,\n" +
                "ambition, ambulance, among, amongst, amount, amusing, an, ancient, ad, advertisement, add, addition, address, admire,\n" +
                "admission, admit, adult, advance, advanced, advantage, adventure, advert, advertise, advice, aeroplane, airplane, afford,\n" +
                "afraid, alter, afternoon, afterwards, again, against, age, aged, and, angry, animal, ankle, anniversary, announce,\n" +
                "announcement, annoy, annual, another, answer, answerphone, ant, antique, anxious, any, anybody, anymore, anyone, anything,\n" +
                "anyway, anywhere, apart, apart from, apartment, apartment building, apologise, apology, appear, appearance, apple,\n" +
                "application, apply, appointment, approach, approve, architect, architecture, area, argue, argument, arm, armchair, army,\n" +
                "around, arrange, arrangement, arrest, arrival, arrive, art, article, artist,as, ashamed, ask, asleep, aspirin, assistant,\n" +
                "at, athlete, athletics atmosphere, attach, attack, attempt, attend,\n" +
                "attention, attitude, attract, attraction, attractive, audience, aunt, author, autumn, available, average,\n" +
                "avoid, awake, away, awful";
        String[] wordsArray = allWordsInDictionary.split(",");
        ArrayList<String> wordsInDictionary = new ArrayList<>();
        for(String word : wordsArray){
            wordsInDictionary.add(word.strip());
        }
        return wordsInDictionary;
    }
    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    private String fetchRandomWord(){
        ArrayList<String> wordsArray = generateWordsInDictionary();
        int randomWordIndex = getRandomNumber(0, wordsArray.size());
        return wordsArray.get(randomWordIndex);
    }
    private String fetchRandomWordDefinition() throws IOException {
        APIConnection randomWordConnection = new APIConnection(this.randomWord);
        DefinitionParser randomWordDefinitionFetcher = new DefinitionParser(randomWordConnection.getDefinitionsInputStream());
        return randomWordDefinitionFetcher.fetchDefinition();
    }


}
