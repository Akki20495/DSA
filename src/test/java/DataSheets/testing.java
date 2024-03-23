package DataSheets;

    class Solution1 {

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
        public Solution1() {
            buckets = new Entry[1000];
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            int index = key % 1000;
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

        public static void main(String[] args) {
            Solution1 a = new Solution1();
            a.put(3,5);
            a.put(3,6);

            System.out.println(a);;
        }
    }