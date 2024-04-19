import java.util.Stack;

public class nextGreaterElem {
    static int[] nextGreater(int[] nums1, int[] nums2){
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[nums2.length];

        for (int i = nums2.length-1; i >= 0; i--) {
            if(st.size() == 0){
                ans[i] = -1;
                st.push(nums2[i]);
            }else{
                while(st.size()!= 0){
                    if(nums2[i] >= st.peek()){
                        st.pop();
                    }else{
                        ans[i] = st.peek();
                        st.push(nums2[i]);
                        break;
                    }
                }
                
                if(st.size() == 0){
                    st.push(nums2[i]);
                }
                ans[i]=-1;
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = ans[i];
        }
        return nums1;
    }
}
