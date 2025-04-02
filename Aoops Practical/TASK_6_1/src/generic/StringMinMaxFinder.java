package generic;
class StringMinMaxFinder implements MinMaxFinder<String> {
    @Override
    public String findMin(String[] array) {
        if (array == null || array.length == 0)
            throw new IllegalArgumentException("Array must not be empty or null");
        
        String min = array[0];
        for (String str : array) {
            if (str.compareTo(min) < 0)
                min = str;
        }
        return min;
    }

    @Override
    public String findMax(String[] array) {
        if (array == null || array.length == 0)
            throw new IllegalArgumentException("Array must not be empty or null");
        
        String max = array[0];
        for (String str : array) {
            if (str.compareTo(max) > 0)
                max = str;
        }
        return max;
    }
}
