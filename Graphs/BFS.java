import java.util.*;

class BFS {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        
        // Start BFS traversal from node 0
        q.add(0);
        visited[0] = true;
        
        while (!q.isEmpty()) {
            int curr = q.poll();  // Retrieve and remove the head of the queue
            list.add(curr);  // Add the current node to the result list
            
            // Get all adjacent vertices of the dequeued node
            for (int neighbor : adj.get(curr)) {
                if (!visited[neighbor]) {
                    q.add(neighbor);  // Add the unvisited neighbor to the queue
                    visited[neighbor] = true;  // Mark it as visited
                }
            }
        }
        
        return list;
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
        
        BFS bfs = new BFS();
        ArrayList<Integer> bfsResult = bfs.bfsOfGraph(V, adj);
        System.out.println("BFS Traversal: " + bfsResult);
    }
}
