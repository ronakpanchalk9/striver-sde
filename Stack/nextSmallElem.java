import java.util.ArrayList;
import java.util.Stack;

public class nextSmallElem {
    public static ArrayList<Integer> prevSmaller(ArrayList<Integer> arr){
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        boolean got = false;
        for (int i = 0; i < arr.size(); i++) {
            if(st.empty()){
                ans.add(-1);
                st.push(arr.get(i));
            }else{
                while(!st.empty()){
                    got = false;
                    if(st.peek() < arr.get(i)){
                        ans.add(st.peek());
                        st.push(arr.get(i));
                        got = true;
                        break;
                    }else{
                        st.pop();
                    }
                }
                if(got == false){
                    ans.add(-1);
                    st.push(arr.get(i));
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(34);
        arr.add(35);
        arr.add(27);
        arr.add(42);
        arr.add(5);
        arr.add(28);
        arr.add(39);
        arr.add(20);
        arr.add(28);
        System.out.println(prevSmaller(arr));
    }
}
