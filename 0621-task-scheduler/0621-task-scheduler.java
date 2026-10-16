import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int a = tasks.length;
        HashMap<Character, Integer> freq = new HashMap<>();
        HashMap<Character, Integer> free = new HashMap<>();
        for (int i = 0; i < a; i++) {
            freq.put(tasks[i], freq.getOrDefault(tasks[i], 0) + 1);
            free.put(tasks[i], 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (x, y) -> y.getValue() - x.getValue()
        );
        for (Character i : freq.keySet()) {
            pq.add(new Pair(i, freq.get(i)));
        }
        int seat = 1;
        while (!pq.isEmpty()) {
            Vector<Pair> pulled = new Vector<>();
            while (!pq.isEmpty()) {
                Pair p = pq.peek();
                pq.poll();
                int foo = p.getKey();
                int child = p.getValue();
                if (free.get((char) foo) <= seat) {
                    if (p.getValue() > 1) {
                        pq.add(new Pair((char) foo, p.getValue() - 1));
                    }
                    free.put((char) foo, seat + n + 1);
                    break;
                } else {
                    pulled.add(p);
                }
            }
            for (int i = 0; i < pulled.size(); i++) {
                pq.add(pulled.get(i));
            }
            seat++;
        }
        return seat - 1;
    }
    class Pair {
        char key;
        int value;
        Pair(char key, int value) {
            this.key = key;
            this.value = value;
        }
        char getKey() {
            return key;
        }
        int getValue() {
            return value;
        }
    }
}