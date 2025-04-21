package SearchingAndSorting.Sorting;

import java.util.Arrays;

public class QuickSort {
    private int[] arr;

    public QuickSort(int[] arr) {
        this.arr = arr;
    }

    public void setArr(int[] arr){
        this.arr = arr;
    }

    public int[] getArr(){
        return arr;
    }

    public void quickSort(int[] array, int startingIndex, int endingIndex){

        if(endingIndex <= startingIndex) return;

        int pivot = partition(array, startingIndex, endingIndex);
        quickSort(array, startingIndex, pivot - 1);
        quickSort(array, pivot + 1, endingIndex);

    }

    public int partition(int[] array, int startingIndex, int endingIndex){

        int pivot = array[endingIndex];
        int i = startingIndex - 1;

        for (int j = startingIndex; j <= endingIndex; j += 1){

            if (array[j] < pivot){

                i += 1;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;

            }

        }
        i += 1;
        int temp = array[i];
        array[i] = array[endingIndex];
        array[endingIndex] = temp;

        return i;

    }

    public static void main(String[] args){
        QuickSort qs = new QuickSort(new int[]{42, 17, 89, 5, 23, 66, 38, 91, 14, 57});
        qs.quickSort(qs.getArr(), 0, qs.getArr().length - 1);
        System.out.println(Arrays.toString(qs.getArr()));
    }

}
