package org.coursera.princeton.algorithms.week2;

public class LinkedListStack implements Stack<String> {
	private Node topNode;
	private int size;

	@Override
	public void push(String item) {
		Node node = new Node(item, topNode);
		topNode = node;
		size++;
	}

	@Override
	public String pop() {
		if (topNode == null) {
			throw new EmptyStackException("Stack is empty");
		}
		size--;
		String value = topNode.value;
		topNode = topNode.nextNode;
		return value;
	}

	@Override
	public boolean isEmpty() {
		return topNode == null;
	}

	@Override
	public int size() {
		return size;
	}

	private class Node {
		String value;
		Node nextNode;

		public Node(String value, Node nextNode) {
			this.value = value;
			this.nextNode = nextNode;
		}
	}
}
