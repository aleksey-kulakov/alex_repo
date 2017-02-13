package ua.itea.javaAdvanced.practice.lesson04.A;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *  Сделать список из 3-х элементов. Получить итератор.
 *  А. Удалить первый и последий элемент через ссылку на коллекцию.
 *  B. Закоментировать предыдущий вариант.
 *  С. И реализовать А.через ссылку на итератор.
 *  D. Вывести коллекцию через итератор.
 *  Е. Вывести коллекцию в обратном порядке.
 *
 * @author Aleksey Kulakov a_kulakov@ukr.net
 * @version 1.0
 * @since 07.02.2017.
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> iter = list.iterator();
        /*list.remove(0);                       // - пункт А и B
        list.remove(list.size()-1);
        while (iter.hasNext()){                 // - В этом случае получаем ConcurrentModificationException
            System.out.println(iter.next());
        }*/
        iter.next();                            // - пункт С
        iter.remove();
        iter.next();
        iter.next();
        iter.remove();
        System.out.println(list);               // - здесь выводится только средний элемент коллекции
        list.add(3);                                // - добавляем в коллекцию пару элементов, что-бы можно
        list.add(4);                                // было выполнить пункты D и E
        System.out.println("Вывод списка в прямом порядке:");   // - пункт D
        ListIterator<Integer> iter2 = list.listIterator();
        while (iter2.hasNext()){
            System.out.println(iter2.next());
        }
        System.out.println("Вывод списка в обратном порядке:"); // - пункт E
        while (iter2.hasPrevious()){
            System.out.println(iter2.previous());
        }
    }
}
