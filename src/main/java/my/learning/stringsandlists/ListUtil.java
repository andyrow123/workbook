package my.learning.stringsandlists;

import java.util.List;
import java.util.Optional;

public interface ListUtil {
    <T> List<T> collectionReverse(List<T> list);

    <T> List<T> recursiveReverse(List<T> list);

    <T> T getLargestElement(List<T> list);

    <T> Optional<T> getLargestElementStream(List<T> list);


}
