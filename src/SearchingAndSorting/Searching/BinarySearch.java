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

    public Object search(int key){
        return search(arr, 0, arr.length - 1, key);
    }

    private Object search(int[] arr, int start, int end, int key) {

        if (start > end) return null;

        int mid = start + (end - start) / 2;

        if (arr[mid] == key){ return mid; }
        else if (arr[mid] > key){ return search(arr, start, mid- 1, key); }
        else { return search(arr, mid + 1, end, key); }

    }

    public static void main(String[] args){
        System.out.println("Binary Search Test: \n");
        System.out.println("Searching for 99 in the array [45, 77, 89, 90, 94, 99, 100]");
        BinarySearch bs = new BinarySearch(new int[]{45, 77, 89, 90, 94, 99, 100});
        System.out.println("99 is at Index: " + bs.search(99) + "\n");
        System.out.println("Searching for 105 in the array [45, 77, 89, 90, 94, 99, 100]");
        System.out.println("105 is at Index: " + bs.search(105));
    }

}
