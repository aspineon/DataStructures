package org.coursera.princeton.algorithms.week2.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.coursera.princeton.algorithms.week2.sort.UtilTest.generateRandomArray;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SelectionSortTest {

	Sortable sortable = new SelectionSort();

	@Test
	void verifyArraySortedInDescending_ifArrayContainsInteger() {
		Integer[] array = {10, 8, 5, 4, 9, 7, 6};
		sortable.sort(array);
		assertEquals(4, array[0]);
		assertEquals(5, array[1]);
		assertEquals(6, array[2]);
		assertEquals(7, array[3]);
		assertEquals(8, array[4]);
		assertEquals(9, array[5]);
		assertEquals(10, array[6]);
	}

	@Test
	void verifyArraySortedInDescending_ifArrayContainsString() {
		String[] array = {"Samuel", "John", "Chen"};
		sortable.sort(array);
		assertEquals("Chen", array[0]);
		assertEquals("John", array[1]);
		assertEquals("Samuel", array[2]);
	}

	@Test
	public void verifyZeroIsFirst_ifArrayVonstainsPossitiveRandomIntegers() {
		int n = 10000;
		Integer[] randomArray = generateRandomArray(n);
		randomArray[n - 1] = 0;
		sortable.sort(randomArray);
		System.out.println(Arrays.toString(randomArray));
		assertEquals(0, randomArray[0]);
	}
}
