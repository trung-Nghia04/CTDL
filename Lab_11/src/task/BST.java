package task;

import java.util.Collection;
import java.util.List;

public class BST<E extends Comparable<E>> {
	private BNode<E> root;

	public BST() {
		this.root = null;

	}

	public void add(E e) {
		if (root == null) {
			root = new BNode<>(e);
		}
		root.add(e);
	}

	// Add a collection of elements col into BST
	public void add(Collection<E> col) {
		for (E e : col) {
			add(e);
		}
	}

	public int depth(E e) {
		return root.depth(e);
	}

	public int height() {
		return root.height();
	}

	public int size() {
		return root.size();
	}

	public boolean contains(E e) {
		return root.contains(e);
	}

	public E findMin() {
		return root.findMin();
	}

	public E findMax() {
		return root.findMax();
	}

	public boolean remove(E e) {
		return root.remove(e);
	}

	// get the descendants of a node
	public List<E> descendants(E data) {
		return root.descendants(data);
	}

	// get the ancestors of a node
	public List<E> ancestors(E data) {
		return root.ancestors(data);
	}

	public void inorder() {
		root.inorder();
	}

	public void preorder() {
		root.preorder();
	}

	public void postorder() {
		root.postorder();
	}
}
