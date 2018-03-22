import java.util.Stack;

public class Assignment_6
{
    public static void main(String[] args) {
        SinglyLinkedList<Integer> sLL2 = new SinglyLinkedList<Integer>();

        for (int i = 1; i < 11; i++) {
            sLL2.addAtHead(i);
        }

        sLL2.printList();

        SinglyLinkedList<Integer> sLL3 = new SinglyLinkedList<Integer>();
        //reverseList
        int z = sLL2.size();
        for (int i = 1; i <= z; i++) {
            int value = sLL2.removeAtHead();
            sLL3.addAtHead(value);
        }

        sLL3.printList();


        //Problem 2

        String calculation = "1+3-(21+7)+12-6+(9+3)-11";
        ArrayStack<Character> arr1 = new ArrayStack<>();
        ArrayStack<String> arr2 = new ArrayStack<>();
        int length = calculation.length();

        for (int i = 0; i < length; i++) {
            arr1.push(calculation.charAt(i));
        }

        int counter = length;
        do {

            //check and concat integers together
            if (testForInt(arr1.top())) {
                String digit = Character.toString(arr1.pop());
                counter--;
                if (testForInt(arr1.top())) {
                    digit = Character.toString(arr1.pop()) + digit;
                    counter--;
                }
                arr2.push(digit);
            }

            //check and add operator String
            if (testForOp(arr1.top())) {
                String oper = Character.toString(arr1.pop());
                arr2.push(oper);
                counter--;
            }

            //check and add parenthesis String
            if (testForPar(arr1.top())) {
                String pare = Character.toString(arr1.pop());
                arr2.push(pare);
                counter--;
            }
        }
        while (counter > 1);
        arr2.push(Character.toString(arr1.top()));
        length = arr2.size();
        for (int i = 0; i < length; i++) {

        }


        System.out.println("Length: " + length);
        for (int i = 0; i < length; i++) {
            System.out.print(arr2.pop() + "  ");
        }
        System.out.println();

    }
        /*
        //Bubble sort testing
        int[] array1 = {9,8,7,5,4,7,5,6,2,6,5,4,3,2,1};

        System.out.print("| ");
        for(int i=0; i<array1.length; i++)
        {
            System.out.print(array1[i]+" | ");
        }
        System.out.println();

        int[] array2 = bubbleSort(array1);

        System.out.print("| ");

        for(int i=0; i<array1.length; i++)
        {
            System.out.print(array1[i]+" | ");
        }
        System.out.println();



    }

    private static int[] bubbleSort(int[] arr)
    {
        for(int j=0; j<arr.length-1; j++)
        {
            for(int i=0; i<arr.length-1; i++)
            {
                if(arr[i]>arr[i+1])
                {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }
        return arr;
    }*/

    public static boolean testForInt(char ele) {
        if (ele == '0')
            return true;
        if (ele == '1')
            return true;
        if (ele == '2')
            return true;
        if (ele == '3')
            return true;
        if (ele == '4')
            return true;
        if (ele == '5')
            return true;
        if (ele == '6')
            return true;
        if (ele == '7')
            return true;
        if (ele == '8')
            return true;
        if (ele == '9')
            return true;

        return false;
    }

    public static boolean testForOp(char ele) {
        if (ele == '+')
            return true;
        if (ele == '-')
            return true;
        return false;
    }

    public static boolean testForPar(char ele) {
        if (ele == '(')
            return true;
        if (ele == ')')
            return true;
        return false;
    }
}

