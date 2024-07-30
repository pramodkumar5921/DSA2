class Solution {
    public int minimumDeletions(String s) {
        Stack<Character>st=new Stack<>();
        int n=s.length();
        int ans=0;
        int i=0;
        while(i<n){
            if(st.size()==0){
                st.push(s.charAt(i));
            }
            else if(s.charAt(i)=='a'){
                if(st.peek()=='b'){
                    st.pop();
                    ans++;
                }
                else{
                    st.push(s.charAt(i));
                }
            }
            else{
                st.push(s.charAt(i));
            }
            i++;
        }
        return ans;
    }
}
