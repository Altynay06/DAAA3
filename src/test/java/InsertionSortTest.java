package daaa2.algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class InsertionSortTest {

    @Test
    void testSimple() {
        int[] arr = {5, 3, 1, 4, 2};
        int[] expected = arr.clone();
        Arrays.sort(expected);

        InsertionSort s = new InsertionSort();
        s.sort(arr);

        assertArrayEquals(expected, arr);
    }
}
