// hash set 
class Solution {
    public int countPalindromicSubsequence(String s) {
        // find unique chars
        HashSet<Character> set = new HashSet<>();
        int n = s.length();
        for(int i=0;i<n;i++){
            set.add(s.charAt(i)); //a,b,c
        }

        int count=0;
        for(char ch : set){
            int first=-1;
            int last = -1;
            for(int i=0;i<n;i++){
                if(ch == s.charAt(i)){
                    if(first == -1){
                        first = i;
                    }
                    last = i;
                }
            }
            if(first == last) continue;
            HashSet<Character> set1 = new HashSet<>();
            for(int i=first+1;i<last;i++){
                set1.add(s.charAt(i));
            }
            count += set1.size();
        }
        return count;
    }
}

// map
