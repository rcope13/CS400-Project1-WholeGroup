// --== CS400 File Header Information ==--
// Name: Rohan Nadgir
// Email: nadgir@wisc.edu
// Team: BB
// TA: Bri Cochran
// Lecturer: Gary Dahl
// Notes to Grader:

public class EnterHash<KeyType, ValueType> {
    
    private KeyType key;
    private ValueType value;
    public EnterHash next;
    public EnterHash previous;
    
    //use getters and setters for next and previous
    /*
     * created two put methods: one for clollisons, one not 
     * 
     */
    
    public  EnterHash (KeyType key, ValueType value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.previous = null;
    }
    public KeyType getKey()
    {
        return key;
    }
    public ValueType getValue()
    {
        return value;
    }
    
    public EnterHash getNext()
    {
        return next;
    }
    
    public EnterHash getPrevious()
    {
        return previous;
    }
    
    public void setNext(EnterHash next)
    {
        this.next = next;
    }
    
    public void setPrevious(EnterHash previous)
    {
        this.previous = previous;
    }
    
}
