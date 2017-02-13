package ua.itea.javaAdvanced.practice.lesson04.Translator;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aleksey Kulakov a_kulakov@ukr.net
 * @version 1.0
 * @since 09.02.2017.
 */
 class Vocabulary {
    private Map<String, String> vocabulary;

    Vocabulary(){
        vocabulary = new HashMap<>();
    }

    void setWord(String originalWord, String translatedWord){
        vocabulary.put(originalWord, translatedWord);
    }

    String getWord(String original){
        return vocabulary.get(original);
    }

    boolean containsWord(String word) {
        return vocabulary.containsKey(word);
    }
}
