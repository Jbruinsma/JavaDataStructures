package SearchingAndSorting.Sorting;

public class InsertionSort {
    private int[] arr;

    public InsertionSort(int[] arrArray) {
        arr = arrArray;
    }

    public void setArr(int[] arr){
        this.arr = arr;
    }

    public void insertionSort() {
        for (int i = 1; i < arr.length; i++) {
            int nextLoc = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > nextLoc) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = nextLoc;
        }
    }

    public void printArray() {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        InsertionSort insertionSort = new InsertionSort(arr);
        System.out.println("Original array:");
        insertionSort.printArray();

        insertionSort.insertionSort();

        System.out.println("Sorted array:");
        insertionSort.printArray();
    }
}
