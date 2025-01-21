import java.util.ArrayList;
import java.util.List;

class Solution {
    public void allPossibility(String str, int i, long target, String path, List<String> ans,long eval,long residual){
        if(i==str.length()){
            if(eval==target){
                ans.add(path);
                return;
            }
        }

        long num = 0;
        String currPath = "";

        for(int j=i;j<str.length();j++){
            num = num*10+(int)str.charAt(j)-'0';
            currPath += str.charAt(j);
            if(j>i && str.charAt(i)=='0'){
                return;
            }
            if(i==0){
                allPossibility(str,j+1,target,path+currPath,ans,num,num);
            }
            else{
                allPossibility(str,j+1,target,path+'+'+currPath,ans,eval+num,num);
                allPossibility(str,j+1,target,path+'-'+currPath,ans,eval-num,-num);
                allPossibility(str,j+1,target,path+'*'+currPath,ans,eval-residual+residual*num,residual*num);
            }
        }
    }
    public List<String> addOperators(String num, int target) {
        int n = num.length();
        List<String> ans = new ArrayList<>();
        long num1 = (long)target;
        allPossibility(num, 0, num1,"", ans,0,0);
        return ans;
    }
}
