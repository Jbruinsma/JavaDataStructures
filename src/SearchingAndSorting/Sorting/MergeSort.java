package SearchingAndSorting.Sorting;

import java.util.Arrays;

public class MergeSort<T extends Comparable<T>> {
    private T[] arr;

    public MergeSort(T[] arrArray) {
        arr = arrArray;
    }

    public void setArr(T[] arr){
        this.arr = arr;
    }

    public String getArr(){ return Arrays.toString(this.arr); }

    public void mergeSort() {
        if (arr.length <= 1) return;

        T[] firstHalf = Arrays.copyOfRange(arr, 0, arr.length / 2);
        T[] secondHalf = Arrays.copyOfRange(arr, arr.length / 2, arr.length);

        MergeSort<T> firstSort = new MergeSort<>(firstHalf);
        MergeSort<T> secondSort = new MergeSort<>(secondHalf);

        firstSort.mergeSort();
        secondSort.mergeSort();
        mergeSortedArrays(firstHalf, secondHalf);
    }

    private void mergeSortedArrays(T[] firstHalf, T[] secondHalf) {
        int firstArr = 0, secondArr = 0, j = 0;

        while (firstArr < firstHalf.length && secondArr < secondHalf.length) {
            if (firstHalf[firstArr].compareTo(secondHalf[secondArr]) <= 0) {
                arr[j++] = firstHalf[firstArr++];
            } else {
                arr[j++] = secondHalf[secondArr++];
            }
        }

        while (firstArr < firstHalf.length) {
            arr[j++] = firstHalf[firstArr++];
        }

        while (secondArr < secondHalf.length) {
            arr[j++] = secondHalf[secondArr++];
        }
    }

    public static void main(String[] args){
        Integer[] vals = {42, 17, 89, 5, 23, 66, 38, 91, 14, 57};
        System.out.println("Merge Sort: \n");
        MergeSort<Integer> integerMergeSort = new MergeSort<>(vals);
        System.out.println("Before Sorting: " + integerMergeSort.getArr() + "\n");
        integerMergeSort.mergeSort();
        System.out.println("After Sorting: " + integerMergeSort.getArr() + "\n");

        String[] names = {"Hazel", "Maya", "Finn", "Carter", "Silas", "Eliana", "Leo", "Bella", "Aiden", "Delilah"};
        MergeSort<String> nameMergeSort = new MergeSort<>(names);
        System.out.println("Before Sorting: " + nameMergeSort.getArr() + "\n");
        nameMergeSort.mergeSort();
        System.out.println("After Sorting: " + nameMergeSort.getArr() + "\n");
    }

}

