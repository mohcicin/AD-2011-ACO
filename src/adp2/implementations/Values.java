package adp2.implementations;

import adp2.algorithms.AntColonisationOptimation;
import adp2.algorithms.BruteForceTSP;
import adp2.algorithms.interfaces.TravelingSalesMan;
import java.util.ArrayList;
import java.util.List;

import adp2.interfaces.Ant;
import adp2.interfaces.Graph;
import adp2.interfaces.Matrix;
import adp2.interfaces.MutableMatrix;
import adp2.interfaces.Path;
import adp2.interfaces.PheromoneElement;

/**
 * Factory class
 * 
 */
public final class Values {

    private Values() {
    }

//    /**
//     * Create a brute force TSP
//     * 
//     * @return brute force TSP
//     */
//    public static TSP bruteForceTSP() {
//        return BruteForceTSP.create();
//    }

	/**
	 * Create a Matrix with given dimensions and values.
	 * 
	 * @param size
         *          the size
	 * @param values
	 *            the values (the first n elements are the first row, the
	 *            following the second one and so forth)
	 * @return a valid Matrix object or NaM if any argument is or contains null
	 *         or values.size() != width*height
	 */
	public static <T> Matrix<T> matrix(int size, List<T> values) {
		if (values == null || values.size() != size*size || values.contains(null))
			return NaM();
		return immutableMatrix(size, values);
	}

    /**
     * Create a Matrix with given dimensions and values.
     * 
     * @param width
     *            the width
     * @param height
     *            the height
     * @param values
     *            the values (the first n elements are the first row, the
     *            following the second one and so forth)
     * @return a valid Matrix object or NaM if any argument is or contains null
     *         or values.size() != width*height
     */
	public static <T> MutableMatrix<T> mutableMatrix(int size, List<T> values) {
		if (values == null || values.size() != size * size
				|| values.contains(null))
			return NaMM();
		return MutableMatrixImpl.create(size, values);
	}

    /**
     * Not a Matrix
     * 
     * @return Not a Matrix
     */
    public static <T> Matrix<T> NaM() {
        return NaM.create();
    }

    /**
     * Not a Mutable Matrix
     * 
     * @return Not a Mutable Matrix
     */
    public static <T> MutableMatrix<T> NaMM() {
        return NaMM.create();
    }

    /**
     * Not a Graph
     * 
     * @return Not a Graph
     */
    public static Graph NaG() {
        return NaG.create();
    }

    /**
     * Not an Ant
     * 
     * @return Not an Ant
     */
    public static Ant NaA() {
        return NaA.create();
    }

    /**
     * Not a Path
     * 
     * @return Not a Path
     */
    public static Path NaP() {
        return NaP.create();
    }

//    /**
//     * Not a Simulation
//     * 
//     * @return Not a Simulation
//     */
//    public static Simulation NaS() {
//        return NaS.create();
//    }
//
//    /**
//     * Not a Traveling Salesman Problem
//     * @return Not a Traveling Salesman Problem
//     */
//    public static TSP NaTSP() {
//        return NaTSP.create();
//    }

    /**
     * Not a PheromoneElement
     * @return not a PheromoneElement
     */
    public static PheromoneElement NaPE() {
        return NaPE.create();
    }

    /**
     * Create a simulation with a defined number of ants in total starting step
     * by step
     * 
     * @param graph
     * @param antsQuantity
     *            total number of ants in the graph
     * @param antsByStep
     *            number of ants, pushed at every step
     * 
     * @return Simulation
     * 
     */
    public static TravelingSalesMan tsmACO(Graph graph, int antsQuantity, int antsByStep, double alpha, int pheromoneDecrease, int pheromoneIntensity) {
//        if (antsQuantity < 0 || antsByStep < 0 || alpha < 0 || alpha > 1) {
//            return Values.NaS();
//        }
        return AntColonisationOptimation.create(graph, antsQuantity, antsByStep, alpha, pheromoneDecrease, pheromoneIntensity);
    }
	
	public static TravelingSalesMan tsmBF(Matrix<Double> matrix) {
        return BruteForceTSP.create(matrix);
    }

    /**
     * Create a Path
     * 
     * @param waypoints
     *            the waypoints in order of traversal
     * @param distance
     *            the total distance of the path
     * @return a valid Path object or Path(EmptyList, -1) if waypoints is or
     *         contains null or if distance is negative
     */
    public static Path path(List<Integer> waypoints, double distance) {
        if (waypoints == null || waypoints.contains(null) || distance < 0) {
            return NaP();
        }
        return PathImpl.create(waypoints, distance);
    }

    /**
     * Create a Graph from Array
     * 
     * @param args
     *            the array from which the Graph will be created
     * @return a valid Graph Object
     */
	public static Graph graphFromList(double... args) {
		if (!graphPreCheck(args)) {
			return NaG();
		}
		List<Double> l = new ArrayList<Double>();
		for (Double elem : args) {
			l.add(elem);
		}
		MutableMatrix<Double> m = mutableMatrix((int) Math.sqrt(args.length), l);

		return graph(m);
	}

    /**
     * PreConditionCheck for the Method "graphFromList"
     * 
     * @param args
     *            the array from which the Graph will be created
     * @return a boolean to show if given Array is valid
     */
    private static boolean graphPreCheck(double[] x) {
        double i = Math.floor(Math.sqrt(x.length));
        if (i == Math.sqrt(x.length)) {
            return true;
        }
        return false;
    }

    /**
     * Create a new ant -> public for testing purposes only -> should be package
     * private
     * 
     * @param startNode
     * @param alpha
     * @param g
     * @return Ant
     */
    public static Ant ant(int startNode, Graph g) {
        return AntImpl.create(startNode, g);
    }

    public static Ant ant(Graph g) {
        return AntImpl.create(g);
    }

    /**
     * Create a new Graph
     * 
     * @param matrix
     * @return Graph
     */
    public static Graph graph(Matrix<Double> matrix) {
        return GraphImpl.create(matrix);
    }

    /**
     * Create a new ImmutableMatrixImpl<E>
     * 
     * @param width
     * @param height
     * @param values
     * @return ImmutableMatrixImpl<E>
     */
	public static <E> ImmutableMatrixImpl<E> immutableMatrix(int size, List<E> values) {
		return ImmutableMatrixImpl.create(size, values);
	}

    /**
     * Create a new display
     * 
     * @param g
     * @return Display
     */
    public static Display display(Graph g) {
        return Display.create(g);
    }

    /**
     * Creates a display only containing the given path
     * 
     * @param g
     * @param p
     * @return Display
     */
    public static Display display(Graph g, Path p) {
        return Display.create(g, p);
    }

    public static PrintGraph printableGraph(Graph g) {
        return PrintGraph.create(g);
    }

    public static <E extends Comparable<? super E>> PermutationIterator<E> permutationIterator(
            List<E> l) {
        return PermutationIterator.create(l);
    }

    /**
     * not a PheromoneElement
     * @param from
     * @param to
     * @param pheromone
     * @return not a PheromoneElement
     */
    public static PheromoneElement pheromoneElement(int from, int to,
            double pheromone) {
        if (from <= 0 || to <= 0 || pheromone < 0) {
            return NaPE();
        }
        return PheromoneElementImpl.valueOf(from, to, pheromone);
    }
//
//    /**
//     * Solving the TSP with the ant-algorithm
//     * @return AcoTsp
//     */
//    public static TSP acoTSP() {
//        return AcoTSP.create();
//    }
//
//    public static TSP acoTSP(int antsQuantity, int antsByStep) {
//        if (antsQuantity < 0 || antsByStep < 0) {
//            return NaTSP();
//        }
//        return AcoTSP.create(antsQuantity, antsByStep);
//    }
//
//    /**
//     * TSP ant algorithm
//     * @param antsQuantity
//     * @param antsByStep
//     * @param number
//     * @param runForSeconds    determines whether number is the maximum of seconds (true) or steps (false)
//     * @return AcoTSP
//     */
//    public static TSP acoTSP(int antsQuantity, int antsByStep, int number, boolean runForSeconds) {
//        if (antsQuantity < 0 || antsByStep < 0 || number < 0) {
//            return NaTSP();
//        }
//        return AcoTSP.create(antsQuantity, antsByStep, number, runForSeconds);
//    }
}
