import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class PowerSet{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter elements of the set, separated by spaces:");
        String[] input = scanner.nextLine().split("\\s+");
        Set<String> set = new HashSet<>();
        for (String elem : input) {
            set.add(elem);
        }

        List<Set<String>> powerSet = generatePowerSet(new ArrayList<>(set));
        displayPowerSet(powerSet);
        scanner.close();
    }

    static List<Set<String>> generatePowerSet(List<String> list) {
        List<Set<String>> powerSet = new ArrayList<>();
        int setSize = list.size();
        int powerSetSize = (int) Math.pow(2, setSize);

        for (int i = 0; i < powerSetSize; i++) {
            Set<String> subset = new HashSet<>();
            for (int j = 0; j < setSize; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(list.get(j));
                }
            }
            powerSet.add(subset);
        }

        return powerSet;
    }

    private static void displayPowerSet(List<Set<String>> powerSet) {
        System.out.println("Power Set:");
        for (Set<String> subset : powerSet) {
            System.out.println(subset);
        }
    }
}
