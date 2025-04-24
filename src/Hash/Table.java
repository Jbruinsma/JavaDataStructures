package Hash;

public interface Table<K, V> {
    void set(K key, V value);
    V get(K key);
    V get(K key, V replacement);
    void delete(K key);
    boolean contains(K key);
    int size();
    boolean isEmpty();
    void clear();
    String toString();
}
