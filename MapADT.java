// --== CS400 File Header Information ==--
// Name: Rohan Nadgir
// Email: nadgir@wisc.edu
// Team: BB
// TA: Bri Cochran
// Lecturer: Gary Dahl
// Notes to Grader:

import java.util.NoSuchElementException;

public interface MapADT<KeyType,ValueType> {
    public boolean put(KeyType key, ValueType value);
    public ValueType get(KeyType key) throws NoSuchElementException;
    public int size();
    public boolean containsKey(KeyType key);
    public ValueType remove(KeyType key);
    public void clear();
}
