package adp2.implementations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import adp2.interfaces.Path;

public final class PathImpl implements Path {

    private final List<Integer> waypoints;
    private final double distance;

    protected static Path create(List<Integer> waypoints, double distance) {
        return new PathImpl(waypoints, distance);
    }

    private PathImpl(List<Integer> waypoints, double distance) {
        this.waypoints = new ArrayList<Integer>(waypoints);
        this.distance = distance;
    }

    public List<Integer> waypoints() {
        return new ArrayList<Integer>(waypoints);
    }

    public double distance() {
        return distance;
    }
	
	public int size() {
		return waypoints.size();
	}

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof PathImpl)) {
            return false;
        }
        return ((PathImpl) o).waypoints.equals(waypoints) && ((PathImpl) o).distance == distance;
    }

    @Override
    public int hashCode() {
        return (int) (41 * waypoints.hashCode() + distance);
    }

    @Override
    public String toString() {
        return "Path(" + waypoints + ", " + distance + ")";
    }
}
