
//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            sc.nextLine();
            String s = sc.next();
            Solution obj = new Solution();
            String ans = obj.postToInfix(s);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends
class Solution {
    public static void insertOperator(Stack<String>st,char ch){
       String ans1 = st.pop();
       String ans2 = st.pop();
       
       String temp = "("+ans2+Character.toString(ch)+ans1+")";
       st.push(temp);
    }
    static String postToInfix(String exp) {
        Stack<String>st = new Stack<>();
       for(int i=0;i<exp.length();i++){
           char ch = exp.charAt(i);
           if(ch=='+' || ch=='*' || ch=='/' || ch=='-' || ch=='^'){
               insertOperator(st,ch);
           }
           else{
               st.push(Character.toString(ch));
           }
       }
       
       String ans="";
       while(st.size()>0){
           ans=st.peek()+ans;
           st.pop();
       }
       
       return ans;
       
    }
}
