package Hash.Maps;

import Hash.Tables.HashTable;

public class HashMap<K, V> {
    HashTable<K, V> table;

    public HashMap(int capacity){
        this.table = new HashTable<>(capacity);
    }

    @Override
    public String toString(){
        return this.table.toString();
    }

    public void set(K key, V value){
        this.table.set(key, value);
    }

    public void remove(K key){
        this.table.delete(key);
    }

    public V get(K key){
        return this.table.get(key);
    }

    public V get(K key, V replacement){
        return this.table.get(key, replacement);
    }

    public boolean contains(K key){
        return this.table.contains(key);
    }

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>(5);

        System.out.println("Adding name = Alice");
        map.set("name", "Alice");
        System.out.println(map);

        System.out.println("\nAdding city = New York");
        map.set("city", "New York");
        System.out.println(map);

        System.out.println("\nAdding age = 25");
        map.set("age", "25");
        System.out.println(map);

        System.out.println("\nUpdating age = 26");
        map.set("age", "26");
        System.out.println(map);

        System.out.println("\nContains name? " + map.contains("name"));
        System.out.println("Contains country? " + map.contains("country"));

        System.out.println("\nRemoving city");
        map.remove("city");
        System.out.println(map);

        System.out.println("\nGet name: " + map.get("name"));
        System.out.println("Get city (default = N/A): " + map.get("city", "N/A"));
    }


}
