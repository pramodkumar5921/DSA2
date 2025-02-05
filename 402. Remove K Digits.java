class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if(n==k){
            return "0";
        }
        Stack<Integer>st = new Stack<>();
        for(int i=0;i<n;i++){
            int tempNum = num.charAt(i)-'0';
            if(st.size()==0){
                st.push(tempNum);
            }
            else{
                while(st.size()>0 && k>0){
                    if(st.peek()>tempNum){
                        st.pop();
                        k-=1;
                    }
                    else{
                        break;
                    }
                }
                st.push(tempNum);
            }
        }
        while(st.size()>0 && k>0){
            st.pop();
            k-=1;
        }
        String ans = "";
        while(st.size()>0){
            ans=Integer.toString(st.peek())+ans;
            st.pop();
        }
        String res = "";
        boolean flag = false;
        for(int i=0;i<ans.length();i++){
            if(ans.charAt(i)=='0' && flag==false){
                continue;
            }
            else{
                flag=true;
                res+=ans.charAt(i);
            }
        }
        if(res.length()==0){
            return "0";
        }
        return res;
    }
}
