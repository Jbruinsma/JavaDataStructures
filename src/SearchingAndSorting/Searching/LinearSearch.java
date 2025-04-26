package SearchingAndSorting.Searching;

public class LinearSearch<T> {
    private T[] arr;

    public LinearSearch(T[] array) {
        arr = array;
    }

    public void setArr(T[] arr){
        this.arr = arr;
    }

    public int search(T target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    public boolean contains(T target) {
        return search(target) != -1;
    }

    public static void main(String[] args) {
        Integer[] vals = {45, 77, 89, 90, 94, 99, 100};
        LinearSearch<Integer> integerLinearSearch = new LinearSearch<>(vals);
        System.out.println("Searching for 99 in the array [45, 77, 89, 90, 94, 99, 100]");
        System.out.println("90 is at Index: " + integerLinearSearch.search(90));
        System.out.println("Contains 5? " + integerLinearSearch.contains(5) + "\n");

        String[] names = {"Aiden", "Bella", "Carter", "Delilah", "Eliana", "Finn", "Hazel", "Leo", "Maya", "Silas"};
        LinearSearch<String> nameLinearSearch = new LinearSearch<>(names);
        System.out.println("Searching for Carter in the array [Aiden, Bella, Carter, Delilah, Eliana, Finn, Hazel, Leo, Maya, Silas]");
        System.out.println("Carter is at Index: " + nameLinearSearch.search("Carter"));
        System.out.println("Contains Maya? " + nameLinearSearch.contains("Maya") + "\n");
    }
}
