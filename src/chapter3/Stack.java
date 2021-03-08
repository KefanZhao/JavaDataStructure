package chapter3;

public interface Stack<T> {
    public boolean isEmpty();

    public void push(T data);

    public T peek(); // 返回栈顶，元素未出栈

    public T pop(); // 返回栈顶，元素出栈
}
