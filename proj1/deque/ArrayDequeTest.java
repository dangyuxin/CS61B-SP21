package deque;

import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {
    @Test
    public void addFirstTest(){
        ArrayDeque<String> aaa = new ArrayDeque<>();
        aaa.addFirst("hello");
        aaa.addFirst("world");
        aaa.addFirst("dyx");
        System.out.println(aaa.get(1));
        System.out.println(aaa.get(2));
        System.out.println(aaa.get(4));
        aaa.printDeque();
    }

    @Test
    public void addLastTest(){
        ArrayDeque<String> aaa = new ArrayDeque<>();
        aaa.addLast("hello");
        aaa.addLast("world");
        aaa.addLast("dyx");
        aaa.addLast("aaa");
        aaa.addLast("bbb");
        aaa.addLast("ccc");
        aaa.addLast("ddd");
        aaa.addLast("eee");
        System.out.println(aaa.get(1));
        System.out.println(aaa.get(2));
        System.out.println(aaa.get(4));
        System.out.println(aaa.removeFirst());
        System.out.println(aaa.removeLast());
        aaa.printDeque();
    }

    @Test
    public void resizeTest(){
        ArrayDeque<String> aaa = new ArrayDeque<>();
        aaa.addLast("hello");
        aaa.addLast("world");
        aaa.addLast("dyx");
        aaa.addLast("aaa");
        aaa.addLast("bbb");
        aaa.addLast("ccc");
        aaa.printDeque();
        aaa.resize(16);
        aaa.printDeque();
    }

    @Test
    public void add(){
        ArrayDeque<Integer> aaa = new ArrayDeque<>();
        for(int i=0;i<64;i++)
            aaa.addLast(i);
        aaa.printDeque();
        System.out.println(aaa.Capacity);
        for(int i=0;i<16;i++)
            aaa.removeFirst();
        for(int i=0;i<17;i++)
            aaa.removeLast();
        aaa.printDeque();
        System.out.println(aaa.size());
        System.out.println(aaa.Capacity);
    }

}
