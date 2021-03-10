package chapter3;

public final class SeqQueue<T> implements Queue<T> {
    private Object[] elements;
    private int front, rear;

    public SeqQueue(int capacity) {
        if (capacity < 64) {
            capacity = 64; // 队列数组容量的最小值
        }
        this.elements = new Object[capacity];
        this.front = this.rear = 0;
    }

    public SeqQueue() {
        this(64);
    }

    @Override
    public boolean isEmpty() {
        return this.front == this.rear;
    }

    @Override
    public boolean add(T data) {
        if (data == null) {
            throw new NullPointerException("data == null");
        }
        if (this.front == (this.rear + 1) % this.elements.length) { // 队列满，则扩充数组
            Object[] temp = this.elements;
            this.elements = new Object[temp.length * 2];
            int j = 0;
            for (int i = this.front; i != this.rear; i = (i + 1) % temp.length) {
                this.elements[j++] = temp[i];
            }
            this.front = 0;
            this.rear = j;
        }
        this.elements[this.rear] = data;
        this.rear = (this.rear + 1) % this.elements.length;
        return true;
    }

    @Override
    public T peek() {
        return this.isEmpty() ? null : (T) this.elements[this.front];
    }

    @Override
    public T poll() { // 出队，返回队首
        if (this.isEmpty()) return null;
        T temp = (T) this.elements[this.front];
        this.front = (this.front + 1) % this.elements.length;
        return temp;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(this.getClass().getName() + "(");
        for (int i = this.front; i != this.rear; i = (i + 1) % this.elements.length) {
            stringBuffer.append(this.elements[i].toString() + ",");
        }
        stringBuffer.setCharAt(stringBuffer.length() - 1, ')');
        return new String(stringBuffer);
    }
}
