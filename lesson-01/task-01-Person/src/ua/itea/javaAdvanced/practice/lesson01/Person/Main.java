package ua.itea.javaAdvanced.practice.lesson01.Person;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Person person = new Person("Иннокентий","Деревянный",true, new GregorianCalendar(1980, Calendar.JANUARY, 11),
                new PhoneNumber("123-11-22"), Person.Temperament.CHOLERIC);
        person.printPerson();
        person.printPerson(Person.Format.SHORT, Person.Stream.OUT);
        person.printPerson(Person.Format.MEDIUM, Person.Stream.OUT);
        person.printPerson(Person.Format.LONG, Person.Stream.OUT);
        Thread.sleep(1000);
        person.printPerson(Person.Format.SHORT, Person.Stream.ERR);
        person.printPerson(Person.Format.MEDIUM, Person.Stream.ERR);
        person.printPerson(Person.Format.LONG, Person.Stream.ERR);
        Thread.sleep(1000);
        System.out.printf("%#s %n", person);
    }
}
