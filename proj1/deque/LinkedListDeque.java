package deque;

import java.lang.reflect.Type;

public class LinkedListDeque<T> {
    private int size;

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

    private Node sentinel = new Node();


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
        if (isEmpty())
            return null;
        T res = sentinel.next.val;
        sentinel.next.next.pre = sentinel;
        sentinel.next = sentinel.next.next;
        size--;
        return res;
    }

    public T removeLast() {
        if (isEmpty())
            return null;
        T res = sentinel.pre.val;
        sentinel.pre.pre.next = sentinel;
        sentinel.pre = sentinel.pre.pre;
        size--;
        return res;
    }

    public T get(int index) {
        if (size - 1 < index)
            return null;
        Node t = sentinel.next;
        for (int i = 0; i < index; i++)
            t = t.next;
        return t.val;
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
        if (o == null)
            return false;
        if (o == this)
            return true;
        if (!(o instanceof LinkedListDeque))
            return false;
        LinkedListDeque<?> lld = (LinkedListDeque<?>) o;
        if (this.getClass() != lld.getClass())
            return false;
        if(this.getClass().isAssignableFrom(lld.getClass()))
            return false;
        if (lld.size() != size)
            return false;
        for (int i = 0; i < size; i++)
            if (lld.get(i) != get(i))
                return false;
        return true;
    }
}
