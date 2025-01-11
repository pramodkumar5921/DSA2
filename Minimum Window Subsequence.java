import java.util.*;
public class Solution {

    // public static boolean check(String tempAns ,int[] Store){
    //     for(int i=0;i<tempAns.length();i++){
    //         if(Store[i]>tempVis[i]){
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    public static int isSubsequence(int i,int j,String str1,String str2,HashMap<String,Integer>mp){
        if(j==str2.length()){
            return i-1;
        }

        if(i==str1.length()){
            return -1;
        }

        String str = Integer.toString(i) + "#" + Integer.toString(j);

        if(mp.containsKey(str)==true){
            return mp.get(str);
        }

        if(str1.charAt(i)==str2.charAt(j)){
            int result = isSubsequence(i+1,j+1,str1,str2,mp);
            mp.put(str,result);
            return result;
        }

        int temp = isSubsequence(i+1, j, str1, str2,mp);

        mp.put(str,temp);

        return temp;
    }
    
    public static String minWindow(String S, String T) {
        ArrayList<Integer>startArr = new ArrayList<>();

        int lenT = T.length();

        for(int i=0;i<S.length();i++){
            if(i+lenT>=S.length()){
                continue;
            }
            if(T.charAt(0) == S.charAt(i)){
                startArr.add(i);
            }
        }

        if(startArr.size()==0){
            return "";
        }

        String ans = "";

        char endTChar = T.charAt(T.length()-1); 

        int[] Store = new int[26];

        for(int i=0;i<T.length();i++){
            int idx = (int)T.charAt(i)-'a';
            Store[idx]++;
        }

        int maxLen = 10000000;
        
        for(int i=0;i<startArr.size();i++){

            HashMap<String,Integer>mp=new HashMap<>();
            int ith = isSubsequence(startArr.get(i),0,S,T,mp);

            if(ith==-1){
                break;
            } 
            
            String tempAns = "";
            // int[] tempVis = new int[26];

            int j=startArr.get(i);
            while(j<=ith){
                tempAns+= S.charAt(j);
                // int idx = (int)S.charAt(j)-'a';
                // tempVis[idx]++;
                j++;
            }

            if(maxLen > tempAns.length()){
                ans=tempAns;
                maxLen=tempAns.length();
            }

        }

        return ans;
    }
}
