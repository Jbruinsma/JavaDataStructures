package Hash.Tables;
import Hash.Table;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class HashTable<K, V> implements Table<K, V> {
    public ArrayList<BucketItem<K, V>>[] table;

    public HashTable(int capacity){
        this.table = new ArrayList[capacity];
    }

    @Override
    public String toString(){
        StringBuilder string = new StringBuilder();
        string.append("{");
        boolean first = true;
        for (int i = 0; i < this.table.length; i ++){
            if (this.table[i] != null){
                for (BucketItem<K, V> list : this.table[i]){
                    if (!first){
                        string.append(", ");
                    }
                    string.append(list.key).append(": ").append(list.value);
                    first = false;
                }
            }
        }
        string.append("}");
        return string.toString();
    }

    public void set(K key, V value){
        int index = this.hash(key);
        if (this.table[index] == null){
            this.table[index] = new ArrayList<>();
            this.table[index].add(new BucketItem<>(key, value));
        } else {
            for (BucketItem<K, V> list : this.table[index]) {
                if (list.key.equals(key)) {
                    list.value = value;
                    return;
                }
            }
            this.table[index].add(new BucketItem<>(key, value));
        }
    }

    public V get(K key){
        int index = this.hash(key);
        if (this.table[index] == null){
            throw new NoSuchElementException("Key not found");
        }
        for (BucketItem<K, V> list : this.table[index]){
            if (list.key.equals(key)){
                return list.value;
            }
        }
        throw new NoSuchElementException("Key not found");
    }

    public V get(K key, V replacement){
        int index = this.hash(key);
        if (this.table[index] == null){
            return replacement;
        }
        for (BucketItem<K, V> list : this.table[index]){
            if (list.key.equals(key)){
                return list.value;
            }
        }
        return replacement;
    }

    public void delete(K key){
        int index = this.hash(key);
        if (this.table[index] == null){
            return;
        }
        for (BucketItem<K, V> list : this.table[index]){
            if (list.key.equals(key)){
                this.table[index].remove(list);
                return;
            }
        }
    }

    public boolean contains(K key){
        int index = this.hash(key);
        if (this.table[index] == null){
            return false;
        }
        for (BucketItem<K, V> list : this.table[index]){
            if (list.key.equals(key)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        int size = 0;
        for (ArrayList<BucketItem<K, V>> lists : this.table) {
            if (lists != null) {
                size += lists.size();
            }
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        for (ArrayList<BucketItem<K, V>> lists : this.table) {
            if (lists != null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void clear() {
        for (int i = 0; i < this.table.length; i++) {
            if (this.table[i] != null) {
                this.table[i] = null;
            }
        }
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % table.length);
    }

    public static void main(String[] args) {
        HashTable<String, Integer> table = new HashTable<>(5);

        table.set("apple", 10);
        table.set("banana", 20);
        table.set("orange", 30);
        System.out.println(table);

        System.out.println("\napple: " + table.get("apple"));
        System.out.println("banana: " + table.get("banana"));
        System.out.println("orange: " + table.get("orange"));

        table.set("banana", 99);
        System.out.println("\nbanana (updated): " + table.get("banana"));

        table.delete("apple");
        System.out.println("\napple (after deletion): " + table.get("apple", -1));

        System.out.println("\nFinal table structure:");
        System.out.println(table);
        System.out.println("Size: " + table.size());
        System.out.println("Is empty: " + table.isEmpty());

        System.out.println("\nClearing table...");
        table.clear();
        System.out.println("Is empty: " + table.isEmpty());
        System.out.println("Final table structure:");
        System.out.println(table);
    }

}
