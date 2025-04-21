package SearchingAndSorting.Searching;

public class LinearSearch {
    private int[] arr;

    public LinearSearch(int[] anArray) {
        arr = anArray;
    }

    public void setArr(int[] arr){
        this.arr = arr;
    }

    public int search(int v) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == v) return i;
        }
        return -1;
    }
}
