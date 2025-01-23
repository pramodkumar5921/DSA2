class Solution {
    public void allCombination(List<List<Integer>>ans,List<Integer>tempAns,int k,int cnt,int target,int n,int i,int[] arr){
        if(i==arr.length){
            if(cnt==k && target==n){
                ans.add(new ArrayList<>(tempAns));
                return;
            }
            return;
        }
        tempAns.add(arr[i]);
        allCombination(ans,tempAns,k,cnt+1,target+arr[i],n,i+1,arr);
        tempAns.remove(tempAns.size()-1);
        allCombination(ans,tempAns,k,cnt,target,n,i+1,arr);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>>ans = new ArrayList<>();
        List<Integer>tempAns = new ArrayList<>();
        int[] arr = new int[9];
        int cnt=1;
        for(int i=0;i<9;i++){
            arr[i]=cnt;
            cnt+=1;
        }
        allCombination(ans,tempAns,k,0,0,n,0,arr);
        return ans;
    }
}
