package generic;

public class Main {
    public static void main(String[] args) {
        Integer[] intArray = {3, 1, 4, 1, 5, 9, 2, 6, 5};
        IntegerMinMaxFinder intFinder = new IntegerMinMaxFinder();
        System.out.println("Min Integer: " + intFinder.findMin(intArray));
        System.out.println("Max Integer: " + intFinder.findMax(intArray));

        String[] strArray = {"apple", "banana", "orange", "pear"};
        StringMinMaxFinder strFinder = new StringMinMaxFinder();
        System.out.println("Min String: " + strFinder.findMin(strArray));
        System.out.println("Max String: " + strFinder.findMax(strArray));

        Character[] charArray = {'a', 'c', 'b', 'z', 'f'};
        CharacterMinMaxFinder charFinder = new CharacterMinMaxFinder();
        System.out.println("Min Character: " + charFinder.findMin(charArray));
        System.out.println("Max Character: " + charFinder.findMax(charArray));

        Float[] floatArray = {2.3f, 4.5f, 1.2f, 3.5f};
        FloatMinMaxFinder floatFinder = new FloatMinMaxFinder();
        System.out.println("Min Float: " + floatFinder.findMin(floatArray));
        System.out.println("Max Float: " + floatFinder.findMax(floatArray));
    }
}

