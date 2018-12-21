/**
 * Copyright 2018 Mercedes Benz Research & Development, A Daimler Company. All rights reserved.
 */

package z.interviewe.datastructure;

/**
 * @author Mahabir Singh
 *
 */
public class BasicHashTable<X, Y> {
    private HashEntry<X, Y>[] data;
    private int capacity;
    private int size;

    public BasicHashTable() {
        this(10);
    }

    public BasicHashTable(int tableSize) {
        this.capacity = tableSize;
        this.data = new HashEntry[this.capacity];
        this.size = 0;
    }

    public Y get(X key) {
        final int hash = calculateHash(key);
        // if we don't have anything for key , return null
        if (data[hash] == null) {
            return null;
        } else {
            return data[hash].getValue();
        }
    }

    public void put(X key, Y value) {
        final int hash = calculateHash(key);

        data[hash] = new HashEntry<>(key, value);
        size++;
    }

    public Y delete(X key) {
        final Y value = get(key);
        if (value == null) {
            return value;
        }
        int hash = calculateHash(key);
        data[hash] = null;
        size--;

        hash = (hash + 1) % this.capacity;
        // If the next slot isn't empty we should re add it so we can keep the hash algorithms clean
        while (data[hash] != null) {
            final HashEntry<X, Y> he = data[hash];
            data[hash] = null;
            put(he.getKey(), he.getValue());
            // we repositioned the hash item and didn't really add a new one so bake of the size
            size--;
            hash = (hash + 1) % this.capacity;
        }
        return value;
    }

    public boolean hashKey(X key) {
        final int hash = calculateHash(key);

        if (data[hash] == null) {
            return false;
        } else if (data[hash].getKey().equals(key)) {
            return true;
        }
        return false;
    }

    public boolean hashValue(Y value) {
        // loop through all the hash entry
        for (int i = 0; i < capacity; i++) {
            final HashEntry<X, Y> entry = data[i];
            // If this head entry isn't null and the value equals the one passed in, the hashtable has this value
            if ((entry != null) && entry.getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }

    public int calculateHash(X key) {
        int hash = key.hashCode() % this.capacity;
        // this is necessary to deal with collection
        while ((data[hash] != null) && !data[hash].getKey().equals(key)) {
            hash += (hash + 1) % this.capacity;
        }
        return hash;
    }

    public int size() {
        return this.size;
    }

    private class HashEntry<X, Y> {
        private X key;
        private Y value;

        public HashEntry(X key, Y value) {
            this.key = key;
            this.value = value;
        }

        public X getKey() {
            return key;
        }

        public void setKey(X key) {
            this.key = key;
        }

        public Y getValue() {
            return value;
        }

        public void setValue(Y value) {
            this.value = value;
        }

    }

}
