package ua.itea.javaAdvanced.practice.lesson04.MyTreeMap;

/**
 * @author Aleksey Kulakov a_kulakov@ukr.net
 * @version 1.0
 * @since 12.02.2017.
 */
public class Main {
    public static void main(String[] args) {
        MyTreeMap<Integer, String> mtm = new MyTreeMap<>();
        mtm.put(1, "один");
        mtm.put(2, "два");
        mtm.put(3, "три");
        /*System.out.println(mtm.get(1));
        System.out.println(mtm.get(2));
        System.out.println(mtm.get(3));
        System.out.println(mtm.firstKey());
        System.out.println(mtm.lastKey());
        mtm.remove(3);
        System.out.println(mtm.lastKey());*/
        mtm.print();
    }
}
