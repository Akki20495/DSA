package DataSheets;

public class MyHashMap {
    private static final int SIZE = 5;
    private Entry[] buckets;

    private static class Entry {
        int key;
        int value;
        Entry next;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    /** Initialize your data structure here. */
    public MyHashMap() {
        buckets = new Entry[SIZE];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = key % SIZE;
        Entry entry = buckets[index];

        if (entry == null) {
            buckets[index] = new Entry(key, value);
            return;
        }

        while (entry.next != null) {
            if (entry.key == key) {
                entry.value = value; // Update existing key
                return;
            }
            entry = entry.next;
        }

        if (entry.key == key) {
            entry.value = value; // Update existing key
        } else {
            entry.next = new Entry(key, value); // Add new entry
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = key % SIZE;
        Entry entry = buckets[index];

        while (entry != null) {
            if (entry.key == key) {
                return entry.value;
            }
            entry = entry.next;
        }

        return -1; // Key not found
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = key % SIZE;
        Entry entry = buckets[index];
        Entry prev = null;

        while (entry != null) {
            if (entry.key == key) {
                if (prev == null) {
                    buckets[index] = entry.next; // Remove first entry in bucket
                } else {
                    prev.next = entry.next; // Remove entry from linked list
                }
                return;
            }
            prev = entry;
            entry = entry.next;
        }
    }


    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();

        // Put key-value pairs
        hashMap.put(1, 100);
        hashMap.put(2, 200);
        hashMap.put(6, 300);
        hashMap.put(11, 400);

        // Get values
         System.out.println("Value for key 1: " + hashMap.get(1)); // Output: 100
        System.out.println("Value for key 2: " + hashMap.get(2)); // Output: 200
        System.out.println("Value for key 3: " + hashMap.get(3)); // Output: 300

        // Remove a key-value pair
        hashMap.remove(11);
        System.out.println("Value for key 2 after removal: " + hashMap.get(1)); // Output: -1
    }
}
