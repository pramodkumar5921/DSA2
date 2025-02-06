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
            String ans = obj.postToPre(s);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends
class Solution {
    static void addOperator(char ch , Stack<String>st){
        String ans1 = st.pop();
        String ans2 = st.pop();
        
        String temp = "("+ans2+ch+ans1+")";
        
        st.push(temp);
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
    static String convertToInfix(String str){
        Stack<String>st = new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch=='+' || ch=='-' || ch=='*' || ch=='/' || ch=='^'){
                addOperator(ch,st);
            }
            else{
                st.add(Character.toString(ch));
            }
        }
        String ans = st.peek();
        return ans;
    }
    static String convertToPostFix(String str){
        int n=str.length();
        Stack<Character>st = new Stack<>();
        String ans = "";
        for(int i=0;i<n;i++){
            char ch = str.charAt(i);
            if(ch=='+' || ch=='-' || ch=='*' || ch=='/'){
                while(st.size()>0 && precedence(st.peek())>=precedence(ch)){
                    ans+=st.pop();
                }
                
                st.push(ch);
                
            }
            else if(ch=='^'){
                while(st.size()>0 && precedence(st.peek())>=precedence(ch)){
                    ans+=st.pop();
                }
                st.push(ch);
                
            }
            else if(ch==')'){
              while(st.size()>0 && st.peek()!='('){
                  ans+=st.pop();
              }  
              if(st.size()>0 && st.peek()=='('){
                  st.pop();
              }
            }
            else if(ch=='('){
                st.push(ch);
            }
            else{
                ans+=ch;
            }
        }
        return ans;
    }
    static String convertToPrefix(String infix){
        String str = "";
        int n=infix.length();
        for(int i=n-1;i>=0;i--){
            char ch = infix.charAt(i);
            if(ch=='('){
                str+=")";
            }
            else if(ch==')'){
                str+='(';
            }
            else{
                str+=ch;
            }
        }
       //System.out.println(str);
        String temp = convertToPostFix(str);
        
      // System.out.print(temp);
        
        String ans = "";
        
        for(int i=temp.length()-1;i>=0;i--){
            if(temp.charAt(i)=='('){
                ans+=')';
            }
            else if(temp.charAt(i)==')'){
                ans+='(';
            }
            else{
                ans+= temp.charAt(i);
            }
        }
        return ans;
    }
    static String postToPre(String post_exp) {
       String infix=convertToInfix(post_exp);
       //System.out.println(infix);
       return convertToPrefix(infix);
    }
}
