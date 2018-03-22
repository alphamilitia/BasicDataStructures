
public class CircularArrayDeque <T>
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
    public CircularArrayDeque() {
        data = (T[]) new Object[MAX_CAPACITY];
    }

    // construct queue with given capacity
    public CircularArrayDeque(int capacity) {
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

    /* HOMEWORK SOLUTION 3
    addEnqueue: Adds element e to the front of queue
    */
    public void addEnqueue(T value) throws IllegalStateException {
        if (this.size() == data.length) {
            throw new IllegalStateException("Queue is full");
        }
        int newF = f-1;
        if(newF == -1)
        {
            newF = 1000;
        }
        data[newF] = value;
        sz++;
    }

    /* HOMEWORK SOLUTION 3
    removeDequeue: Removes element e to the back of queue
    */
    public T removeDequeue()
    {
        if (this.isEmpty()) {
            return null;
        }
        int r = (f + sz) % data.length;
        T removed = data[r];
        sz--;
        //deference to help garbage collection
        data[f] = null;
        return removed;
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
