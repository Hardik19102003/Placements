import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimizeTransactions {
    public static int minTransfers(int[][] debts) {
        Map<Integer, Integer> balance = new HashMap<>();
        
        // Calculate the net balance for each person
        for (int[] debt : debts) {
            int from = debt[0], to = debt[1], amount = debt[2];
            balance.put(from, balance.getOrDefault(from, 0) - amount);
            balance.put(to, balance.getOrDefault(to, 0) + amount);
        }
        
        // Filter out zero balances
        List<Integer> netBalances = new ArrayList<>();
        for (int bal : balance.values()) {
            if (bal != 0) {
                netBalances.add(bal);
            }
        }
        
        // Recursively find the minimum number of transactions
        return settle(0, netBalances);
    }

    private static int settle(int start, List<Integer> netBalances) {
        while (start < netBalances.size() && netBalances.get(start) == 0) {
            start++;
        }
        if (start == netBalances.size()) {
            return 0;
        }

        int minTransactions = Integer.MAX_VALUE;
        for (int i = start + 1; i < netBalances.size(); i++) {
            if (netBalances.get(i) * netBalances.get(start) < 0) {
                netBalances.set(i, netBalances.get(i) + netBalances.get(start));
                minTransactions = Math.min(minTransactions, 1 + settle(start + 1, netBalances));
                netBalances.set(i, netBalances.get(i) - netBalances.get(start));  // backtrack
            }
        }
        
        return minTransactions;
    }

    public static void main(String[] args) {
        int[][] debts = {
            {0, 1, 20},
            {1, 0, 10},
            {1, 2, 10},
            {2, 0, 10}
        };
        
        System.out.println(minTransfers(debts));  // Output: 1
    }
}
