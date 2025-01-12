class Solution {
    public boolean canBeValid(String s, String locked) {
        Stack<Integer>st1 = new Stack<>();
        Stack<Integer>st2 = new Stack<>();
        if(s.length()%2==1){
            return false;
        }

        for(int i=0;i<s.length();i++){
            if(locked.charAt(i)=='0'){
                st2.add(i);
                continue;
            }
            else{
                if(s.charAt(i)=='('){
                    st1.add(i);
                }
                else{
                    if(st1.size()==0){
                        if(st2.size()==0){
                            return false;
                        }
                        else{
                            st2.pop();
                        }
                    }
                    else{
                        st1.pop();
                    }
                }
            }
        }

        while(st1.size()>0 && st2.size()>0){
            int top1 = st1.peek();
            int top2 = st2.peek();

            st1.pop();
            st2.pop();

            if(top1>top2){
                return false;
            }
        }

        if(st1.size()>0){
            return false;
        }
        if(st2.size()%2==1){
            return false;
        }

        return true;
        
    }
}
