package Queue.LinkedListImplementation;

import Queue.LinkedListImplementation.LinkedList.LinkedList;
import Queue.LinkedListImplementation.LinkedList.ListNode;

public class Queue<T> {
    LinkedList<T> queue;

    public Queue() {
        this.queue = new LinkedList<>();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        ListNode<T> curr = this.queue.head;
        while (curr != null){
            sb.append(curr.getVal());
            curr = curr.getNext();
            if (curr != null){
                sb.append(", ");
            }
        }
        sb.append("]\n");
        return sb.toString();
    }

    public void push(T value){
        this.queue.append(value);
    }

    public T pop(){
        return this.queue.deleteHead();
    }

    public T peek(){
        if (this.isEmpty()){
            return null;
        } else {
            return this.queue.head.getVal();
        }
    }

    public boolean isEmpty(){
        return this.queue.head == null;
    }

    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();
        System.out.println("New Queue Initialized: \n");
        System.out.println(q);
        System.out.println("Push 1:\n");
        q.push(1);
        System.out.println(q);
        System.out.println("Push 2:\n");
        q.push(2);
        System.out.println(q);
        System.out.println("Push 3:\n");
        q.push(3);
        System.out.println(q);
        System.out.println("Pop:");
        System.out.println("Result: " + q.pop() + "\n");
        System.out.println(q);
        System.out.println("Peek:");
        System.out.println("Result: " + q.peek() + "\n");
        System.out.println(q);
        System.out.println("Is Empty? " + q.isEmpty() + "\n");
        System.out.println("Pop:");
        System.out.println("Result: " + q.pop() + "\n");
        System.out.println(q);
        System.out.println("Pop:");
        System.out.println("Result: " + q.pop() + "\n");
        System.out.println(q);
        System.out.println("Is Empty? " + q.isEmpty() + "\n");
    }

}
