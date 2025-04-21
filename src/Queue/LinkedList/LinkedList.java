package Queue.LinkedList;

public class LinkedList<T> {
    ListNode<T> head;
    ListNode<T> tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public void append(T value){
        ListNode<T> newNode = new ListNode<>(value);
        if (this.head == null){
            this.head = newNode;

        } else {
            this.tail.setNext(newNode);
        }
        this.tail = newNode;
    }

    public T deleteHead(){
        if (this.head == null){
            return null;
        } else {
            ListNode<T> temp = this.head;
            this.head = this.head.getNext();
            return temp.getVal();
        }
    }

}
