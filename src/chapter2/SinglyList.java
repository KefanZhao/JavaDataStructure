package chapter2;

public class SinglyList<T> {
    public Node<T> head; // 头指针，表示单链表的开始，也是单链表的唯一标识

    public SinglyList() {
        this.head = new Node<T>();
    }

    public SinglyList(T[] values) {
        this();
        Node<T> rear = this.head;
        for (int i = 0; i < values.length; i++) {
            if (values[i] != null) {
                rear.next = new Node<>(values[i], null); // 尾插法
            }
        }
    }

//    public SinglyList(T[] values) {
//        this();
//        for (int i = 0; i < values.length; i++) {
//            this.head.next = new Node<>(values[i], this.head.next); // 头插法
//        }
//    }

    /*
    以下都是成员方法
     */

    public boolean isEmpty() {
        return this.head.next == null;
    }

    public T get(int i) {
        Node<T> p = this.head.next;
        for (int j = 0; p != null && j < i; j++) { // 遍历单链表，寻找第i个结点
            p = p.next;
        }
        return (i >= 0 && p != null) ? p.data : null;
    }


}
