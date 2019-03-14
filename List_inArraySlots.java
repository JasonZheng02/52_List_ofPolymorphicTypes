/**
  Implement a list of diverse types, including
  integers, double-precision floating point numbers,
  and Strings.
 */

public class List_inArraySlots {

    private Object[] list;
    private int filledElements; // the number of elements in this list

    private static final int INITIAL_CAPACITY = 10;
    public static final int INTEGER = 0;
    public static final int DOUBLE = 1;
    public static final int STRING = 2;

    /**
      Construct an empty list with a small initial capacity.
     */
    public List_inArraySlots() {
        list = new Object[INITIAL_CAPACITY];
    }


    /**
      @return the number of elements in this list
     */
    public int size() {
        return filledElements;
    }

    public Object get( int index ) {
        return list[index];
    }
        
     /**
       @return a string representation of this list,
       in [a,b,c,] format
      */
    public String toString() {
	String result = "[";
    for( int index = 0; index < filledElements; index++)
        result += list[index] + ",";
	return result + "]";
    }


    /**
      Appends @value to the end of this list.
      @return true, in keeping with conventions yet to be discussed
     */
    
    //New add method
    public boolean add( Object element){
        if (filledElements == list.length){
            expand();
        }
        
        list[filledElements] = element;
        
        filledElements++;
        return true;
    }
    
    //Old add method
    public boolean add( int type   // same meaning as in typeOfElements
                      , int    intValue
                      , double doubleValue
                      , String stringValue
                      ) {
        if (filledElements == list.length) {
            expand();
        }
        
        if (type == INTEGER)
            list[filledElements] = intValue;
        else if (type == DOUBLE)
            list[filledElements] = doubleValue;
        else
            list[filledElements] = stringValue;
        
        filledElements++;
        return true;
    }

    /**
      Double the capacity of the List_inArraySlots,
      preserving existing data.
     */
    private void expand() {
        System.out.println( "expand... (for debugging)");
            /* S.O.P. rules for debugging:
            Working methods should be silent. But during
            development, the programmer must verify that
            this method is called when that is appropriate.
            So test using the println(), then comment it out.
            */
        Object[] bigger = new Object[list.length * 2];
        for (int index = 0;index < list.length; index++){
            bigger[index] = list[index];
        }
        list = bigger;
    }
}
