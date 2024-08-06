class Solution {
    public int minimumPushes(String word) {
        HashMap<Character,Integer>mp=new HashMap<>();
        ArrayList<Integer>arr=new ArrayList<>();
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(mp.containsKey(ch)==true){
                int cnt=mp.get(ch);
                mp.put(ch,cnt+1);
            }
            else{
                mp.put(ch,1);
            }
        }
        for(Map.Entry<Character,Integer>it:mp.entrySet()){
            int cnt=it.getValue();
            arr.add(cnt);
        }
        Collections.sort(arr);
        int ans=0;
        int cnt=1;
        int temp=1;
        for(int i=arr.size()-1;i>=0;i--){
            ans+= arr.get(i) * temp;
            if(cnt%8==0){
                temp=temp+1;
            }
            cnt++;
        }
        return ans;
    }
}
