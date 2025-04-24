package Hash.Tables;

public class BucketItem<K, V> {
    public K key;
    V value;

    public BucketItem(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "[" + key + ", " + value + "]";
    }

}
