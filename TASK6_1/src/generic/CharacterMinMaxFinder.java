package generic;

class CharacterMinMaxFinder implements MinMaxFinder<Character> {
    @Override
    public Character findMin(Character[] array) {
        if (array == null || array.length == 0)
            throw new IllegalArgumentException("Array must not be empty or null");
        
        Character min = array[0];
        for (Character ch : array) {
            if (ch.compareTo(min) < 0)
                min = ch;
        }
        return min;
    }

    @Override
    public Character findMax(Character[] array) {
        if (array == null || array.length == 0)
            throw new IllegalArgumentException("Array must not be empty or null");
        
        Character max = array[0];
        for (Character ch : array) {
            if (ch.compareTo(max) > 0)
                max = ch;
        }
        return max;
    }
}
