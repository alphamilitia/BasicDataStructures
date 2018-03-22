/* Queue
 * Doubly Linked list-based implementation
 */

public class DoublyLinkedQueue<T>
{
    //create a empty doubly linked list
    private DoublyLinkedList<T> dll = new DoublyLinkedList<>();

    //constructor for DoublyLinkedQueue
    public DoublyLinkedQueue(){
    }

    /* size: Returns the number of elements in the queue */
    public int size()
    {
        return dll.size();
    }

    /* isEmpty: Returns a boolean indicating whether the queue is empty */
    public boolean isEmpty()
    {
        return dll.isEmpty();
    }

    /* first: Returns the first element of the queue,
     * without removing it or null if the queue if empty */
    public T first()
    {
        return dll.first();
    }

    /* first: Returns the first element of the queue,
     * without removing it or null if the queue if empty */
    public T last()
    {
        return dll.last();
    }

    /* enqueue: Adds element e to the back of queue */
    public void enqueue(T value)
    {
        dll.addLast(value);
    }

    /* dequeue: Removes and returns the first element
     * from the queue or null if the queue is empty */
    public T dequeue()
    {
        T value = dll.removeFirst();
        return value;
    }

    /* print: singly linked list-based queue*/
    public void printQueue()
    {
        dll.printList();
    }
}
