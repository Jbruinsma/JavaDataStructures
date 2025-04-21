package Queue.LinkedList;

public class ListNode<T> {
    private T val;
    private ListNode<T> prev;
    private ListNode<T> next;

    public ListNode(T val) {
        this.val = val;
        this.prev = null;
        this.next = null;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public T getVal() {
        return val;
    }

    public void setPrev(ListNode<T> prev) {
        this.prev = prev;
    }

    public ListNode<T> getPrev() {
        return prev;
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }

    public ListNode<T> getNext() {
        return next;
    }

}
