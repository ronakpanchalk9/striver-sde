import java.util.ArrayList;
import java.util.List;

public class palindromePartition {
    static boolean isPalindrome(String s, int start, int end){
        while(start <= end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
    static void solve(List<String> tmp, List<List<String>> ans, String s, int idx){
        if(idx == s.length()){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = idx; i < s.length(); ++i) {
            if(isPalindrome(s, idx, i)){
                tmp.add(s.substring(idx, i+1));
                solve(tmp, ans, s, idx+1);
                tmp.remove(tmp.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s){
        List<String> tmp = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        solve(tmp, ans, s, 0);
        return ans;
    }
}
