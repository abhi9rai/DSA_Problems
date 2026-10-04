class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
         HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> have = new HashMap<>();
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            have.put(c, have.getOrDefault(c, 0) + 1);
        }
        return check(need, have);
    }
    static boolean check(HashMap<Character, Integer> need,
                         HashMap<Character, Integer> have) {
        for (char c : need.keySet()) {
            int fneed = need.get(c);
            int fhave = have.getOrDefault(c, 0);
            if (fhave < fneed) {
                return false;
            }
        }
        return true;
    }
}