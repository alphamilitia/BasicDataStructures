/* Singly linked list
 * Implementation
 */

public class SinglyLinkedList<T>
{
    private Node<T> tail; // tail node
    private Node<T> head; // head node
    private int size; // size

    /* Constructor */
    public SinglyLinkedList() {
        size = 0;
    }

    /* isEmpty: Returns a boolean indicating whether the list is empty */
    public boolean isEmpty() {
        return size == 0;
    }

    /*  size: Returns the number of elements in the list */
    public int size() {
        return size;
    }

    /* getNode: get the element with value */
    public Node<T> find(T value) {
        // find the element at i-1th position
        Node<T> cNode = head;
        Node<T> prevNode = null;
        while (!cNode.value.equals(value) && cNode.next != null) {
            prevNode = cNode;
            cNode = cNode.next;
        }

        if (!cNode.value.equals(value)) {
            System.out.println("Can not find value " + value + " in the list");
            return null;
        }

        return cNode;
    }

    /* first: Returns the first element in the list */
    public T first() {
        if (this.isEmpty()) {
            return null;
        }
        return head.value;
    }

    /* last: Returns the last element in the list */
    public T last() {
        if (this.isEmpty()) {
            return null;
        }
        return tail.value;
    }

    /* addFirst: Adds an element to the front of the list */
    public void addFirst(T value) {
        // allocate a new node
        Node<T> newest = new Node<>();
        // insert the element
        newest.value = value;
        // have new node point to old head
        newest.next = head;
        // update head
        head = newest;
        // if size = 0, new node is also the tail
        if (size == 0) {
            tail = head;
        }
        // linked list size increments
        size++;
    }

    /* addLast: Adds a new element e to the end of the list */
    public void addLast(T value) {
        // if size = 0, = add First
        if(size == 0) {
            addFirst(value);
            return;
        }
        // allocate a new node
        Node<T> newest = new Node<>();
        // insert the element
        newest.value = value;
        // have new node point to null
        newest.next = null;
        // traverse the linked list to find the tail
        Node<T> cNode = head;
        while(cNode.next != null) {
            cNode = cNode.next;
        }
        // find the tail
        tail = cNode;
        // have old tail point to new node
        tail.next = newest;
        // update tail
        tail  = newest;
        size++; // linked list size increments
    }

    /* addBetween: Inserts an element into the i-th element in the list */
    public void addBetween(int index, T value) {
        // test index out of bounds
        if(index > this.size()) {
            System.out.println("Out of list bounds!");
            return;
        }
        // if index = 1, = add first
        if(index == 1) {
            addFirst(value);
            return;
        }
        // if index = size, = add last
        if (index == this.size()) {
            addLast(value);
            return;
        }

        // if index = i, insert into the i-th element
        // find the element at i-1th position
        Node<T> cNode = head;
        for(int i = 1; cNode.next != null && (i+1) != index; i++) {
            cNode = cNode.next;
        }
        // allocate a new node
        Node<T> newNode = new Node<T>();
        // insert new element
        newNode.value = value;
        // have the new node point to the same next node
        newNode.next = cNode.next;
        // have the current node point to the new node
        cNode.next = newNode;
        // size increments
        size++;
    }

    /* removeFirst: Removes and returns the first element of the list */
    public T removeFirst() {
        // if empty, return null
        if(this.isEmpty()) {
            return null;
        } else {
            T removed = head.value;
            // update head
            head = head.next;
            // size decrements
            size--;
            // if size shrinks to 0, then no tail
            if (size == 0){
                tail = null;
            }
            return removed;
        }
    }

    /* removeLast: Removes and returns the last element of the list */
    public T removeLast() {
        // if empty, return null
        if(this.isEmpty()) {
            return null;
        }
        // if size = 1, = remove first
        if(this.size == 1) {
            T removed = removeFirst();
            return removed;
        }

        // allocate a temporary node
        Node<T> cNode = head;
        Node<T> prevNode = null;

        // keep a moving window scheme
        // find the tail
        while(cNode.next != null) {
            prevNode = cNode;
            cNode = cNode.next;
        }

        T removed = cNode.value;
        // find the second last node then have it point to null
        prevNode.next = null;
        // update tail
        tail = prevNode;
        // size decrements
        size--;
        // if size shrinks to 0, then no head
        if (size == 0) {
            head = null;
        }
        return removed;
    }


    /* Removes and returns the i-th element */
    public T removeBetween(int index) {
        T removed;
        // test index out of bounds
        if(index > this.size() || index <= 0) {
            System.out.println("Can't remove! Out of list bounds!");
            return null;
        }

        // if index = i, remove from the i-th element
        // find the element at i-1th position
        Node<T> cNode = head;
        Node<T> prevNode = null;
        for(int i = 1; cNode.next != null && i != index; i++) {
            prevNode = cNode;
            cNode = cNode.next;
        }

        // if index = 1, = removed first
        if(prevNode == null) {
            removed = removeFirst();
            return removed;
            // = remove last
        } else if (cNode.next == null) {
            removed = removeLast();
            return removed;
        }

        removed = cNode.value;
        // find the cNode then have prevNode point to cNode.next
        prevNode.next = cNode.next;
        // size decrements
        size--;
        if (size == 0){
            head = null;
            tail = null;
        }
        return removed;
    }

    /* Removes and returns the element with value */
    public T removeBetween(T value) {
        T removed = null;
        // find the element at i-1th position
        Node<T> cNode = head;
        Node<T> prevNode = null;
        while (!cNode.value.equals(value) && cNode.next != null) {
            prevNode = cNode;
            cNode = cNode.next;
        }

        if (!cNode.value.equals(value)) {
            System.out.println("Can not find value " + value + " in the list");
            return null;
        }

        // if index = 1, = removed first
        if(prevNode == null) {
            removed = removeFirst();
            return removed;
            // = remove last
        } else if (cNode.next == null) {
            removed = removeLast();
            return removed;
        }

        removed = cNode.value;
        // find the cNode then have prevNode point to cNode.next
        prevNode.next = cNode.next;
        // size decrements
        size--;
        if (size == 0){
            head = null;
            tail = null;
        }
        return removed;
    }

    public void printList() {
        Node<T> current = head;
        System.out.print("Singly linked List: ");
        while(current != null) {
            System.out.println(current.value + " ");
            current = current.next;
        }
        System.out.printf("\n");
    }

    public void printList1() {
        Node<T> current = head;
        while(current != null) {
            System.out.print(current.value + " ");
            System.out.println();
            current = current.next;
        }
        System.out.printf("\n");
    }

    public void printList2() {
        Node<T> current = head;
        while(current != null) {
            System.out.print(current.value+ " ");
            current = current.next;
        }
        System.out.printf("\n");
    }


    public void printList3() {
        System.out.print("List: ");
        for(Node<T> current = head; current != null; current = current.next) {
            System.out.print(current.value);
        }
        //System.out.printf("\n");
    }
}
