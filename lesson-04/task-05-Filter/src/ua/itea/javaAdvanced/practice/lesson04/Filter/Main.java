package ua.itea.javaAdvanced.practice.lesson04.Filter;

import java.util.*;

/**
 * Написать метод filter(...), который принимает множество Person и возраст. Возвращает новое множество,
 * содержащее только людей равных и старше указанного возраста. Продемонстрировать использование.
 *
 * @author Aleksey Kulakov a_kulakov@ukr.net
 * @version 1.0
 * @since 09.02.2017.
 */
public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Иван", "Иванов", new GregorianCalendar(1985, Calendar.JANUARY, 11));
        Person p2 = new Person("Петр", "Петров", new GregorianCalendar(1979, Calendar.MAY, 13));
        Person p3 = new Person("Сидор", "Сидоров", new GregorianCalendar(1978, Calendar.SEPTEMBER, 14));
        Person p4 = new Person("Вася", "Пупкин", new GregorianCalendar(1980, Calendar.JANUARY, 5));
        Person p5 = new Person("Федор", "Сумкин", new GregorianCalendar(1976, Calendar.MAY, 23));
        Person p6 = new Person("Гриша", "Грушин", new GregorianCalendar(1982, Calendar.SEPTEMBER, 24));
        List<Person> persons = new ArrayList<>();
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        persons.add(p4);
        persons.add(p5);
        persons.add(p6);
        for(Person x : persons){
            x.printPerson(Person.Format.SHORT,Person.Stream.OUT);
        }
        System.out.println();
        List<Person> filteredPersons = filter(persons, 35);
        for(Person x : filteredPersons){
            x.printPerson(Person.Format.SHORT,Person.Stream.OUT);
        }
    }

    private static List<Person> filter(List<Person> persons, int age){
        List<Person> list = new ArrayList<>();
        Iterator<Person> itr = persons.iterator();
        Person persona;
        while(itr.hasNext()){
            persona = itr.next();
            if(persona.getAge() >= age){
                list.add(persona);
            }
        }
        return list;
    }
}
