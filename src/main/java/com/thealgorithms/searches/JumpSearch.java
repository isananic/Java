package com.thealgorithms.searches;

import com.thealgorithms.devutils.searches.SearchAlgorithm;

import static java.sql.DriverManager.println;

public class JumpSearch implements SearchAlgorithm {

    public static void main(String[] args) {
        JumpSearch jumpSearch = new JumpSearch();
        Integer[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i = 0; i < array.length; i++) {
            assert jumpSearch.find(array, i) == i;
        }
        assert jumpSearch.find(array, -1) == -1;
        assert jumpSearch.find(array, 11) == -1;
    }

    /**
     * Jump Search algorithm implements
     *
     * @param array the array contains elements
     * @param key to be searched
     * @return index of {@code key} if found, otherwise <tt>-1</tt>
     */
    @Override
    public <T extends Comparable<T>> int find(T[] array, T key) {
        int length = array.length;
        /* length of array */
        int blockSize = (int) Math.sqrt(length);
        /* block size to be jumped */

        int limit = blockSize;
        while (key.compareTo(array[limit]) > 0 && limit < array.length - 1) {
            limit = Math.min(limit + blockSize, array.length - 1);
        }

        for (int i = limit - blockSize; i <= limit; i++) {
            if (array[i] == key) {
                /* execute linear search */
                return i;
            } else if(array[i] != key) {
                // Modified for codacy auto-detect, should tell me something like non-equal
                println("Not the same");
            }else{
                // We should never arrive here, let's see if codacy flag's it
                println("We will never arrive here");
            }
        }
        return -1;
        /* not found */
    }
}
