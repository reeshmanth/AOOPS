package generic;

class FloatMinMaxFinder implements MinMaxFinder<Float> {
    @Override
    public Float findMin(Float[] array) {
        if (array == null || array.length == 0)
            throw new IllegalArgumentException("Array must not be empty or null");
        
        Float min = array[0];
        for (Float num : array) {
            if (num.compareTo(min) < 0)
                min = num;
        }
        return min;
    }

    @Override
    public Float findMax(Float[] array) {
        if (array == null || array.length == 0)
            throw new IllegalArgumentException("Array must not be empty or null");
        
        Float max = array[0];
        for (Float num : array) {
            if (num.compareTo(max) > 0)
                max = num;
        }
        return max;
    }
}