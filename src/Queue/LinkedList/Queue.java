package Queue.LinkedList;

public class Queue<T> {
    LinkedList<T> queue;

    public Queue() {
        this.queue = new LinkedList<>();
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

}
