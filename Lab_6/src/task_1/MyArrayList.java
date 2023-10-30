package task_1;

import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<E> {
	public static final int DEFAULT_CAPACITY = 10;
	private E[] elements;
	private int size;

	public MyArrayList() {
		this.elements = (E[]) new Object[DEFAULT_CAPACITY];
	}

	public MyArrayList(int capacity) {
		this.elements = (E[]) new Object[capacity];
	}

	// creates an array of double-size if the array of elements is full
	public void growSize() {
		E[] newElements = (E[]) new Object[elements.length * 2];
		System.arraycopy(elements, 0, newElements, 0, elements.length);
		elements = newElements;
	}

	// Returns the number of elements in this list.
	public int size() {
		return size;
	}

	// Returns whether the list is empty.
	public boolean isEmpty() {

		return size == 0;
	}

	// Returns (but does not remove) the element at index i.
	public E get(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException();
		}
		return elements[i];
	}

	// Replaces the element at index i with e, and returns the replaced element. ∗/
	public E set(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException();
		}
		E oldElement = elements[i];
		elements[i] = e;
		return oldElement;
	}

	// It is used to append the specified element at the end of a list.
	public boolean add(E e) {
		if (size == elements.length) {
			growSize();
		}
		elements[size] = e;
		size++;
		return true;
	}

	// Inserts element e to be at index i, shifting all subsequent elements later.
	public void add(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i > size) {
			throw new IndexOutOfBoundsException();
		}

		for (int j = size - 1; j >= i; j--) {
			elements[j + 1] = elements[j];
		}

		elements[i] = e;
		size++;
	}

	// Removes and returns the element at index i,shifting subsequent elements
	// earlier.
	public E remove(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException();
		}

		E oldElement = elements[i];

		for (int j = i; j < size - 1; j++) {
			elements[j] = elements[j + 1];
		}

		elements[size - 1] = null;
		size--;

		return oldElement;
	}

	// It is used to clear all elements in the list.
	public void clear() {
		size = 0;
		for (int i = 0; i < elements.length; i++) {
			elements[i] = null;
		}
	}

	// It is used to return the index in this list of the last occurrence of the
	// specified element, or -1 if the list does not contain this element.
	public int lastIndexOf(Object o) {
		for (int i = size - 1; i >= 0; i--) {
			if (elements[i].equals(o)) {
				return i;
			}
		}
		return -1;
	}

	// It is used to return an array containing all of the elements in this list in
	// the correct order.
	public E[] toArray() {
		E[] newArray = (E[]) new Object[size];
		System.arraycopy(elements, 0, newArray, 0, size);
		return newArray;
	}

	// It is used to return a shallow copy of an ArrayList.
	public MyArrayList<E> clone() {
		MyArrayList<E> clone = new MyArrayList<>(size);
		for (int i = 0; i < size; i++) {
			clone.add(elements[i]);
		}
		return clone;
	}
	// It returns true if the list contains the specified element

	public boolean contains(E o) {
		for (int i = 0; i < size; i++) {
			if (elements[i].equals(o)) {
				return true;
			}
		}
		return false;
	}
	// It is used to return the index in this list of thefirst occurrence of the
	// specified element, or -1 if theList does not contain this element.

	public int indexOf(E o) {
		for (int i = 0; i < size; i++) {
			if (elements[i].equals(o)) {
				return i;
			}
		}
		return -1;
	}
	// It is used to remove the first occurrence of the specified element.

	public boolean remove(E e) {
		int index = indexOf(e);
		if (index != -1) {
			remove(index);
			return true;
		} else {
			return false;
		}
	}

	// It is used to sort the elements of the list on the basis of specified
	// comparator.
	public void sort(Comparator<E> c) {
		if (c == null) {
			Arrays.sort(elements, 0, size);
		} else {
			Arrays.sort(elements, 0, size, c);
		}
	}

}