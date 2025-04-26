package Queue.ArrayImplementation;

import java.util.ArrayList;

public class Queue<T> {
    ArrayList<T> queue;

    public Queue(){
        this.queue = new ArrayList<>();
    }

    @Override
    public String toString(){
        return this.queue.toString() + "\n";
    }

    public void push(T value){
        this.queue.add(value);
    }

    public T pop(){
        if (this.isEmpty()){
            return null;
        } else {
            return this.queue.removeFirst();
        }
    }

    public T peek(){
        if (this.isEmpty()){
            return null;
        } else {
            return this.queue.get(0);
        }
    }

    public boolean isEmpty(){
        return this.queue.isEmpty();
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
