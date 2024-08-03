class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        HashMap<Integer,Integer>mp=new HashMap<>();
        for(int i=0;i<target.length;i++){
            if(mp.containsKey(target[i])==true){
                int cnt=mp.get(target[i]);
                mp.put(target[i],cnt+1);
            }
            else{
                mp.put(target[i],1);
            }
        }
        for(int i=0;i<arr.length;i++){
            if(mp.containsKey(arr[i])==false){
                return false;
            }
            else{
                int cnt=mp.get(arr[i]);
                cnt=cnt-1;
                if(cnt==0){
                    mp.remove(arr[i]);
                }
                else{
                    mp.put(arr[i],cnt);
                }
            }
        }
        return true;
    }
}
