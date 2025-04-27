package SearchingAndSorting.Sorting;

import java.util.Arrays;

public class InsertionSort<T extends Comparable<T>> {
    private T[] arr;

    public InsertionSort(T[] arrArray) {
        arr = arrArray;
    }

    public void setArr(T[] arr){
        this.arr = arr;
    }

    public void insertionSort() {
        for (int i = 1; i < arr.length; i++) {
            T nextElement = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1].compareTo(nextElement) > 0) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = nextElement;
        }
    }

    public T[] getArr() {
        return this.arr;
    }

    public static void main(String[] args) {
        Integer[] vals = {5, 2, 9, 1, 5, 6};
        System.out.println("Insertion Sort: \n");
        InsertionSort<Integer> integerInsertionSort = new InsertionSort<>(vals);
        System.out.println("Before Sorting: " + Arrays.toString(integerInsertionSort.getArr()) + "\n");
        integerInsertionSort.insertionSort();
        System.out.println("After Sorting: " + Arrays.toString(integerInsertionSort.getArr()) + "\n");

        String[] names = {"Hazel", "Maya", "Finn", "Carter", "Silas", "Eliana", "Leo", "Bella", "Aiden", "Delilah"};
        InsertionSort<String> nameInsertionSort = new InsertionSort<>(names);
        System.out.println("Before Sorting: " + Arrays.toString(nameInsertionSort.getArr()) + "\n");
        nameInsertionSort.insertionSort();
        System.out.println("After Sorting: " + Arrays.toString(nameInsertionSort.getArr()) + "\n");
    }
}
