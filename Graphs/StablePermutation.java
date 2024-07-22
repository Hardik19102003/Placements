import java.util.Arrays;
import java.util.HashSet;

public class StablePermutation {

     public static int findStabilizationIterations(ArrayList<Integer> P) {
        int n = P.size();
        ArrayList<Integer> target = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            target.add(i); // Target stable permutation [1, 2, ..., n]
        }

        HashSet<String> seenPermutations = new HashSet<>();
        int iterations = 0;

        while (true) {
            if (P.equals(target)) {
                return iterations;
            }

            String currentPermutation = P.toString();
            if (seenPermutations.contains(currentPermutation)) {
                return -1; // Detected a cycle, hence P is unstable
            }
            seenPermutations.add(currentPermutation);

            P = applyPermutation(P);
            iterations++;
        }
    }

    private static ArrayList<Integer> applyPermutation(ArrayList<Integer> P) {
        int n = P.size();
        ArrayList<Integer> newP = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            newP.add(P.get(P.get(i) - 1));
        }
        return newP;
    }

    public static void main(String[] args) {
        ArrayList<Integer> P = new ArrayList<>(Arrays.asList(2, 3, 1, 4));
        System.out.println(findStabilizationIterations(P)); // Output: number of iterations or -1 if unstable
    }
}
}
