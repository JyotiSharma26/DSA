class Solution {
    


    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        boolean[] visited = new boolean[n];
        int[] depth = new int[n];
        int maxEmployees = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                maxEmployees = Math.max(maxEmployees, dfs(i, favorite, visited, depth));
            }
        }

        return maxEmployees;
    }

    private int dfs(int node, int[] favorite, boolean[] visited, int[] depth) {
        if (visited[node]) {
            return depth[node] > 0 ? depth[node] : 0;
        }

        visited[node] = true;
        int nextNode = favorite[node];
        depth[node] = 1 + dfs(nextNode, favorite, visited, depth);

        return depth[node];
    }
}    