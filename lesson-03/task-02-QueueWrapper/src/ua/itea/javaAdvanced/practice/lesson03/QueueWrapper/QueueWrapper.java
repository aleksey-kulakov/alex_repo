package ua.itea.javaAdvanced.practice.lesson03.QueueWrapper;


import java.util.*;

public class QueueWrapper {
    public static void main(String[] args) {
        Queue<Integer> qi = new LinkedList<>();
        qi.add(1);
        qi.add(2);
        qi.add(3);
        qi.add(4);
        qi.add(5);
        System.out.println(qi);
        List<Integer> list = asList(qi);
        System.out.println(list);
        qi.poll();
        System.out.println(qi);
        System.out.println(list);
    }

    static <T> List<T> asList(Queue<T> que){
        return (LinkedList)(que);
    }


    /*static <T> List<T> asList(Queue<T> que){
        List<T> list = new ArrayList<T>();
        for(T x : que){
            list.add(x);
        }
        return list;
    }*/
}
