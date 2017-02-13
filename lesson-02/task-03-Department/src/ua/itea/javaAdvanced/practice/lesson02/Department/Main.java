package ua.itea.javaAdvanced.practice.lesson02.Department;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        //создаем Person департамент разнорабочих
        Person gw1 = new Person("Иван", "Иванов", new GregorianCalendar(1980, Calendar.JANUARY, 11));
        Person gw2 = new Person("Петр", "Петров", new GregorianCalendar(1979, Calendar.MAY, 13));
        Person gw3 = new Person("Сидор", "Сидоров", new GregorianCalendar(1981, Calendar.SEPTEMBER, 14));
        ArrayList<Person> gw = new ArrayList<>();
        gw.add(gw1);
        gw.add(gw2);
        gw.add(gw3);
        Department<Person> generalWorkers = new Department<>("Разнорабочие", gw);
        //создаем Employee департамент разработчиков
        Employee dev1 = new Employee("Вася", "Пупкин", new GregorianCalendar(1980, Calendar.JANUARY, 5));
        Employee dev2 = new Employee("Федор", "Сумкин", new GregorianCalendar(1979, Calendar.MAY, 23));
        Employee dev3 = new Employee("Гриша", "Грушин", new GregorianCalendar(1981, Calendar.SEPTEMBER, 24));
        ArrayList<Employee> dev = new ArrayList<>();
        dev.add(dev1);
        dev.add(dev2);
        dev.add(dev3);
        Department<Employee> developers = new Department<>("Разработчики", dev);
        //сейчас средний возраст в двух департаментах одинаковый
        System.out.println(generalWorkers.averageAge());
        System.out.println(developers.averageAge());
        System.out.println(generalWorkers.hasSameAverageAge(developers));
        //добавляем одного товарища в разнорабочие
        Person gw4 = new Person("Павел", "Павлов", new GregorianCalendar(1975, Calendar.SEPTEMBER, 14));
        generalWorkers.addEmployee(gw4);
        //сейчас средний возраст уже разный
        System.out.println(generalWorkers.averageAge());
        System.out.println(developers.averageAge());
        System.out.println(generalWorkers.hasSameAverageAge(developers));
    }
}
