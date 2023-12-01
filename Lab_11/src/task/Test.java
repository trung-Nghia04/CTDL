package task;

public class Test {
	public static void main(String[] args) {
		BST<Integer> bst = new BST<>();
		bst.add(25);
		bst.add(15);
		bst.add(50);
		bst.add(10);
		bst.add(22);
		bst.add(35);
		bst.add(70);
		bst.add(4);
		bst.add(12);
		bst.add(18);
		bst.add(24);
		bst.add(31);
		bst.add(44);
		bst.add(66);
		bst.add(90);
		System.out.println("Depth of 70: " + bst.depth(70));

		System.out.println("Height BST: " + bst.height());

		System.out.println("Size BST: " + bst.size());

		System.out.println("Element 12: " + bst.contains(50));

		System.out.println("Find min: " + bst.findMin());

		System.out.println("Find max: " + bst.findMax());

		System.out.println("Ancestors of 15: " + bst.ancestors(22));

		System.out.println("Descendants of 50: " + bst.descendants(50));

		System.out.print("\nInorder: ");
		bst.inorder();

		System.out.print("\nPreorder: ");
		bst.preorder();

		System.out.print("\nPostorder: ");
		bst.postorder();

		System.out.print("\nRemove 70: " + bst.remove(70));

	}
}
