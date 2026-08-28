class Solution {
    Set<Integer> safe = new HashSet<>(); 
    Set<Integer> currPath = new HashSet<>(); 
    Map<Integer, List<Integer>> adjList = new HashMap<>(); 

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int[] pre : prerequisites) {
            int crs = pre[0]; 
            int prereq = pre[1]; 
            if (!adjList.containsKey(crs)) {
                adjList.put(crs, new ArrayList<>()); 
            }
            adjList.get(crs).add(prereq); 
        }

        for (int i = 0; i < numCourses; i++) {
            if (!adjList.containsKey(i)) adjList.put(i, new ArrayList<>()); 
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) return false; 
        }
        return true; 
    }

    public boolean dfs(int course) {
        if (currPath.contains(course)) return false; 
        if (safe.contains(course)) return true; 

        currPath.add(course); 

        for (int neigh : adjList.get(course)) {
            if (!dfs(neigh)) return false; 
        }

        //if we get out of this then this path is safe.
        currPath.remove(course); 
        safe.add(course); 
        return true; 
    }
}
