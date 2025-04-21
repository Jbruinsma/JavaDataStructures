package Hash.Tables;

public class List<K, V> {
    public K key;
    V value;

    public List(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "[" + key + ", " + value + "]";
    }

}
