class Solution {
    public int help(String str){
        int x=0,y=0;
        int ans = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='N'){
                x+=1;
            }
            else if(str.charAt(i)=='S'){
                x-=1;
            }
            else if(str.charAt(i)=='W'){
                y+=1;
            }
            else if(str.charAt(i)=='E'){
                y-=1;
            }
            ans=Math.max(ans, Math.abs(x)+Math.abs(y));
        }
        

        return Math.max(ans,0);
    }
    public int maxDistance(String s, int k) {
        int ans=0;
        StringBuilder str1 = new StringBuilder();
        int cnt=k;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='N' && cnt>0){
                cnt-=1;
                str1.append('S');
            }
            else if(s.charAt(i)=='E' && cnt>0){
                   cnt-=1;
                str1.append('W');
            }
            else{
                str1.append(s.charAt(i));
            }
        }
        String temp1 = str1.toString();
        ans = Math.max(ans,help(temp1));

        StringBuilder str2 = new StringBuilder();
        cnt=k;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='N' && cnt>0){
                   cnt-=1;
                str2.append('S');
            }
            else if(s.charAt(i)=='W' && cnt>0){
                   cnt-=1;
                str2.append('E');
            }
            else{
                str2.append(s.charAt(i));
            }
        }
         String temp2 = str2.toString();
        ans = Math.max(ans,help(temp2));


        StringBuilder str3 = new StringBuilder();
        cnt=k;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='S' && cnt>0){
                   cnt-=1;
                str3.append('N');
            }
            else if(s.charAt(i)=='E' && cnt>0){
                   cnt-=1;
                str3.append('W');
            }
            else{
                str3.append(s.charAt(i));
            }
        }
        String temp3=str3.toString();

        //System.out.print(temp3);
        ans = Math.max(ans,help(temp3));

        StringBuilder str4 = new StringBuilder();
        cnt=k;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='S' && cnt>0){
                   cnt-=1;
                str4.append('N');
            }
            else if(s.charAt(i)=='W' && cnt>0){
                   cnt-=1;
                str4.append('E');
            }
            else{
                str4.append(s.charAt(i));
            }
        }
        String temp4 = str4.toString();
        ans = Math.max(ans,help(temp4));

        return ans;
    }
}
