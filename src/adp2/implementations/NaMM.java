package adp2.implementations;

import java.util.ArrayList;
import java.util.Iterator;

import adp2.interfaces.*;

public class NaMM<T> implements MutableMatrix<T> {

    private static MutableMatrix<Object> instance;
    
    @SuppressWarnings("unchecked")
    protected static <T> MutableMatrix<T> create() {
        if (instance == null) {
            instance = (NaMM<Object>)new NaMM<T>();
        }
        return (NaMM<T>)instance;
    }
	
	public int size() {
		return -1;
	}

	public T get(int x, int y) {
        throw new IndexOutOfBoundsException();
	}

	public Iterator<T> iterator() {
        return new ArrayList<T>().iterator();
	}

	public void set(int x, int y, T value) {
		
	}

	public MutableMatrix<T> deepClone() {
		return create();
	}

	
	
}
