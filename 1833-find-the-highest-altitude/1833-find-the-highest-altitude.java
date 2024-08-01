import java.util.*;

class Solution {
    public int largestAltitude(int[] gain) {
    
        int cur = 0;
        int result = 0;
        for (int g: gain) {
            cur += g;
            result = Math.max(cur, result);
        }

        return result;
    }
}