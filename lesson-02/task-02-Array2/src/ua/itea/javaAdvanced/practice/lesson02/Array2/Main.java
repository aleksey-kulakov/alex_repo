package ua.itea.javaAdvanced.practice.lesson02.Array2;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        int number;
        for (int i = 0; i < 20; i++) {
            number = (int)( 1000 * Math.random());
            number *= randomSign(number);
            list.add(number);
        }
        for (int x : list){
            System.out.print(x + " ");
        }
        System.out.println();

        list = returnSortedCollection(list);
        for (int x : list){
            System.out.print(x + " ");
        }
    }

    //доделать
    private static <T extends Number & Comparable> ArrayList<T> returnSortedCollection(ArrayList<T> list){
        long sum = 0L;
        for(T x : list){
            sum = (long)x.shortValue();
        }
        //long avg = (sum/list.size());
        T a;
        T b;
        for (int i = list.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                a = list.get(j);
                b = list.get(j+1);
                if( a.doubleValue() > b.doubleValue()) {
                    list.set(j, b);
                    list.set(j + 1, a);
                }
            }
        }
        return list;
    }

    private static <T extends Number> int randomSign(T number){
        String s = "" + (int)(Math.round(number.doubleValue()));
        int a = Integer.parseInt(s.substring(0,1));
        int b = Integer.parseInt(s.substring(s.length()-1));
        if (((a+b))%2 == 0){
            return 1;
        }
        return -1;
    }

}
