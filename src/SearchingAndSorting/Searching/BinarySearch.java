package SearchingAndSorting.Searching;

public class BinarySearch<T extends Comparable<T>> {
    private T[] arr;

    public BinarySearch(T[] anArray) {
        arr = anArray;
    }

    public void setArr(T[] arr){
        this.arr = arr;
    }

    public T[] getArr() { return this.arr; }

    public Object search(T key){
        return search(arr, 0, arr.length - 1, key);
    }

    public boolean contains(T key){
        return search(arr, 0, arr.length - 1, key) != null;
    }

    private Object search(T[] arr, int start, int end, T key) {

        if (start > end) return null;

        int mid = start + (end - start) / 2;

        int comparison = arr[mid].compareTo(key);
        if (comparison == 0){ return mid; }
        else if (comparison > 0){ return search(arr, start, mid- 1, key); }
        else { return search(arr, mid + 1, end, key); }

    }

    public static void main(String[] args){
        System.out.println("Binary Search Test: \n");

        Integer[] vals = {45, 77, 89, 90, 94, 99, 100};
        System.out.println("Searching for 99 in the array [45, 77, 89, 90, 94, 99, 100]");
        BinarySearch<Integer> integerBinarySearch = new BinarySearch<>(vals);
        System.out.println("99 is at Index: " + integerBinarySearch.search(99));
        System.out.println("Contains 77? " + integerBinarySearch.contains(77) +"\n");

        String[] names = {"Aiden", "Bella", "Carter", "Delilah", "Eliana", "Finn", "Hazel", "Leo", "Maya", "Silas"};
        System.out.println("Searching for 105 in the array [Aiden, Bella, Carter, Delilah, Eliana, Finn, Hazel, Leo, Maya, Silas]");
        BinarySearch<String> nameBinarySearch = new BinarySearch<String>(names);
        System.out.println("Carter is at Index: " + nameBinarySearch.search("Carter"));
        System.out.println("Contains Maya? " + nameBinarySearch.contains("Maya") + "\n");
    }

}
