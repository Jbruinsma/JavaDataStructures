package SearchingAndSorting.Sorting;

import java.util.Arrays;

public class SelectionSort<T extends Comparable<T>> {
    private T[] arr;

    public SelectionSort(T[] arrArray) {
        arr = arrArray;
    }

    public void setArr(T[] arr){
        this.arr = arr;
    }

    public T[] getArr(){
        return this.arr;
    }

    public void sortIntAscending() {
        for (int i = 0; i < arr.length - 1; i++) {
            int minimumPos = minPos(i);
            swap(minimumPos, i);
        }
    }

    public void sortIntDescending(){
        for (int i = 0; i < this.arr.length - 1; i ++){
            int largestPos = largestPos(i);
            swap(i, largestPos);
        }
    }

    private int largestPos(int startFrom){
        int largestPos = startFrom;
        for (int i = startFrom + 1; i < arr.length; i ++){
            if (arr[i].compareTo(arr[largestPos]) > 0) largestPos = i;
        }
        return largestPos;
    }

    private int minPos(int startFrom) {
        int minimumPos = startFrom;
        for (int i = startFrom + 1; i < arr.length; i++) {
            if (arr[i].compareTo(arr[minimumPos]) < 0) minimumPos = i;
        }
        return minimumPos;
    }

    private void swap(int firstPos, int secondPos) {
        T temporary = arr[firstPos];
        arr[firstPos] = arr[secondPos];
        arr[secondPos] = temporary;
    }

    public static void main(String[] args){
        Integer[] vals = {42, 17, 89, 5, 23, 66, 38, 91, 14, 57};
        System.out.println("Selection Sort: \n");
        SelectionSort<Integer> integerSelectionSort = new SelectionSort<>(vals);
        System.out.println("Before sorting: " + Arrays.toString(integerSelectionSort.getArr()) + "\n");
        integerSelectionSort.sortIntAscending();
        System.out.println("After sorting: " + Arrays.toString(integerSelectionSort.getArr()) + "\n");
        integerSelectionSort.sortIntDescending();
        System.out.println("Sorting in descending order: " + Arrays.toString(integerSelectionSort.getArr()) + "\n");

        String[] names = {"Hazel", "Maya", "Finn", "Carter", "Silas", "Eliana", "Leo", "Bella", "Aiden", "Delilah"};
        SelectionSort<String> nameSelectionSort = new SelectionSort<>(names);
        System.out.println("Before sorting: " + Arrays.toString(nameSelectionSort.getArr()) + "\n");
        nameSelectionSort.sortIntAscending();
        System.out.println("After sorting: " + Arrays.toString(nameSelectionSort.getArr()) + "\n");

    }

}

