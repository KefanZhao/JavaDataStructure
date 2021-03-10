package chapter3;

public interface Queue <T>{
    public boolean isEmpty();

    public boolean add(T data); // 入队

    public T peek(); // 返回队头，没有删除

    public T poll(); // 出队，返回队头（注意这里返回了队头）（到底是队头还是出队元素？）
}
