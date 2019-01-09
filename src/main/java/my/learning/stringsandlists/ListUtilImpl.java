package my.learning.stringsandlists;

import java.util.*;

public class ListUtilImpl implements ListUtil {

    @Override
    public <T> List<T> collectionReverse(List<T> list) {
        Collections.reverse(list);
        return list;
    }

    @Override
    public <T> List<T> recursiveReverse(List<T> list) {
        if(list.size() <= 1) {
            return list;
        }

        List<T> reversed = new ArrayList<T>();
        reversed.add(list.get(list.size() - 1));
        reversed.addAll(recursiveReverse(list.subList(0, list.size() - 1)));

        return reversed;
    }

    @Override
    public <T> T getLargestElement(List<T> list) {
        int largestIndex = 0;
        int largestIndexLength = 0;
        int equalLengthCounter = 0;

        for(int i = 0; i < list.size(); i++) {
            T element = list.get(i);
            if(element.toString().length() != largestIndexLength && element.toString().length() > largestIndexLength) {
                largestIndex = i;
                largestIndexLength = element.toString().length();
            }
            else {
                equalLengthCounter++;
            }
        }

        T text = (T) "All Equal";

        if (equalLengthCounter == list.size() - 1) { return text; }

        return list.get(largestIndex);
    }

    @Override
    public <T> Optional<T> getLargestElementStream(List<T> list) {
        return Optional.of(list.stream()
                .max(Comparator.comparingInt(e -> e.toString().length()))
                .orElse((T) "All Equal"));
    }

}
