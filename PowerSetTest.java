import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;

public class PowerSetTest {

    @Test
    public void testEmptySet() {
        List<String> emptyList = new ArrayList<>();
        List<Set<String>> powerSet = PowerSet.generatePowerSet(emptyList);
        assertEquals(1, powerSet.size(), "Power set of an empty set should contain only one subset (the empty set).");
        assertTrue(powerSet.contains(new HashSet<>()), "Power set of an empty set should contain the empty set.");
    }

    @Test
    public void testSingleElement() {
        List<String> singleElement = new ArrayList<>();
        singleElement.add("a");
        List<Set<String>> powerSet = PowerSet.generatePowerSet(singleElement);
        assertEquals(2, powerSet.size(), "Power set of a single element set should contain two subsets.");
        assertTrue(powerSet.contains(new HashSet<>()), "Power set should include the empty set.");
        HashSet<String> singleElementSet = new HashSet<>();
        singleElementSet.add("a");
        assertTrue(powerSet.contains(singleElementSet), "Power set should include the set with the single element.");
    }

    @Test
    public void testTwoElements() {
        List<String> elements = new ArrayList<>();
        elements.add("a");
        elements.add("b");
        List<Set<String>> powerSet = PowerSet.generatePowerSet(elements);
        assertEquals(4, powerSet.size(), "Power set of a two-element set should contain four subsets.");
        assertTrue(powerSet.contains(new HashSet<>()), "Power set should include the empty set.");
        HashSet<String> firstElementSet = new HashSet<>();
        firstElementSet.add("a");
        assertTrue(powerSet.contains(firstElementSet), "Power set should include subsets of individual elements.");
        HashSet<String> secondElementSet = new HashSet<>();
        secondElementSet.add("b");
        assertTrue(powerSet.contains(secondElementSet), "Power set should include subsets of individual elements.");
        HashSet<String> bothElementsSet = new HashSet<>();
        bothElementsSet.add("a");
        bothElementsSet.add("b");
        assertTrue(powerSet.contains(bothElementsSet), "Power set should include the subset of both elements.");
    }

    @Test
    public void testThreeElements() {
        List<String> elements = new ArrayList<>();
        elements.add("a");
        elements.add("b");
        elements.add("c");
        List<Set<String>> powerSet = PowerSet.generatePowerSet(elements);
        assertEquals(8, powerSet.size(), "Power set of a three-element set should contain eight subsets.");
        // Test a few select subsets to verify correctness
        assertTrue(powerSet.contains(new HashSet<>())); // Empty set
        assertTrue(powerSet.contains(Set.of("a"))); // Single elements
        assertTrue(powerSet.contains(Set.of("b")));
        assertTrue(powerSet.contains(Set.of("c")));
        assertTrue(powerSet.contains(Set.of("a", "b"))); // Combinations of two elements
        assertTrue(powerSet.contains(Set.of("a", "c")));
        assertTrue(powerSet.contains(Set.of("b", "c")));
        assertTrue(powerSet.contains(Set.of("a", "b", "c"))); // All elements
    }

    @Test
    public void testNonAlphabeticElements() {
        List<String> elements = new ArrayList<>();
        elements.add("1");
        elements.add("#");
        List<Set<String>> powerSet = PowerSet.generatePowerSet(elements);
        assertEquals(4, powerSet.size(), "Power set of a set containing non-alphabetic elements should contain four subsets.");
        assertTrue(powerSet.contains(new HashSet<>())); // Empty set
        assertTrue(powerSet.contains(Set.of("1"))); // Individual elements
        assertTrue(powerSet.contains(Set.of("#")));
        assertTrue(powerSet.contains(Set.of("1", "#"))); // Combination of all elements
    }

    @Test
    public void testDuplicateElementsInInput() {
        List<String> elements = new ArrayList<>();
        elements.add("a");
        elements.add("a");
        elements.add("b");
        List<Set<String>> powerSet = PowerSet.generatePowerSet(new ArrayList<>(new HashSet<>(elements))); // Remove duplicates
        assertEquals(4, powerSet.size(), "Power set should handle duplicate elements correctly and only include unique subsets.");
        assertTrue(powerSet.contains(new HashSet<>())); // Empty set
        assertTrue(powerSet.contains(Set.of("a"))); // Individual element
        assertTrue(powerSet.contains(Set.of("b"))); // Individual element
        assertTrue(powerSet.contains(Set.of("a", "b"))); // Combination of all elements
    }

}
