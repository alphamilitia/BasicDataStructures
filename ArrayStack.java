
public class ArrayStack<T>
{
    //default array capacity
    public static int MAX_CAPACITY = 10000;
    //generate the array
    private T[] data;
    //index of the top element
    private int t = -1;

    //constructor
    public ArrayStack()
    {
        data = (T[])new Object[MAX_CAPACITY];
    }

    public ArrayStack(int capacity)
    {
        data = (T[])new Object[capacity];
    }

    public int size()
    {
        return (t+1);
    }

    public boolean isEmpty()
    {
        return (t == -1);
    }

    public T top()
    {
        if(isEmpty()==true)
        {
            return null;
        }
        return (data[t]);
    }

    public T pop()
    {
        if(isEmpty()==true)
        {
            return null;
        }
        T removed = data[t];
        data[t] = null;
        t--;
        return removed;
    }

    public void push(T value)
    {
        t++;
        data[t] = value;
    }

    public void printStack()
    {
        for(int i=t; i>=0; t--)
        {
            System.out.println(data[i]);
        }
    }


}
