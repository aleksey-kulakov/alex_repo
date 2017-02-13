package src.ua.itea.javaAdvanced.practice.lesson02.qwert;

public class GenericInitialization {
    public static void main(String[] args) {
        new Box<Long>(); //OK
        new Box<>(); //OK?
    }
}

class Box<T>{

    Box[] b = new Box[1]; //OK

    public void m(Box<T> b){
        new Box<T>(); //OK
        // T t = new T(); //not OK
        // T[] a = new T[1]; //not OK
        Box<T> ba; //OK
        ba = new Box<T>(); //OK
    }

}



