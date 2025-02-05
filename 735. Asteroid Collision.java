class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer>st = new Stack<>();
        for(int i=0;i<n;i++){
            if(asteroids[i]>0){
                st.push(asteroids[i]);
            }
            else{
                if(st.size()==0){
                    st.push(asteroids[i]);
                }
                else if(st.peek()<0){
                    st.push(asteroids[i]);
                }
                else{
                    int temp=Math.abs(asteroids[i]);
                    boolean flag=false;
                    while(st.size()>0 && st.peek()>0){
                        if(temp>st.peek()){
                            st.pop();
                        }
                        else if(temp==st.peek()){
                            flag=true;
                            st.pop();
                            break;
                        }
                        else{
                            flag=true;
                            break;
                        }
                    }
                    if(flag==false){
                        st.push(asteroids[i]);
                    }
                }
            }
        }
        int cnt = st.size()-1;
        int[] ans = new int[cnt+1];
        while(st.size()>0){
            ans[cnt]=st.pop();
            cnt-=1;
        }
        return ans;

    }
}
