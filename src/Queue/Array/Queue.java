package Queue.Array;

import java.util.ArrayList;

public class Queue<T> {
    ArrayList<T> queue;

    public Queue(){
        this.queue = new ArrayList<>();
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

}
