package adp2.implementations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import adp2.interfaces.Path;

public final class NaP implements Path {

    public static Path instance;

    protected static Path create() {
        if (instance == null) {
            instance = new NaP();
        }
        return instance;
    }

    private NaP() {
    }

    public List<Integer> waypoints() {
        return new ArrayList<Integer>();
    }

    public double distance() {
        return Double.NaN;
    }

    @Override
    public String toString() {
        return "NaP";
    }
	
	public int size() {
		return 0;
	}
}
