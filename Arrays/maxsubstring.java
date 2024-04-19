import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class maxsubstring {
    public int lenOfSubstring(String s) {
        HashMap<Character, Integer> mpp = new HashMap<>();
        int len = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (mpp.containsKey(s.charAt(i))) {
                left = Math.max(mpp.get(s.charAt(i)) + 1, left);
            }
            mpp.put(s.charAt(i), i);
            len = Math.max(len, i - left + 1);
        }
        return len;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mod = 1000000000+7;
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int len = sc.nextInt();
            String s = sc.next();
            char[] sortedString = s.toCharArray();
            Arrays.sort(sortedString);
            int cnt = 0;
            HashMap<String, Integer> temp = new HashMap<>();
            for (int j = 0; j < sortedString.length; j++) {
                String t1 = "";
                for (int j2 = j; j2 < sortedString.length; j2++) {
                    t1 += sortedString[j2];
                    temp.put(t1, 1);
                }
            }
            System.out.println(temp.size()%mod);
        }
    }
}
