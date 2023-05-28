package deque;

import java.lang.reflect.Type;
import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T> ,Iterable<T>{
    private int size;
    private final Node sentinel;

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    private class Node {
        T val;
        Node next;
        Node pre;

        public Node(T item) {
            val = item;
        }

        public Node() {
            next = this;
            pre = this;
        }
    }

    public LinkedListDeque() {
        sentinel = new Node();
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(T item) {
        Node newNode = new Node(item);
        newNode.next = sentinel.next;
        sentinel.next.pre = newNode;
        newNode.pre = sentinel;
        sentinel.next = newNode;
        size++;
    }

    public void addLast(T item) {
        Node newNode = new Node(item);
        newNode.pre = sentinel.pre;
        sentinel.pre.next = newNode;
        newNode.next = sentinel;
        sentinel.pre = newNode;
        size++;
    }

    public T removeFirst() {
        if (isEmpty()) return null;
        T res = sentinel.next.val;
        sentinel.next.next.pre = sentinel;
        sentinel.next = sentinel.next.next;
        size--;
        return res;
    }

    public T removeLast() {
        if (isEmpty()) return null;
        T res = sentinel.pre.val;
        sentinel.pre.pre.next = sentinel;
        sentinel.pre = sentinel.pre.pre;
        size--;
        return res;
    }

    public T get(int index) {
        if (size <= index) return null;
        Node t = sentinel.next;
        for (int i = 0; i < index; i++)
            t = t.next;
        return t.val;
    }

    public T getRecursive(int index) {
        if (size <= index) return null;
        return helper(sentinel.next, index);
    }

    public T helper(Node t, int index) {
        if (index == 0) return t.val;
        return helper(t.next, index - 1);
    }

    public void printDeque() {
        Node t = sentinel.next;
        while (t != sentinel) {
            System.out.print(t.val);
            System.out.print(" ");
            t = t.next;
        }
        System.out.println();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o == this) return true;
        if (!(o instanceof LinkedListDeque)) return false;
        LinkedListDeque<?> lld = (LinkedListDeque<?>) o;
        if (this.getClass() != lld.getClass()) return false;
        if (this.getClass().isAssignableFrom(lld.getClass())) return false;
        if (lld.size() != size) return false;
        for (int i = 0; i < size; i++)
            if (lld.get(i) != get(i)) return false;
        return true;
    }
}
