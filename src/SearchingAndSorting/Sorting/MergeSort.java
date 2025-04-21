package SearchingAndSorting.Sorting;

import java.util.Arrays;

public class MergeSort {
    private int[] arr;

    public MergeSort(int[] arrArray) {
        arr = arrArray;
    }

    public void setArr(int[] arr){
        this.arr = arr;
    }

    public String getArr(){ return Arrays.toString(this.arr); }

    public void mergeSort() {
        if (arr.length <= 1) return;

        int[] firstHalf = new int[arr.length / 2];
        int[] secondHalf = new int[arr.length - firstHalf.length];

        System.arraycopy(arr, 0, firstHalf, 0, firstHalf.length);
        System.arraycopy(arr, firstHalf.length, secondHalf, 0, secondHalf.length);

        MergeSort firstSort = new MergeSort(firstHalf);
        MergeSort secondSort = new MergeSort(secondHalf);

        firstSort.mergeSort();
        secondSort.mergeSort();
        mergeSortedArrays(firstHalf, secondHalf);
    }

    private void mergeSortedArrays(int[] firstHalf, int[] secondHalf) {
        int firstArr = 0, secondArr = 0, j = 0;

        while (firstArr < firstHalf.length && secondArr < secondHalf.length) {
            if (firstHalf[firstArr] <= secondHalf[secondArr]) {
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
        MergeSort ms = new MergeSort(new int[]{42, 17, 89, 5, 23, 66, 38, 91, 14, 57});
        ms.mergeSort();
        System.out.println(ms.getArr());
    }

}

