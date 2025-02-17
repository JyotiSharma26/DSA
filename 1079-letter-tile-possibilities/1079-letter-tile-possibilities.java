class Solution {
    int len;
    public int numTilePossibilities(String tiles) {
        len = tiles.length();
        int freq[] = new int[26];
        for(int i=0;i<len;i++){
            freq[tiles.charAt(i) - 'A']++;
        }
        int count = backtrack(freq);
        return count;
    }
    public int backtrack(int freq[]){
        int count=0;
        for(int i=0;i<26;i++){
            if(freq[i]==0) continue;
            count++;
            freq[i]--;
            count += backtrack(freq);
            freq[i]++;
        }
        return count;
    }
}