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

    public void set(int i, T data) {
        if (data == null) {
            throw new NullPointerException("data == null");
        }
        Node<T> p = this.head.next;
        for (int j = 0; p != null && j < i; j++) {
            p = p.next;
        }
        if (i >= 0 && p != null) {
            p.data = data; // p指向第i个结点
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public int size() { // n
        int i = 0;
        for (Node<T> p = this.head.next; p != null; p = p.next) { // p遍历单链表
            i++;
        }
        return i;
    }

    public Node<T> insert(int i, T data) { // n
        // 这里对i进行容错处理，i<0则插入最前，i>n则插入最后
        if (data == null) {
            throw new NullPointerException("data == null");
        }
        Node<T> front = this.head; // front指向头结点
        for (int j = 0; front.next != null && j < i; j++) {
            front = front.next;
        }
        front.next = new Node<>(data, front.next);
        return front.next; // 返回插入结点
    }

    public T remove(int i) {
        Node<T> front = this.head;
        for (int j = 0; front.next != null && j < i; j++) {
            front = front.next;
        }
        if (i >= 0 && front.next != null) {
            T old = front.next.data;
            front.next = front.next.next;
            return old;
        }
        return null;
    }

    public Node<T> search(T key) {
        for (Node<T> p = this.head.next; p != null; p = p.next) {
            if (key.equals(p.data)) { // 执行T类的equals()方法，运行时多态
                return p;
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SinglyList<?>)) {
            return false;
        }
        Node<T> p = this.head.next;
        Node<T> q = ((SinglyList<T>) obj).head.next;
        while (p != null && q != null && p.data.equals(q.data)) {
            p = p.next;
            q = q.next;
        }
        return p == null && q == null;
    }

    @Override
    public String toString() {
        String str = this.getClass().getName() + "(";
        Node<T> temp = head;
        while (temp.next == null) {
            str += temp.next.data + ",";
            temp = temp.next;
        }
        return str + ")";
    }
}
