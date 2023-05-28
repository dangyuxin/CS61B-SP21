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

    @Test
    public void b03(){
        // fill up, empty, fill up again.
        ArrayDeque<Integer> aaa = new ArrayDeque<>();
        for(int i=0;i<8;i++)
            aaa.addLast(100);
        aaa.printDeque();
        System.out.println(aaa.Capacity);
        for(int i=0;i<8;i++)
            aaa.removeFirst();
        aaa.printDeque();
        System.out.println(aaa.Capacity);

        for(int i=0;i<7;i++)
            aaa.addLast(100);
        aaa.printDeque();
        System.out.println(aaa.Capacity);
    }


    ////other test

    @Test
    public void addTest() {
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();

        assertTrue("Should be empty", arrayDeque.isEmpty());

        arrayDeque.addFirst("front");
        assertEquals("Should have size 1", 1, arrayDeque.size());

        arrayDeque.addLast("middle");
        assertEquals("Should have size 2", 2, arrayDeque.size());

        arrayDeque.addLast("back");
        assertEquals("Should have size 3", 3, arrayDeque.size());

        System.out.println("Printing out deque: ");
        arrayDeque.printDeque();
    }

    @Test
    public void addWithResizingTest() {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        for (int i = 0; i < 20; i++) {
            arrayDeque.addLast(i);
        }

        assertEquals("Should have size 20", 20, arrayDeque.size());
    }

    @Test
    public void addBigAmountTest() {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        int M = 1000000;

        for (int i = 0; i < M; i++) {
            arrayDeque.addLast(i);
        }

        assertEquals("Should have size 1000000", M, arrayDeque.size());
    }

    @Test
    public void removeTest() {
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();

        arrayDeque.addFirst("front");
        arrayDeque.addLast("middle");
        arrayDeque.addLast("back");

        assertEquals("Should remove last item", "back", arrayDeque.removeLast());
        assertEquals("Should remove first item", "front", arrayDeque.removeFirst());

        assertEquals("Should have size 1", 1, arrayDeque.size());
    }

    @Test
    public void removeWithResizingTest() {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        for (int i = 0; i < 20; i++) {
            arrayDeque.addLast(i);
        }

        for (int i = 0; i < 20; i++) {
            assertEquals("Should be equal", i, (int) arrayDeque.removeFirst());
        }

        assertTrue("Should be empty", arrayDeque.isEmpty());

        for (int i = 0; i < 20; i++) {
            arrayDeque.addLast(i);
        }

        assertEquals("Should have size 20", 20, arrayDeque.size());
    }

    @Test
    public void removeBigAmountTest() {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        int M = 1000000;

        for (int i = 0; i < M; i++) {
            arrayDeque.addLast(i);
        }

        assertEquals("Should have size 1000000", M, arrayDeque.size());

        for (int i = 0; i < M; i++) {
            assertEquals("Should be equal", i, (int) arrayDeque.removeFirst());
        }

        assertTrue("Should be empty", arrayDeque.isEmpty());
    }

    @Test
    public void getTest() {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        for (int i = 0; i < 20; i++) {
            arrayDeque.addLast(i);
        }

        for (int i = 0; i < 20; i++) {
            assertEquals("Should be equal", i, (int) arrayDeque.get(i));
        }

        assertNull("Should be null when index out of bound", arrayDeque.get(20));
    }

    @Test
    public void getBigAmountTest() {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        int M = 1000000;

        for (int i = 0; i < M; i++) {
            arrayDeque.addLast(i);
        }

        for (int i = 0; i < M; i++) {
            assertEquals("Should be equal", i, (int) arrayDeque.get(i));
        }
    }

}
