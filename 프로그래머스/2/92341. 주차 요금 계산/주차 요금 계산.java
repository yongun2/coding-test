import java.util.*;

class Solution {
    
    class Result {
        int num;
        int fee;
        public Result(int num, int fee) {
            this.num = num;
            this.fee = fee;
        }
    }
    public List<Integer> solution(int[] fees, String[] records) {
        
        
        Map<String, Integer> table = new HashMap<>();
        Map<String, List<Integer>> entry = new HashMap<>();
        
        // 기본 시간, 기본 요금, 단위 시간, 단위 요금
        Map<String, Integer> parkTime = new HashMap<>();
        
        for (String record: records) {
            String[] query = record.split(" ");
            int time = toMin(query[0]);
            String num = query[1];
            String way = query[2];
            
            entry.putIfAbsent(num, new ArrayList());
            entry.get(num).add(time);
        }
        
        System.out.println(entry);
        
        for (String key : entry.keySet()) {
            List<Integer> t = entry.get(key);
            table.putIfAbsent(key, 0);
            if (t.size() % 2 == 0) {
                for (int i = 0; i < t.size() - 1; i += 2) {
                    int diff = t.get(i + 1) - t.get(i);
                    System.out.printf("key = %s diff = %d\n", key, diff);
                    table.put(key, table.get(key) + diff);
                }
            } else {
                for (int i = 0; i < t.size() - 1; i += 2) {
                    table.put(key, table.get(key) + t.get(i + 1) - t.get(i));
                }
                
                table.put(key, table.get(key) + toMin("23:59") - t.get(t.size() - 1));
            }
        }
        System.out.println(table);
        
        List<Result> results = new ArrayList<>();
        int index = 0;
        for (String key: table.keySet()) {
            Integer num = Integer.parseInt(key);
            int fee;
            if (table.get(key) <= fees[0]) {
                fee = fees[1];
            } else {
                fee = fees[1] + (int) Math.ceil(((double)(table.get(key) - fees[0]) / fees[2])) * fees[3];    
            }
            System.out.printf("num: %d fee: %d\n", num, fee);
            results.add(new Result(num, fee));
        }
        
        Collections.sort(results, (a, b) -> a.num - b.num);
        List<Integer> answer = new ArrayList<>();
        for (Result result: results) {
            answer.add(result.fee);
        }
        System.out.println(answer);
    
        
        return answer;
    }
    
    private int toMin(String time) {
        StringTokenizer st = new StringTokenizer(time, ":");
        int result = 0;
        result += Integer.parseInt(st.nextToken()) * 60;
        result += Integer.parseInt(st.nextToken());
        return result;
    }
}