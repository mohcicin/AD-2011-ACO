package adp2.implementations;

import java.util.ArrayList;
import java.util.Iterator;

import adp2.interfaces.Matrix;

public final class NaM<T> implements Matrix<T> {
    
    private static Matrix<Object> instance;
    
    protected static <T> Matrix<T> create() {
        if (instance == null) {
            instance = (NaM<Object>)new NaM<T>();
        }
        return (NaM<T>)instance;
    }
    
    private NaM() {}

    public Iterator<T> iterator() {
        return new ArrayList<T>().iterator();
    }

    public int size() {
        return 0;
    }

    public T get(int x, int y) {
        throw new IndexOutOfBoundsException();
    }
    
    @Override
    public String toString() {
        return "NaM";
    }
}
