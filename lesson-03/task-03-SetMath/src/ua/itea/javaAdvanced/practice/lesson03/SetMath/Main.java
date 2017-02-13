package ua.itea.javaAdvanced.practice.lesson03.SetMath;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> intSet1 = new HashSet<>();
        intSet1.add(1);
        intSet1.add(2);
        intSet1.add(3);
        intSet1.add(4);
        intSet1.add(5);
        Set<Integer> intSet2 = new HashSet<>();
        intSet2.add(4);
        intSet2.add(5);
        intSet2.add(6);
        intSet2.add(7);
        intSet2.add(8);
        SetMath<Integer> smi = new SetMath<>();
        System.out.println(smi.setUnion(intSet1, intSet2));
        System.out.println(smi.setIntersection(intSet1, intSet2));
        System.out.println(smi.setDifference(intSet1, intSet2));

        Set<String> strSet1 = new HashSet<>();
        strSet1.add("один");
        strSet1.add("два");
        strSet1.add("три");
        strSet1.add("четыре");
        strSet1.add("пять");
        Set<String> strSet2 = new HashSet<>();
        strSet2.add("четыре");
        strSet2.add("пять");
        strSet2.add("шесть");
        strSet2.add("семь");
        strSet2.add("восемь");
        SetMath<String> sms = new SetMath<>();
        System.out.println(sms.setUnion(strSet1, strSet2));
        System.out.println(sms.setIntersection(strSet1, strSet2));
        System.out.println(sms.setDifference(strSet1, strSet2));
    }
}
