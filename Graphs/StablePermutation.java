import java.util.Arrays;
import java.util.HashSet;

public class StablePermutation {

    public static int findStabilizationIterations(int[] P) {
        int n = P.length;
        int[] target = new int[n];
        for (int i = 0; i < n; i++) {
            target[i] = i + 1; // Target stable permutation [1, 2, ..., n]
        }

        HashSet<String> seenPermutations = new HashSet<>();
        int iterations = 0;

        while (true) {
            if (Arrays.equals(P, target)) {
                return iterations;
            }

            String currentPermutation = Arrays.toString(P);
            if (seenPermutations.contains(currentPermutation)) {
                return -1; // Detected a cycle, hence P is unstable
            }
            seenPermutations.add(currentPermutation);

            P = applyPermutation(P);
            iterations++;
        }
    }

    private static int[] applyPermutation(int[] P) {
        int n = P.length;
        int[] newP = new int[n];
        for (int i = 0; i < n; i++) {
            newP[i] = P[P[i] - 1];
        }
        return newP;
    }

    public static void main(String[] args) {
        int[] P = {2, 3, 1, 4};
        System.out.println(findStabilizationIterations(P)); // Output: number of iterations or -1 if unstable
    }
}
