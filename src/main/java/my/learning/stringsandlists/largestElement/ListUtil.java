package my.learning.stringsandlists.largestElement;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class ListUtil implements Comparable<String> {
    public String getLargestStringElement(List<String> stringList) {

        int largestIndex = 0;
        int largestIndexLength = 0;
        int equalLengthCounter = 0;

        for(int i = 0; i < stringList.size(); i++) {
            String element = stringList.get(i);
            if(element.length() != largestIndexLength && element.length() > largestIndexLength) {
                largestIndex = i;
                largestIndexLength = element.length();
            }
            else {
                equalLengthCounter++;
            }
        }

        return equalLengthCounter != stringList.size() - 1 ? stringList.get(largestIndex) : "All Equal";
    }

    public Optional<String> getLargestStringElementStream(List<String> stringList) {
        return Optional.of(stringList.stream()
                .max(Comparator.comparingInt(String::length))
                .orElse("All Equal"));
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }
}
