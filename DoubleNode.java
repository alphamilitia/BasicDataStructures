/* Node in doubly linked list
 * Implementation
 */

public class DoubleNode<T>
{
    /* instance variables */
    public T value; // element
    public DoubleNode<T> prev; // reference to the previous node
    public DoubleNode<T> next; // reference to the next node

    /* constructors */
    public DoubleNode(){
        value = null;
        prev = null;
        next = null;
    }

    public DoubleNode(DoubleNode<T> prev, DoubleNode<T> next) {
        this.next = next;
        this.prev = prev;
    }

    public DoubleNode(T value) {
        this.value = value;
    }

    public DoubleNode(T value, DoubleNode<T> prev, DoubleNode<T> next) {
        this.next = next;
        this.prev = prev;
        this.value = value;
    }

    /* add an element after the current node */
    public void addAfter(DoubleNode<T> newNode) {
        // Before: current --- currentNext
        // After:  current --- newNode --- currentNext
        newNode.next = this.next;
        newNode.prev = this;
        this.next = newNode;
        newNode.next.prev = newNode;
    }

    /* add the element before the current node */
    public void addBefore(DoubleNode<T> newNode) {
        // Before: currentPrev --- current
        // After:  currentPrev --- newNode --- current
        newNode.next = this;
        newNode.prev = this.prev;
        this.prev.next = newNode;
        this.prev = newNode;
    }

    /* remove the element */
    public void remove()
    {
        this.prev.next = this.next;
        this.next.prev = this.prev;
    }
}
