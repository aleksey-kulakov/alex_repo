package ua.itea.javaAdvanced.practice.lesson04.C;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *  В HashMapDemo добавить пару пар ключ-значение.
 *  А. При итерировании по EntrySet сделать в мапе транслейтинг значений на англ.язык.
 *  B. Проитерироваться по коллекции значений в мапе и удалить пустые значения.
 *
 * @author Aleksey Kulakov a_kulakov@ukr.net
 * @version 1.0
 * @since 07.02.2017.
 */
public class HashMapDemo {
    private static Map<String, String> vocabulary = new HashMap<>();

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Человек1");
        map.put(2, "Человек2");
        map.put(null, "3Человек3");
        map.put(3, "");
        map.put(4, "");
        map.put(5, "Собака");
        map.put(6, "6Собака");


        Set<Map.Entry<Integer, String>> set = map.entrySet();
        for (Map.Entry<Integer, String> entry : set)
            System.out.println(entry.getKey() + " = " + entry.getValue());

        Set<Integer> set2 = map.keySet();
        for (Integer key : set2)
            System.out.println(map.get(key));

        Iterator<Map.Entry<Integer, String>> itr = map.entrySet().iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }

        vocabulary.put("Человек", "Human");
        vocabulary.put("Собака", "Dog");

        Iterator<Integer> itrMapKey = set2.iterator();
        String mapWord;
        Integer mapKey;
        while(itrMapKey.hasNext()){
            mapKey = itrMapKey.next();
            mapWord = map.get(mapKey);
            if (mapWord.isEmpty()){
                itrMapKey.remove();
                continue;
            }
            map.put(mapKey, translate(mapWord));
        }
        System.out.println("Преобразованная мапа:");
        for (Map.Entry<Integer, String> entry : set) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

    }

    private static String translate(String mixWord){
        String translated;
        char[] ch = mixWord.toCharArray();
        String word = "";
        for(char x : ch){
            if (Character.isLetter(x)){
                word += "" + x;
            }
        }
        if (vocabulary.containsKey(word)){
            translated = vocabulary.get(word);
        }
        else{
            translated = mixWord;
        }
        return toMakeFullWord(translated, mixWord, word);
    }

    private static String toMakeFullWord(String translated, String mixWord, String word){
        String fullWord = "";
        if (mixWord.equals(word)){
            return translated;
        }
        else{
            int index = mixWord.indexOf(word);
            if (index == 0){
                fullWord = translated;
            }
            if (index > 0){
                fullWord = mixWord.substring(0,index) + translated;
            }
            if ((index + word.length()) < mixWord.length()){
                fullWord += mixWord.substring((index + word.length()));
            }
        }
        return fullWord;
    }
}
