import java.util.*;
import java.util.stream.*;

class Solution {
    
    private Map<String, Integer> map = new HashMap<>();
    private List<Integer> choice = new ArrayList<>();
    
    public List<String> solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        // 이전에 가장 많이 함께 주문한 단품메뉴들을 코스요리 메뉴로 구성
        // 단 2개 이상의 단품메뉴 && 2명 이상의 손님이 주문한 단품메뉴 조합
        
        for (String order: orders) {
            for (int n: course) {
                sequence(order, 0, 0, n);
            }
        }
        
        
        for (int size: course) {
            int max = Integer.MIN_VALUE;
            
            for (String key: map.keySet()) {
                if (key.length() == size) {
                    max = Math.max(max, map.get(key));    
                }    
            }
            
            if (max <= 1) {
                continue;
            }
            for (String key: map.keySet()) {
                if (key.length() == size && 
                    map.get(key) == max
                   ) {
                    answer.add(key);
                }
            }
            
        }
        
        Collections.sort(answer);
        
        
        return answer;
    }
    
    private void sequence(String order, int depth, int s, int n) {
        if (depth == order.length()) {
            if (s == n) {
                result(order);
            }
            return;
        }
        
        choice.add(0);
        sequence(order, depth + 1, s, n);
        choice.remove(choice.size() - 1);
        
        choice.add(1);
        sequence(order, depth + 1, s + 1, n);
        choice.remove(choice.size() - 1);
    }
    private void result(String order) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < order.length(); ++i) {
            if(choice.get(i) == 1) {
                sb.append(String.valueOf(order.charAt(i)));
            }
        }
        
        String result = sb.toString();
        char[] tmp = result.toCharArray();
        Arrays.sort(tmp);
        result = new String(tmp);
        
        map.putIfAbsent(result, 0);
        map.put(result, map.get(result) + 1);
        
    }
}