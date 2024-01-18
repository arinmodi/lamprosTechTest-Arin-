import java.util.*;

public class Problem_1 {

    public static void main(String[] args) {
        // creating graph for course and pre-requisties
        List<List<Integer>> adj = new ArrayList<>();
        int n=4;

        for (int i=0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(2).add(1);
        adj.get(3).add(1);

        List<Integer> ans = findTopo(adj);

        System.out.println(ans.toString());

    }

    public static List<Integer> findTopo(List<List<Integer>> adj) {
        /** Algo: 
         * 
         * Step 1 : Counting the indgree of each node
         * Step 2 : Adding the nodes with 0 indegree to the queue cause it will not have any dependency
         * Step 3 : Loop through queue nodes and decrementing the inDegree of the nodes which are neighbour of the poped element
         *          and adding it to the queue if it's indegree become zero
         * 
        */

        

        List<Integer> ans = new ArrayList<>();

        int n = adj.size();
        int[] inDegree = new int[n];

        for (int i=0; i < n; i++) {
            for (int nbs : adj.get(i)) {
                inDegree[nbs]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i=0; i < n; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        int count = 0;

        while(!q.isEmpty()) {
            int node = q.remove();
            ans.add(node);
            count++;

            for (int nb : adj.get(node)) {
                inDegree[nb]--;
                if (inDegree[nb] == 0) {
                    q.add(nb);
                }
            }
        }

        // chekcing for cycle, if count > n then it means there is cycle, so no answer possible

        if (count > n) return new ArrayList<Integer>();

        return ans;
    }
    
}
