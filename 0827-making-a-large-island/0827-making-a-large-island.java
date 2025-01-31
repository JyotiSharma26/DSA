class Solution {
    private int[] dir = {-1, 0, 1, 0, -1};

    private boolean isValid(int n, int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < n);
    }

    private int markIsland(int[][] grid, int islandNumber, int n, int x, int y) {
        grid[x][y] = islandNumber;
        int count = 1;
        for (int i = 0; i < 4; ++i) {
            int newX = x + dir[i];
            int newY = y + dir[i + 1];
            if (isValid(n, newX, newY) && grid[newX][newY] == 1) {
                count += markIsland(grid, islandNumber, n, newX, newY);
            }
        }
        return count;
    }

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        Map<Integer, Integer> islandSize = new HashMap<>();
        int islandNumber = 2;

        // Mark islands
        for (int x = 0; x < n; ++x) {
            for (int y = 0; y < n; ++y) {
                if (grid[x][y] == 1) {
                    int island = markIsland(grid, islandNumber, n, x, y);
                    islandSize.put(islandNumber, island);
                    islandNumber++;
                }
            }
        }

        // Try to convert each 0 to 1 one by one
        int maxSize = 0;
        for (int x = 0; x < n; ++x) {
            for (int y = 0; y < n; ++y) {
                if (grid[x][y] == 0) {
                    Set<Integer> islands = new HashSet<>();
                    for (int i = 0; i < 4; ++i) {
                        int newX = x + dir[i];
                        int newY = y + dir[i + 1];
                        if (isValid(n, newX, newY)) {
                            islands.add(grid[newX][newY]);
                        }
                    }
                    // Iterate and find total size of current island
                    int currIsland = 1;
                    for (int key : islands) {
                        currIsland += islandSize.getOrDefault(key, 0);
                    }
                    maxSize = Math.max(maxSize, currIsland);
                }
            }
        }
        return maxSize == 0 ? n * n : maxSize;
    }
}

