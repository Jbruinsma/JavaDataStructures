package Heap.Array;

import java.util.ArrayList;

public class Heap<T extends Comparable<T>> {
    ArrayList<T> heap;

    public Heap(){
        this.heap = new ArrayList<T>();
    }

    @Override
    public String toString(){
        return "\n" + this.heap.toString();
    }

    public int len(){
        return this.heap.size();
    }

    public T getMin(){
        this.swap(0, this.len() - 1);
        T minVal = this.heap.removeLast();
        this.bubble_down(0);
        return minVal;
    }

    public void insert(T val){
        if (val != null){
            int index = this.len();
            this.heap.add(val);
            this.bubble_up(index);
        }
    }

    public void bubble_up(int index){
        int parentIndex = (index - 1) / 2;
        while (index > 0 && this.heap.get(parentIndex).compareTo(this.heap.get(index)) > 0){
            this.swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    public void bubble_down(int index){
        while (true){
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            int smallestChildIndex = index;

            if (leftChildIndex < this.len() && this.heap.get(leftChildIndex).compareTo(this.heap.get(smallestChildIndex)) < 0){
                smallestChildIndex = leftChildIndex;
            }
            if (rightChildIndex < this.len() && this.heap.get(rightChildIndex).compareTo(this.heap.get(smallestChildIndex)) < 0){
                smallestChildIndex = rightChildIndex;
            }
            if (smallestChildIndex == index){ break; }
            this.swap(index, smallestChildIndex);
            index = smallestChildIndex;
        }
    }

    private void swap(int index1, int index2){
        T temp = this.heap.get(index1);
        this.heap.set(index1, this.heap.get(index2));
        this.heap.set(index2, temp);
    }

    public static void main(String[] args){
        Heap<Integer> heap = new Heap<>();
        int[] vals = {5, 2, 10, 7, 1, 25, 3};
        for (int val : vals){
            heap.insert(val);
            System.out.println(heap);
        }

        System.out.println("\nMIN VAL: " + heap.getMin());
        System.out.println(heap);

    }

}
