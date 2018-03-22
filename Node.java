/* Node in singly linked list
 * Node in circularly linked list
 * Implementation
 */

public class Node<T>
{
    public T value;
    public Node<T> next; // reference to next node

    /* Constructor */
    public Node() {
        this.next = null;
    }

    public Node(Node<T> next) {
        this.next = next;
    }

    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getNext() {
        return this.next;
    }
}
