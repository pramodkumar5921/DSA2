class Solution {
    Map<Integer,Integer>mp=new HashMap<>();
    public int MapValue(int val){
        String str=Integer.toString(val);
        int n=str.length();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            int ch=str.charAt(i)-'0';
            arr[i]=mp.get(ch);
        }
        int temp=0;
        for(int i=0;i<n;i++){
            temp=temp*10+arr[i];
        }
        return temp;
    }
    public static boolean cmp(List<Integer>a,List<Integer>b){
        if(!a.get(0).equals(b.get(0))){
            return a.get(0)<b.get(0);
        }
        return a.get(1)<b.get(1);
    }
    public int[] sortJumbled(int[] mapping, int[] nums) {
        for(int i=0;i<mapping.length;i++){
            mp.put(i,mapping[i]);
        }
        List<List<Integer>>temp=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int val=MapValue(nums[i]);
            List<Integer>dummy=new ArrayList<>();
            dummy.add(val);
            dummy.add(i);
            dummy.add(nums[i]);
            temp.add(dummy);
        }
        temp.sort((a,b)->cmp(a,b) ? -1 : 1);
        int[] ans=new int[nums.length];
        for(int i=0;i<temp.size();i++){
            ans[i]=temp.get(i).get(2);
        }
        return ans;
    }
}
