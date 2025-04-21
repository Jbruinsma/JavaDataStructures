package SearchingAndSorting.Searching;

public class BinarySearch {
    private int[] arr;

    public BinarySearch(int[] anArray) {
        arr = anArray;
    }

    public void setArr(int[] arr){
        this.arr = arr;
    }

    public int[] getArr() { return this.arr; }

    public boolean search(int[] arr, int start, int end, int key) {

        if (start > end) return false;

        int mid = start + (end - start) / 2;

        if (arr[mid] == key){ return true; }
        else if (arr[mid] > key){ return search(arr, start, mid- 1, key); }
        else { return search(arr, mid + 1, end, key); }

    }

    public static void main(String[] args){
        BinarySearch bs = new BinarySearch(new int[]{45, 77, 89, 90, 94, 99, 100});
        System.out.println(bs.search(bs.getArr(), 0, bs.getArr().length, 99));
    }

}
