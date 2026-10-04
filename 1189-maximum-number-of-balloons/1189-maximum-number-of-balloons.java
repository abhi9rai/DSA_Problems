class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> have = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            have.put(ch, have.getOrDefault(ch, 0) + 1);
        }
        HashMap<Character, Integer> need = new HashMap<>();
        need.put('b', 1);
        need.put('a', 1);
        need.put('l', 2);
        need.put('o', 2);
        need.put('n', 1);
        return check(have, need);
    }
    public int check(HashMap<Character, Integer> have,HashMap<Character, Integer> need) {
        int res = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> i : need.entrySet()) {
            char c = i.getKey();
            int fneed = i.getValue();
            int fhave = have.getOrDefault(c, 0);
            int times = fhave / fneed;
            res = Math.min(res, times);
        }
        return res;
    }
}