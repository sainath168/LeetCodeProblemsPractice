package main.algorithmsAndDataStructure.arraysDataStructure;

public class ArraysExample {

    public static void main(String[] args) {
        Array numbersArray = new Array(3);
        numbersArray.insert(10);
        numbersArray.insert(20);
        numbersArray.insert(30);
        numbersArray.insert(40);
        numbersArray.insert(70);
        numbersArray.insert(60);
        numbersArray.insert(50);
        numbersArray.removeAt(3);
        System.out.println(numbersArray.indexOf(50));

        numbersArray.print();
    }

}

class Array {

    private int[] numbers;
    private int arrayPointer;

    Array() {
        initializeArray(1);
        arrayPointer = 0;
    }

    /**
     * Constructor - used to initialize the array with size passed as parameter
     */
    Array(int size) {
        initializeArray(size);
        arrayPointer = 0;
    }

    private void initializeArray(int size) {
        numbers = new int[size];
    }

    /**
     * insert() method
     * increase the array size by 1,
     * and push the item to array
     */
    public void insert(int value) {
        if (arrayPointer == numbers.length) {
            int[] newArray = new int[arrayPointer + 1];
            for (int i = 0; i < numbers.length; i++) {
                newArray[i] = numbers[i];
            }
            numbers = newArray;
        }
        numbers[arrayPointer] = value;   // or  numbers[arrayPointer++] = value; and delete the next stmt because it is post increment
        arrayPointer++;
    }

    /**
     * removeAt() method
     * - check if index is valid
     * - it should remove the element at the index passed
     */
    public void removeAt(int index) {
        if (index < numbers.length) {
            int[] newArray = new int[numbers.length - 1];

            int newArrayIndex = 0;
            for (int i = 0; i < numbers.length; i++) {
                if (i != index) {
                    newArray[newArrayIndex] = numbers[i];
                    newArrayIndex++;
                }
            }
            System.out.println("Old array size: " + numbers.length + " and after removing: " + newArray.length);
            numbers = newArray;


            //instead of creating new array and copying it to main array like above code, we can just delete item in current array
            //but this will reduce the
            /*for (int i = index; i < arrayPointer; i++) {
                numbers[i] = numbers[i + 1];
            }
            arrayPointer--;*/
        } else {
            throw new IllegalArgumentException();
        }
    }


    /**
     * indexOf() method
     * it should return the index of the value that passed
     * if not found return -1
     */
    public int indexOf(int value) {
        for (int i = 0; i < arrayPointer; i++) {
            if (numbers[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public void print() {
        for (int i : numbers) {
            System.out.println(i);
        }
    }


}