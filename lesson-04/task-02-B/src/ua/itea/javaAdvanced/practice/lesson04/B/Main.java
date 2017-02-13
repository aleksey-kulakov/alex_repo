package ua.itea.javaAdvanced.practice.lesson04.B;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 *  Есть список чисел (от 5 до 15) сгенерированных рандомно. Нужно заменить
 *  среднее (по индексу) число. Через итератор установить туда макс. элемент
 *  из списка. А это среднее число через итератор добавляем в конец списка.
 *
 * @author Aleksey Kulakov a_kulakov@ukr.net
 * @version 1.0
 * @since 07.02.2017.
 */

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int length = randomLength();
        for (int i = 0; i < length; i++) {
            list.add(randomNumber());
        }
        System.out.println("Первоначальный список:");
        System.out.println(list);

        int middle = length / 2;
        int maxNumber = list.get(0);
        int count = 0;
        int number;
        int middleNumber = 0;
        for(int x : list){
            if (x > maxNumber){
                maxNumber = x;
            }
        }
        ListIterator<Integer> iter = list.listIterator();
        while (count <= middle){
            number = iter.next();
            if (count == middle){
                middleNumber = number;
                iter.set(maxNumber);
            }
            count++;
        }
        while (iter.hasNext()) {
            iter.next();
        }
        iter.add(middleNumber);
        System.out.println("Преобразованный список:");
        System.out.println(list);
    }

    private static int randomNumber(){
        return (int)(100 * Math.random());
    }

    private static int randomLength(){
        return 5 + (int)(10 * Math.random());
    }
}
