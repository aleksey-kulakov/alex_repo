package ua.itea.javaAdvanced.practice.lesson04.Translator;

import java.util.*;

/**
 * @author Aleksey Kulakov a_kulakov@ukr.net
 * @version 1.0
 * @since 09.02.2017.
 */
class Translator {
    private Vocabulary vocabulary;
    private String originalText;

    Translator(String originalText, Vocabulary vocabulary){
        this.originalText = originalText;
        this.vocabulary = vocabulary;
    }

    String getTranslation(){
        return translateText();
    }

    private List<String> splitToConversations(String text){
        StringTokenizer st = new StringTokenizer(text,".");
        List<String> conversations = new ArrayList<>();
        while(st.hasMoreTokens()){
            conversations.add((st.nextToken()).trim());
        }
        return conversations;
    }

    private List<String> splitToWords(String text){
        StringTokenizer st = new StringTokenizer(text," ");
        List<String> conversations = new ArrayList<>();
        while(st.hasMoreTokens()){
            conversations.add((st.nextToken()).trim());
        }
        return conversations;
    }

    private String translateWord(String word){
        if (vocabulary.containsWord(word)){
            return vocabulary.getWord(word);
        }
        else {
            return word;
        }
    }

    private String translateConversation(String originalConversation){
        List<String> originalWords = splitToWords(originalConversation);
        String translatedConversation = "";
        Iterator<String> itr = originalWords.iterator();
        while(itr.hasNext()){
            translatedConversation += translateWord(itr.next());
            if (itr.hasNext()){
                translatedConversation += " ";
            }
            else{
                translatedConversation += ". ";
            }
        }
        return translatedConversation;
    }

    private String translateText(){
        List<String> originalConversations = splitToConversations(originalText);
        String translatedText = "";
        for (String originalConversation : originalConversations) {
            translatedText += translateConversation(originalConversation);
        }
        return translatedText;
    }
}
