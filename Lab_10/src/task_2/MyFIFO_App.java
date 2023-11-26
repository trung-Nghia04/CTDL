package task_2;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyFIFO_App {
	// method stutter that accepts a queue of integers as
	// a parameter
	// and replaces
	// every element of the queue with two copies of that
	// element
	// front [1, 2, 3] back
	// becomes
	// front [1, 1, 2, 2, 3, 3] back
	public static <E> void stutter(Queue<E> input) {
		int size = input.size();
		for (int i = 0; i < size; i++) {
			E e = input.poll();
			input.offer(e);
			input.offer(e);
		}
	}

	// Method mirror that accepts a queue of strings as a
	// parameter and
	// appends the
	// queue's contents to itself in reverse order
	// front [a, b, c] back
	// becomes
	// front [a, b, c, c, b, a] back
	public static <E> void mirror(Queue<E> input) {
		Stack<E> stack = new Stack<>();
		Queue<E> heplQueue = new LinkedList<>();
		while (!input.isEmpty()) {
			heplQueue.offer(input.peek());
			stack.push(input.poll());
		}
		while (!heplQueue.isEmpty()) {
			input.offer(heplQueue.poll());
		}
		while (!stack.isEmpty()) {
			E element = stack.pop();
			input.offer(element);
		}

	}

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		System.out.println("Original Queue: " + queue);
		stutter(queue);
		System.out.println("Modified Queue: " + queue);
		Queue<String> queue2 = new LinkedList<>();
		queue2.offer("a");
		queue2.offer("b");
		queue2.offer("c");
		System.out.println("Original Queue: " + queue2);
		mirror(queue2);
		System.out.println("Mirrored Queue: " + queue2);

	}
}
