class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int longest = 1;
        int strictlyIncreasing = 1;
        int strictlyDecreasing = 1;
        
        for (int i = 1; i < n; ++i) {
            if (nums[i] > nums[i - 1]) {
                strictlyIncreasing++;
                strictlyDecreasing = 1;
            } else if (nums[i] < nums[i - 1]) {
                strictlyDecreasing++;
                strictlyIncreasing = 1;
            } else {
                strictlyIncreasing = 1;
                strictlyDecreasing = 1;
            }
            
            longest = Math.max(longest, Math.max(strictlyIncreasing, strictlyDecreasing));
        }
        
        return longest;
    }
}

