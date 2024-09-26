import java.util.*;

class Solution {
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        
        Map<String, String> termsMap = new HashMap<>();
        
        int todaySec = toSec(today);
        System.out.println(todaySec);
        for (String term: terms) {
            String[] query = term.split(" ");
            termsMap.put(query[0], query[1]);
        }
        
        System.out.println(termsMap);
        
        for (int i = 1; i <= privacies.length; ++i) {
            String[] query = privacies[i-1].split(" ");
            String term = query[1];
            int yearSec = toSec(query[0]) + Integer.parseInt(termsMap.get(term)) * 28 * 24 * 60;
         
            
            if (yearSec <= todaySec) {
                answer.add(i);
            }    
        }
        
        System.out.println(answer);
        
        
        
        return answer;
    }
    
    private int toSec(String day) {
        
        StringTokenizer st = new StringTokenizer(day, ".");
    
        int result = 0;
        result += Integer.parseInt(st.nextToken()) * 12 * 28 * 24 * 60;
        result += Integer.parseInt(st.nextToken()) * 28 * 24 * 60;
        result += Integer.parseInt(st.nextToken()) * 24 * 60;
        
        return result;
    }
}