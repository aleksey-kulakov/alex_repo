package ua.itea.javaAdvanced.practice.lesson01.Person;

import java.util.*;

class Person implements Cloneable, Formattable{

    private String name;
    private String surName;
    private boolean gender;
    private int age;
    private Calendar birthDay;
    private PhoneNumber phoneNumber;
    private Temperament temperament;

    enum Temperament{SANGUINE, PHLEGMATIC, SUPINE, CHOLERIC, MELANCHOLIC}
    enum Format{SHORT, MEDIUM, LONG};
    enum Stream{OUT, ERR};

    public Person(String name, String surName, boolean gender, Calendar birthDay, PhoneNumber phoneNumber,
                  Temperament temperament){
        this.name = name;
        this.surName = surName;
        this.gender = gender;
        this.birthDay = birthDay;
        this.age = calcAge(birthDay);
        this.phoneNumber = phoneNumber;
        this.temperament = temperament;
    }

    //копирующий конструктор
    public Person(Person another) {
        this(another.getName(), another.getSurName(), another.isMan(), another.getBirthDay(),
                another.getPhoneNumber(),another.getTemperament());
    }

    private int calcAge(Calendar birthDay){
        GregorianCalendar currentDate = new GregorianCalendar();
        int currentYear  = currentDate.get(Calendar.YEAR);
        int currentDayOfYear = currentDate.get(Calendar.DAY_OF_YEAR);
        int birthDayYear  = birthDay.get(Calendar.YEAR);
        int birthDayOfYear = birthDay.get(Calendar.DAY_OF_YEAR);
        if (birthDayOfYear>currentDayOfYear){
            return currentYear - birthDayYear -1;
        }
        return currentYear - birthDayYear;
    }

    private String getName(){
        return name;
    }

    private String getSurName(){
        return surName;
    }

    private boolean isMan(){
        return gender;
    }

    private Calendar getBirthDay(){
        return birthDay;
    }

    private PhoneNumber getPhoneNumber(){
        return phoneNumber;
    }

    private Temperament getTemperament(){
        return temperament;
    }

    private String pol(boolean gender){
        if(gender){
            return "male";
        }
        else {
            return "female";
        }
    }

    void printPerson(){
        String s = String.format("Gender: %6s , temper: %11s ; age: %2d ; name: %11s ; surname: %13s",
                pol(gender), temperament, age, name, surName);
        System.out.println(s);
    }

    void printPerson(Format format, Stream stream){
        String ss = String.format("Name: %11s ; surname: %13s ; age: %2d", name, surName, age);
        String sm = String.format("Name: %11s ; surname: %13s ; age: %2d ; gender: %6s", name, surName, age, pol(gender));
        String sl = String.format(new Locale("ru","ru"),"Name: %1$11s ; surname: %2$13s ; birthday: %3$te-%3$tB-%3$tY ;" +
                " age: %4$2d ; gender: %5$6s ; temper: %6$11s", name, surName, birthDay, age, pol(gender), temperament);
        if (format == Format.SHORT && stream == Stream.ERR){
            System.err.println(ss);
        }
        if (format == Format.SHORT && stream == Stream.OUT){
            System.out.println(ss);
        }
        if (format == Format.MEDIUM && stream == Stream.ERR){
            System.err.println(sm);
        }
        if (format == Format.MEDIUM && stream == Stream.OUT){
            System.out.println(sm);
        }
        if (format == Format.LONG && stream == Stream.ERR){
            System.err.println(sl);
        }
        if (format == Format.LONG && stream == Stream.OUT){
            System.out.println(sl);
        }
    }

    @Override
    public void formatTo(Formatter formatter, int flags, int width, int precision) {
        String s = String.format("Gender: %6s , temper: %11s ; age: %2d ; name: %11s ; surname: %13s",
                pol(gender), temperament, age, name, surName);
        if (flags==1){
            s = s.toUpperCase();
        }
        formatter.format(s);
    }

    @Override
    public String toString(){
        String bd = "; birthDay: " + birthDay.get(Calendar.DAY_OF_MONTH) + "-" + (birthDay.get(Calendar.MONTH) +
                1) + "-" + birthDay.get(Calendar.YEAR);
        return getClass().getName() + "; name: " + name + "; surname: " + surName + "; gender: " + pol(gender) + "; age: " +
                age + bd + "; tel.: " + phoneNumber + ", temper: " + temperament;
    }

    @Override
    protected void finalize() throws Throwable {
        try {
            System.out.println("Object " + toString() + " removed!");
        } finally {
            super.finalize();
        }
    }

    @Override
    public int hashCode(){
        //return Objects.hash(name, gender, age, birthDay, phoneNumber);  // - другой вариант
        return (7 * Objects.hashCode(name)) + (11 * Objects.hashCode(gender)) + (13 * Objects.hashCode(age)) +
                + (17 * Objects.hashCode(birthDay)) + (19 * Objects.hashCode(phoneNumber));
    }

    @Override
    public boolean equals(Object another){
        if (this == another) return true;
        if (another == null) return false;
        if (this.getClass() != another.getClass()) return false;
        Person p = (Person) another;
        return (name.equals(p.name) && (gender == p.gender) && (age == p.age) &&
        birthDay.equals(p.birthDay) && phoneNumber.equals(p.phoneNumber));
    }

    @Override
    public Person clone(){
        Person copy;
        try{
            copy = (Person)super.clone();
            copy.birthDay = (Calendar)copy.birthDay.clone();
        } catch (CloneNotSupportedException ex){
            throw new AssertionError("Does class implement Cloneable?");
        }
        return copy;
    }
}
