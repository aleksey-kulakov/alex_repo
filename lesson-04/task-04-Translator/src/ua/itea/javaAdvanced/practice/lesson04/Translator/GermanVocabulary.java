package ua.itea.javaAdvanced.practice.lesson04.Translator;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aleksey Kulakov a_kulakov@ukr.net
 * @version 1.0
 * @since 09.02.2017.
 */
public class GermanVocabulary extends Vocabulary{

    GermanVocabulary(){
        super();
        loadBase();
    }

    private void loadBase(){
        setWord("это","das ist");
        setWord("очень","sehr");
        setWord("круто","phantastisch");
        setWord("так-себе","soso");
        setWord("вообще","allgemein");
        setWord("не","nicht");
    }
}
