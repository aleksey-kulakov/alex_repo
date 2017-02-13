package ua.itea.javabasic.practice.lesson01.RandomInputStream;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        RandomInputStream ris = new RandomInputStream();
        ris.mark(3);
        System.out.println(ris.read());
        System.out.println(ris.read());
        System.out.println(ris.read());
        ris.reset();
        System.out.println(ris.read());
        System.out.println(ris.read());
        System.out.println(ris.read());
        System.out.println(ris.read());
        System.out.println(ris.markSupported());
    }
}
