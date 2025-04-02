package InLab2;

import java.util.Collections;
import java.util.List;

public class CadetSorter {
    
    public static void sortCadets(List<String> cadets) {
        if (cadets == null || cadets.isEmpty()) return;
        Collections.sort(cadets);
    }
}
