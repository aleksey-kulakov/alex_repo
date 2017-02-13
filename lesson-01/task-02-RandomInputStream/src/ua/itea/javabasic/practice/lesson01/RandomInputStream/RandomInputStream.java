package ua.itea.javabasic.practice.lesson01.RandomInputStream;

import java.io.IOException;
import java.io.InputStream;

public class RandomInputStream extends InputStream{
    private final static int  MIN_LENGTH = 4;
    private final static int  MAX_LENGTH = 5;
    private byte[] stream;
    private int count;
    private int mark;
    private int markLimit;


    RandomInputStream(){
        stream = createStream();
        count = 0;
        mark = -1;
    }

    @Override
    public int read() throws IOException {
        if (count >= stream.length){
            return -1;
        }
        int bait = stream[count];
        count++;
        if (count > markLimit){
            mark = -1;
        }
        return bait;
    }

    private byte[] createStream(){
        int length = MIN_LENGTH + (int)((MAX_LENGTH - MIN_LENGTH)*Math.random());
        byte[] b = new byte[length];
        for (int i = 0; i < b.length; i++) {
            b[i] = (byte)(127*Math.random());
        }
        return b;
    }

    @Override
    public void mark(int bytes){
        mark = count;
        markLimit = mark + bytes;
    }

    @Override
    public void reset(){
        if(mark >= 0){
            count = mark;
        }
    }

    @Override
    public boolean markSupported() {
        return true;
    }
}
