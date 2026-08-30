class Solution {
    Set<Integer> currPath = new HashSet<>(); 
    public boolean validTree(int n, int[][] edges) {
        //valid tree -> no CYCLES?are 


        //tree vs graph -> tree has no cycles, graph has cycles: tree is also fully connected so we have to loop thru all n nodes. 

        //so if we can detect cycles, and a call from root returns true (for yes cycles)
            //r false bcuz a tree wouldnt have cycles and this representation does.
        //if no cycle
            //r true. 
        
        //graph is an abstraction where we can use GRAPH algorithms to traverse nodes. good w recursion
            //dfs, bfs, djikstras
            //dfs is depth first search - used to go deep as possible and show ALL paths. 
                //stack, and good w recursion  (via call stack)
                //cycle detection, yes 
                //runtime is O(V+E)
            //bfs is breadth first search - good for SPT and also all paths
                //queue, can be recursive but a lil trickier and requires q (cant use stack)
                //cycle detectionm, yes
                // O(V+E)
            //djkistras - used for spt w weighted edges
                //bfs variant with pq for weighted edges
                //********not needed for this problem - every edge is == 1. 

            //will use dfs because of the GOOD w recursion fact. 

            //ok so dfs is decided. 


            //1) adj List
                //representation of the graph via hm with node -> all edges.
                    //key, val is int -> list of ints. 
                //need an entry for every value 0 to n -1. 
                //if no outgoning edges (leaf nodes lets say) -> empty list. 
        Map<Integer, List<Integer>> adjList = new HashMap<>(); 
        for (int[] edge : edges) {
            int src = edge[0]; 
            int tgt = edge[1]; 
            pair(adjList, src, tgt); 
            pair(adjList, tgt, src); 
        } 

                //edges are undirected - so (1, 0) is equiv to (0, 1). 
                //make another function union where we map node 1, and node 2 and vice versa within the hashmap.  so we call function twice where node 1. node 2, and then node 2, node 1. 

            //3) union
                //for the hm, , if it has the node 1 then we get node 1s list and add 0.
                //else just put w new list and node 2 added in. 

            
            //2)calling the dfs
                //for every possible value within the graph:
                    //(0 to n - 1)
                        //we can call dfs, and if A SINGLE ONE returns false we can r false immediately. 
            //else r true. 
        for (int i = 0; i < n; i++) {
            if (!adjList.containsKey(i)) {
                adjList.put(i, new ArrayList<>()); 
            }
        }

        if (!dfs(0, -1, adjList)) return false; 
        // if (safe.size() != n) return false;  

        return currPath.size() == n; 

            //3) dfs(int node)
                //currPath set for cycle detection. why?
                //safeNodes set for nodes we have alr seen and deemed to not lead to cycles.
                //if node we r on is in currpath, return f -> means a cycle. cuz ATP in the recursion
                //we are exploring an original call fully to see if there is ANY chance of cycle fromt hat OG node 
                //so from node 1, we r exploring ALL of node 1s neighbors to see if itll lead us back to 1 
                //if so, cycle 

                //but if we none, then that node 1 is safe and we can add it to safeNodes so if another node goes to it, we know that the rest of the paths from there r safe for it. 

                //so add to currpath, explore neighbors -> r false if cycle.
                //after neigh, take og node and add remove from currpath and add to safe and r true. 

        
    }
    public boolean dfs(int node, int parent, Map<Integer, List<Integer>> adjList) {
            if (currPath.contains(node)) return false; 

            currPath.add(node); 

            for (int neigh : adjList.get(node)) {
                if (neigh == parent) continue; 
                if (!dfs(neigh, node, adjList)) return false; 
            }

            return true; 
        }

    public void pair(Map<Integer, List<Integer>> adjList, int node1, int node2) {
            if (!adjList.containsKey(node1)) {
                adjList.put(node1, new ArrayList<>()); 
            }
            adjList.get(node1).add(node2); 
        }
}
