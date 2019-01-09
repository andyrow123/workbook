package my.learning.stringsandlists;

import my.learning.stringsandlists.largestElement.ListUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class ListUtilImplTest {

    final private static List<Integer> EXPECTED_REVERSE_INTEGER_LIST = Arrays.asList(4,3,2,1);
    final private static List<String> EXPECTED_REVERSE_STRING_LIST = Arrays.asList("four","three","two","one");
    private List<Integer> toReverseIntegerList;
    private List<String> toReverseStringList;
    private ListUtilImpl reverseListUtilImpl;
    private ListUtilImpl largestListUtil;
    private List<String> clearLargest = Arrays.asList("one", "two", "three", "four");
    private List<String> sameLength = Arrays.asList("five", "five", "five");

    @Before
    public void setup() {
        toReverseIntegerList = Arrays.asList(1,2,3,4);
        toReverseStringList = Arrays.asList("one","two","three","four");
        reverseListUtilImpl = new ListUtilImpl();
        largestListUtil = new ListUtilImpl();
    }

    // Collections
    // [1,2,3,4] returns [4,3,2,1]
    @Test
    public void collectionReverse_shouldReturnAReversedListOfInts() {
        assertEquals(EXPECTED_REVERSE_INTEGER_LIST, reverseListUtilImpl.collectionReverse(toReverseIntegerList));
    }

    // ["one","two","three","four"] returns ["four","three","two","one"]
    @Test
    public void collectionReverse_shouldReturnAReversedListOfStrings() {
        assertEquals(EXPECTED_REVERSE_STRING_LIST, reverseListUtilImpl.collectionReverse(toReverseStringList));
    }

    // Recursively
    // [1,2,3,4] returns [4,3,2,1]
    @Test
    public void recursiveReverse_shouldReturnAReversedListOfInts() {
        assertEquals(EXPECTED_REVERSE_INTEGER_LIST, reverseListUtilImpl.recursiveReverse(toReverseIntegerList));

    }

    // ["one","two","three","four"] returns ["four","three","two","one"]
    @Test
    public void recursiveReverse_shouldReturnAReversedListOfStrings() {
        assertEquals(EXPECTED_REVERSE_STRING_LIST, reverseListUtilImpl.recursiveReverse(toReverseStringList));
    }

    @Test
    public void shouldReturnCorrectStringWhenLargest() {
        assertEquals("three", largestListUtil.getLargestElement(clearLargest));
    }

    @Test
    public void shouldReturnAllEqualWhenSameLength() {
        assertEquals("All Equal", largestListUtil.getLargestElement(sameLength));
        assertEquals("All Equal", largestListUtil.getLargestElement(Arrays.asList("one", "one", "one")));
    }

    @Test
    public void stream_shouldReturnCorrectStringWhenLargest() {
        assertEquals(Optional.of("three"), largestListUtil.getLargestElementStream(clearLargest));
    }

    @Test
    public void stream_shouldReturnAllEqualWhenSameLength() {
        assertEquals(Optional.of("All Equal"), largestListUtil.getLargestElementStream(sameLength));
        assertEquals(Optional.of("All Equal"), largestListUtil.getLargestElementStream(Arrays.asList("one", "one", "one")));
    }
}
