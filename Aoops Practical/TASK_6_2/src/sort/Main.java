package sort;

public class Main {

    public static void main(String[] args) {
        Integer[] intArray = {5, 3, 8, 1, 2, 7};
        System.out.println("Original Integer Array:");
        BubbleSort.printArray(intArray);
        BubbleSort.bubbleSort(intArray);
        System.out.println("Sorted Integer Array:");
        BubbleSort.printArray(intArray);

        Double[] doubleArray = {3.5, 1.2, 7.8, 4.4, 2.1};
        System.out.println("\nOriginal Double Array:");
        BubbleSort.printArray(doubleArray);
        BubbleSort.bubbleSort(doubleArray);
        System.out.println("Sorted Double Array:");
        BubbleSort.printArray(doubleArray);

        String[] strArray = {"banana", "apple", "grape", "orange", "kiwi"};
        System.out.println("\nOriginal String Array:");
        BubbleSort.printArray(strArray);
        BubbleSort.bubbleSort(strArray);
        System.out.println("Sorted String Array:");
        BubbleSort.printArray(strArray);
    }
}
