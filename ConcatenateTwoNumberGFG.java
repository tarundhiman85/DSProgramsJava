import java.util.HashMap;
import java.util.Map;

public class ConcatenateTwoNumberGFG {
    static long countPairs(int N, int X, int numbers[]){
        Map<String,Integer> hm = new HashMap<>();
        for (int z:
             numbers) {
            String s = Integer.toString(z);
            hm.put(s,hm.getOrDefault(s,0)+1);
        }
        long count = 0L;
        String x = Integer.toString(X);
        for (String k:
             hm.keySet()) {
            if(k.length()>=x.length()) continue;
            int index = x.indexOf(k);
            String req = x.substring(k.length());
            if(index==0 && hm.containsKey(req)){
                int val = hm.get(req);
                if(req.equals(k)) count+=((long) val *(val-1));
                else count+=((long) val *hm.get(k));
            }
        }
        return count;
    }
    public static void main(String[] args) {
        countPairs(4,1212, new int[]{1, 212, 12, 12});
    }
}
