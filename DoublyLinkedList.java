/* Doubly linked list
 * Implementation
 */

public class DoublyLinkedList<T>
{
    /* instance variables */
    private DoubleNode<T> SENTINEL_HEADER;
    private DoubleNode<T> SENTINEL_TRAILER;
    private int size;

    /* constructors */
    public DoublyLinkedList () {
		/* Create two dummy nodes */
        SENTINEL_HEADER = new DoubleNode<T>();
        SENTINEL_TRAILER = new DoubleNode<T>();

		/* Create a doubly linked list with only two dummy nodes */
        SENTINEL_HEADER.next = SENTINEL_TRAILER;
        SENTINEL_TRAILER.prev = SENTINEL_HEADER;
    }

	/* Operations */

    /* size: Returns the number of elements in the list */
    public int size() {
        return size;
    }

    /* isEmpty: Returns a boolean indicating whether the list is empty */
    public boolean isEmpty() {
        return size == 0;
    }

    /* first: Returns the first element in the list */
    public T first() {
        if (this.isEmpty()) {
            return null;
        } else {
            return SENTINEL_HEADER.value;
        }
    }

    /* last: Returns the last element in the list */
    public T last() {
        if (this.isEmpty()) {
            return null;
        } else {
            return SENTINEL_TRAILER.value;
        }
    }


    /* find: find and return a node by using its value */
    public DoubleNode<T> find(T value) {
        // initially make currentNode reference header
        DoubleNode<T> currentNode = SENTINEL_HEADER;
        // moving window
        while(currentNode.next.value != value
                && currentNode.next != SENTINEL_TRAILER) {
            currentNode = currentNode.next;
        }
        // if found, return the node's element
        if(currentNode.next.value == value) {
            return currentNode.next;
        } else {
            System.out.println("Can not found element with value "
                    + value);
        }
        return null;
    }

    /* set: Replaces the element’s value oldE with value newE */
    public void set(T oldE, T newE) {
        // if not found, display "can not find oldE"
        if (this.find(oldE) == null) {
            System.out.println(oldE + " can not be found ");
        } else {
            DoubleNode<T> foundNode = find(oldE);
            foundNode.value = newE;
        }
    }

    /* addFirst: Adds a new element value
     * to the front of the list */
    public void addFirst(T value) {
        addAfter(SENTINEL_HEADER, value);
    }

    /* addLast: Adds a new element value
     * to the end of the list */
    public void addLast(T value) {
        addBefore(SENTINEL_TRAILER, value);
    }

    /* addAfter: Inserts a new element value after node refNode  */
    public void addAfter(DoubleNode<T> refNode, T value) {
        // allocate a new node and insert new element
        DoubleNode<T> newNode = new DoubleNode<>(value);
        // if refNode is not empty, insert newNode after refNode
        if(refNode != null) {
            refNode.addAfter(newNode);
            size++;
        }
    }

    /* addBefore: Inserts a new element e before node refNode */
    public void addBefore(DoubleNode<T> refNode, T value) {
        // allocate a new node and insert new element
        DoubleNode<T> newNode = new DoubleNode<>(value);
        // if refNode is not empty, insert newNode before refNode
        if(refNode != null) {
            refNode.addBefore(newNode);
            size++;
        }
    }

    /* Remove: Removes and returns the element value */
    public DoubleNode<T> remove(T value) {
        // find the node which value is value
        DoubleNode<T> removeNode = this.find(value);
        // if removeNode is not empty, remove that node
        if(removeNode != null) {
            removeNode.remove();
            size--; // size decrements
            return removeNode;
        }
        return null;
    }

    /* Remove: Removes and returns the first value */
    public T removeFirst() {
        // find the node which value is value
        DoubleNode<T> removeNode = this.SENTINEL_HEADER;
        // if removeNode is not empty, remove that node
        if(removeNode != null) {
            T removed = removeNode.value;
            removeNode.remove();
            size--; // size decrements
            return removed;
        }
        return null;
    }


    /* display the status of the linked list */
    public void printList() {
        System.out.println("Doubly Linked List: ");

        if(this.isEmpty()) {
            System.out.print("EMPTY");
        }

        for(DoubleNode<T> current = SENTINEL_HEADER.next; current != SENTINEL_TRAILER; current = current.next) {
            System.out.printf("%2d ", current.value);
        }
        System.out.printf("\n");
    }
}
