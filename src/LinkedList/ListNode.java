package LinkedList;

public class ListNode<T extends Comparable<T>>{
    private T val;
    private ListNode<T> prev;
    private ListNode<T> next;

    public ListNode(T val){
        this.val = val;
        this.prev = null;
        this.next = null;
    }

    public T getVal() { return this.val; }

    public ListNode<T> getPrev() { return this.prev; }

    public ListNode<T> getNext() { return this.next; }

    public void setVal(T val) { this.val = val; }

    public void setPrev(ListNode<T> prev) { this.prev = prev; }

    public void setNext(ListNode<T> next) { this.next = next; }

    public int compareTo(ListNode<T> other) { return this.val.compareTo(other.getVal()); }

}
