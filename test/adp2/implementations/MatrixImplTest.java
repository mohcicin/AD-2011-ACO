package adp2.implementations;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import adp2.interfaces.Matrix;

public class MatrixImplTest {
	Matrix<Integer> matrix;
	List<Integer> list;

	@Before
	public void setUp() throws Exception {
		list = asList(
	             -1, 100,  50,  33,  25,  20,  16,  14,
	            100,  -1, 100,  50,  33,  25,  20,  16,
	             50, 100,  -1, 100,  50,  33,  25,  20,
	             33,  50, 100,  -1, 100,  50,  33,  25,
	             25,  33,  50, 100,  -1, 100,  50,  33,
	             20,  25,  33,  50, 100,  -1, 100,  50,
	             16,  20,  25,  33,  50, 100,  -1, 100,
	             14,  16,  20,  25,  33,  50, 100,  -1
	         );
	    matrix = Values.matrix(8, list);
	}

	@Test
	public void testValueOf() {

		assertEquals(Values.NaM(), Values.matrix(1, null));
		assertEquals(Values.NaM(), Values.matrix(1, new ArrayList<Integer>()));
		assertEquals(Values.NaM(), Values.matrix(1, Arrays.asList(1,2)));
		assertEquals(Values.NaM(), Values.matrix(0, Arrays.asList(1,2)));
		assertEquals(Values.NaM(), Values.matrix(2, Arrays.asList(1,2,null,1)));

		assertEquals(2, Values.matrix(2, Arrays.asList(1,2,2,1)).size());
	}

	@Test
	public void testGet() {
		matrix = Values.matrix(8, list);
		assertSame(33, matrix.get(6,3));
		assertSame(20, matrix.get(2,7));
	}

	@Test(expected=IndexOutOfBoundsException.class)
	public void testGetFailsOutOfBoundsWidth() {
	    matrix.get(9, 2);
	}

	@Test(expected=IndexOutOfBoundsException.class)
	public void testGetFailsOutOfBoundsHeight() {
	    matrix.get(4, 12);
	}
}
