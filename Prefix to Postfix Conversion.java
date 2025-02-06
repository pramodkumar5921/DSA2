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
            String ans = obj.preToPost(s);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static void addOperator(char ch ,Stack<String>st){
        String ans1 = st.pop();
        String ans2 = st.pop();
        
        String temp = "("+ans1+ch+ans2+")";
        st.push(temp);
    }
    static String convertPreToInFix(String pre_exp){
        int n = pre_exp.length();
        Stack<String>st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            char ch = pre_exp.charAt(i);
            
            if(ch=='+' || ch=='-' || ch=='*' || ch=='/' || ch=='^'){
                addOperator(ch,st);
            }
            else{
                st.push(Character.toString(ch));
            }
        }
        String ans = st.peek();
        return ans;
    }
    static int precedence(char ch){
        if(ch=='+' || ch=='-'){
            return 1;
        }
        else if(ch=='*' || ch=='/'){
            return 2;
        }
        else if(ch=='^'){
            return 3;
        }
        return -1;
    }
    static String infixToPost(String infix){
        Stack<Character>st = new Stack<>();
        String ans = "";
        for(int i=0;i<infix.length();i++){
            char ch = infix.charAt(i);
            if(ch=='+' || ch=='-' || ch=='*' || ch=='/' || ch=='^'){
                 while(st.size()>0 && precedence(st.peek())>=precedence(ch)){
                     ans+=st.peek();
                     st.pop();
                 }
                 st.push(ch);
            }
            else if(ch=='('){
                st.push(ch);
            }
            else if(ch==')'){
                while(st.size()>0 && st.peek()!='('){
                    ans+=st.pop();
                }
                if(st.size()>0){
                    st.pop();
                }
            }
            else{
                ans+=ch;
            }
        }
        return ans;
    }
    static String preToPost(String pre_exp) {
        String infixExp = convertPreToInFix(pre_exp);
        return infixToPost(infixExp);
        
    }
}
