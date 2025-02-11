package generic;

class IntegerMinMaxFinder implements MinMaxFinder<Integer> {
    @Override
    public Integer findMin(Integer[] array) {
        if (array == null || array.length == 0)
            throw new IllegalArgumentException("Array must not be empty or null");
        
        Integer min = array[0];
        for (Integer num : array) {
            if (num.compareTo(min) < 0)
                min = num;
        }
        return min;
    }

    @Override
    public Integer findMax(Integer[] array) {
        if (array == null || array.length == 0)
            throw new IllegalArgumentException("Array must not be empty or null");
        
        Integer max = array[0];
        for (Integer num : array) {
            if (num.compareTo(max) > 0)
                max = num;
        }
        return max;
    }
}