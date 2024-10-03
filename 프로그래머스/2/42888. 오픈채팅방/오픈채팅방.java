import java.util.*;

class Solution {
    
    class Entry {
        public String uid;
        public String entry;
        public Entry(String uid, String entry) {
            this.uid = uid;
            this.entry = entry;
        }
    }
    
    public List<String> solution(String[] records) {
        List<String> answer = new ArrayList<>();
        
        Map<String, String> nickname = new HashMap<>();
        List<Entry> entries = new ArrayList<>();
        
        
        for (String record: records) {
            String[] queries = record.split(" ");
            
            if (queries.length == 2) {
                // Leave
                String entry = queries[0];
                String uid = queries[1];
                entries.add(new Entry(uid, entry));
            } else {
                // Enter or Change
                String entry = queries[0];
                String uid = queries[1];
                String name = queries[2];    
                
                if ("Enter".equals(entry)){
                    entries.add(new Entry(uid, entry));    
                }
                // Enter든 Change든 닉네임 반영
                nickname.put(uid, name);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Entry entry: entries) {
            sb.append(nickname.get(entry.uid));
            if ("Enter".equals(entry.entry)) {
                sb.append("님이 들어왔습니다.");
            } else {
                sb.append("님이 나갔습니다.");
            }
            answer.add(sb.toString());
            sb.setLength(0);
        }
        
        return answer;
    }
}