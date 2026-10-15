import java.util.*;
class Solution {
    public String reorganizeString(String s) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> b.key - a.key
        );
        int freq[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.add(new Pair(freq[i], (char) (i + 'a')));
            }
        }
        ArrayList<Character> res = new ArrayList<>();
        int seat = 0;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            if (seat == 0 || res.get(seat - 1) != p.value) {
                res.add(p.value);
                seat++;
                p.key--;
                if (p.key > 0) {
                    pq.add(p);
                }
            } else {
                if (pq.isEmpty()) {
                    return "";
                }
                Pair p2 = pq.poll();
                res.add(p2.value);
                seat++;
                p2.key--;
                if (p2.key > 0) {
                    pq.add(p2);
                }
                pq.add(p);
            }
        }
        String ans = "";
        for (int i = 0; i < res.size(); i++) {
            ans += res.get(i);
        }
        return ans;
    }
    class Pair {
        int key;
        char value;

        Pair(int key, char value) {
            this.key = key;
            this.value = value;
        }
    }
}