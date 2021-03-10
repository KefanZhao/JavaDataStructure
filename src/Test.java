import chapter2.SeqList;
import chapter2.SinglyList;
import chapter3.LinkedStack;
import chapter3.SeqQueue;
import chapter3.SeqStack;

public class Test {
    public static void main(String[] args) {
        SeqList<Integer> list = new SeqList<>(20);
        SeqStack<Integer> seqStack = new SeqStack<>(2);
        LinkedStack<Integer> linkedStack = new LinkedStack<>();
        SeqQueue<Integer> seqQueue = new SeqQueue<>();
        seqQueue.add(3);
        seqQueue.add(4);
        seqQueue.add(5);
        seqQueue.add(6);
        seqQueue.add(7);
        System.out.println(seqQueue);
        System.out.println(seqQueue.peek());
        System.out.println(seqQueue);
        System.out.println(seqQueue.poll());
        System.out.println(seqQueue);
    }
}
