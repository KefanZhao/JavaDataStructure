package chapter2;

import java.util.Arrays;
import java.util.Objects;

public class SeqList<T> {
    private Object[] elements;
    private int n;
    private static final int capacity = 64;

    public SeqList(int length) {
        this.elements = new Object[length];
        this.n = 0;
    }

    public SeqList() { // 默认容量的空表
        this(capacity);
    }

    public SeqList(T[] values) {
        this(values.length);
        for (int i = 0; i < values.length; i++) {
            this.elements[i] = values[i];
        }
        this.n = elements.length;
    }

    /*
    以下全部是成员方法
     */
    public boolean isEmpty() { // 1
        return this.n == 0;
    }

    public int size() { // 1
        return this.n;
    }

    public T get(int i) { // 1
        if (i >= 0 && i < this.n) {
            return (T) this.elements[i];
        }
        return null;
    }

    public void set(int i, T data) { // 1
        if (data == null) {
            throw new NullPointerException("data == null");
        }
        if (i >= 0 && i < this.n) {
            this.elements[i] = data;
        } else {
            throw new java.lang.IndexOutOfBoundsException();
        }
    }

    public int insert(T data) {
        if (data == null) {
            throw new NullPointerException("data === null");
        }
        if (this.size() >= this.elements.length) {
            Object[] newData = new Object[capacity * 2];
            for (int i = 0; i < elements.length; i++) {
                newData[i] = elements[i];
            }
            elements = newData;
        }
        elements[n] = data;
        n++;
        return n;
    }

    public int insert(int i, T data) { // n/2
        if (data == null) {
            throw new NullPointerException("data == null");
        }
        if (i < 0) i = 0;
        if (i > this.n) i = this.n;
        Object[] source = this.elements;
        if (this.n == elements.length) { // 如果数组满，则需要扩充顺序表的数组容量
            this.elements = new Object[source.length * 2];
        }
        for (int j = 0; j < i; j++) { // 复制当前数组的i - 1个元素
            this.elements[j] = source[j];
        }
        for (int j = this.n - 1; j >= i; j--) { // 从j开始至表尾的元素向后移动，次序从后向前
            this.elements[j + 1] = source[j];
        }
        this.elements[i] = data;
        this.n++;
        return i;
    }

    public T remove(int i) { // (n-1)/2
        if (this.n > 0 && i >= 0 && i < this.n) {
            T old = (T) this.elements[i];
            for (int j = i; j < this.n - 1; j++) {
                this.elements[j] = this.elements[j + 1]; // 元素向前移动一个位置
            }
            this.elements[this.n - 1] = null; // 设置数组元素为空，释放原引用实例
            this.n--;
            return old;
        }
        return null;
    }

    public int search(T key) { // n
        for (int i = 0; i < this.n; i++) {
            if (key.equals(this.elements[i])) { // 执行了T类的equals(Object)方法，属于运行时多态
                return i;
            }
        }
        return -1; // 表示表空或者没有找到
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof SeqList<?>) {
            SeqList<T> list = (SeqList<T>) obj;
            if (this.n == list.n) {
                for (int i = 0; i < this.n; i++) {
                    if (!this.get(i).equals(list.get(i))) { // 这里也是一个运行时多态
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }


    @Override
    public String toString() { // n
        String str = this.getClass().getName() + "(";
        if (this.n > 0) {
            str += this.elements[0].toString();
        }
        for (int i = 1; i < this.n; i++) {
            str += "," + this.elements[i].toString();
        }
        return str + ")";
    }
}
