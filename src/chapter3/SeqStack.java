package chapter3;

import chapter2.SeqList;

/**
 * 该类是关于线性栈的定义
 * 需要注意的是，类中很多方法直接调用了线性表中的方法，当弹栈下溢或者出栈上溢时没有相关的Exception
 * @param <T>
 */
public final class SeqStack<T> implements Stack<T> {
    private SeqList<T> list; // 顺序表

    public SeqStack(int capacity) {
        this.list = new SeqList<>(capacity);
    }

    public SeqStack() {
        this(64);
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public void push(T data) {
        this.list.insert(data);
    }

    @Override
    public T peek() {
        return this.list.get((list.size() - 1));
    }

    @Override
    public T pop() {
        return this.list.remove(list.size() - 1);
    }

    @Override
    public String toString() {
        return this.getClass().getName() + " " + this.list.toString();
    }
}
