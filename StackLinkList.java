

public class StackLinkList<T>
{

    private SinglyLinkedList sll = new SinglyLinkedList<>();

    public StackLinkList(){}

    public int size()
    {
        return sll.size();
    }

    public boolean isEmpty()
    {
        return sll.isEmpty();
    }

    public T top()
    {
        return (T) sll.first();
    }

    public void push(T value)
    {
        sll.addAtHead(value);
    }

    public T pop()
    {
        return (T) sll.removeAtHead();
    }


    public void printStack()
    {
        sll.printList();
    }


}
