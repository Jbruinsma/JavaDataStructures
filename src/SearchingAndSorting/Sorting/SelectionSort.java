package SearchingAndSorting.Sorting;

import java.util.Arrays;

public class SelectionSort {
    private int[] arr;

    public SelectionSort(int[] arrArray) {
        arr = arrArray;
    }

    public void setArr(int[] arr){
        this.arr = arr;
    }

    public void resetArray(){
        this.arr = new int[]{42, 17, 89, 5, 23, 66, 38, 91, 14, 57};
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
            if (arr[i] > arr[largestPos]) largestPos = i;
        }
        return largestPos;
    }

    private int minPos(int startFrom) {
        int minimumPos = startFrom;
        for (int i = startFrom + 1; i < arr.length; i++) {
            if (arr[i] < arr[minimumPos]) minimumPos = i;
        }
        return minimumPos;
    }

    private void swap(int firstPos, int secondPos) {
        int temporary = arr[firstPos];
        arr[firstPos] = arr[secondPos];
        arr[secondPos] = temporary;
    }

    public static void main(String[] args){
        int[] arr = {42, 17, 89, 5, 23, 66, 38, 91, 14, 57};

        SelectionSort ss = new SelectionSort(arr);
        ss.sortIntAscending();
        System.out.println(Arrays.toString(ss.arr));

        ss.setArr(arr);
        ss.sortIntDescending();
        System.out.println(Arrays.toString(ss.arr));

    }

}

