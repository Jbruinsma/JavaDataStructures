package SearchingAndSorting.Sorting;

import java.util.Arrays;

public class QuickSort<T extends Comparable<T>> {
    private T[] arr;

    public QuickSort(T[] arr) {
        this.arr = arr;
    }

    public void setArr(T[] arr){
        this.arr = arr;
    }

    public String getArrString(){
        return Arrays.toString(arr);
    }

    public void sort(){
        quickSort(arr, 0, arr.length - 1);
    }

    public void quickSort(T[] array, int startingIndex, int endingIndex){

        if(endingIndex <= startingIndex) return;

        int pivot = partition(array, startingIndex, endingIndex);
        quickSort(array, startingIndex, pivot - 1);
        quickSort(array, pivot + 1, endingIndex);

    }

    public int partition(T[] array, int startingIndex, int endingIndex){

        T pivot = array[endingIndex];
        int i = startingIndex - 1;

        for (int j = startingIndex; j <= endingIndex; j += 1){

            if (array[j].compareTo(pivot) < 0){

                i += 1;
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;

            }

        }
        i += 1;
        T temp = array[i];
        array[i] = array[endingIndex];
        array[endingIndex] = temp;

        return i;

    }

    public static void main(String[] args){
        Integer[] vals = { 5, 2, 9, 1, 5, 6 };
        QuickSort<Integer> integerQuickSort = new QuickSort<>(vals);
        System.out.println("Quick Sort: \n");
        System.out.println("Before Sorting: " + integerQuickSort.getArrString() + "\n");
        integerQuickSort.sort();
        System.out.println("After Sorting: " + integerQuickSort.getArrString() + "\n");

        String[] names = {"Hazel", "Maya", "Finn", "Carter", "Silas", "Eliana", "Leo", "Bella", "Aiden", "Delilah"};
        QuickSort<String> nameQuickSort = new QuickSort<>(names);
        System.out.println("Before Sorting: " + nameQuickSort.getArrString() + "\n");
        nameQuickSort.sort();
        System.out.println("After Sorting: " + nameQuickSort.getArrString() + "\n");
    }

}
