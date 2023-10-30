package task_2;
public class SinglyLinkedList<E> {
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size;

    public SinglyLinkedList() {
        super();
    }

    @Override
	public String toString() {
		return  head + ", " + tail + ", " + size;
	}

	public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) {
            return null;
        } else {
            return head.data;
        }
    }

    public E last() {
        if (isEmpty()) {
            return null;
        } else {
            return tail.data;
        }
    }

    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void addLast(E e) {
        Node<E> newNode = new Node<>(e);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode; 
        }
        size++;
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        } else {
            Node<E> oldHead = head;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            size--;
            return oldHead.data;
        }
    }

    public E removeLast() {
        if (isEmpty()) {
            return null;
        } else {
            Node<E> oldTail = tail;
            if (head == tail) {
                head = tail = null;
            } else {
                Node<E> newTail = head;
                while (newTail.next != tail) {
                    newTail = newTail.next;
                }
                tail = newTail;
                tail.next = null;
            }
            size--;
            return oldTail.data;
        }
    }

   
}