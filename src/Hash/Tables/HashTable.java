package Hash.Tables;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class HashTable<K, V> {
    public ArrayList<List<K, V>>[] table;

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
                for (List<K, V> list : this.table[i]){
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
            this.table[index].add(new List<>(key, value));
        } else {
            for (List<K, V> list : this.table[index]) {
                if (list.key.equals(key)) {
                    list.value = value;
                    return;
                }
            }
            this.table[index].add(new List<>(key, value));
        }
    }

    public V get(K key){
        int index = this.hash(key);
        if (this.table[index] == null){
            throw new NoSuchElementException("Key not found");
        }
        for (List<K, V> list : this.table[index]){
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
        for (List<K, V> list : this.table[index]){
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
        for (List<K, V> list : this.table[index]){
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
        for (List<K, V> list : this.table[index]){
            if (list.key.equals(key)){
                return true;
            }
        }
        return false;
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
    }

}
