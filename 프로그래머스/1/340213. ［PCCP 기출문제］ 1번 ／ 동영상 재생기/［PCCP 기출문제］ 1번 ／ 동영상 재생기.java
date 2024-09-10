class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        // 10초전 이동, 10초후 이동, 건너뛰기
        
        int total = Integer.parseInt(video_len.substring(0, 2)) * 60 
            + Integer.parseInt(video_len.substring(3, 5));
        
        int opStart = Integer.parseInt(op_start.substring(0, 2)) * 60 
            + Integer.parseInt(op_start.substring(3, 5));
        
        int opEnd = Integer.parseInt(op_end.substring(0, 2)) * 60 
            + Integer.parseInt(op_end.substring(3, 5));
        
        int cur = Integer.parseInt(pos.substring(0, 2)) * 60 
            + Integer.parseInt(pos.substring(3, 5));
        
        System.out.println(cur);
        for(String command: commands) {
            if (opStart <= cur && cur <= opEnd) {
                cur = opEnd;   
            }
            
            if (cur < 0) {
                cur = 0;
            } else if (cur >= total){
                cur = total;
            }
            
            if("prev".equals(command)) {
                cur -= 10;
            } else {
                cur += 10;
            }
            
            if (opStart <= cur && cur <= opEnd) {
                cur = opEnd;   
            }
            
            if (cur < 0) {
                cur = 0;
            } else if (cur >= total){
                cur = total;
            }
        }
        
        
        System.out.println(cur);
        
        int min = (int) cur / 60;
        int sec = cur % 60;
            
        if (min / 10 == 0) {
            answer += "0" + String.valueOf(min);
        } else {
            answer += String.valueOf(min);
        }
        
        answer += ":";
        
        if (sec / 10 == 0) {
            answer += "0" + String.valueOf(sec);
        } else {
            answer += String.valueOf(sec);
        }
        
        
        
        return answer;
    }
}