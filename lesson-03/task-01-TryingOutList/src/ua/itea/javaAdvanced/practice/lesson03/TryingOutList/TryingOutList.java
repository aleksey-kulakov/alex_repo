package ua.itea.javaAdvanced.practice.lesson03.TryingOutList;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TryingOutList {
    public static void main(String[] args) {
        String[] str = new String[] {"один","два","три"};
        Integer[] num = {1,2,3};
        List<String> strList = asList(str);
        List<Integer> intList = asList(num);

        System.out.println(strList);
        System.out.println(intList);

        printRm();

        //Создание немодифицируемого списка
        /*List<Integer> list = new ArrayList<>();
        List<Integer> list2 = Collections.unmodifiableList(list);
        list2.add(1);*/
    }

    private static <T> List<T> asList(T[] array){
        List<T> list = new ArrayList<>();
        Collections.addAll(list, array);
        /*for(T x : array){  - вариант 2
            list.add(x);
        }*/
        return list;
    }

     private static void printRm(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.remove(0);
        list.remove(0);
        list.remove(0);
        list.remove(list.size()-1);
        list.forEach(System.out::println);  //вывод элементов используя лямбда - выражения
        /*for(int x : list){            - вариант 2
            System.out.println(x);
        }*/
    }
}
