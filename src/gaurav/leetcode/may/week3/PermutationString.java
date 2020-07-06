package gaurav.leetcode.may.week3;

public class PermutationString {

    public boolean checkInclusion(String p, String s) {

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
            if (i < p.length() - 1) {
                continue;
            }

            boolean isValid = true;
            for (int j = 0; j < 26; j++) {
                if (pCount[j] == 0) continue;
                if (pCount[j] != sCount[j]) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                return true;
            }

            sCount[s.charAt(start++) - 'a']--;
        }

        return false;

    }
}
