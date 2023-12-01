package task;

import java.util.ArrayList;
import java.util.List;

public class BNode<E extends Comparable<E>> {
	private E data;
	private BNode<E> left;
	private BNode<E> right;

	public BNode(E data) {
		this.data = data;
		this.right = null;
		this.left = null;
	}

	public BNode(E data, BNode<E> left, BNode<E> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	// Add element e into BST
	public void add(E e) {
		if (e.compareTo(this.data) < 0) {
			if (left == null) {
				left = new BNode<E>(e);
			} else {
				left.add(e);
			}
		} else if (e.compareTo(this.data) > 0) {
			if (right == null) {
				right = new BNode<E>(e);
			} else {
				right.add(e);
			}
		}
	}

	// Calculates the depth of a node in the BST

	public int depth(E node) {
		if (node.compareTo(data) == 0) {
			return 0;
		} else if (node.compareTo(data) < 0) {
			if (left == null) {
				return -1;
			} else {
				int leftDepth = left.depth(node);
				if (leftDepth == -1) {
					return -1;
				} else {
					return leftDepth + 1;
				}
			}
		} else {
			if (right == null) {
				return -1;
			} else {
				int rightDepth = right.depth(node);
				if (rightDepth == -1) {
					return -1;
				} else {
					return rightDepth + 1;
				}
			}
		}
	}

	public int height() {
		int leftHeight = 0;
		int rightHeight = 0;
		if (left != null) {
			leftHeight = left.height() + 1;
		}
		if (right != null) {
			rightHeight = right.height() + 1;
		}

		return Math.max(leftHeight, rightHeight);
	}

	public int size() {
		int leftSize = 0;
		int rightSize = 0;
		if (left != null) {
			leftSize = left.size();
		}
		if (right != null) {
			rightSize = right.size();
		}
		return leftSize + rightSize + 1;
	}

	public boolean contains(E e) {
		if (e.compareTo(data) == 0) {
			return true;

		} else if (e.compareTo(data) < 0) {
			if (left == null) {
				return false;
			}
			return left.contains(e);
		} else {
			if (right == null) {
				return false;
			}
			return right.contains(e);
		}
	}

	public E findMin() {
		if (left == null) {
			return data;
		} else {
			return left.findMin();
		}
	}

	public E findMax() {
		if (right == null) {
			return data;
		} else {
			return right.findMax();
		}
	}

	public List<E> descendants(E data) {
		BNode<E> node = findNode(data);
		List<E> descendants = new ArrayList<E>();
		if (node != null) {
			node.addDescendantsToList(descendants);

		}
		return descendants;
	}

	private void addDescendantsToList(List<E> list) {
		if (left != null) {
			left.addDescendantsToList(list);
		}
		list.add(data);
		if (right != null) {
			right.addDescendantsToList(list);
		}
	}

	public BNode<E> findNode(E data) {
		if (data.compareTo(this.data) == 0) {
			return this;
		} else if (data.compareTo(this.data) < 0) {
			if (left == null) {
				return null;
			} else {
				return left.findNode(data);
			}
		} else {
			if (right == null) {
				return null;
			} else {
				return right.findNode(data);
			}
		}
	}

	// get the ancestors of a node
	public List<E> ancestors(E e) {
		int comp = e.compareTo(data);
		List<E> re = new ArrayList<>();
		if (comp == 0) {
			return re;
		}
		if (left != null) {
			if (left.contains(e)) {
				re.addAll(left.ancestors(e));
				re.add(data);
			}
		}
		if (right != null) {
			if (right.contains(e)) {
				re.addAll(right.ancestors(e));
				re.add(data);
			}
		}
		return re;
	}

	public void inorder() {
		if (left != null) {
			left.inorder();
		}
		System.out.print(data + " ");
		if (right != null) {
			right.inorder();
		}
	}

	public void preorder() {
		if (data != null) {
			System.out.print(data + " ");
		}
		if (left != null) {
			left.preorder();
		}
		if (right != null) {
			right.preorder();
		}
	}

	public void postorder() {
		if (left != null) {
			left.postorder();
		}
		if (right != null) {
			right.postorder();
		}
		if (data != null) {
			System.out.print(data + " ");
		}
	}

	public boolean remove(E data) {
		if (data.compareTo(this.data) < 0) {
			if (left != null) {
				if (left.remove(data)) {
					return true;
				}
			}
			return false;
		} else if (data.compareTo(this.data) > 0) {
			if (right != null) {
				if (right.remove(data)) {
					return true;
				}
			}
			return false;
		} else {
			if (left == null) {
				right = null;
				return true;
			} else if (right == null) {
				left = null;
				return true;
			} else {
				data = right.findMin();
				if (!right.remove(data)) {
					return false;
				}
				this.data = data;
				return true;
			}
		}
	}
//	public BNode<E> remove(E e) {
//		if (e.compareTo(this.data) < 0) {
//			if (left != null) {
//				left = left.remove(e);
//			}
//			return this;
//		} else if (e.compareTo(this.data) > 0) {
//			if (right != null) {
//				right = right.remove(e);
//			}
//			return this;
//		} else {
//			if (left == null) {
//				return right;
//			} else if (right == null) {
//				return left;
//			} else {
//				e = right.findMin();
//				right = right.remove(e);
//				this.data = e;
//				return this;
//			}
//		}
//	}

}
