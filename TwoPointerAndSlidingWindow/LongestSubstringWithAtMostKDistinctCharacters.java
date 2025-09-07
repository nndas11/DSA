package TwoPointerAndSlidingWindow;

//

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {
    public static void main(String[] args) {
        System.out.println(LongestSubstringWithAtMostKDistinctCharacters("eccceeaeba", 2));
    }

    private static int LongestSubstringWithAtMostKDistinctCharacters(String s, int k){
        int n = s.length();
        int l = 0;
        int r = 0;

        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();

        while(r < n){
            char ch = s.charAt(r);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            if(map.size() > k){
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                if(map.get(s.charAt(l)) == 0)    map.remove(s.charAt(l));
                l++;
            }
            maxLength = Math.max(maxLength, r - l + 1);
            r++;
        }

        return maxLength;
    }
}
