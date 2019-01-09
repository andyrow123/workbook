package my.learning.stringsandlists.largestElement;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class ListUtilImplTest {

    private ListUtil listUtil;
    private List<String> clearLargest = Arrays.asList("one", "two", "three", "four");
    private List<String> sameLength = Arrays.asList("five", "five", "five");

    @Before
    public void setup() {
        listUtil = new ListUtil();
    }

    @Test
    public void shouldReturnCorrectStringWhenLargest() {
        assertEquals("three", listUtil.getLargestStringElement(clearLargest));
    }

    @Test
    public void shouldReturnAllEqualWhenSameLength() {
        assertEquals("All Equal", listUtil.getLargestStringElement(sameLength));
        assertEquals("All Equal", listUtil.getLargestStringElement(Arrays.asList("one", "one", "one")));
    }

    @Test
    public void stream_shouldReturnCorrectStringWhenLargest() {
        assertEquals(Optional.of("three"), listUtil.getLargestStringElementStream(clearLargest));
    }

    @Test
    public void stream_shouldReturnAllEqualWhenSameLength() {
        assertEquals(Optional.of("All Equal"), listUtil.getLargestStringElementStream(sameLength));
        assertEquals(Optional.of("All Equal"), listUtil.getLargestStringElementStream(Arrays.asList("one", "one", "one")));
    }
}
