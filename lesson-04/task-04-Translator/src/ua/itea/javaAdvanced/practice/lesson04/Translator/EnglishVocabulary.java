package ua.itea.javaAdvanced.practice.lesson04.Translator;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aleksey Kulakov a_kulakov@ukr.net
 * @version 1.0
 * @since 09.02.2017.
 */
public class EnglishVocabulary extends Vocabulary{

    EnglishVocabulary(){
        super();
        loadBase();
    }

    private void loadBase(){
        setWord("это","this is");
        setWord("очень","very");
        setWord("круто","cool");
        setWord("так-себе","so-so");
        setWord("вообще","generally");
        setWord("не","not");
    }
}
