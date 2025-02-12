//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            System.out.println(new Solution().countSubstr(s, k));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends
class Solution {
    int solutionForK1(String s,int k){
        HashMap<Character,Integer>mp1 = new HashMap<>();
        int ib=0,j=0;
        int ans = 0;
        while(true){
            boolean f1 = false;
            boolean f2 = false;
            while(ib<s.length()){
                f1 = true;
                char ch = s.charAt(ib);
                mp1.put(ch,mp1.getOrDefault(ch,0)+1);
                if(mp1.size()==2){
                    removeIdx(mp1,ch);
                    break;
                }
                ib+=1;
            }
            while(j<ib){
                f2 = true;
                if(mp1.size()==k){
                    ans = ans + ib-j;
                }
                removeIdx(mp1,s.charAt(j));
                j+=1;
                if(mp1.size()<k){
                    break;
                }
            }
            if(f1==false && f2==false){
                break;
            }
        }
        return ans;
    }
    int countDistinctSubStr(String s,int k){
        if(k==1){
            return solutionForK1(s,k);
        }
        HashMap<Character,Integer>mp1 = new HashMap<>();
        HashMap<Character,Integer>mp2 = new HashMap<>();
        int ib=0,is=0;
        int j=0;
        int ans = 0;
        while(true){
            boolean f1 = false;
            boolean f2 = false;
            boolean f3 = false;
            while(ib<s.length()){
                f1=true;
                char ch = s.charAt(ib);
                mp1.put(ch,mp1.getOrDefault(ch,0)+1);
                if(mp1.size()==k+1){
                    removeIdx(mp1,ch);
                    //ib-=1;
                    break;
                }
                ib+=1;
            }
            while(is<s.length()){
                f2=true;
                char ch = s.charAt(is);
                mp2.put(ch,mp2.getOrDefault(ch,0)+1);
                if(mp2.size()==k){
                    removeIdx(mp2,ch);
                    //is-=1;
                    break;
                }
                is+=1;
            }
            while(j<is){
                f3=true;
                if(mp1.size()==k && mp2.size()==k-1){
                    ans = ans+ib-is;
                }
                char ch = s.charAt(j);
                removeIdx(mp1,ch);
                removeIdx(mp2,ch);
                j+=1;
                if(mp1.size()<k || mp2.size()<k-1){
                    break;
                }
            }
            if(f1==false && f2 == false && f3==false){
                break;
            }
        }
        return ans;
    }
    void removeIdx(HashMap<Character,Integer>mp,char ch){
        if(mp.get(ch)==1){
            mp.remove(ch);
        }
        else{
            mp.put(ch,mp.get(ch)-1);
        }
    }
    int countSubstr(String s, int k) {
      int ans = countDistinctSubStr(s,k);
      return ans;
    }
}
