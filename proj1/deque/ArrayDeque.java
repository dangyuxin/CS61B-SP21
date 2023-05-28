package deque;

public class ArrayDeque<T> implements Deque<T> {

    private int size;
    private T[] val;
    public int Capacity;
    private int front;
    private int rear;

    public ArrayDeque() {
        size = 0;
        Capacity = 8;
        val = (T[]) new Object[Capacity];
        front = 0;
        rear = 0;
    }

    public int minus(int step) {
        if (step % Capacity == 0)
            return Capacity - 1;
        return step - 1;
    }

    public int plus(int step) {
        if ((step + 1) % Capacity == 0)
            return 0;
        return step + 1;
    }

    public void resize(int Cap) {
        T[] tmp = (T[]) new Object[Cap];
        int j = rear;
        if (rear >= Cap) {
            while (rear != front) {
                rear = minus(rear);
                tmp[rear-front] = val[rear];
            }
            Capacity = Cap;
            val=tmp;
            front=0;
            rear=front+size;
        } else {
            while (j != front) {
                j = minus(j);
                tmp[j] = val[j];
            }
            tmp[j] = val[j];
            val = tmp;
            Capacity = Cap;
        }
    }


    @Override
    public void addFirst(T item) {
        if (isFull())
            resize(Capacity * 2);
        front = minus(front);
        val[front] = item;
        size++;
    }

    @Override
    public void addLast(T item) {
        if (isFull())
            resize(Capacity * 2);
        val[rear] = item;
        rear = plus(rear);
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == Capacity - 1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        int step = front;
        while (step != rear) {
            System.out.print(val[step]);
            System.out.print(' ');
            step = plus(step);
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (isEmpty())
            return null;
        if (Capacity >= 16 && size <= Capacity / 4)
            resize(Capacity / 2);
        T res = val[front];
        front = plus(front);
        size--;
        return res;
    }

    @Override
    public T removeLast() {
        if (isEmpty())
            return null;
        if (Capacity >= 16 && size <= Capacity / 4)
            resize(Capacity / 2);
        rear = minus(rear);
        T res = val[rear];
        size--;
        return res;
    }

    @Override
    public T get(int index) {
        if (size <= index)
            return null;
        return val[(front + index) % Capacity];
    }
}
