package GeekBrains.JDK.Seminar3;

public class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }

    public static void main(String[] args) {
        Pair<String, Integer> instancePair = new Pair<>("key", 1);
        System.out.println(instancePair.getKey()); // key
        System.out.println(instancePair.getValue()); // 1
        System.out.println(instancePair); // Pair{key=key, value=1}
    }
}
