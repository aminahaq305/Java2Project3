
public class GenericStack<E> {

	public static class Node<E> {
		E element;
		Node<E> next;

		public Node(E element) {
			this.element = element;
		}
	}

	private Node<E> topPtr;

	public GenericStack() {
		this.topPtr = null;
	}

	public void push(E e) {
		Node<E> newNode = new Node<>(e);
		newNode.next = topPtr;
		topPtr = newNode;
	}

	public E pop() {
		if (topPtr == null) {
			//System.out.println("Stack is empty");
			return null;
		}
		else {
			E e = topPtr.element;
			topPtr = topPtr.next;
			return e;
		}
	}

	public String toString() {
		StringBuilder result = new StringBuilder();

		Node<E> tempPtr = topPtr;
		while (tempPtr != null) {
			result.append(tempPtr.element + "\n");
			tempPtr = tempPtr.next;
		}
		return result.toString();
	}

}
