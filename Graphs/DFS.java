import java.util.*;

class DFS {
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[V];
        // Start DFS from node 0
        dfs(0, adj, visited, list);
        return list;
    }
    
    // Helper method to perform DFS
    private void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> list) {
        // Mark the current node as visited and add it to the list
        visited[node] = true;
        list.add(node);
        
        // Recur for all the vertices adjacent to this vertex
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, list);
            }
        }
    }
    
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(0).add(3);
        adj.get(1).add(4);
        
        DFS dfs = new DFS();
        ArrayList<Integer> dfsResult = dfs.dfsOfGraph(V, adj);
        System.out.println("DFS Traversal: " + dfsResult);
    }
}
