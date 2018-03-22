/* Queue
 * Array-based implementation
 */

public class ArrayQueue<T>
{
    // default array capacity
    public static final int MAX_CAPACITY = 1000;
    // generic array used for storage
    private T[] data;
    // index of the front element in queue
    private int f = 0;
    private int sz = 0;

    /* constructor */
    // construct queue with default max capacity
    public ArrayQueue() {
        data = (T[]) new Object[MAX_CAPACITY];
    }

    // construct queue with given capacity
    public ArrayQueue(int capacity) {
        data = (T[]) new Object[capacity];
    }

    /* size: Returns the number of elements in the queue */
    public int size() {
        return sz;
    }

    /* isEmpty: Returns a boolean indicating
     * whether the stack is empty */
    public boolean isEmpty() {
        return (sz == 0);
    }

    /* first : Returns the front element of the queue,
     * without removing it or null if the queue if empty  */
    public T first() {
        if (this.isEmpty()) {
            return null;
        }
        return data[f];
    }

    /* dequeue: Removes and returns the first element
     * from the queue or null if the queue is empty */
    public T dequeue() {
        if (this.isEmpty()) {
            return null;
        }
        T removed = data[f];
        //deference to help garbage collection
        data[f] = null;
        f = (f + 1) % data.length;
        sz--;
        return removed;
    }

    /* enqueue: Adds element e to the back of queue */
    public void enqueue(T value) throws IllegalStateException {
        if (this.size() == data.length) {
            throw new IllegalStateException("Queue is full");
        }
        int r = (f + sz) % data.length;
        data[r] = value;
        sz++;
    }

    /* print: array-based queue*/
    public void printQueue() {
        if ((f+sz) <= data.length) {
            for (int i = f; i < f + sz; i++) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        } else {
            for (int i = f; i < data.length ; i++) {
                System.out.print(data[i] + " ");
            }
            for (int i = 0; i < (f+sz)%data.length; i++) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }
    }
}
