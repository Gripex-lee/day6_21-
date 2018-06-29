package day6_21;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class A064 {
	private static class Pair{
        private int count;
        private int index;
        Pair(int count, int index) {
            this.count = count;
            this.index = index;
        }
        public int getCount() {
            return count;
        }
        public int getIndex() {
            return index;
        }
        public void setCount(int count) {
            this.count = count;
        }
        public void setIndex(int index) {
            this.index = index;
        }
    }
    public static void firstKNonRepeating(String str, int k) {
        Map<Character, Pair> map = new HashMap<>();
        for (int i = 0 ; i < str.length(); i++){
            if (!map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), new Pair(1, i));
            }
            else {
                Pair pair = map.get(str.charAt(i));
                pair.setCount(pair.getCount() + 1);
                pair.setIndex(i);
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Map.Entry<Character,Pair> entry: map.entrySet()) {
            int count = entry.getValue().getCount();
            int index = entry.getValue().getIndex();
            if (count == 1) {
                pq.add(index);
            }
        }
        while (k-- > 0 && !pq.isEmpty()){
            int min_index = pq.poll();
            System.out.print(str.charAt(min_index) + " ");
        }
    }
    public static void main (String[] args){
    	Scanner br=new Scanner(System.in);
        String str = br.nextLine();
        int k = br.nextInt();
        firstKNonRepeating(str, k);
    }
}
