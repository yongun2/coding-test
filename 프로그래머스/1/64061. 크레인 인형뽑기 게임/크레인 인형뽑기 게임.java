import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> top = new HashMap<>();
        
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if (board[j][i] != 0) {
                    top.put(i + 1, j);
                    break;
                }
            }
        }
        System.out.println(top);
        
        for (int m: moves) {
            if (top.get(m) >= board[m-1].length) continue;
            
            if (stack.size() == 0) {
                stack.push(board[top.get(m)][m-1]);
            } else {
                if (stack.peek() == board[top.get(m)][m-1]) {
                    answer+=2;
                    stack.pop();
                } else {
                    stack.push(board[top.get(m)][m-1]);
                }
            }
            top.put(m, top.get(m) + 1);
        }
        
        
        
        return answer;
    }
}