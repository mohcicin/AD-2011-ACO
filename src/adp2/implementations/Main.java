package adp2.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import adp2.interfaces.Graph;
import adp2.interfaces.Matrix;
import adp2.interfaces.Simulation;

public class Main {
	public static void main(String[] args) {
		List<Integer> dist = Arrays.asList(0, 2, 10, 1, 20, 1, 20,
				3, 20, 2, 0, 2, 20, 20, 20, 20, 20, 20,
				10, 2, 0, 1, 14, 20, 20, 20, 20, 1, 20,
				1, 0, 20, 20, 20, 20, 20, 20, 20, 14, 20,
				0, 2, 20, 20, 20, 1, 20, 20, 20, 2, 0,
				3, 20, 20, 20, 20, 20, 20, 20, 3, 0, 10,
				2, 3, 20, 20, 20, 20, 20, 10, 0, 4, 20,
				20, 20, 20, 20, 20, 2, 4, 0);
		List<Integer> graphy = Arrays.asList(
				0, 1, 2, 4, 5,
				1, 0, 6, 2, 3,
				2, 6, 0, 9, 1,
				4, 2, 9, 0, 3,
				5, 3, 1, 3, 0);
		
		List<Integer> dist2 = Arrays.asList(
				0, 2, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 
				2, 0, 2, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 
				20, 2, 0, 1, 20, 20, 20, 20,
				20, 20, 20, 20, 20, 20, 20, 20, 20, 1, 0,
				3, 20, 20, 20, 20, 20, 20, 20, 20, 20,
				20, 20, 20, 20, 3, 0, 2, 20, 20, 20, 20,
				20, 20, 20, 20, 20, 20, 20, 20, 20, 2, 0,
				3, 20, 20, 20, 20, 20, 20, 20, 20, 20,
				20, 20, 20, 20, 3, 0, 2, 20, 20, 20, 20,
				20, 20, 20, 20, 20, 20, 20, 20, 20, 2, 0,
				4, 20, 20, 20, 20, 20, 20, 20, 20, 20,
				20, 20, 20, 20, 4, 0, 1, 20, 20, 20, 20,
				20, 20, 20, 20, 20, 20, 20, 20, 20, 1, 0,
				2, 20, 20, 20, 20, 20, 20, 20, 20, 20,
				20, 20, 20, 20, 2, 0, 3, 20, 20, 20, 20,
				20, 20, 20, 20, 20, 20, 20, 20, 20, 3, 0,
				1, 20, 20, 20, 20, 20, 20, 20, 20, 20,
				20, 20, 20, 20, 1, 0, 1, 20, 20, 20, 20,
				20, 20, 20, 20, 20, 20, 20, 20, 20, 1, 0,
				2, 20, 20, 20, 20, 20, 20, 20, 20, 20,
				20, 20, 20, 20, 2, 0);
		List<Integer> easy = Arrays.asList(
				0,4,
				4,0);
		List<Double> pher = new ArrayList<Double>();
		for (int i = 0; i < 225; i++) {
			pher.add(0.0);
		}
		Matrix<Integer> distM = MatrixImpl.valueOf(2, 2, easy);
		Matrix<Double> pherM = MatrixImpl.valueOf(2, 2, pher);
		Graph g = GraphImpl.valueOf(distM, pherM);
		Simulation s1 = SimulationImpl.valueOf(g, 1);
		s1.start();
	}
}