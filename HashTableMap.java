// --== CS400 File Header Information ==--
// Name: Rohan Nadgir
// Email: nadgir@wisc.edu
// Team: BB
// TA: Bri Cochran
// Lecturer: Gary Dahl
// Notes to Grader:

import java.util.NoSuchElementException;

public class HashTableMap<KeyType, ValueType> implements MapADT<KeyType, ValueType> {

    private int capacity;
    private int size;
    EnterHash<KeyType, ValueType>[] hashArray;
    EnterHash next;

    public HashTableMap(int capacity) {
        this.capacity = capacity;
        size = 0;
        hashArray = new EnterHash[capacity];
        this.next = null;
    }

    public HashTableMap() {
        this.capacity = 10;
        size = 0;
        hashArray = new EnterHash[capacity];
        this.next = null;
    }

    @Override
    public boolean put(KeyType key, ValueType value) {
        int hashIndex = Math.abs(key.hashCode()) % hashArray.length;
        EnterHash head = hashArray[hashIndex];

        while (head != null) {
            if (head.getKey().equals(key)) {
                return false;
            }
            head = head.next;
        }

        EnterHash newEntry = new EnterHash(key, value);
        head = hashArray[hashIndex];
        newEntry.next = head;
        hashArray[hashIndex] = newEntry;
        size++;

        if ((double) size / capacity >= 0.8) {
            rehash();
        }
        return true;

    }

    @Override
    public ValueType get(KeyType key) throws NoSuchElementException {
        int hashValue = key.hashCode();
        int hashKey = Math.abs(hashValue % capacity);

        if (containsKey(key) == false) {
            throw new NoSuchElementException("No Such Element.");
        } else {
            if (hashArray[hashKey].getKey().equals(key)) {
                return (ValueType) hashArray[hashKey].getValue();
            } else {
                return assistGetMethod(key);
            }
        }

    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean containsKey(KeyType key) {
        int hashValue = key.hashCode();
        int hashKey = Math.abs(hashValue % capacity);
        EnterHash hashTableHead = hashArray[hashKey];
        while(hashTableHead != null) {
            if(hashTableHead.toString().equals(key.toString())) {
                return true;
            }
            hashTableHead = hashTableHead.next;
        }
        
        return false;
        
    }

    @Override
    public ValueType remove(KeyType key) {
        int hashKey = Math.abs(key.hashCode() % capacity);
        if (containsKey(key) == false) {
            return null;
        }

        if (key.equals(hashArray[(int) hashKey].getKey())) {
            EnterHash temp = hashArray[(int) hashKey];
            hashArray[(int) hashKey] = null;
            this.size--;
            return (ValueType) temp.getValue();
        } 
        else if (hashArray[(int) hashKey].getNext() != null) {
            EnterHash temp = hashArray[(int) hashKey];
            return assistRemoveMethod(temp, key, hashKey);
        }
        return null;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            hashArray[i] = null;
            this.size--;
        }
    }

    private void rehash() {
        EnterHash[] oldHashArray = hashArray;
        hashArray = new EnterHash[2 * oldHashArray.length];
        size = 0;
        for (int i = 0; i < oldHashArray.length; i++) {
            EnterHash current = oldHashArray[i];
            if (current != null) {
                put((KeyType) current.getKey(), (ValueType) current.getValue());
            }
        }
    }

    private ValueType assistGetMethod(KeyType key) {
        int hashValue = key.hashCode();
        int hashKey = Math.abs(hashValue % capacity);
        EnterHash testVar = hashArray[hashKey].getNext();
        if (((KeyType) testVar.getKey()).equals(key)) {
            return (ValueType) testVar.getValue();
        } else {
            assistGetMethod(key);
        }
        return null;
    }


    private ValueType assistRemoveMethod(EnterHash test, KeyType key, int hashKey) {
        test = test.getNext();
        if (key.equals(test.getKey())) {
            EnterHash temp = test;
            if (test.getNext() == null) {
                test.getPrevious().setNext(null);
            } else {
                test.getPrevious().setNext(test.getNext());
                test.getNext().setPrevious(test.getPrevious());
            }
            this.size--;
            return (ValueType) temp.getValue();
        } else if (test.getNext() != null) {
            test = test.getNext();
            if (assistRemoveMethod(test, key, hashKey) != null) {
                return assistRemoveMethod(test, key, hashKey);
            } else {
                assistRemoveMethod(test, key, hashKey);
            }
        }
        return null;
    }


}
