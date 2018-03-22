/* Queue
 * Linked list-based implementation
 */

public class SinglyLinkedQueue<T>
{
    /* create an empty singly linked list */
    private SinglyLinkedList<T> sll = new SinglyLinkedList<>();

    /* constructor */
    public SinglyLinkedQueue() {
    }

    /* size: Returns the number of elements in the queue */
    public int size()
    {
        return sll.size();
    }

    /* isEmpty: Returns a boolean indicating whether the queue is empty */
    public boolean isEmpty()
    {
        return sll.isEmpty();
    }

    /* first: Returns the first element of the queue,
     * without removing it or null if the queue if empty */
    public T first()
    {
        return sll.first();
    }

    /* enqueue: Adds element e to the back of queue */
    public void enqueue(T value)
    {
        sll.addLast(value);
    }

    /* dequeue: Removes and returns the first element
     * from the queue or null if the queue is empty */
    public T dequeue()
    {
        return sll.removeFirst();
    }

    /* print: singly linked list-based queue*/
    public void printQueue()
    {
        sll.printList2();
    }
}
