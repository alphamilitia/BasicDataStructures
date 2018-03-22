

public class CircularyLinkedList<T>
{

    private Node<T> head;
    private int size;

    //Constructor
    /* Constructor */
    public CircularyLinkedList()
    {
        this.size = 0;
    }

    /* Returns a boolean indicating whether the list is empty */
    public boolean isEmpty()
    {
        return size == 0;
    }

    /*  Returns the number of elements in the list */
    public int size()
    {
        return size;
    }

    /* Returns the first element in the list */
    public T first() {
        if (this.isEmpty()) {
            return null;
        } else {
            return head.value;
        }
    }

    /* Returns the last element in the list */
    public T last() {
        if (this.isEmpty()) {
            return null;
        } else {
            // traverse the linked list to find the tail
            Node<T> currentNode = head;
            while (currentNode.next != head) {
                currentNode = currentNode.next;
            }
            return currentNode.value;
        }
    }

    public Node find(T value)
    {
        Node current = head;
        if (isEmpty()) {
            return null;
        }
        for(int i=1; i <= size; i++)
        {
            if (current.equals(value))
            {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    /* Insert at head : add an element to the front*/
    public void addFirst(T value)
    {
        Node newNode = new Node<>(value);
        if(size == 0)
        {
            head = newNode;
            newNode.next = head;
        }
        else
        {
            Node temp = head;
            newNode.next = temp;
            head = newNode;
        }
        size++;
    }

    /* Insert at tail*/
    public void addLast(T value) {

        Node<T> newNode = new Node<>(value);
        if (size == 0)
        {
            head = newNode;
            newNode.next = head;
        }

        Node counter = head;
        for(int i=1; i <= size; i++)
        {
            if(counter.next == head)
            {
                counter = newNode;
                newNode.next = head;
            }
            counter = counter.next;
        }
        size++; // linked list size increments
    }

    public void set(T old, T newE)
    {
        Node<T> current = head;
        if (isEmpty()) {
            System.out.println("List is Empty");
        }
        for(int i=1; i <= size; i++)
        {
            if (current.equals(old))
            {
                old = newE;
            }
            current = current.next;
        }
    }

    public T removeFirst()
    {
        if (isEmpty()) {
            System.out.println("List is Empty");
        }
        else
        {
            T removed = head.value;
            head = head.next;
            size--;
            return removed;
        }
        return null;

    }

    public T removeLast() {
        if(this.isEmpty())
        {
            return null;
        }
        if(this.size == 1)
        {
            T removed = removeFirst();
            return removed;
        }

        Node<T> link = head;
        Node<T> previousLink = null;

        // keep a moving window scheme
        while(link.next != head) {
            previousLink = link;
            link = link.next;
        }

        T removed = link.value;
        // find the second last node then have it point to null
        previousLink.next = head;
        size--; // linked list size decrements
        return removed;
    }

    public T removeBetween(int index)
    {
        // test index out of bounds
        if (index > this.size())
        {
            System.out.println("Out of list bounds.");
        }

        // if index = 1, = remove head
        if (index == 1) {
            removeFirst();
        }

        if(index == this.size)
        {
            removeLast();
        }

        // find and remove at the specified index
        Node<T> link = head;
        Node<T> previous = null;
        for(int i=1; i<index; i++)
        {
            previous = link;
            link.next = link;
        }
        T removed = link.value;
        previous.next = link.next;
        size--;
        return removed;
    }

    public void removeBetween(T value)
    {
        Node<T> current = head;
        if (isEmpty()) {
            System.out.println("Empty");
        }
        Node link = find(value);

        for(int i =1; i<=size; i++)
        {
            if(current.next.equals(link))
            {
                current.next = current.next.next;
                size--;
            }
        }
    }

    public void printList()
    {
        Node<T> current = head;

        System.out.print("List: ");
        for(int i = 1; i<=size; i++) {
            System.out.printf("%2d ", current.value);
            current = current.next;
        }
        System.out.printf("\n");
    }
}
