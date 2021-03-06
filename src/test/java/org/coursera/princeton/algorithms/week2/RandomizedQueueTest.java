package org.coursera.princeton.algorithms.week2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class RandomizedQueueTest {
	private static final String ITEM = "item";
	RandomizedQueue<String> randomizedQueue;

	@BeforeEach
	public void setup() {
		randomizedQueue = new RandomizedQueue<String>();
	}

	@Test
	void throwIllegalArgumentException_ifEnqueueWithANullItem() {
		assertThrows(IllegalArgumentException.class, () -> {
			randomizedQueue.enqueue(null);
		});
	}

	@Test
	void throwNoSuchElementException_ifRandomizedQueueEmptyInSampleCall() {
		assertThrows(NoSuchElementException.class, () -> {
			randomizedQueue.sample();
		});
	}

	@Test
	void throwNoSuchElementException_ifRandomizedQueueEmptyInDequeueCall() {
		assertThrows(NoSuchElementException.class, () -> {
			randomizedQueue.dequeue();
		});
	}

	@Test
	void throwNoSuchElementException_ifNoMoreItemsReturnInIteratorNextCall() {
		assertThrows(NoSuchElementException.class, () -> {
			randomizedQueue.iterator().next();
		});
	}

	@Test
	void throwUnsupportedOperationException_ifIteratorRemoveCalled() {
		assertThrows(UnsupportedOperationException.class, () -> {
			randomizedQueue.iterator().remove();
		});
	}

	@Test
	void addItem_ifEnqueueAnItemToQueue() {
		randomizedQueue.enqueue(ITEM);

		assertTrue(randomizedQueue.size() == 1);
		assertEquals(ITEM, randomizedQueue.dequeue());
	}

	@Test
	void returnNotNullItem_ifSampleCalled() {
		randomizedQueue.enqueue(ITEM);
		assertNotNull(randomizedQueue.sample());
	}

	@Test
	void doNotThrowException_ifEnqueueAndDequeuMulptipleItems() {
		IntStream.range(0, 100).forEach(i -> {
			randomizedQueue.enqueue("item" + i);
		});
		IntStream.range(0, 100).forEach(i -> {
			randomizedQueue.sample();
			System.out.println(randomizedQueue.dequeue());
		});
	}
}
