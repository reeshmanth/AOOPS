package InLab2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class CadetSorterTest {
    
    @Test
    public void testEmptyList() {
        List<String> cadets = new ArrayList<>();
        CadetSorter.sortCadets(cadets);
        assertTrue(cadets.isEmpty(), "List should remain empty");
    }

    @Test
    public void testSingleCadet() {
        List<String> cadets = new ArrayList<>(List.of("Amit"));
        CadetSorter.sortCadets(cadets);
        assertEquals(List.of("Amit"), cadets, "List with one cadet should remain unchanged");
    }

    @Test
    public void testAlreadySortedCadets() {
        List<String> cadets = new ArrayList<>(Arrays.asList("Amit", "John", "Rahul", "Zara"));
        List<String> expected = new ArrayList<>(cadets);
        CadetSorter.sortCadets(cadets);
        assertEquals(expected, cadets, "Already sorted list should remain unchanged");
    }

    @Test
    public void testUnsortedCadets() {
        List<String> cadets = new ArrayList<>(Arrays.asList("Rahul", "John", "Amit", "Zara"));
        List<String> expected = Arrays.asList("Amit", "John", "Rahul", "Zara");
        CadetSorter.sortCadets(cadets);
        assertEquals(expected, cadets, "List should be sorted alphabetically");
    }

    @Test
    public void testCadetsWithDuplicateNames() {
        List<String> cadets = new ArrayList<>(Arrays.asList("Amit", "John", "Amit", "Zara", "John"));
        List<String> expected = Arrays.asList("Amit", "Amit", "John", "John", "Zara");
        CadetSorter.sortCadets(cadets);
        assertEquals(expected, cadets, "List should be sorted, maintaining duplicate names");
    }

    @Test
    public void testCadetsWithDifferentCase() {
        List<String> cadets = new ArrayList<>(Arrays.asList("john", "Amit", "rahul", "Zara"));
        List<String> expected = Arrays.asList("Amit", "Zara", "john", "rahul");
        CadetSorter.sortCadets(cadets);
        assertEquals(expected, cadets, "Sorting should be case-sensitive");
    }
}

