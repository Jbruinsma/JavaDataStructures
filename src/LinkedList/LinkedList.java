package LinkedList;

import java.util.ArrayList;

public class LinkedList<T extends Comparable<T>> {
    ListNode<T> head;

    public LinkedList(){
        this.head = null;
    }

    public LinkedList(T val){
        if (val != null) {
            this.head = new ListNode<T>(val);
        }
    }

    public LinkedList(T[] array){
        if (array.length > 0){
            this.head = new ListNode<T>(array[0]);
            for (int i = 1; i < array.length; i ++){
                this.append(array[i]);
            }
        }
    }

    public void append(T val){
        if (val != null) {
            if (this.isEmpty()) {
                this.head = new ListNode<T>(val);
            } else {
                ListNode<T> tail = this.iterate();
                ListNode<T> newNode = new ListNode<T>(val);
                assert tail != null;
                tail.setNext(newNode);
                newNode.setPrev(tail);
            }
        }
    }

    public void prepend(T val){
        if (this.isEmpty()){
            this.head = new ListNode<T>(val);
        } else {
            ListNode<T> currHead = this.head;
            ListNode<T> newNode = new ListNode<T>(val);
            currHead.setPrev(newNode);
            newNode.setNext(currHead);
            this.head = newNode;
        }
    }

    public void insertAt(int index, T val){
        if (val != null){
            this.verifyIndex(index);
            if (index == 0){
                this.prepend(val);
            } else {
                ListNode<T> newNode = new ListNode<T>(val);
                ListNode<T> currNodeAtIndex = this.iterate(index);
                assert currNodeAtIndex != null;
                ListNode<T> currNodeAtIndexPrev = currNodeAtIndex.getPrev();
                if (currNodeAtIndexPrev != null) {
                    currNodeAtIndexPrev.setNext(newNode);
                }
                newNode.setPrev(currNodeAtIndexPrev);
                newNode.setNext(currNodeAtIndex);
                currNodeAtIndex.setPrev(newNode);
            }
        }
    }

    public T remove(T val){
        if (val != null) {
            if (this.isEmpty()) {
                return null;
            } else {
                ListNode<T> curr = this.head;
                while(curr != null){
                    if (curr.getVal().equals(val)){
                        this.removeNode(curr);
                        return val;
                    }
                    curr = curr.getNext();
                }
            }
        }
        return null;
    }

    public T removeAt(int index){
        this.verifyIndex(index);
        if (this.isEmpty()){
            return null;
        } else{
            ListNode<T> nodeAtIndex = this.iterate(index);
            assert nodeAtIndex != null;
            T nodeVal = nodeAtIndex.getVal();
            this.removeNode(nodeAtIndex);
            return nodeVal;
        }
    }

    public void clear(){
        this.head = null;
    }

    public void reverse(){
        if (!this.isEmpty()){
            ListNode<T> tail = this.iterate();
            ListNode<T> curr = tail;
            while (curr != null){
                this.swapPointers(curr);
                curr = curr.getNext();
            }
            this.head = tail;
        }
    }

    public ListNode<T> getNodeAt(int index){
        this.verifyIndex(index);
        if (this.isEmpty()){
            return null;
        } else {
            return this.iterate(index);
        }
    }

    public T find(T val){
        if (val != null){
            if (!this.isEmpty()){
                ListNode<T> curr = this.head;
                while (curr != null){
                    if (curr.getVal().equals(val)){
                        return val;
                    }
                    curr = curr.getNext();
                }
            }
        }
        return null;
    }

    public boolean contains(T val){
        if (val != null){
            if (!this.isEmpty()){
                ListNode<T> curr = this.head;
                while (curr != null){
                    if (curr.getVal().equals(val)){
                        return true;
                    }
                    curr = curr.getNext();
                }
            }
        }
        return false;
    }

    public boolean isEmpty(){
        return this.head == null;
    }

    public int size(){
        if (this.isEmpty()){
            return 0;
        } else{
            int count = 0;
            ListNode<T> curr = this.head;
            while (curr != null){
                curr = curr.getNext();
                count += 1;
            }
            return count;
        }
    }

    public ArrayList<T> toArrayList(){
        ArrayList<T> array = new ArrayList<>();
        ListNode<T> curr = this.head;
        while (curr != null){
            array.add(curr.getVal());
            curr = curr.getNext();
        }
        return array;
    }

    @Override
    public String toString(){
        if (this.isEmpty()){
            return " ";
        } else {
            StringBuilder llStr = new StringBuilder();
            ListNode<T> curr = this.head;
            while (curr != null){
                llStr.append(curr.getVal());
                curr = curr.getNext();
                if (curr != null){
                    llStr.append(" <--> ");
                }
            }
            return llStr.toString();
        }
    }

    private ListNode<T> iterate(){
        if (!this.isEmpty()){
            ListNode<T> curr = this.head;
            while (curr.getNext() != null){
                curr = curr.getNext();
            }
            return curr;
        }
        return null;
    }

    private ListNode<T> iterate(int index){
        if (!this.isEmpty()) {
            this.verifyIndex(index);
            int count = 0;
            ListNode<T> curr = this.head;
            while (count < index){
                curr = curr.getNext();
                count += 1;
            }
            return curr;
        }
        return null;
    }

    private void verifyIndex(int index){
        int length = this.size();
        if (index < 0 || index >= length){
            throw new IllegalArgumentException("Index is invalid. Index must be greater than 0 and less than " + length);
        }
    }

    private void removeNode(ListNode<T> node){
        ListNode<T> nodePrev = node.getPrev();
        ListNode<T> nodeNext = node.getNext();
        if (nodePrev != null){
            nodePrev.setNext(nodeNext);
        }
        if (nodeNext != null){
            nodeNext.setPrev(nodePrev);
        }
    }

    private void swapPointers(ListNode<T> node){
        ListNode<T> nodePrev = node.getPrev();
        ListNode<T> nodeNext = node.getNext();
        node.setPrev(nodeNext);
        node.setNext(nodePrev);
    }

    public static void main(String[] args){
        Integer[] vals = {1, 2, 3};
        LinkedList<Integer> ll = new LinkedList<>(vals);
        ll.reverse();
        System.out.println(ll);
        System.out.println(ll.toArrayList());
    }
}