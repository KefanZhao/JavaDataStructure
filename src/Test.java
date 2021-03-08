import chapter2.SeqList;
import chapter3.LinkedStack;
import chapter3.SeqStack;

public class Test {
    public static void main(String[] args) {
        SeqList<Integer> list = new SeqList<>(20);
        SeqStack<Integer> seqStack = new SeqStack<>(2);
        LinkedStack<Integer> linkedStack = new LinkedStack<>();
        linkedStack.push(3);
        linkedStack.push(4);
        linkedStack.push(5);
        linkedStack.push(6);
        linkedStack.push(7);
        System.out.println(linkedStack);
    }
}
