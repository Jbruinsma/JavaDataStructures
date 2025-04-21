package Hash.Sets;

import Hash.Tables.HashTable;

public class Set {
    HashTable<Integer, Boolean> table;

    public Set(int capacity){
        this.table = new HashTable<>(capacity);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("{");
        boolean first = true;
        for (int i = 0; i < table.table.length; i++) {
            if (table.table[i] != null) {
                for (Hash.Tables.List<Integer, Boolean> item : table.table[i]) {
                    if (!first) out.append(", ");
                    out.append(item.key);
                    first = false;
                }
            }
        }
        out.append("}");
        return out.toString();
    }

    public void add(int val){
        this.table.set(val, true);
    }

    public void remove(int val){
        this.table.delete(val);
    }

    public boolean contains(int val){
        return this.table.contains(val);
    }

    public static void main(String[] args) {
        Set set = new Set(5);

        System.out.println("Initial set: " + set);

        System.out.println("\nAdding 10");
        set.add(10);
        System.out.println(set);

        System.out.println("\nAdding 20");
        set.add(20);
        System.out.println(set);

        System.out.println("\nAdding 30");
        set.add(30);
        System.out.println(set);

        System.out.println("\nAdding 10 again");
        set.add(10);
        System.out.println(set);

        System.out.println("\nContains 20? " + set.contains(20));
        System.out.println("Contains 40? " + set.contains(40));

        System.out.println("\nRemoving 20");
        set.remove(20);
        System.out.println(set);

        System.out.println("\nContains 20? " + set.contains(20));

        System.out.println("\nFinal Set: " + set);
    }

}
