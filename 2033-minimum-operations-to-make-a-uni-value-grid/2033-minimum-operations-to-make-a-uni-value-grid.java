class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        
        List<Integer> vec = new ArrayList<>();
        
        // Flatten the grid into a list
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                vec.add(grid[i][j]);
            }
        }
        
        int L = vec.size();
        
        // Find the median using sorting (alternative to nth_element in C++)
        Collections.sort(vec);
        int target = vec.get(L / 2);
        
        int result = 0;
        for (int num : vec) {
            if (num % x != target % x) {
                return -1;
            }
            result += Math.abs(target - num) / x;
        }
        
        return result;
    }
}