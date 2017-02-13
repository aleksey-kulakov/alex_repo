package ua.itea.javaAdvanced.practice.lesson02.Array;

public class Main {

    public static void main(String[] args) {
        Integer[] array = {1,2,3,4,5,6,7,8,9};
        Double element = 5.0;
        System.out.println(countElementsLess(array,element));
    }

    private static <T extends Number> int countElementsLess(T[] array, T element){
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].doubleValue() < element.doubleValue()){
                count++;
            }
        }
        return count;
    }
}
