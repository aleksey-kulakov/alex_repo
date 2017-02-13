package ua.itea.javaAdvanced.practice.lesson04.Translator;

/**
 * Translator. Написать программу переводчик, которая будет переводить текст, написанный на одном языке,
 * на другой язык согласно заранее составленному словарю.
 *
 * @author Aleksey Kulakov a_kulakov@ukr.net
 * @version 1.0
 * @since 09.02.2017.
 */
public class Main {
    public static void main(String[] args) {
        EnglishVocabulary english = new EnglishVocabulary();
        GermanVocabulary german = new GermanVocabulary();
        String originalText = "Java это очень круто. PHP это так-себе. Pascal это вообще не круто";
        Translator russianEnglish = new Translator(originalText, english);
        Translator russianGerman = new Translator(originalText, german);
        System.out.println(russianEnglish.getTranslation());
        System.out.println(russianGerman.getTranslation());
    }
}
